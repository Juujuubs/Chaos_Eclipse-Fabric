package net.jubs.eclipse_do_caos.blocks.custom;


import net.jubs.eclipse_do_caos.sound.ModSounds;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class SamaraPlushieBlock extends HorizontalFacingBlock {

    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;
    public SamaraPlushieBlock(Settings settings) {
        super(settings);


    }
    //VOXEL SHAPE
    private static final VoxelShape SHAPE_N = Block.createCuboidShape(5, 0, 4, 11, 6, 12);
    private static final VoxelShape SHAPE_S = Block.createCuboidShape(5, 0, 4, 11, 6, 12);
    private static final VoxelShape SHAPE_E = Block.createCuboidShape(4, 0, 5, 12, 6, 11);
    private static final VoxelShape SHAPE_W = Block.createCuboidShape(4, 0, 5, 12, 6, 11);
    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        switch (state.get(FACING)) {
            case NORTH:
                return SHAPE_N;
            case SOUTH:
                return SHAPE_S;
            case EAST:
                return SHAPE_E;
            case WEST:
                return SHAPE_W;
            default:
                return SHAPE_N;
        }
    }
    //ROTATING BLOCK
    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing().getOpposite());
    }

    @Override
    public BlockState rotate(BlockState state, BlockRotation rotation) {
        return state.with(FACING, rotation.rotate(state.get(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, BlockMirror mirror) {
        return state.rotate(mirror.getRotation(state.get(FACING)));
    }

    @Override
protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
}

    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
world.playSound(player,pos,ModSounds.SAMARA_SOUNDS, SoundCategory.BLOCKS, 1f, 1f);
        return ActionResult.SUCCESS;
    }


    @Override
    public void appendTooltip(ItemStack stack, @Nullable BlockView world, List<Text> tooltip, TooltipContext options) {
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.samara_plushie.tooltip"));
        super.appendTooltip(stack, world, tooltip, options);
    }
}