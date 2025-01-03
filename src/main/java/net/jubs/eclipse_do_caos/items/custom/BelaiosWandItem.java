package net.jubs.eclipse_do_caos.items.custom;

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
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.Heightmap;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class BelaiosWandItem extends Item {
    public BelaiosWandItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);
        if (!world.isClient()) {

            Vec3d lookVector = user.getRotationVector();
            Vec3d newPosition = user.getPos().add(lookVector.multiply(8));

            // Verifica um raio de 8 blocos ao redor do jogador
            boolean foundEmptySpace = false;
            for (int i = -8; i <= 8; i++) {
                for (int j = -8; j <= 8; j++) {
                    for (int k = -8; k <= 8; k++) {
                        BlockPos blockPos = new BlockPos((int) (newPosition.x + i),
                                (int) (newPosition.y + j),
                                (int) (newPosition.z + k));

                        if (world.getBlockState(blockPos).isAir()) {
                            BlockPos nearestEmptyPos = world.getTopPosition(Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, new BlockPos((int) newPosition.x, (int) newPosition.y, (int) newPosition.z));

                            if (nearestEmptyPos != null && !nearestEmptyPos.equals(user.getBlockPos())) {
                                // Teleporta o jogador para o centro do bloco vazio encontrado
                                user.teleport(nearestEmptyPos.getX() + 0.5, nearestEmptyPos.getY(), nearestEmptyPos.getZ() + 0.5);
                                foundEmptySpace = true;
                                break; // Sai do loop de procurar blocos vazios se encontrar um bloco vazio
                            }
                        }
                    }
                    if (foundEmptySpace) {
                        break;
                    }
                }
                if (foundEmptySpace) {
                    break;
                }
            }
            if (foundEmptySpace) {
                for (int i = 0; i < 15; i++) {
                    double offsetX = Math.random() * 0.5;
                    double offsetY = Math.random() * 2;
                    double offsetZ = Math.random() * 0.5;
                    ((ServerWorld) world).spawnParticles(ParticleTypes.SOUL_FIRE_FLAME,
                            user.getX() + offsetX, user.getY() + offsetY, user.getZ() + offsetZ,
                            1, 0, 0, 0, 0.1);
                }
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 200, 1));
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.HASTE, 300, 0));
                world.playSound(null, user.getX(), user.getY(), user.getZ(), ModSounds.CROSSING_SPELL, SoundCategory.PLAYERS, 1.0F, 1.0F);
                user.getItemCooldownManager().set(this, 300);

                stack.damage(1, user, (player) -> player.sendToolBreakStatus(hand));

            } else {
                // Caso não haja um bloco vazio, toca um som para indicar que o item não pôde ser ativado
                user.getItemCooldownManager().set(this, 40);
                user.playSound(SoundEvents.BLOCK_BEACON_DEACTIVATE, SoundCategory.PLAYERS, 1.0F, 1.0F);
            }
        }
        return super.use(world, user, hand);
    }
    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.belaios_wand.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.belaios_wandline2.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.space.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.belaios_wand2.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.belaios_wand3.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.space.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.belaios_wandeffect2.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.belaios_wandeffect.tooltip"));
        super.appendTooltip(stack, world, tooltip, context);
    }

    @Override
    public boolean canRepair(ItemStack stack, ItemStack ingredient) {
        return ingredient.isOf(ModItems.ESSENCE) || super.canRepair(stack, ingredient);
    }
}
