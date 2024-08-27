package net.jubs.eclipse_do_caos.items.custom;

import net.jubs.eclipse_do_caos.sound.ModSounds;
import net.minecraft.block.Blocks;
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
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;


public class QrazStaffItem extends Item {
    public QrazStaffItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        double radius = 6.0D;
        Box box = user.getBoundingBox().expand(radius);
        world.getEntitiesByClass(LivingEntity.class, box, entity -> entity != user && user.squaredDistanceTo(entity) <= radius * radius)
                .forEach(entity -> {
                    for (int y = 0; y <= 2; y++) {
                        for (int x = -1; x <= 1; x++) {
                            for (int z = -1; z <= 1; z++) {
                                BlockPos pos = new BlockPos(entity.getBlockPos().getX() + x, entity.getBlockPos().getY() + y, entity.getBlockPos().getZ() + z);
                                if (world.getBlockState(pos).isAir()) { // Verifica se o bloco é vazio
                                    world.setBlockState(pos, Blocks.OAK_LEAVES.getDefaultState());
                                }
                                    entity.addStatusEffect(new StatusEffectInstance(StatusEffects.WITHER, 120, 2));
                                    entity.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 240, 1));

                            }
                        }
                    }
                });
        user.addStatusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 400, 0));

        if (!world.isClient) {

            for (int i = 0; i < 300; i++) {
                double offsetX = Math.random() * radius - radius / 2;
                double offsetY = Math.random() * 2;
                double offsetZ = Math.random() * radius - radius / 2;
                ((ServerWorld) world).spawnParticles(ParticleTypes.ITEM_SLIME,
                        user.getX() + offsetX, user.getY() + offsetY, user.getZ() + offsetZ,
                        1, 0, 0, 0, 0.1);
            }

            world.playSound(null, user.getX(), user.getY(), user.getZ(), ModSounds.VINE_TRAP, SoundCategory.PLAYERS, 4.0F, 1.0F);
            user.getItemCooldownManager().set(this, 850);
            return super.use(world, user, hand);
        }

        return new TypedActionResult<>(ActionResult.CONSUME, user.getStackInHand(hand));

    }
    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.qraz_staff.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.qraz_staffline2.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.space.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.qraz_staff2.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.space.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.qraz_staffeffect.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.space.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.qraz_staff3.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.qraz_staffentity.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.qraz_stafftrap.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.qraz_staffeffect2.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.qraz_staffeffect3.tooltip"));
        super.appendTooltip(stack, world, tooltip, context);
    }

}
