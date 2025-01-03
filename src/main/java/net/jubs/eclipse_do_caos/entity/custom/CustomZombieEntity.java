package net.jubs.eclipse_do_caos.entity.custom;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.ActiveTargetGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.PhantomEntity;
import net.minecraft.entity.mob.SlimeEntity;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class CustomZombieEntity extends ZombieEntity {
    private final PlayerEntity owner;
    private int lifeTicks = 0;

    public CustomZombieEntity(EntityType<? extends ZombieEntity> entityType, World world, PlayerEntity owner) {
        super(entityType, world);
        this.owner = owner;
        this.setCanPickUpLoot(true); // Eles podem equipar itens
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new MeleeAttackGoal(this, 1.0D, false));
        this.targetSelector.add(1, new ActiveTargetGoal<>(this, HostileEntity.class, true));
        this.targetSelector.add(3, new ActiveTargetGoal<>(this, SlimeEntity.class, true));
        this.targetSelector.add(4, new ActiveTargetGoal<>(this, PhantomEntity.class, true));
        this.targetSelector.add(2, new ActiveTargetGoal<>(this, PlayerEntity.class, 10, true, false, (entity) -> entity != this.owner));
    }

    @Override
    protected void dropEquipment(DamageSource source, int lootingMultiplier, boolean allowDrops) {
        // Eles não dropam o equipamento
    }

    @Override
    public void dropLoot(DamageSource source, boolean causedByPlayer) {
        // Eles não dropam o loot
    }

    @Override
    public void tick() {
        super.tick();

        if (!this.getWorld().isClient) {
            this.lifeTicks++;
            if (this.lifeTicks >= 600) {
                this.kill();
            }
        }
    }

    @Override
    public void onDeath(DamageSource source) {
        // Chama o método super.onDeath para garantir que eles possam tomar dano e morrer
        super.onDeath(source);

        // Remove XP dropando
        this.experiencePoints = 0;
    }

    @Override
    public boolean burnsInDaylight() {
        // Eles não queimam no sol
        return false;
    }

    @Override
    public boolean tryAttack(Entity target) {
        if (target instanceof CustomZombieEntity) {
            return false;
        }
        return super.tryAttack(target);
    }

    @Override
    public boolean canTarget(@Nullable LivingEntity target) {
        if (target instanceof CustomZombieEntity) {
            return false;
        }
        return super.canTarget(target);
    }
}
