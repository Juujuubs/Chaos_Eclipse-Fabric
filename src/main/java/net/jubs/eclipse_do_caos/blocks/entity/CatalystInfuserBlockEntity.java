package net.jubs.eclipse_do_caos.blocks.entity;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.jubs.eclipse_do_caos.items.ModItems;
import net.jubs.eclipse_do_caos.screen.CatalystInfuserScreenHandler;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;


public class CatalystInfuserBlockEntity extends BlockEntity implements ExtendedScreenHandlerFactory, ImplementedInventory {
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(7, ItemStack.EMPTY);

    public static final int INPUT_SLOT_HUMAN = 0;
    public static final int INPUT_SLOT_ELF = 1;
    public static final int INPUT_SLOT_DEVIL = 2;
    public static final int INPUT_SLOT_GOBLIN = 3;
    public static final int INPUT_SLOT_ESSENCE = 4;
    public static final int INPUT_SLOT_BOTTLE = 5;
    public static final int OUTPUT_SLOT = 6;

    protected final PropertyDelegate propertyDelegate;
    private int progress = 0;
    private int maxProgress = 72;

    public CatalystInfuserBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlocksEntities.CATALYST_INFUSER_BLOCK_ENTITY, pos, state);
        for (int i = 0; i < inventory.size(); i++) {
            inventory.set(i, ItemStack.EMPTY.copy());
        }

        this.propertyDelegate = new PropertyDelegate() {
            @Override
            public int get(int index) {
                return switch (index) {
                    case 0 -> CatalystInfuserBlockEntity.this.progress;
                    case 1 -> CatalystInfuserBlockEntity.this.maxProgress;
                    default -> 0;
                };
            }

            @Override
            public void set(int index, int value) {
                switch (index) {
                    case 0 -> CatalystInfuserBlockEntity.this.progress = value;
                    case 1 -> CatalystInfuserBlockEntity.this.maxProgress = value;
                }
            }

            @Override
            public int size() {
                return 2;
            }
        };
    }

    @Override
    public void writeScreenOpeningData(ServerPlayerEntity player, PacketByteBuf buf) {
        buf.writeBlockPos(this.pos);

    }

    @Override
    public Text getDisplayName() {
        return Text.translatable("Catalyst Infuser");
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return inventory;
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        Inventories.writeNbt(nbt, inventory);
        nbt.putInt("catalyst_infuser.progress", progress);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        Inventories.readNbt(nbt, inventory);
        progress = nbt.getInt("catalyst_infuser.progress");
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return new CatalystInfuserScreenHandler(syncId, playerInventory, this, this.propertyDelegate);
    }

    public void tick(World world, BlockPos pos, BlockState state) {
        if(world.isClient()) {
            return;
        }

        if(isOutputSlotEmptyOrReceivable()){
            if(this.hasRecipe()) {
                this.increaseCraftProgress();
                markDirty(world, pos, state);

                if(hasCraftingFinished()) {
                    this.craftItem();
                    this.resetProgress();

                }
            } else {
                this.resetProgress();
            }

        } else {
            this.resetProgress();
            markDirty(world, pos, state);
        }

    }

    private void resetProgress() {
        this.progress = 0;
    }

    private void craftItem() {
        this.removeStack(INPUT_SLOT_HUMAN, 1);
        this.removeStack(INPUT_SLOT_ELF, 1);
        this.removeStack(INPUT_SLOT_DEVIL, 1);
        this.removeStack(INPUT_SLOT_GOBLIN, 1);
        this.removeStack(INPUT_SLOT_ESSENCE, 1);
        this.removeStack(INPUT_SLOT_BOTTLE, 1);
        ItemStack result = new ItemStack(ModItems.CATALYST, 1);

        this.setStack(OUTPUT_SLOT, new ItemStack(result.getItem(), getStack(OUTPUT_SLOT).getCount() + result.getCount()));
    }

    private boolean hasCraftingFinished() {
        return progress >= maxProgress;
    }

    private void increaseCraftProgress() {
        progress++;
    }

    private boolean hasRecipe() {
        ItemStack result = new ItemStack(ModItems.CATALYST);
        boolean hasHumanInput = getStack(INPUT_SLOT_HUMAN).getItem() == ModItems.HUMAN_TOOTH;
        boolean hasElfInput = getStack(INPUT_SLOT_ELF).getItem() == ModItems.ELF_EAR;
        boolean hasDevilInput = getStack(INPUT_SLOT_DEVIL).getItem() == ModItems.DEVIL_HORN;
        boolean hasGoblinInput = getStack(INPUT_SLOT_GOBLIN).getItem() == ModItems.GOBLIN_EYE;
        boolean hasEssenceInput = getStack(INPUT_SLOT_ESSENCE).getItem() == ModItems.ESSENCE;
        boolean hasBottleInput = getStack(INPUT_SLOT_BOTTLE).getItem() == ModItems.CATALYST_EMPTY;

        return hasHumanInput && hasElfInput && hasDevilInput && hasGoblinInput && hasEssenceInput && hasBottleInput && canInsertAmountIntoOutputSlot(result) && canInsertItemIntoOutputSlot(result.getItem());
    }


    private boolean canInsertItemIntoOutputSlot(Item item) {
        return this.getStack(OUTPUT_SLOT).getItem() == item || this.getStack(OUTPUT_SLOT).isEmpty();
    }

    private boolean canInsertAmountIntoOutputSlot(ItemStack result) {
        return this.getStack(OUTPUT_SLOT).getCount() + result.getCount() <= getStack(OUTPUT_SLOT).getMaxCount();
    }

    private boolean isOutputSlotEmptyOrReceivable() {
        return this.getStack(OUTPUT_SLOT).isEmpty() || this.getStack(OUTPUT_SLOT).getCount() < this.getStack(OUTPUT_SLOT).getMaxCount();
    }
    @Override
    public boolean canInsert(int slot, ItemStack stack, @Nullable Direction dir) {
        // Apenas é possível o funil inserir itens se for pela parte de cima e os itens forem válidos para os slots
        Item item = stack.getItem();
        return dir == Direction.UP && (
                (slot == INPUT_SLOT_HUMAN && item == ModItems.HUMAN_TOOTH) ||
                        (slot == INPUT_SLOT_ELF && item == ModItems.ELF_EAR) ||
                        (slot == INPUT_SLOT_DEVIL && item == ModItems.DEVIL_HORN) ||
                        (slot == INPUT_SLOT_GOBLIN && item == ModItems.GOBLIN_EYE) ||
                        (slot == INPUT_SLOT_ESSENCE && item == ModItems.ESSENCE) ||
                        (slot == INPUT_SLOT_BOTTLE && item == ModItems.CATALYST_EMPTY)
        );
    }

    @Override
    public boolean canExtract(int slot, ItemStack stack, Direction dir) {
        // Apenas é possível de extrair os itens se o funil estiver embaixo e o slot for o de saída
        return dir == Direction.DOWN && slot == OUTPUT_SLOT;
    }
}