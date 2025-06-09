package net.jubs.eclipse_do_caos.items.custom;

import net.jubs.eclipse_do_caos.items.ModToolMaterial;
import net.jubs.eclipse_do_caos.sound.ModSounds;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class AkiraKatanaItem extends SwordItem {
    public AkiraKatanaItem(ModToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        target.setOnFireFor(6); // Por quanto tempo o alvo vai ficar queimando
        attacker.getWorld().playSoundFromEntity(null, target, ModSounds.AKIRA_HIT, SoundCategory.PLAYERS, 1, 1);
        return super.postHit(stack, target, attacker);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
            double radius = 6.0D;
            Box box = user.getBoundingBox().expand(radius);
            world.getEntitiesByClass(LivingEntity.class, box, entity -> entity != user && entity != user.getVehicle() && user.squaredDistanceTo(entity) <= radius * radius)
                    .forEach(entity -> {
                        entity.setOnFireFor(20);
                    });
        if (!world.isClient) {
            for (int i = 0; i < 150; i++) {
                double offsetX = Math.random() * radius - radius / 2;
                double offsetY = Math.random() * 2;
                double offsetZ = Math.random() * radius - radius / 2;
                ((ServerWorld) world).spawnParticles(ParticleTypes.DRIPPING_DRIPSTONE_LAVA,
                        user.getX() + offsetX, user.getY() + offsetY, user.getZ() + offsetZ,
                        1, 0, 0, 0, 0.1);
            }
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 300, 1));
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 300, 1));
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.HASTE, 300, 1));
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 400, 4));
            world.playSound(null, user.getX(), user.getY(), user.getZ(), ModSounds.TORMENT, SoundCategory.PLAYERS, 2F, 1.0F);
            user.getItemCooldownManager().set(this, 650);
        }

        return super.use(world, user, hand);


    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.akira_katana.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.space.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.akira_katana2.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.space.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.akira_katanaeffect.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.akira_katanaeffect2.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.akira_katanaeffect3.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.akira_katanaeffect6.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.space.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.akira_katana3.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.akira_katanaeffect4.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.space.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.akira_katana4.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.akira_katanaeffect5.tooltip"));
        super.appendTooltip(stack, world, tooltip, context);
    }
}


