package net.jubs.eclipse_do_caos.items.custom;

import net.jubs.eclipse_do_caos.items.ModToolMaterial;
import net.jubs.eclipse_do_caos.sound.ModSounds;
import net.jubs.eclipse_do_caos.util.ModTags;
import net.minecraft.block.BlockState;
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

public class SawEaterItem extends SwordItem {
    public SawEaterItem(ModToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        attacker.getWorld().playSoundFromEntity(null, target, ModSounds.SAW_EATER_HIT, SoundCategory.PLAYERS, 1, 1);
        attacker.addStatusEffect(new StatusEffectInstance(StatusEffects.SATURATION, 20, 0));


        // Chance de 50% de aplicar esses efeitos nos ataques
        if (new java.util.Random().nextFloat() < 0.5) {
            target.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 20, 1));
            target.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 20, 1));
        }

        return super.postHit(stack, target, attacker);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (!world.isClient()) {

            for (int i = 0; i < 80; i++) {
                double offsetX = Math.random() * 0.5;
                double offsetY = Math.random() * 2;
                double offsetZ = Math.random() * 0.5;
                ((ServerWorld) world).spawnParticles(ParticleTypes.ENCHANTED_HIT,
                        user.getX() + offsetX, user.getY() + offsetY, user.getZ() + offsetZ,
                        1, 0, 0, 0, 0.1);
            }

            user.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 400, 0));
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.HASTE, 400, 0));
            world.playSound(null, user.getX(), user.getY(), user.getZ(), ModSounds.SAW_EATER_SLASHER, SoundCategory.PLAYERS, 1F, 1.0F);
            user.getItemCooldownManager().set(this, 550);


        }

        return super.use(world, user, hand);


    }
    @Override
    public float getMiningSpeedMultiplier(ItemStack stack, BlockState state) {

        return state.isIn(ModTags.Blocks.SAW_EATER_MINEABLE) ? 12.5f : 12.0f;
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.saw_eater.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.saw_eaterline2.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.space.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.saw_eater2.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.space.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.saw_eatereffect.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.saw_eatereffect2.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.space.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.saw_eater3.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.saw_eaterself.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.saw_eatereffect3.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.space.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.saw_eaterentities.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.saw_eatereffect4.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.saw_eatereffect5.tooltip"));
        super.appendTooltip(stack, world, tooltip, context);
    }
}


