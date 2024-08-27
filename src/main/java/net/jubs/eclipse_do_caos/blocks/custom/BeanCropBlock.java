package net.jubs.eclipse_do_caos.blocks.custom;

import net.jubs.eclipse_do_caos.items.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CarrotsBlock;
import net.minecraft.item.ItemConvertible;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;

public class BeanCropBlock extends CarrotsBlock {
    public static final int MAX_AGE = 5;
    public static final IntProperty AGE = Properties.AGE_5;

    public BeanCropBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected ItemConvertible getSeedsItem() {
        return ModItems.BEAN;
    }


    @Override
    public IntProperty getAgeProperty() {
        return AGE;
}

    @Override
    public int getMaxAge() {
        return MAX_AGE;
}

@Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(AGE);
}

}
