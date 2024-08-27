package net.jubs.eclipse_do_caos.items.custom;

import net.jubs.eclipse_do_caos.sound.ModSounds;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BowItem;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ZoraBowItem extends BowItem {
    public ZoraBowItem(Settings settings) {
        super(settings);
    }

    @Override
    public void onStoppedUsing(ItemStack stack, World world, LivingEntity user, int remainingUseTicks) {
        if (!(user instanceof PlayerEntity)) {
            return;
        }

        int useTicks = this.getMaxUseTime(stack) - remainingUseTicks;
        if (useTicks < 0) {
            return;
        }

        if (useTicks >= 18) {
            if (!world.isClient()) {
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.INVISIBILITY, 180));
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 120));
            world.playSound(null, user.getX(), user.getY(), user.getZ(), ModSounds.ZORA_BOW_FIRE, SoundCategory.PLAYERS, 2.0F, 1.0F);

            }
        }

        super.onStoppedUsing(stack, world, user, remainingUseTicks);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.zora_bow.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.zora_bowline2.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.space.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.zora_bow2.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.space.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.zora_boweffect.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.zora_boweffect2.tooltip"));
        super.appendTooltip(stack, world, tooltip, context);
    }
}

