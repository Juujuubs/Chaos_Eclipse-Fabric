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
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class HelenaBaseballBatItem extends SwordItem {
    public HelenaBaseballBatItem(ModToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }
    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        attacker.getWorld().playSoundFromEntity(null, target, ModSounds.HELENA_HIT, SoundCategory.PLAYERS, 2, 1);
        return super.postHit(stack, target, attacker);
    }
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (!world.isClient()) {

            for (int i = 0; i < 50; i++) {
                double offsetX = Math.random() * 0.5;
                double offsetY = Math.random() * 2;
                double offsetZ = Math.random() * 0.5;
                ((ServerWorld) world).spawnParticles(ParticleTypes.FLAME,
                        user.getX() + offsetX, user.getY() + offsetY, user.getZ() + offsetZ,
                        1, 0, 0, 0, 0.1);
            }

            user.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 20 * 20, 0));
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.HASTE, 20 * 20, 1));
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 20 * 20, 0));
            world.playSound(null, user.getX(), user.getY(), user.getZ(), ModSounds.SCARLET_RAMPAGE, SoundCategory.PLAYERS, 1F, 1.0F);
            user.getItemCooldownManager().set(this, 550);


        }

        return super.use(world, user, hand);


    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.helena_baseball_bat.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.helena_baseball_batline2.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.space.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.helena_baseball_bat2.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.space.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.helena_baseball_bateffect1.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.helena_baseball_bateffect2.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.helena_baseball_bateffect3.tooltip"));
        super.appendTooltip(stack, world, tooltip, context);
    }
}


