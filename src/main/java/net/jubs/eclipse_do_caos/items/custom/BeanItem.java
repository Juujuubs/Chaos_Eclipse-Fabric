package net.jubs.eclipse_do_caos.items.custom;

import net.jubs.eclipse_do_caos.blocks.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FarmlandBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BeanItem extends AliasedBlockItem {
    public BeanItem(Block block, Settings settings) {
        super(block, settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        BlockPos blockPos = context.getBlockPos();
        World world = context.getWorld();
        BlockPos pos = context.getBlockPos();
        BlockState state = world.getBlockState(pos);
        PlayerEntity playerEntity = context.getPlayer();
        if (state.getBlock() instanceof FarmlandBlock) {
            // Verifica se há algo já plantado na terra arada
            if (world.isAir(pos.up())) {
                // Se o bloco é terra arada e está vazio, planta o feijão
                world.setBlockState(pos.up(), ModBlocks.BEAN_CROP.getDefaultState());
                world.playSound(playerEntity, blockPos, SoundEvents.ITEM_CROP_PLANT, SoundCategory.BLOCKS, 1.0f, 1.0f);
                if (!world.isClient) {
                    // Se é server, diminui a quantidade de feijões no inventário
                    context.getStack().decrement(1);
                }
                return ActionResult.SUCCESS;
            } else {
                // Se já há algo plantado, não faz nada
                return super.useOnBlock(context);
            }
        }
        // Se o bloco não é terra arada, nada muda
        return super.useOnBlock(context);
    }
}

