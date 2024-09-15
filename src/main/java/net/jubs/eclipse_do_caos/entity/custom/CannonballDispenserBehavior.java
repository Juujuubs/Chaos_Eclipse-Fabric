package net.jubs.eclipse_do_caos.entity.custom;

import net.jubs.eclipse_do_caos.items.ModItems;
import net.jubs.eclipse_do_caos.sound.ModSounds;
import net.minecraft.block.DispenserBlock;
import net.minecraft.block.dispenser.ItemDispenserBehavior;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.math.BlockPointer;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Position;
import net.minecraft.world.World;

public class CannonballDispenserBehavior extends ItemDispenserBehavior {
    @Override
    protected ItemStack dispenseSilently(BlockPointer pointer, ItemStack stack) {
        World world = pointer.getWorld();
        Position position = DispenserBlock.getOutputLocation(pointer);
        Direction direction = pointer.getBlockState().get(DispenserBlock.FACING);
        world.playSound(null, pointer.getX(), pointer.getY(), pointer.getZ(), ModSounds.CANNONBALL_BLAST, SoundCategory.BLOCKS, 1.0F, 1.0F);
        CannonballEntity cannonball = new CannonballEntity(world, position.getX(), position.getY(), position.getZ());
        cannonball.setItem(new ItemStack(ModItems.CANNONBALL));
        double velocityMultiplier = 2.0;
        cannonball.setVelocity(direction.getOffsetX() * velocityMultiplier, direction.getOffsetY() * velocityMultiplier, direction.getOffsetZ() * velocityMultiplier);
        world.spawnEntity(cannonball);
        stack.decrement(1);
        return stack;
    }
}