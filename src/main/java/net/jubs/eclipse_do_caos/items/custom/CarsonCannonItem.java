package net.jubs.eclipse_do_caos.items.custom;

import net.jubs.eclipse_do_caos.entity.custom.CannonballEntity;
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

public class CarsonCannonItem extends Item {
    public CarsonCannonItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);
        ItemStack cannonballStack = findCannonball(user);
        if (cannonballStack.isEmpty()) {
            // Se o jogador não tem uma Bola de Canhão no inventário, aplica esse efeito
            if (!world.isClient) {
                for (int i = 0; i < 15; i++) {
                    double offsetX = Math.random() * - 0.5;
                    double offsetY = Math.random() * 2;
                    double offsetZ = Math.random() * - 0.5;
                    ((ServerWorld) world).spawnParticles(ParticleTypes.NOTE,
                            user.getX() + offsetX, user.getY() + offsetY, user.getZ() + offsetZ,
                            1, 0, 0, 0, 0.1);
                }
            user.getItemCooldownManager().set(this, 550);
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.LUCK, 350));

            world.playSound(null, user.getX(), user.getY(), user.getZ(), ModSounds.EMPTY_CANNON, SoundCategory.PLAYERS, 1.0F, 1.0F);
            }

            return TypedActionResult.fail(user.getStackInHand(hand));
        }

        if (!world.isClient()) {
            // Lança a Bola de Canhão
            Vec3d lookVec = user.getRotationVec(1.0F);
            CannonballEntity cannonball = new CannonballEntity(world, user);
            cannonball.setItem(new ItemStack(ModItems.CANNONBALL));
            cannonball.setPosition(user.getX(), user.getEyeY(), user.getZ());
            cannonball.setVelocity(lookVec.x * 2, lookVec.y * 2, lookVec.z * 2);
            world.spawnEntity(cannonball);

            for (int i = 0; i < 80; i++) {
                double offsetX = Math.random() * - 0.5;
                double offsetY = Math.random() * 2;
                double offsetZ = Math.random() * - 0.5;
                ((ServerWorld) world).spawnParticles(ParticleTypes.ASH,
                        user.getX() + offsetX, user.getY() + offsetY, user.getZ() + offsetZ,
                        1, 0, 0, 0, 0.1);
            }

            world.playSound(null, user.getX(), user.getY(), user.getZ(), ModSounds.CANNONBALL_BLAST, SoundCategory.PLAYERS, 1.0F, 1.0F);
            user.getItemCooldownManager().set(this, 45);

            stack.damage(1, user, (player) -> player.sendToolBreakStatus(hand));

            // Consome uma Bola de Canhão do inventário do jogador se ele estiver no Criativo
            if (!user.isCreative()) {
                cannonballStack.decrement(1);
            }
        }

        return super.use(world, user, hand);
    }

    private ItemStack findCannonball(PlayerEntity player) {
        for (int i = 0; i < player.getInventory().size(); i++) {
            ItemStack stack = player.getInventory().getStack(i);
            if (stack.getItem() == ModItems.CANNONBALL) {
                return stack;
            }
        }
        return ItemStack.EMPTY;
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.carson_cannon.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.carson_cannonline2.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.space.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.carson_cannon2.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.carson_cannon3.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.space.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.carson_cannonclick.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.carson_cannoneffect.tooltip"));
        super.appendTooltip(stack, world, tooltip, context);
    }

    @Override
    public boolean canRepair(ItemStack stack, ItemStack ingredient) {
        return ingredient.isOf(ModItems.ESSENCE) || super.canRepair(stack, ingredient);
    }
}
