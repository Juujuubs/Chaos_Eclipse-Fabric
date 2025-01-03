package net.jubs.eclipse_do_caos.items.custom;

import net.jubs.eclipse_do_caos.entity.custom.LightningStrikeEntity;
import net.jubs.eclipse_do_caos.items.ModItems;
import net.jubs.eclipse_do_caos.sound.ModSounds;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class AsgoreGrimoireItem extends Item {
    public AsgoreGrimoireItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);
        if (!world.isClient()) {
            LightningStrikeEntity lightningStrikeEntity = new LightningStrikeEntity(world, user);
            lightningStrikeEntity.setItem(new ItemStack(ModItems.LIGHTNING_STRIKE));

            world.playSound(null, user.getX(), user.getY(), user.getZ(), ModSounds.LIGHTNING_STRIKE, SoundCategory.PLAYERS, 3.0F, 1.0F);
            double speed = 2;
            double vx = -Math.sin(user.getYaw() * 0.017453292) * Math.cos(user.getPitch() * 0.017453292) * speed;
            double vy = -Math.sin(user.getPitch() * 0.017453292) * speed;
            double vz = Math.cos(user.getYaw() * 0.017453292) * Math.cos(user.getPitch() * 0.017453292) * speed;
            lightningStrikeEntity.setVelocity(vx, vy, vz);
            world.spawnEntity(lightningStrikeEntity);

            for (int i = 0; i < 30; i++) {
                double offsetX = Math.random() * 0.5;
                double offsetY = Math.random() * 2;
                double offsetZ = Math.random() * 0.5;
                ((ServerWorld) world).spawnParticles(ParticleTypes.ELECTRIC_SPARK,
                        user.getX() + offsetX, user.getY() + offsetY, user.getZ() + offsetZ,
                        1, 0, 0, 0, 0.1);
            }


            user.getItemCooldownManager().set(this, 85);

            stack.damage(1, user, (player) -> player.sendToolBreakStatus(hand));

        }

        return TypedActionResult.consume(stack);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context){
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.asgore_grimoire.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.asgore_grimoireline2.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.space.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.asgore_grimoire2.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.space.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.asgore_grimoireeffect.tooltip"));
        super.appendTooltip(stack, world, tooltip, context);
    }

    @Override
    public boolean canRepair(ItemStack stack, ItemStack ingredient) {
        return ingredient.isOf(ModItems.ESSENCE) || super.canRepair(stack, ingredient);
    }
}
