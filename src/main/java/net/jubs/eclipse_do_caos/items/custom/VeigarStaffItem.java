package net.jubs.eclipse_do_caos.items.custom;

import net.jubs.eclipse_do_caos.items.ModItems;
import net.jubs.eclipse_do_caos.sound.ModSounds;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;


public class VeigarStaffItem extends Item {
    public VeigarStaffItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);
        double radius = 6.0D;
        Box box = user.getBoundingBox().expand(radius);
        world.getEntitiesByClass(LivingEntity.class, box, entity -> entity != user && user.squaredDistanceTo(entity) <= radius * radius)
                .forEach(entity -> {
                    if (entity instanceof PlayerEntity || entity instanceof PassiveEntity) { // Verifica se a entidade é um jogador ou uma criatura pacífica
                        entity.addStatusEffect(new StatusEffectInstance(StatusEffects.DOLPHINS_GRACE, 400, 0));
                        entity.addStatusEffect(new StatusEffectInstance(StatusEffects.WATER_BREATHING, 400, 0));
                    }
                });
        user.addStatusEffect(new StatusEffectInstance(StatusEffects.CONDUIT_POWER, 400, 0));
        user.addStatusEffect(new StatusEffectInstance(StatusEffects.DOLPHINS_GRACE, 400, 1));

        if (!world.isClient) {

            for (int i = 0; i < 300; i++) {
                double offsetX = Math.random() * radius - radius / 2;
                double offsetY = Math.random() * 2;
                double offsetZ = Math.random() * radius - radius / 2;
                ((ServerWorld) world).spawnParticles(ParticleTypes.DRIPPING_DRIPSTONE_WATER,
                        user.getX() + offsetX, user.getY() + offsetY, user.getZ() + offsetZ,
                        1, 0, 0, 0, 0.1);
            }

            world.playSound(null, user.getX(), user.getY(), user.getZ(), ModSounds.FLOW, SoundCategory.PLAYERS, 1.0F, 1.0F);
            user.getItemCooldownManager().set(this, 650);

            stack.damage(1, user, (player) -> player.sendToolBreakStatus(hand));

            return super.use(world, user, hand);
        }

            return new TypedActionResult<>(ActionResult.CONSUME, user.getStackInHand(hand));

    }
    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.veigar_staff.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.veigar_staffline2.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.space.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.veigar_staff2.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.space.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.veigar_staffeffect.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.veigar_staffeffect2.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.space.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.veigar_staff3.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.veigar_staffentity.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.veigar_staffeffect3.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.veigar_staffeffect4.tooltip"));
        super.appendTooltip(stack, world, tooltip, context);
    }

    @Override
    public boolean canRepair(ItemStack stack, ItemStack ingredient) {
        return ingredient.isOf(ModItems.ESSENCE) || super.canRepair(stack, ingredient);
    }
}



