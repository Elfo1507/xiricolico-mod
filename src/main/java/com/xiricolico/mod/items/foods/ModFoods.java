package com.xiricolico.mod.items.foods;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

/**
 * Food properties for custom food items
 */
public class ModFoods {
    
    // Magic Berry: Restores health + gives night vision
    public static final FoodProperties MAGIC_BERRY = new FoodProperties.Builder()
            .nutrition(4)
            .saturationModifier(0.6f)
            .effect(new MobEffectInstance(MobEffects.NIGHT_VISION, 1200, 0), 0.8f) // 60 seconds, 80% chance
            .effect(new MobEffectInstance(MobEffects.REGENERATION, 200, 0), 0.5f) // 10 seconds, 50% chance
            .alwaysEdible() // Can be eaten even when full
            .build();
    
    // Starfruit: High nutrition + special effects
    public static final FoodProperties STARFRUIT = new FoodProperties.Builder()
            .nutrition(6)
            .saturationModifier(0.8f)
            .effect(new MobEffectInstance(MobEffects.GLOWING, 2400, 0), 1.0f) // 2 minutes, 100% chance
            .effect(new MobEffectInstance(MobEffects.LUCK, 6000, 0), 0.7f) // 5 minutes, 70% chance
            .effect(new MobEffectInstance(MobEffects.DIG_SPEED, 1200, 1), 0.6f) // 1 minute Haste II, 60% chance
            .alwaysEdible()
            .build();
    
    // Vigor Root: Basic food with utility effects
    public static final FoodProperties VIGOR_ROOT = new FoodProperties.Builder()
            .nutrition(3)
            .saturationModifier(0.4f)
            .effect(new MobEffectInstance(MobEffects.DIG_SPEED, 800, 0), 0.9f) // 40 seconds Haste I, 90% chance
            .effect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 600, 0), 0.7f) // 30 seconds Speed I, 70% chance
            .fast() // Eaten quickly
            .build();
    
    // Crystal Berry: Protective effects
    public static final FoodProperties CRYSTAL_BERRY = new FoodProperties.Builder()
            .nutrition(2)
            .saturationModifier(0.3f)
            .effect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 1800, 0), 0.8f) // 90 seconds, 80% chance
            .effect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 1200, 0), 0.6f) // 60 seconds, 60% chance
            .alwaysEdible()
            .build();
    
    // Shadow Fruit: Stealth-based effects
    public static final FoodProperties SHADOW_FRUIT = new FoodProperties.Builder()
            .nutrition(4)
            .saturationModifier(0.5f)
            .effect(new MobEffectInstance(MobEffects.INVISIBILITY, 600, 0), 0.9f) // 30 seconds, 90% chance
            .effect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 1200, 1), 0.7f) // 60 seconds Speed II, 70% chance
            .alwaysEdible()
            .build();
}
