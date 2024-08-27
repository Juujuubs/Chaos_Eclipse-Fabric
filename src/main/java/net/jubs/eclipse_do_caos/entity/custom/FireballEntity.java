package net.jubs.eclipse_do_caos.entity.custom;

import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.thrown.SnowballEntity;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;
import net.minecraft.util.math.Direction;

public class FireballEntity extends SnowballEntity {

    public FireballEntity(EntityType<? extends SnowballEntity> entityType, World world) {
        super(entityType, world);
        this.setNoGravity(true);
    }

    public FireballEntity(World world, LivingEntity owner) {
        super(world, owner);
        this.setNoGravity(true);
    }

    public FireballEntity(World world, double x, double y, double z) {
        super(world, x, y, z);
        this.setNoGravity(true);
    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        super.onEntityHit(entityHitResult);
        Entity hitEntity = entityHitResult.getEntity();
        Entity owner = this.getOwner();
        if (entityHitResult.getEntity() instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) entityHitResult.getEntity();
            if (player.isCreative()) {
                // Se o jogador estiver no criativo, não causa dano
                return;
            }
        }
        if (entityHitResult.getEntity() instanceof LivingEntity) {
            LivingEntity livingEntity = owner instanceof LivingEntity ? (LivingEntity)owner : null;
            float damage = 8.0f;
            boolean hurt = hitEntity.damage(this.getDamageSources().mobProjectile(this, livingEntity), damage);
            if (hurt) {
                if(hitEntity instanceof LivingEntity livingHitEntity){
                    livingHitEntity.setOnFireFor(6);
                }
            }


        }
    }

    @Override
    protected void onBlockHit(BlockHitResult blockHitResult) {
        super.onBlockHit(blockHitResult);
        Direction direction = blockHitResult.getSide();
        getWorld().setBlockState(blockHitResult.getBlockPos().offset(direction), Blocks.FIRE.getDefaultState());

    }
}

