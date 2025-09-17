package com.xiricolico.mod.items;

import com.xiricolico.mod.XiricolicoMod;
import com.xiricolico.mod.core.ModRegistries;
import com.xiricolico.mod.items.foods.ModFoods;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.registries.RegistryObject;

/**
 * Central registration for all mod items
 */
public class ModItems {
    
    // Basic Items
    public static final RegistryObject<Item> ESSENCE_CRYSTAL = 
        ModRegistries.ITEMS.register("essence_crystal", 
            () -> new Item(new Item.Properties()
                .rarity(Rarity.UNCOMMON)
                .stacksTo(64)));
    
    public static final RegistryObject<Item> PURIFIED_DUST = 
        ModRegistries.ITEMS.register("purified_dust", 
            () -> new Item(new Item.Properties()
                .rarity(Rarity.COMMON)
                .stacksTo(64)));
    
    // Food Items with special effects
    public static final RegistryObject<Item> MAGIC_BERRY = 
        ModRegistries.ITEMS.register("magic_berry", 
            () -> new Item(new Item.Properties()
                .food(ModFoods.MAGIC_BERRY)
                .rarity(Rarity.UNCOMMON)
                .stacksTo(16)));
    
    public static final RegistryObject<Item> STARFRUIT = 
        ModRegistries.ITEMS.register("starfruit", 
            () -> new Item(new Item.Properties()
                .food(ModFoods.STARFRUIT)
                .rarity(Rarity.RARE)
                .stacksTo(8)));
    
    public static final RegistryObject<Item> VIGOR_ROOT = 
        ModRegistries.ITEMS.register("vigor_root", 
            () -> new Item(new Item.Properties()
                .food(ModFoods.VIGOR_ROOT)
                .rarity(Rarity.COMMON)
                .stacksTo(32)));
    
    // Tool Items
    public static final RegistryObject<Item> ESSENCE_DETECTOR = 
        ModRegistries.ITEMS.register("essence_detector", 
            () -> new Item(new Item.Properties()
                .rarity(Rarity.RARE)
                .stacksTo(1)));
    
    // Material Items
    public static final RegistryObject<Item> SHADOW_ESSENCE = 
        ModRegistries.ITEMS.register("shadow_essence", 
            () -> new Item(new Item.Properties()
                .rarity(Rarity.RARE)
                .stacksTo(64)));
    
    public static final RegistryObject<Item> CRYSTALLIZED_TIME = 
        ModRegistries.ITEMS.register("crystallized_time", 
            () -> new Item(new Item.Properties()
                .rarity(Rarity.EPIC)
                .stacksTo(16)));

    public static void init() {
        XiricolicoMod.LOGGER.info("Initializing Xiricolico Items");
    }
}
