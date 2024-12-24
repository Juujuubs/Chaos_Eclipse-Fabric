package net.jubs.eclipse_do_caos.items.custom;

import net.jubs.eclipse_do_caos.sound.ModSounds;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ShieldItem;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemStack;
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

public class PallisShieldItem extends ShieldItem {
    private int useCooldown = 0;
    private int tickCounter = 0;

    public PallisShieldItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (!world.isClient()) {
            if (useCooldown == 0) {
                double radius = 6.0D;
                Box box = user.getBoundingBox().expand(radius);
                world.getEntitiesByClass(LivingEntity.class, box, entity -> entity != user && user.squaredDistanceTo(entity) <= radius * radius)
                        .forEach(entity -> {
                            if (entity instanceof PlayerEntity || entity instanceof PassiveEntity) { // Verifica se a entidade é um jogador ou uma criatura pacífica
                                entity.addStatusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 400, 1));
                                entity.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 400, 1));
                            }
                        });
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 400, 1));
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 400, 1));
                world.playSound(null, user.getX(), user.getY(), user.getZ(), ModSounds.DEFENSE, SoundCategory.PLAYERS, 3F, 1.0F);
                useCooldown = 70;

                for (int i = 0; i < 180; i++) {
                    double offsetX = Math.random() * radius - radius / 2;
                    double offsetY = Math.random() * 2;
                    double offsetZ = Math.random() * radius - radius / 2;
                    ((ServerWorld) world).spawnParticles(ParticleTypes.TOTEM_OF_UNDYING,
                            user.getX() + offsetX, user.getY() + offsetY, user.getZ() + offsetZ,
                            1, 0, 0, 0, 0.1);
                }

            } else {
                user.sendMessage(Text.of("Cooldown remaining: " + useCooldown /2 + " seconds"), true);
            }
        }

        return super.use(world, user, hand);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (entity instanceof PlayerEntity) {
            PlayerEntity user = (PlayerEntity) entity;
                if (useCooldown > 0) {
                    tickCounter++;
                    if (tickCounter >= 20) {
                        useCooldown--;
                        tickCounter = 0;

                }
            }
        }
        super.inventoryTick(stack, world, entity, slot, selected);
    }
    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List< Text > tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.pallis_shield.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.space.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.pallis_shield2.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.space.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.pallis_shieldeffect.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.pallis_shieldeffect2.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.space.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.pallis_shield3.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.pallis_shieldentity.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.pallis_shieldeffect3.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.pallis_shieldeffect4.tooltip"));
        super.appendTooltip(stack, world, tooltip, context);
    }
}
