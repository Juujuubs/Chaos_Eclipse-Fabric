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

public class AgathaBonesawItem extends SwordItem {
    public AgathaBonesawItem(ModToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }
    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        target.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 40, 0), attacker);
        attacker.getWorld().playSoundFromEntity(null, target, ModSounds.BONESAW_HIT, SoundCategory.PLAYERS, 1, 1);
        return super.postHit(stack, target, attacker);
    }
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        double radius = 8.0D;
        Box box = user.getBoundingBox().expand(radius);
        world.getEntitiesByClass(LivingEntity.class, box, entity -> entity != user && entity != user.getVehicle() && user.squaredDistanceTo(entity) <= radius * radius)
                .forEach(entity -> {
                    entity.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 400, 1));
                    entity.addStatusEffect(new StatusEffectInstance(StatusEffects.DARKNESS, 400, 0));
                    entity.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 200, 1));
                    entity.addStatusEffect(new StatusEffectInstance(StatusEffects.MINING_FATIGUE, 200, 1));
                });


        if (!world.isClient) {
            for (int i = 0; i < 300; i++) {
                double offsetX = Math.random() * radius - radius / 2;
                double offsetY = Math.random() * 2;
                double offsetZ = Math.random() * radius - radius / 2;
                ((ServerWorld) world).spawnParticles(ParticleTypes.FISHING,
                        user.getX() + offsetX, user.getY() + offsetY, user.getZ() + offsetZ,
                        1, 0, 0, 0, 0.1);
            }

            user.addStatusEffect(new StatusEffectInstance(StatusEffects.WATER_BREATHING, 1200, 0));
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 400, 1));
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 600, 0));
            world.playSound(null, user.getX(), user.getY(), user.getZ(), ModSounds.DEEP_SEA, SoundCategory.PLAYERS, 2F, 1.0F);
            user.getItemCooldownManager().set(this, 1600);


        }

        return super.use(world, user, hand);


    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.agatha_bonesaw.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.space.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.agatha_bonesaw2.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.space.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.agatha_bonesaweffect.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.agatha_bonesaweffect2.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.agatha_bonesaweffect3.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.space.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.agatha_bonesaw3.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.agatha_bonesawentities.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.agatha_bonesaweffect4.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.space.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.agatha_bonesaw4.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.agatha_bonesaweffect5.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.agatha_bonesaweffect8.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.agatha_bonesaweffect6.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.agatha_bonesaweffect7.tooltip"));
        super.appendTooltip(stack, world, tooltip, context);
    }
}


