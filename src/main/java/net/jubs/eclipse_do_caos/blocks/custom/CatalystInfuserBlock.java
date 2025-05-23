package net.jubs.eclipse_do_caos.blocks.custom;


import net.jubs.eclipse_do_caos.blocks.entity.CatalystInfuserBlockEntity;
import net.jubs.eclipse_do_caos.blocks.entity.ModBlocksEntities;
import net.jubs.eclipse_do_caos.sound.ModSounds;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.NamedScreenHandlerFactory;
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

public class CatalystInfuserBlock extends BlockWithEntity implements BlockEntityProvider {

    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;
    public CatalystInfuserBlock(Settings settings) {
        super(settings);


    }
    //VOXEL SHAPE
    private static final VoxelShape SHAPE_N = Block.createCuboidShape(1.25, 0, 1.25, 14.75, 14, 14.75);
    private static final VoxelShape SHAPE_S = Block.createCuboidShape(1.25, 0, 1.25, 14.75, 14, 14.75);
    private static final VoxelShape SHAPE_E = Block.createCuboidShape(1.25, 0, 1.25, 14.75, 14, 14.75);
    private static final VoxelShape SHAPE_W = Block.createCuboidShape(1.25, 0, 1.25, 14.75, 14, 14.75);
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


    //TOOLTIP
    @Override
    public void appendTooltip(ItemStack stack, @Nullable BlockView world, List<Text> tooltip, TooltipContext options) {
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.catalyst_infuser.tooltip"));
        super.appendTooltip(stack, world, tooltip, options);
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new CatalystInfuserBlockEntity(pos, state);
    }
    @Override
    public void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        if (state.getBlock() != newState.getBlock()) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if (blockEntity instanceof CatalystInfuserBlockEntity) {
                ItemScatterer.spawn(world, pos, (CatalystInfuserBlockEntity)blockEntity);
                world.updateComparators(pos,this);
            }
            super.onStateReplaced(state, world, pos, newState, moved);
        }
    }
    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (!world.isClient) {
            world.playSound(null, pos, ModSounds.INFUSER_POT, SoundCategory.BLOCKS, 1f, 1f);

            NamedScreenHandlerFactory screenHandlerFactory = ((CatalystInfuserBlockEntity) world.getBlockEntity(pos));
            if (screenHandlerFactory != null) {
                player.openHandledScreen(screenHandlerFactory);



            }
            return ActionResult.SUCCESS;
        }
        return ActionResult.SUCCESS;
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return checkType(type, ModBlocksEntities.CATALYST_INFUSER_BLOCK_ENTITY,
                (world1, pos, state1, blockEntity) -> blockEntity.tick(world1, pos, state1));
    }
}