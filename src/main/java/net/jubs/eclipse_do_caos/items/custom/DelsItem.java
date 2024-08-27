package net.jubs.eclipse_do_caos.items.custom;

import net.jubs.eclipse_do_caos.sound.ModSounds;
import net.jubs.eclipse_do_caos.util.ModTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.sound.SoundCategory;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class DelsItem extends Item {
    public DelsItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        if(!context.getWorld().isClient()) {
            BlockPos positionClicked = context.getBlockPos();
            PlayerEntity user = context.getPlayer();
            boolean foundBlock = false;

            for(int i = 0; i <= positionClicked.getY() + 64; i++) {
                BlockState state = context.getWorld().getBlockState(positionClicked.down(i));

                if(isEssenceBlock(state)) {
                    outputEssenceCoordinates(positionClicked.down(i), user, state.getBlock());
                    foundBlock = true;

                    context.getWorld().playSound(null, positionClicked, ModSounds.DELS_FOUND_ESSENCE,
                            SoundCategory.BLOCKS, 1f,1f);

                    break;
                }
            }

            if(!foundBlock){
                user.sendMessage(Text.translatable("message.eclipse_do_caos.dels.message"));
            }
        }

        context.getStack().damage(1, context.getPlayer(),
                playerEntity -> playerEntity.sendToolBreakStatus(playerEntity.getActiveHand()));

        return ActionResult.SUCCESS;
    }

    private void outputEssenceCoordinates(BlockPos blockPos, PlayerEntity player, Block block) {
        player.sendMessage(Text.literal("Found " + block.asItem().getName().getString() + " at " +
                "(" + blockPos.getX() + ", " + blockPos.getY() + "," + blockPos.getZ() + ")"), false);
    }

    private boolean isEssenceBlock(BlockState state) {
        return state.isIn(ModTags.Blocks.DELS_UNKNOWN_BLOCKS);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.dels.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.space.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.dels2.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.dels3.tooltip"));
        super.appendTooltip(stack, world, tooltip, context);
    }
}


