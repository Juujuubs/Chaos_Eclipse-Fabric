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
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ChaliIILanceItem extends SwordItem {
    public ChaliIILanceItem(ModToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }
    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        attacker.getWorld().playSoundFromEntity(null, target, ModSounds.CHALI_II_LANCE_HIT, SoundCategory.PLAYERS, 2, 1);
        return super.postHit(stack, target, attacker);
    }
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (!world.isClient()) {

            double dashDistance = 12.0;
            double directionX = -Math.sin(Math.toRadians(user.getYaw())) * dashDistance;
            double directionZ = Math.cos(Math.toRadians(user.getYaw())) * dashDistance;
            if (user.isOnGround()) {
                user.setVelocity(directionX, user.getVelocity().y, directionZ);
            } else {

                double airResistance = 0.15;
                user.setVelocity(directionX * airResistance, user.getVelocity().y, directionZ * airResistance);
            }
            user.velocityModified = true;


            for (int i = 0; i < 50; i++) {
                double offsetX = Math.random() * 0.5;
                double offsetY = Math.random() * 2;
                double offsetZ = Math.random() * 0.5;
                ((ServerWorld) world).spawnParticles(ParticleTypes.CRIMSON_SPORE,
                        user.getX() + offsetX, user.getY() + offsetY, user.getZ() + offsetZ,
                        1, 0, 0, 0, 0.1);
            }

            user.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 300, 0));
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 300, 0));
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 200, 2));
            world.playSound(null, user.getX(), user.getY(), user.getZ(), ModSounds.SPIDER_DASH, SoundCategory.PLAYERS, 1F, 1.0F);
            user.getItemCooldownManager().set(this, 400);

            Vec3d startPos = user.getPos();
            Vec3d endPos = startPos.add(user.getRotationVec(1.0F).multiply(8));
            Box box = new Box(startPos, endPos).expand(1.0, 1.0, 1.0);
            List<LivingEntity> entities = world.getEntitiesByClass(LivingEntity.class, box, entity -> entity != user);

            for (LivingEntity entity : entities) {
                if (entity.getBoundingBox().intersects(box)) {
                    entity.addStatusEffect(new StatusEffectInstance(StatusEffects.WITHER, 100, 0));
                    entity.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 200, 1));
                }
            }


        }

        return super.use(world, user, hand);


    }


    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.chali_ii_lance.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.chali_ii_lanceline2.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.space.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.chali_ii_lance2.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.space.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.chali_ii_lanceeffect1.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.chali_ii_lanceeffect2.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.chali_ii_lanceeffect3.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.space.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.chali_ii_lance3.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.chali_ii_lanceeffect4.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.chali_ii_lanceeffect5.tooltip"));
        super.appendTooltip(stack, world, tooltip, context);
    }
}


