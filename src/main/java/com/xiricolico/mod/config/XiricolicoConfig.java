package com.xiricolico.mod.config;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;
import net.minecraftforge.registries.ForgeRegistries;
import com.xiricolico.mod.XiricolicoMod;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Configuration class for Xiricolico Mod settings
 */
@Mod.EventBusSubscriber(modid = XiricolicoMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class XiricolicoConfig {
    
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();

    // Feature toggles
    static {
        BUILDER.comment("Feature Toggles - Enable/disable major mod features");
        BUILDER.push("features");
    }
    
    private static final ForgeConfigSpec.BooleanValue ENABLE_CUSTOM_MOBS = BUILDER
            .comment("Enable custom mobs spawning in the world")
            .define("enableCustomMobs", true);

    private static final ForgeConfigSpec.BooleanValue ENABLE_MACHINES = BUILDER
            .comment("Enable machine blocks and automation")
            .define("enableMachines", true);

    private static final ForgeConfigSpec.BooleanValue ENABLE_CUSTOM_FOODS = BUILDER
            .comment("Enable custom foods with special effects")
            .define("enableCustomFoods", true);

    private static final ForgeConfigSpec.BooleanValue ENABLE_STATUS_EFFECTS = BUILDER
            .comment("Enable custom status effects")
            .define("enableStatusEffects", true);

    // Balance settings
    static {
        BUILDER.pop();
        BUILDER.comment("Balance Settings - Adjust gameplay balance");
        BUILDER.push("balance");
    }

    private static final ForgeConfigSpec.IntValue MOB_SPAWN_RATE = BUILDER
            .comment("Spawn rate multiplier for custom mobs (1-100)")
            .defineInRange("mobSpawnRate", 10, 1, 100);

    private static final ForgeConfigSpec.DoubleValue MACHINE_SPEED_MULTIPLIER = BUILDER
            .comment("Speed multiplier for machine operations (0.1-5.0)")
            .defineInRange("machineSpeedMultiplier", 1.0, 0.1, 5.0);

    private static final ForgeConfigSpec.IntValue FOOD_EFFECT_DURATION = BUILDER
            .comment("Duration multiplier for food effects in ticks (100-6000)")
            .defineInRange("foodEffectDuration", 600, 100, 6000);

    private static final ForgeConfigSpec.IntValue MAX_ESSENCE_STORAGE = BUILDER
            .comment("Maximum essence storage in essence-based blocks")
            .defineInRange("maxEssenceStorage", 10000, 1000, 100000);

    static {
        BUILDER.pop();
        BUILDER.comment("Debug Settings - Development and testing options");
        BUILDER.push("debug");
    }

    private static final ForgeConfigSpec.BooleanValue LOG_MOB_SPAWNS = BUILDER
            .comment("Log custom mob spawn events to console")
            .define("logMobSpawns", false);

    private static final ForgeConfigSpec.BooleanValue LOG_MACHINE_OPERATIONS = BUILDER
            .comment("Log machine operation details")
            .define("logMachineOperations", false);

    private static final ForgeConfigSpec.ConfigValue<List<? extends String>> DEBUG_ITEMS = BUILDER
            .comment("List of items to enable debug mode for")
            .defineListAllowEmpty("debugItems", List.of(), XiricolicoConfig::validateItemName);

    static {
        BUILDER.pop();
    }

    public static final ForgeConfigSpec SPEC = BUILDER.build();

    // Cached config values for performance
    public static boolean enableCustomMobs;
    public static boolean enableMachines;
    public static boolean enableCustomFoods;
    public static boolean enableStatusEffects;
    public static int mobSpawnRate;
    public static double machineSpeedMultiplier;
    public static int foodEffectDuration;
    public static int maxEssenceStorage;
    public static boolean logMobSpawns;
    public static boolean logMachineOperations;
    public static Set<Item> debugItems;

    private static boolean validateItemName(final Object obj) {
        return obj instanceof final String itemName && 
               ForgeRegistries.ITEMS.containsKey(ResourceLocation.tryParse(itemName));
    }

    @SubscribeEvent
    static void onLoad(final ModConfigEvent event) {
        // Feature toggles
        enableCustomMobs = ENABLE_CUSTOM_MOBS.get();
        enableMachines = ENABLE_MACHINES.get();
        enableCustomFoods = ENABLE_CUSTOM_FOODS.get();
        enableStatusEffects = ENABLE_STATUS_EFFECTS.get();

        // Balance settings
        mobSpawnRate = MOB_SPAWN_RATE.get();
        machineSpeedMultiplier = MACHINE_SPEED_MULTIPLIER.get();
        foodEffectDuration = FOOD_EFFECT_DURATION.get();
        maxEssenceStorage = MAX_ESSENCE_STORAGE.get();

        // Debug settings
        logMobSpawns = LOG_MOB_SPAWNS.get();
        logMachineOperations = LOG_MACHINE_OPERATIONS.get();

        // Convert debug items list
        debugItems = DEBUG_ITEMS.get().stream()
                .map(itemName -> ForgeRegistries.ITEMS.getValue(ResourceLocation.tryParse(itemName)))
                .collect(Collectors.toSet());
    }
}
