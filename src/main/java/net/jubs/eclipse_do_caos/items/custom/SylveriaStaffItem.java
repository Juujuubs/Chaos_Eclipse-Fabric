package net.jubs.eclipse_do_caos.items.custom;

import net.jubs.eclipse_do_caos.items.ModItems;
import net.jubs.eclipse_do_caos.sound.ModSounds;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
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
import java.util.Random;
import net.minecraft.entity.effect.StatusEffect;


public class SylveriaStaffItem extends Item {
    private static final Random RANDOM = new Random();

    public SylveriaStaffItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);
        double radius = 8.0D;
        Box box = user.getBoundingBox().expand(radius);

        StatusEffect effect1;
        StatusEffect effect2;
        StatusEffect effect3;

        if (RANDOM.nextBoolean()) {
            effect1 = StatusEffects.INSTANT_HEALTH;
            effect2 = StatusEffects.SPEED;
            effect3 = StatusEffects.STRENGTH;
        } else {
            effect1 = StatusEffects.INSTANT_DAMAGE;
            effect2 = StatusEffects.SLOWNESS;
            effect3 = StatusEffects.WEAKNESS;
        }

        if (!world.isClient) {
            world.getEntitiesByClass(LivingEntity.class, box, entity -> entity != user && user.squaredDistanceTo(entity) <= radius * radius)
                    .forEach(entity -> {
                        entity.addStatusEffect(new StatusEffectInstance(effect1, 60, 2));
                        entity.addStatusEffect(new StatusEffectInstance(effect2, 400, 1));
                        entity.addStatusEffect(new StatusEffectInstance(effect3, 400, 1));
                    });

            user.addStatusEffect(new StatusEffectInstance(effect1, 60, 2));
            user.addStatusEffect(new StatusEffectInstance(effect2, 400, 1));
            user.addStatusEffect(new StatusEffectInstance(effect3, 400, 1));

            for (int i = 0; i < 300; i++) {
                double offsetX = RANDOM.nextDouble() * radius - radius / 2;
                double offsetY = RANDOM.nextDouble() * 2;
                double offsetZ = RANDOM.nextDouble() * radius - radius / 2;
                ((ServerWorld) world).spawnParticles(ParticleTypes.CRIMSON_SPORE,
                        user.getX() + offsetX, user.getY() + offsetY, user.getZ() + offsetZ,
                        1, 0, 0, 0, 0.1);
            }

            world.playSound(null, user.getX(), user.getY(), user.getZ(), ModSounds.POSSESSED_CHAOS, SoundCategory.PLAYERS, 1.0F, 1.0F);
            user.getItemCooldownManager().set(this, 550);

            stack.damage(1, user, (player) -> player.sendToolBreakStatus(hand));

        }

        return new TypedActionResult<>(ActionResult.CONSUME, user.getStackInHand(hand));
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.sylveria_staff.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.space.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.sylveria_staff2.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.space.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.sylveria_staffeffect.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.space.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.sylveria_staff3.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.qraz_staffgood.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.sylveria_staffeffect2.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.sylveria_staffeffect3.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.sylveria_staffeffect4.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.space.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.qraz_staffbad.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.sylveria_staffeffect5.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.sylveria_staffeffect6.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.sylveria_staffeffect7.tooltip"));

        super.appendTooltip(stack, world, tooltip, context);
    }

    @Override
    public boolean canRepair(ItemStack stack, ItemStack ingredient) {
        return ingredient.isOf(ModItems.ESSENCE) || super.canRepair(stack, ingredient);
    }
}





