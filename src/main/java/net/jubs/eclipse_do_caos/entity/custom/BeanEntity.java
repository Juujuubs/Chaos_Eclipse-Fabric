package net.jubs.eclipse_do_caos.entity.custom;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.thrown.SnowballEntity;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;

public class BeanEntity extends SnowballEntity {

    public BeanEntity(EntityType<? extends SnowballEntity> entityType, World world) {
        super(entityType, world);
    }

    public BeanEntity(World world, LivingEntity owner) {
        super(world, owner);
    }

    @Override
    protected void onCollision(HitResult hitResult) {
        super.onCollision(hitResult);
        if (!this.getWorld().isClient) {
            this.getWorld().createExplosion(this, this.getX(), this.getBodyY(0.0625D), this.getZ(), 2.2F, false, World.ExplosionSourceType.NONE);
            this.discard();
        }
    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        super.onEntityHit(entityHitResult);
        Entity hitEntity = entityHitResult.getEntity();
        Entity owner = this.getOwner();
        if (!this.getWorld().isClient) {
            this.getWorld().createExplosion(this, this.getX(), this.getBodyY(0.0625D), this.getZ(), 2.35F, false, World.ExplosionSourceType.NONE);
            this.discard();
        }
        LivingEntity livingEntity = owner instanceof LivingEntity ? (LivingEntity)owner : null;
        float damage = 1.0f;
        boolean hurt = hitEntity.damage(this.getDamageSources().mobProjectile(this, livingEntity), damage);
    }
}

