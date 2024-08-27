package net.jubs.eclipse_do_caos.items.custom;

import net.jubs.eclipse_do_caos.items.ModFoodComponents;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class CookedBeanItem extends Item {
    public CookedBeanItem(Settings settings) {
        super(settings.food(ModFoodComponents.COOKED_BEAN));
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        if (!world.isClient && world.getRandom().nextFloat() < 0.10F) {
            world.createExplosion(user, user.getX(), user.getBodyY(0.5D), user.getZ(), 4.0F, World.ExplosionSourceType.NONE);
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.INSTANT_DAMAGE, 60, 10));
        }
        return super.finishUsing(stack, world, user);
    }
}





