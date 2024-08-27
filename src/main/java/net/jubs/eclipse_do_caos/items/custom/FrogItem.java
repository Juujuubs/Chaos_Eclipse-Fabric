package net.jubs.eclipse_do_caos.items.custom;

import net.jubs.eclipse_do_caos.sound.ModSounds;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;



public class FrogItem extends Item {
    public FrogItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        double radius = 8.0D;
        Box box = user.getBoundingBox().expand(radius);
        world.getEntitiesByClass(LivingEntity.class, box, entity -> entity != user && user.squaredDistanceTo(entity) <= radius * radius)
                .forEach(entity -> {
                    entity.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 200, 2));
                    entity.addStatusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 200, 1));

                });


        if (!world.isClient) {
            for (int i = 0; i < 300; i++) {
                double offsetX = Math.random() * radius - radius / 2;
                double offsetY = Math.random() * 2;
                double offsetZ = Math.random() * radius - radius / 2;
                ((ServerWorld) world).spawnParticles(ParticleTypes.SMOKE,
                        user.getX() + offsetX, user.getY() + offsetY, user.getZ() + offsetZ,
                        1, 0, 0, 0, 0.1);
            }
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 200, 0));
            world.playSound(null, user.getX(), user.getY(), user.getZ(), ModSounds.FROG_USE, SoundCategory.PLAYERS, 1.0F, 1.0F);
            user.getItemCooldownManager().set(this, 350);
        }

            return new TypedActionResult<>(ActionResult.CONSUME, user.getStackInHand(hand));

    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.frog.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.frogline2.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.space.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.frog2.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.space.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.frogeffect.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.space.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.frog3.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.frogeffect2.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.frogeffect3.tooltip"));
        super.appendTooltip(stack, world, tooltip, context);
    }

}



