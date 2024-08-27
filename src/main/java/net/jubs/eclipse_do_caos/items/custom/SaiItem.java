package net.jubs.eclipse_do_caos.items.custom;

import net.jubs.eclipse_do_caos.items.ModToolMaterial;
import net.jubs.eclipse_do_caos.sound.ModSounds;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.PhantomEntity;
import net.minecraft.entity.mob.SlimeEntity;
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

import java.util.Arrays;
import java.util.List;

public class SaiItem extends SwordItem {
    public SaiItem(ModToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        attacker.getWorld().playSoundFromEntity(null, target, ModSounds.SAI_HIT, SoundCategory.PLAYERS, 25, 1);
        attacker.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 20, 0));
        return super.postHit(stack, target, attacker);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        double radius = 8.0D;
        Box box = user.getBoundingBox().expand(radius);
        List<Class<? extends LivingEntity>> hostileClasses = Arrays.asList(HostileEntity.class, SlimeEntity.class, PhantomEntity.class);
        world.getEntitiesByClass(LivingEntity.class, box, entity -> entity != user && user.squaredDistanceTo(entity) <= radius * radius)
                .forEach(entity -> {
                    boolean isHostile = hostileClasses.stream().anyMatch(clazz -> clazz.isInstance(entity));
                    if (isHostile) {
                        // Aplica esse efeito a mobs hostis
                        if (entity.isUndead()) {
                            // Aplica esse efeito contrário a mobs mortos-vivos
                            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.INSTANT_HEALTH, 50, 1));
                        } else {
                            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.INSTANT_DAMAGE, 50, 1));
                        }
                    } else {
                        // Aplica esse efeito a mobs pacíficos
                        entity.addStatusEffect(new StatusEffectInstance(StatusEffects.INSTANT_HEALTH, 50, 1));
                    }
                });
        if (!world.isClient()) {

            for (int i = 0; i < 150; i++) {
                double offsetX = Math.random() * radius - radius / 2;
                double offsetY = Math.random() * 2;
                double offsetZ = Math.random() * radius - radius / 2;
                ((ServerWorld) world).spawnParticles(ParticleTypes.CLOUD,
                        user.getX() + offsetX, user.getY() + offsetY, user.getZ() + offsetZ,
                        1, 0, 0, 0, 0.1);
            }

            user.addStatusEffect(new StatusEffectInstance(StatusEffects.INSTANT_HEALTH, 50, 1));
            world.playSound(null, user.getX(), user.getY(), user.getZ(), ModSounds.MISHAP, SoundCategory.PLAYERS, 1F, 1.0F);
            user.getItemCooldownManager().set(this, 200);
        }

        return super.use(world, user, hand);


    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.sai.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.sailine2.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.space.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.sai2.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.space.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.saieffect.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.space.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.sai3.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.saieffect2.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.space.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.sai4.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.saihostile.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.saieffect3.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.space.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.saientity.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.saieffect4.tooltip"));
        super.appendTooltip(stack, world, tooltip, context);
    }
}


