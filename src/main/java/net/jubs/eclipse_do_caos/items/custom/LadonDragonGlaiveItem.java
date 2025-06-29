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

public class LadonDragonGlaiveItem extends SwordItem {
    public LadonDragonGlaiveItem(ModToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        attacker.getWorld().playSoundFromEntity(null, target, ModSounds.LADON_DRAGON_GLAIVE_HIT, SoundCategory.PLAYERS, 1, 1);
        return super.postHit(stack, target, attacker);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
            double radius = 7.0D;
            Box box = user.getBoundingBox().expand(radius);
            world.getEntitiesByClass(LivingEntity.class, box, entity -> entity != user && entity != user.getVehicle() && user.squaredDistanceTo(entity) <= radius * radius)
                    .forEach(entity -> {
                        entity.addStatusEffect(new StatusEffectInstance(StatusEffects.LEVITATION, 200, 0));
                        entity.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 200, 0));
                    });
        if (!world.isClient()) {

            for (int i = 0; i < 250; i++) {
                double offsetX = Math.random() * radius - radius / 2;
                double offsetY = Math.random() * 2;
                double offsetZ = Math.random() * radius - radius / 2;
                ((ServerWorld) world).spawnParticles(ParticleTypes.ENCHANT,
                        user.getX() + offsetX, user.getY() + offsetY, user.getZ() + offsetZ,
                        1, 0, 0, 0, 0.1);
            }

            user.addStatusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 350, 0));
            world.playSound(null, user.getX(), user.getY(), user.getZ(), ModSounds.LEVITATE, SoundCategory.PLAYERS, 2F, 1.0F);
            user.getItemCooldownManager().set(this, 550);
        }

        return super.use(world, user, hand);


    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.ladon_dragon_glaive.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.ladon_dragon_glaiveline2.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.space.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.ladon_dragon_glaive2.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.space.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.ladon_dragon_glaiveeffect.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.space.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.ladon_dragon_glaive3.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.ladon_dragon_glaiveeffect2.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.ladon_dragon_glaiveeffect3.tooltip"));
        super.appendTooltip(stack, world, tooltip, context);
    }
}


