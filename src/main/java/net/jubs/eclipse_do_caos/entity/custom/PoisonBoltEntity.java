package net.jubs.eclipse_do_caos.entity.custom;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.projectile.thrown.SnowballEntity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.entity.AreaEffectCloudEntity;

public class PoisonBoltEntity extends SnowballEntity {

    public PoisonBoltEntity(EntityType<? extends SnowballEntity> entityType, World world) {
        super(entityType, world);
        this.setNoGravity(true);
    }

    public PoisonBoltEntity(World world, LivingEntity owner) {
        super(world, owner);
        this.setNoGravity(true);

    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        super.onEntityHit(entityHitResult);
        Entity hitEntity = entityHitResult.getEntity();
        Entity owner = this.getOwner();
        if (!this.getWorld().isClient && entityHitResult.getEntity() != this.getOwner()) {
            createPoisonCloud(this.getWorld(), entityHitResult.getEntity().getBlockPos().up());
        }
        LivingEntity livingEntity = owner instanceof LivingEntity ? (LivingEntity)owner : null;
        float damage = 1.0f;
        boolean hurt = hitEntity.damage(this.getDamageSources().mobProjectile(this, livingEntity), damage);
    }

    @Override
    protected void onCollision(HitResult hitResult) {
        super.onCollision(hitResult);
        if (!this.getWorld().isClient && hitResult.getType() == HitResult.Type.BLOCK) {
            createPoisonCloud(this.getWorld(), ((BlockHitResult)hitResult).getBlockPos().up());
            this.discard();
        }
    }

    private void createPoisonCloud(World world, BlockPos pos) {
        AreaEffectCloudEntity cloud = new AreaEffectCloudEntity(world, pos.getX(), pos.getY(), pos.getZ());
        cloud.setRadius(4.0F);
        cloud.setDuration(300);
        cloud.setParticleType(ParticleTypes.COMPOSTER);
        cloud.addEffect(new StatusEffectInstance(StatusEffects.POISON, 300, 1));
        cloud.addEffect(new StatusEffectInstance(StatusEffects.HUNGER, 300, 2));
        world.spawnEntity(cloud);
    }
}
