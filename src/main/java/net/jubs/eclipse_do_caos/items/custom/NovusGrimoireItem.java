package net.jubs.eclipse_do_caos.items.custom;

import net.jubs.eclipse_do_caos.entity.custom.CustomZombieEntity;
import net.jubs.eclipse_do_caos.sound.ModSounds;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
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
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class NovusGrimoireItem extends Item {
    public NovusGrimoireItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (!world.isClient()) {
            for (int i = 0; i < 4; i++) {
                double offset = i * Math.PI / 2.0; // Cria uma distância para cada zumbi
                double x = user.getX() + Math.cos(offset);
                double z = user.getZ() + Math.sin(offset);

                BlockPos originalPos = new BlockPos((int)Math.round(x), (int)Math.round(user.getY()), (int)Math.round(z));
                BlockPos spawnPos = world.getBlockState(originalPos).isAir() ? originalPos : findNearestAirBlock(world, originalPos);

                CustomZombieEntity zombie = new CustomZombieEntity(EntityType.ZOMBIE, world, user);
                zombie.refreshPositionAndAngles(spawnPos.getX(), spawnPos.getY(), spawnPos.getZ(), 0, 0);
                zombie.initialize((ServerWorldAccess) world, world.getLocalDifficulty(spawnPos), SpawnReason.EVENT, null, null);

                world.spawnEntity(zombie);
            }

            for (int i = 0; i < 120; i++) {
                double offsetX = Math.random() * 4.0 - 3.0;
                double offsetY = Math.random() * 2;
                double offsetZ = Math.random() * 4.0 - 3.0;
                ((ServerWorld) world).spawnParticles(ParticleTypes.SCULK_SOUL,
                        user.getX() + offsetX, user.getY() + offsetY, user.getZ() + offsetZ,
                        1, 0, 0, 0, 0.1);
            }

            user.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 800, 2));
            world.playSound(null, user.getX(), user.getY(), user.getZ(), ModSounds.SOUL_ALTERATION, SoundCategory.PLAYERS, 1.0F, 1.0F);
            user.getItemCooldownManager().set(this, 1200);
        }

        return super.use(world, user, hand);
    }

    private BlockPos findNearestAirBlock(World world, BlockPos pos) {
        for (int dx = -2; dx <= 2; dx++) {
            for (int dy = -2; dy <= 2; dy++) {
                for (int dz = -2; dz <= 2; dz++) {
                    BlockPos checkPos = pos.add(dx, dy, dz);
                    if (world.getBlockState(checkPos).isAir()) {
                        return checkPos;
                    }
                }
            }
        }
        return pos; // Retorna a posição original se não encontrar um bloco vazio
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.novus_grimoire.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.space.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.novus_grimoire2.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.space.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.novus_grimoireeffect.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.novus_grimoireeffect2.tooltip"));
        super.appendTooltip(stack, world, tooltip, context);
    }
}

