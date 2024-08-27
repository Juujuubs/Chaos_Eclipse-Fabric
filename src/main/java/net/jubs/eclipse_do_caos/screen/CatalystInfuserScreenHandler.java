package net.jubs.eclipse_do_caos.screen;

import net.jubs.eclipse_do_caos.blocks.entity.CatalystInfuserBlockEntity;
import net.jubs.eclipse_do_caos.items.ModItems;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.ArrayPropertyDelegate;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;

import static net.jubs.eclipse_do_caos.blocks.entity.CatalystInfuserBlockEntity.*;

public class CatalystInfuserScreenHandler extends ScreenHandler {

    private final Inventory inventory;
    private final PropertyDelegate propertyDelegate;
    private final CatalystInfuserBlockEntity blockEntity;

    public CatalystInfuserScreenHandler(int syncId, PlayerInventory inventory, PacketByteBuf buf) {
        this(syncId, inventory, inventory.player.getWorld().getBlockEntity((buf.readBlockPos())),
                new ArrayPropertyDelegate(2));
    }


    public CatalystInfuserScreenHandler(int syncId, PlayerInventory playerInventory, BlockEntity blockEntity, PropertyDelegate arrayPropertyDelegate) {
        super(ModScreenHandlers.CATALYST_INFUSER_SCREEN_HANDLER, syncId);
        checkSize(((Inventory)blockEntity), 7);
        this.inventory = ((Inventory) blockEntity);
        inventory.onOpen(playerInventory.player);
        this.propertyDelegate = arrayPropertyDelegate;
        this.blockEntity = ((CatalystInfuserBlockEntity) blockEntity);

        this.addSlot(new Slot(inventory, 0, 34, 13));
        this.addSlot(new Slot(inventory, 1, 15, 32));
        this.addSlot(new Slot(inventory, 2, 34, 51));
        this.addSlot(new Slot(inventory, 3, 53, 32));
        this.addSlot(new Slot(inventory, 4, 80, 13));
        this.addSlot(new Slot(inventory, 5, 80, 51));
        this.addSlot(new Slot(inventory, 6, 145, 32));


        addPlayerInventory(playerInventory);
        addPlayerHotbar(playerInventory);

        addProperties(arrayPropertyDelegate);
    }

    public boolean isCrafting() {
        return propertyDelegate.get(0) > 0;
    }

    public int getScaledProgress() {
        int progress = this.propertyDelegate.get(0);
        int maxProgress = this.propertyDelegate.get(1); // Progresso máximo
        int progressBarSize = 148; // Largura em pixels da barra

                return maxProgress != 0 && progress != 0 ? progress * progressBarSize / maxProgress : 0;
    }


    @Override
    public ItemStack quickMove(PlayerEntity player, int index) {
        Slot slot = this.slots.get(index);
        if (slot == null || !slot.hasStack()) return ItemStack.EMPTY;
        ItemStack stack = slot.getStack();
        ItemStack stackCopy = stack.copy();

        // Determina onde começam e onde terminam os slots dentro da tela
        int containerStart;
        int containerEnd;
        if (index < this.inventory.size()) {
            containerStart = this.inventory.size();
            containerEnd = containerStart + 36;
        } else {
            containerStart = 0;
            containerEnd = this.inventory.size();
        }

        // Ele vai tentar colocar no lugar correto baseado no item que for clicado com shift
        if (!this.moveItemStackTo(stack, containerStart, containerEnd, true)) {
            return ItemStack.EMPTY;
        }

        if (stack.isEmpty()) {
            slot.setStack(ItemStack.EMPTY);
        } else {
            slot.markDirty();
        }

        if (stack.getCount() == stackCopy.getCount()) {
            return ItemStack.EMPTY;
        }

        slot.onTakeItem(player, stack);
        return stackCopy;
    }

    private boolean moveItemStackTo(ItemStack stack, int startIndex, int endIndex, boolean reverseDirection) {
        boolean moved = false;
        int i = (reverseDirection ? endIndex - 1 : startIndex);
        while (!stack.isEmpty() && (reverseDirection ? i >= startIndex : i < endIndex)) {
            Slot slot = this.slots.get(i);
            ItemStack existingStack = slot.getStack();

            if (shouldItemGoInSlot(stack, i)) {
                if (existingStack.isEmpty()) {
                    slot.setStack(stack.copy());
                    stack.setCount(0);
                    moved = true;
                } else if (canMergeItems(existingStack, stack)) {
                    int remain = Math.min(slot.getMaxItemCount(), existingStack.getMaxCount()) - existingStack.getCount();
                    int toMove = Math.min(remain, stack.getCount());
                    stack.decrement(toMove);
                    existingStack.increment(toMove);
                    moved = toMove > 0;
                }
            }

            i += (reverseDirection ? -1 : 1);
        }
        return moved;
    }

    private boolean shouldItemGoInSlot(ItemStack stack, int slotIndex) {
        Item item = stack.getItem();
        switch (slotIndex) {
            case INPUT_SLOT_HUMAN:
                return item == ModItems.HUMAN_TOOTH;
            case INPUT_SLOT_ELF:
                return item == ModItems.ELF_EAR;
            case INPUT_SLOT_DEVIL:
                return item == ModItems.DEVIL_HORN;
            case INPUT_SLOT_GOBLIN:
                return item == ModItems.GOBLIN_EYE;
            case INPUT_SLOT_ESSENCE:
                return item == ModItems.ESSENCE;
            case INPUT_SLOT_BOTTLE:
                return item == ModItems.CATALYST_EMPTY;
            case OUTPUT_SLOT:
                return item == ModItems.CATALYST;
            default:
                return true;
        }
    }

    private boolean canMergeItems(ItemStack existingStack, ItemStack stack) {
        return ItemStack.areItemsEqual(existingStack, stack) && ItemStack.areItemsEqual(stack, existingStack);
    }


    @Override
    public boolean canUse(PlayerEntity player) {
        return this.inventory.canPlayerUse(player);
    }
    private void addPlayerInventory(PlayerInventory playerInventory) {
        for (int i = 0; i < 3; ++i) {
            for (int l = 0; l < 9; ++l) {
                this.addSlot(new Slot(playerInventory, l + i * 9 + 9, 8 + l * 18, 84 + i * 18));
            }
        }
    }

    private void addPlayerHotbar(PlayerInventory playerInventory) {
        for (int i = 0; i < 9; ++i) {
            this.addSlot(new Slot(playerInventory, i, 8 + i * 18, 142));
        }
    }
}
