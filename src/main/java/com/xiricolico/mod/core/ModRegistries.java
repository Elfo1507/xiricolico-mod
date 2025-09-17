package com.xiricolico.mod.core;

import com.xiricolico.mod.XiricolicoMod;
import com.xiricolico.mod.blocks.ModBlocks;
import com.xiricolico.mod.effects.ModEffects;
import com.xiricolico.mod.entities.ModEntities;
import com.xiricolico.mod.items.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

/**
 * Central registry management for all mod content
 */
public class ModRegistries {
    
    public static final DeferredRegister<Block> BLOCKS = 
        DeferredRegister.create(ForgeRegistries.BLOCKS, XiricolicoMod.MODID);
    
    public static final DeferredRegister<Item> ITEMS = 
        DeferredRegister.create(ForgeRegistries.ITEMS, XiricolicoMod.MODID);
    
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = 
        DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, XiricolicoMod.MODID);
    
    public static final DeferredRegister<MobEffect> MOB_EFFECTS = 
        DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, XiricolicoMod.MODID);
    
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = 
        DeferredRegister.create(Registries.CREATIVE_MODE_TAB, XiricolicoMod.MODID);

    /**
     * Register all deferred registers to the mod event bus
     */
    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
        ITEMS.register(eventBus);
        ENTITY_TYPES.register(eventBus);
        MOB_EFFECTS.register(eventBus);
        CREATIVE_MODE_TABS.register(eventBus);
        
        // Initialize content classes to trigger static registration
        ModBlocks.init();
        ModItems.init();
        ModEntities.init();
        ModEffects.init();
        ModTabs.init();
    }
}
