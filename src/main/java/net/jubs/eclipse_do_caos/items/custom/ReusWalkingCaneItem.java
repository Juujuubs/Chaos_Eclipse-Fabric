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
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ReusWalkingCaneItem extends SwordItem {
    public ReusWalkingCaneItem(ModToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }
    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        attacker.getWorld().playSoundFromEntity(null, target, ModSounds.WALKING_CANE_HIT, SoundCategory.PLAYERS, 1, 1);

        if (new java.util.Random().nextFloat() < 0.4) {
            target.setOnFireFor(2); // Por quanto tempo o alvo vai ficar queimando
            attacker.getWorld().playSoundFromEntity(null, target, SoundEvents.ENTITY_EXPERIENCE_ORB_PICKUP, SoundCategory.HOSTILE, 1, 1);
        }

        return super.postHit(stack, target, attacker);
    }
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (!world.isClient()) {

            for (int i = 0; i < 50; i++) {
                double offsetX = Math.random() * 0.5;
                double offsetY = Math.random() * 2;
                double offsetZ = Math.random() * 0.5;
                ((ServerWorld) world).spawnParticles(ParticleTypes.SOUL_FIRE_FLAME,
                        user.getX() + offsetX, user.getY() + offsetY, user.getZ() + offsetZ,
                        1, 0, 0, 0, 0.1);
            }

            user.addStatusEffect(new StatusEffectInstance(StatusEffects.HASTE, 300, 2));
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.SATURATION, 400, 1));
            world.playSound(null, user.getX(), user.getY(), user.getZ(), ModSounds.FLAMES, SoundCategory.PLAYERS, 1F, 1.0F);
            user.getItemCooldownManager().set(this, 600);


        }

        return super.use(world, user, hand);


    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.reus_walking_cane.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.reus_walking_caneline2.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.space.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.reus_walking_cane2.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.space.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.reus_walking_caneeffect.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.reus_walking_caneeffect2.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.space.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.reus_walking_cane3.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.reus_walking_caneentities.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.reus_walking_caneeffect3.tooltip"));
        super.appendTooltip(stack, world, tooltip, context);
    }
}


