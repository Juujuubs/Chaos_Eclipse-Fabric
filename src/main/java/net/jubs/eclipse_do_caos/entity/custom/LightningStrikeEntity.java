package net.jubs.eclipse_do_caos.entity.custom;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.thrown.SnowballEntity;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.entity.LightningEntity;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.server.network.ServerPlayerEntity;

public class LightningStrikeEntity extends SnowballEntity {

    public LightningStrikeEntity(EntityType<? extends SnowballEntity> entityType, World world) {
        super(entityType, world);
        this.setNoGravity(true);
    }

    public LightningStrikeEntity(World world, LivingEntity owner) {
        super(world, owner);
        this.setNoGravity(true);
    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        super.onEntityHit(entityHitResult);
        Entity hitEntity = entityHitResult.getEntity();
        Entity owner = this.getOwner();
        if (!this.getWorld().isClient) {
            summonLightning(this.getWorld(), (LivingEntity) this.getOwner(), entityHitResult.getEntity().getBlockPos());
        }
        LivingEntity livingEntity = owner instanceof LivingEntity ? (LivingEntity)owner : null;
        float damage = 1.0f;
        boolean hurt = hitEntity.damage(this.getDamageSources().mobProjectile(this, livingEntity), damage);
    }

    @Override
    protected void onCollision(HitResult hitResult) {
        super.onCollision(hitResult);
        if (!this.getWorld().isClient && hitResult.getType() == HitResult.Type.BLOCK) {
            summonLightning(this.getWorld(), (LivingEntity) this.getOwner(), ((BlockHitResult)hitResult).getBlockPos());
            this.discard();
        }
    }

    private void summonLightning(World world, LivingEntity owner, BlockPos pos) {
        LightningEntity lightningEntity = (LightningEntity) EntityType.LIGHTNING_BOLT.create(world);
        lightningEntity.refreshPositionAfterTeleport(Vec3d.ofBottomCenter(pos));
        world.spawnEntity(lightningEntity);

        if (owner instanceof ServerPlayerEntity serverPlayer) {
            lightningEntity.setChanneler(serverPlayer);
        }
    }
}
