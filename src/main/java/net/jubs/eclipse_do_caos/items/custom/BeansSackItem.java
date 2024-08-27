package net.jubs.eclipse_do_caos.items.custom;

import net.jubs.eclipse_do_caos.entity.custom.BeanEntity;
import net.jubs.eclipse_do_caos.items.ModItems;
import net.jubs.eclipse_do_caos.sound.ModSounds;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class BeansSackItem extends Item {
    public BeansSackItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack beanStack = findBean(user);
        if (beanStack.isEmpty()) {
            // Se o jogador não tem um Feijão no inventário, aplica esse efeito
            if (!world.isClient()) {
            for (int i = 0; i < 15; i++) {
                double offsetX = Math.random() * 0.5;
                double offsetY = Math.random() * 2;
                double offsetZ = Math.random() * 0.5;
                ((ServerWorld) world).spawnParticles(ParticleTypes.NAUTILUS,
                        user.getX() + offsetX, user.getY() + offsetY, user.getZ() + offsetZ,
                        1, 0, 0, 0, 0.1);
            }
                user.getItemCooldownManager().set(this, 650);
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOW_FALLING, 400));

                world.playSound(null, user.getX(), user.getY(), user.getZ(), ModSounds.EMPTY_BEAN_SACK, SoundCategory.PLAYERS, 1.0F, 1.0F);
            }

            return TypedActionResult.fail(user.getStackInHand(hand));
        }

        if (!world.isClient()) {
            // Lança o feijão
            Vec3d lookVec = user.getRotationVec(1.0F);
            BeanEntity bean = new BeanEntity(world, user);
            bean.setItem(new ItemStack(ModItems.BEAN));
            bean.setPosition(user.getX(), user.getEyeY(), user.getZ());
            bean.setVelocity(lookVec.x * 2, lookVec.y * 2, lookVec.z * 2);
            world.spawnEntity(bean);

            for (int i = 0; i < 50; i++) {
                double offsetX = Math.random() * - 0.5;
                double offsetY = Math.random() * 2;
                double offsetZ = Math.random() * - 0.5;
                ((ServerWorld) world).spawnParticles(ParticleTypes.SPORE_BLOSSOM_AIR,
                        user.getX() + offsetX, user.getY() + offsetY, user.getZ() + offsetZ,
                        1, 0, 0, 0, 0.1);
            }

            world.playSound(null, user.getX(), user.getY(), user.getZ(), ModSounds.BEANS, SoundCategory.PLAYERS, 1.0F, 1.0F);
            user.getItemCooldownManager().set(this, 45);

            if (!user.isCreative()) {
                beanStack.decrement(1);
            }
        }

        return super.use(world, user, hand);
    }
    private ItemStack findBean(PlayerEntity player) {
        for (int i = 0; i < player.getInventory().size(); i++) {
            ItemStack stack = player.getInventory().getStack(i);
            if (stack.getItem() == ModItems.BEAN) {
                return stack;
            }
        }
        return ItemStack.EMPTY;
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.beans_sack.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.beans_sackline2.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.space.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.beans_sack2.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.beans_sack3.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.space.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.beans_sackclick.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.beans_sackeffect.tooltip"));
        super.appendTooltip(stack, world, tooltip, context);
    }
}
