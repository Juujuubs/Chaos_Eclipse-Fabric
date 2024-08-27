package net.jubs.eclipse_do_caos.blocks.custom;


import net.jubs.eclipse_do_caos.sound.ModSounds;
import net.minecraft.block.*;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.text.Text;
import net.minecraft.util.*;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;


import java.util.List;

public class RadioAnnouncerBlock extends HorizontalFacingBlock {

    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;
    public RadioAnnouncerBlock(Settings settings) {
        super(settings);


    }
    //VOXEL SHAPE
    private static final VoxelShape SHAPE_N = Block.createCuboidShape(2, 0, 4, 14.4, 8, 12);
    private static final VoxelShape SHAPE_S = Block.createCuboidShape(1.8, 0, 4, 14.2, 8, 12);
    private static final VoxelShape SHAPE_E = Block.createCuboidShape(4, 0, 2, 12, 8, 14.4);
    private static final VoxelShape SHAPE_W = Block.createCuboidShape(4, 0, 1.4, 12, 8, 14);
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
world.playSound(player,pos,ModSounds.RADIO_SOUNDS, SoundCategory.BLOCKS, 1f, 1f);
        return ActionResult.SUCCESS;
    }


    //TOOLTIP
    @Override
    public void appendTooltip(ItemStack stack, @Nullable BlockView world, List<Text> tooltip, TooltipContext options) {
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.radio_announcer.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.radio_announcer2.tooltip"));
        super.appendTooltip(stack, world, tooltip, options);
    }
}