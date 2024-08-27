package net.jubs.eclipse_do_caos.items.custom;

import net.jubs.eclipse_do_caos.entity.custom.PoisonBoltEntity;
import net.jubs.eclipse_do_caos.items.ModItems;
import net.jubs.eclipse_do_caos.sound.ModSounds;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class OldGrimoireItem extends Item {
    public OldGrimoireItem(Settings settings) {
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

            for (int i = 0; i < 30; i++) {
                double offsetX = Math.random() * 0.5;
                double offsetY = Math.random() * 2;
                double offsetZ = Math.random() * 0.5;
                ((ServerWorld) world).spawnParticles(ParticleTypes.COMPOSTER,
                        user.getX() + offsetX, user.getY() + offsetY, user.getZ() + offsetZ,
                        1, 0, 0, 0, 0.1);
            }
            user.getItemCooldownManager().set(this, 150);

        }

        return TypedActionResult.consume(stack);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context){
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.old_grimoire.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.old_grimoireline2.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.space.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.old_grimoire2.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.space.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.old_grimoire3.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.old_grimoireeffect.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.old_grimoireeffect2.tooltip"));
        super.appendTooltip(stack, world, tooltip, context);
    }
}
