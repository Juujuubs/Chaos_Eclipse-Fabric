package net.jubs.eclipse_do_caos.items.custom;

import net.jubs.eclipse_do_caos.items.ModItems;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;
import net.minecraft.client.item.TooltipContext;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Random;


public class CatalystItem extends HoneyBottleItem {
    private static final int MAX_USE_TIME = 40;
    public CatalystItem(Settings settings) {
        super(settings);
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        PlayerEntity playerEntity;
        PlayerEntity playerEntity2 = playerEntity = user instanceof PlayerEntity ? (PlayerEntity) user : null;
        if (playerEntity instanceof ServerPlayerEntity) {
            Criteria.CONSUME_ITEM.trigger((ServerPlayerEntity) playerEntity, stack);
        }
        if (!world.isClient) {
            // Lista de efeitos possíveis
            StatusEffect[] possibleEffects = new StatusEffect[]{
                    StatusEffects.WITHER,
                    StatusEffects.REGENERATION,
                    StatusEffects.STRENGTH,
                    StatusEffects.WEAKNESS,
                    StatusEffects.SPEED,
                    StatusEffects.SLOWNESS,
                    StatusEffects.SATURATION,
                    StatusEffects.HUNGER,
                    StatusEffects.LUCK,
                    StatusEffects.UNLUCK,
                    StatusEffects.SLOW_FALLING,
                    StatusEffects.LEVITATION,
                    StatusEffects.HASTE,
                    StatusEffects.MINING_FATIGUE,
                    StatusEffects.ABSORPTION,
                    StatusEffects.WATER_BREATHING,
                    StatusEffects.POISON,
                    StatusEffects.BLINDNESS
            };

            // Seleciona um efeito aleatório da lista
            StatusEffect randomEffect = possibleEffects[new Random().nextInt(possibleEffects.length)];

            // Aplica o efeito selecionado
            user.addStatusEffect(new StatusEffectInstance(randomEffect, 1200, 3));

            for (int i = 0; i < 50; i++) {
                double offsetX = Math.random() * 0.5;
                double offsetY = Math.random() * 2;
                double offsetZ = Math.random() * 0.5;
                ((ServerWorld) world).spawnParticles(ParticleTypes.CRIMSON_SPORE,
                        user.getX() + offsetX, user.getY() + offsetY, user.getZ() + offsetZ,
                        1, 0, 0, 0, 0.1);
            }

        }
        if (playerEntity != null) {
            playerEntity.incrementStat(Stats.USED.getOrCreateStat(this));
            if (!playerEntity.getAbilities().creativeMode) {
                stack.decrement(1);
            }
        }
        if (playerEntity == null || !playerEntity.getAbilities().creativeMode) {
            if (stack.isEmpty()) {
                return new ItemStack(ModItems.CATALYST_EMPTY);
            }
            if (playerEntity != null) {
                playerEntity.getInventory().insertStack(new ItemStack(ModItems.CATALYST_EMPTY));
            }
        }

        return stack;
    }

    @Override
    public int getMaxUseTime(ItemStack stack) {
        return 40;
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.DRINK;
    }

    @Override
    public SoundEvent getDrinkSound() {
        return SoundEvents.ITEM_HONEY_BOTTLE_DRINK;


    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        return ItemUsage.consumeHeldItem(world, user, hand);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.catalyst.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.catalystline2.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.space.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.catalyst2.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.space.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.catalysteffect.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.space.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.catalyst3.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.catalysteffect2.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.catalysteffect22.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.space.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.catalysteffect3.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.catalysteffect33.tooltip"));
        super.appendTooltip(stack, world, tooltip, context);

    }

}
