package net.jubs.eclipse_do_caos.items.custom;

import net.jubs.eclipse_do_caos.entity.custom.PoisonBoltEntity;
import net.jubs.eclipse_do_caos.items.ModItems;
import net.jubs.eclipse_do_caos.sound.ModSounds;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SnowballItem;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class PoisonBoltItem extends SnowballItem {
    public PoisonBoltItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);

        if (!world.isClient) {
            PoisonBoltEntity poisonBoltEntity = new PoisonBoltEntity(world, user);
            poisonBoltEntity.setItem(new ItemStack(ModItems.POISON_BOLT));

            world.playSound(null, user.getX(), user.getY(), user.getZ(), ModSounds.POISON_BOLT, SoundCategory.PLAYERS, 1.0F, 1.0F);
            double speed = 2;
            double vx = -Math.sin(user.getYaw() * 0.017453292) * Math.cos(user.getPitch() * 0.017453292) * speed;
            double vy = -Math.sin(user.getPitch() * 0.017453292) * speed;
            double vz = Math.cos(user.getYaw() * 0.017453292) * Math.cos(user.getPitch() * 0.017453292) * speed;
            poisonBoltEntity.setVelocity(vx, vy, vz);
            world.spawnEntity(poisonBoltEntity);
        }

        user.getItemCooldownManager().set(this, 75);

        if (!user.isCreative()) {
            stack.decrement(1);
        }

        return TypedActionResult.consume(stack);
    }
}

