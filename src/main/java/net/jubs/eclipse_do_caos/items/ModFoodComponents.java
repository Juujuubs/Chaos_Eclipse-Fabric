package net.jubs.eclipse_do_caos.items;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class ModFoodComponents {
    public static final FoodComponent TILAPIA = new FoodComponent.Builder().hunger(3).saturationModifier(0.2f)
            .statusEffect(new StatusEffectInstance(StatusEffects.POISON, 200), 0.15f).build();

    public static final FoodComponent FRIED_TILAPIA = new FoodComponent.Builder().hunger(7).saturationModifier(0.9f)
            .statusEffect(new StatusEffectInstance(StatusEffects.LUCK, 300), 0.35f).build();

    public static final FoodComponent SUSHI_TILAPIA = new FoodComponent.Builder().hunger(4).saturationModifier(1.5f).snack()
            .statusEffect(new StatusEffectInstance(StatusEffects.SATURATION, 300), 0.20f).build();

    public static final FoodComponent BEAN = new FoodComponent.Builder().hunger(2).saturationModifier(0.1f).snack()
            .statusEffect(new StatusEffectInstance(StatusEffects.HEALTH_BOOST, 300), 0.01f).build();
    public static final FoodComponent EDEN_TREE_APPLE = new FoodComponent.Builder().hunger(12).saturationModifier(8.0f)
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 300, 5), 0.3f)
            .statusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 300, 5), 0.3f)
            .statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 300, 5), 0.3f)
            .build();
    public static final FoodComponent EDEN_APPLE = new FoodComponent.Builder().hunger(20).saturationModifier(12.0f).alwaysEdible()
            // Efeitos Positivos
            .statusEffect(new StatusEffectInstance(StatusEffects.HEALTH_BOOST, 300, 10), 1.0f)
            .statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 300, 10), 1.0f)
            .statusEffect(new StatusEffectInstance(StatusEffects.HASTE, 300, 10), 1.0f)
            .statusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 300, 10), 1.0f)
            .statusEffect(new StatusEffectInstance(StatusEffects.INSTANT_HEALTH, 300, 10), 1.0f)
            .statusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST, 300, 10), 1.0f)
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 300, 10), 1.0f)
            .statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 300, 10), 1.0f)
            .statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 300, 10), 1.0f)
            .statusEffect(new StatusEffectInstance(StatusEffects.WATER_BREATHING, 300, 10), 1.0f)
            .statusEffect(new StatusEffectInstance(StatusEffects.INVISIBILITY, 300, 10), 1.0f)
            .statusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 300, 10), 1.0f)
            .statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 300, 10), 1.0f)
            .statusEffect(new StatusEffectInstance(StatusEffects.SATURATION, 300, 10), 1.0f)
            .statusEffect(new StatusEffectInstance(StatusEffects.CONDUIT_POWER, 300, 10), 1.0f)
            .statusEffect(new StatusEffectInstance(StatusEffects.DOLPHINS_GRACE, 300, 10), 1.0f)
            .statusEffect(new StatusEffectInstance(StatusEffects.SLOW_FALLING, 300, 10), 1.0f)
            .statusEffect(new StatusEffectInstance(StatusEffects.HERO_OF_THE_VILLAGE, 300, 10), 1.0f)
            .statusEffect(new StatusEffectInstance(StatusEffects.LUCK, 300, 10), 1.0f)
            // Efeitos Neutros
            .statusEffect(new StatusEffectInstance(StatusEffects.GLOWING, 300, 10), 1.0f)
            // Efeitos Negativos
            .statusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 300, 10), 1.0f)
            .statusEffect(new StatusEffectInstance(StatusEffects.MINING_FATIGUE, 300, 10), 1.0f)
            .statusEffect(new StatusEffectInstance(StatusEffects.INSTANT_DAMAGE, 300, 10), 1.0f)
            .statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 300, 10), 1.0f)
            .statusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 300, 10), 1.0f)
            .statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 300, 10), 1.0f)
            .statusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 300, 10), 1.0f)
            .statusEffect(new StatusEffectInstance(StatusEffects.POISON, 300, 10), 1.0f)
            .statusEffect(new StatusEffectInstance(StatusEffects.WITHER, 300, 10), 1.0f)
            .statusEffect(new StatusEffectInstance(StatusEffects.LEVITATION, 300, 10), 1.0f)
            .statusEffect(new StatusEffectInstance(StatusEffects.BAD_OMEN, 300, 10), 1.0f)
            .statusEffect(new StatusEffectInstance(StatusEffects.DARKNESS, 300, 10), 1.0f)
            .statusEffect(new StatusEffectInstance(StatusEffects.UNLUCK, 300, 10), 1.0f)
            .build();
    public static final FoodComponent COOKED_BEAN = new FoodComponent.Builder().hunger(5).saturationModifier(0.6f).snack().build();

    public static final FoodComponent GOBLIN_EYE = new FoodComponent.Builder().hunger(2).saturationModifier(0.4f).snack()
            .statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 200), 0.25f).build();
    public static final FoodComponent ELF_EAR = new FoodComponent.Builder().hunger(4).saturationModifier(0.5f)
            .statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 200), 0.35f).build();



}
