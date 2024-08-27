package net.jubs.eclipse_do_caos.entity.custom;

import net.minecraft.block.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.thrown.SnowballEntity;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;


public class CannonballEntity extends SnowballEntity {

    public CannonballEntity(EntityType<? extends SnowballEntity> entityType, World world) {
        super(entityType, world);
        this.setNoGravity(false);
    }

    public CannonballEntity(World world, LivingEntity owner) {
        super(world, owner);
        this.setNoGravity(false);
    }

    public CannonballEntity(World world, double x, double y, double z) {
        super(world, x, y, z);
        this.setNoGravity(false);

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
            float damage = 12.0f;
            boolean hurt = hitEntity.damage(this.getDamageSources().mobProjectile(this, livingEntity), damage);
        }
    }

    @Override
    protected void onBlockHit(BlockHitResult blockHitResult) {
        super.onBlockHit(blockHitResult);
        if (getWorld().getBlockState(blockHitResult.getBlockPos()).getBlock() instanceof GlassBlock || getWorld().getBlockState(blockHitResult.getBlockPos()).getBlock() instanceof PaneBlock ||
                getWorld().getBlockState(blockHitResult.getBlockPos()).getBlock() instanceof IceBlock || getWorld().getBlockState(blockHitResult.getBlockPos()).getBlock() instanceof TintedGlassBlock ||
                getWorld().getBlockState(blockHitResult.getBlockPos()).getBlock() instanceof StainedGlassBlock || getWorld().getBlockState(blockHitResult.getBlockPos()).getBlock() instanceof StainedGlassPaneBlock) {
            getWorld().breakBlock(blockHitResult.getBlockPos(), false);

        }
        if (getWorld().getBlockState(blockHitResult.getBlockPos()).getBlock() instanceof LanternBlock || getWorld().getBlockState(blockHitResult.getBlockPos()).getBlock() instanceof RedstoneLampBlock ||
                getWorld().getBlockState(blockHitResult.getBlockPos()).getBlock() instanceof DecoratedPotBlock || getWorld().getBlockState(blockHitResult.getBlockPos()).getBlock() == Blocks.SEA_LANTERN ||
                getWorld().getBlockState(blockHitResult.getBlockPos()).getBlock() == Blocks.GLOWSTONE || getWorld().getBlockState(blockHitResult.getBlockPos()).getBlock() instanceof PointedDripstoneBlock) {
            getWorld().breakBlock(blockHitResult.getBlockPos(), true);
        }

    }
}
