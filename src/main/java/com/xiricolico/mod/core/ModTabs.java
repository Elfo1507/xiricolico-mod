package com.xiricolico.mod.core;

import com.xiricolico.mod.XiricolicoMod;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.registries.RegistryObject;

/**
 * Creative mode tabs for organizing mod content
 */
public class ModTabs {
    
    public static final RegistryObject<CreativeModeTab> XIRICOLICO_ITEMS = 
        ModRegistries.CREATIVE_MODE_TABS.register("xiricolico_items", 
            () -> CreativeModeTab.builder()
                .title(Component.translatable("itemGroup.xiricolico.items"))
                .icon(() -> new ItemStack(Items.APPLE))
                .displayItems((parameters, output) -> {
                    // Items will be automatically populated by ModItems
                }).build());
    
    public static final RegistryObject<CreativeModeTab> XIRICOLICO_BLOCKS = 
        ModRegistries.CREATIVE_MODE_TABS.register("xiricolico_blocks", 
            () -> CreativeModeTab.builder()
                .title(Component.translatable("itemGroup.xiricolico.blocks"))
                .icon(() -> new ItemStack(Items.STONE))
                .displayItems((parameters, output) -> {
                    // Blocks will be automatically populated by ModBlocks
                }).build());
    
    public static final RegistryObject<CreativeModeTab> XIRICOLICO_MACHINES = 
        ModRegistries.CREATIVE_MODE_TABS.register("xiricolico_machines", 
            () -> CreativeModeTab.builder()
                .title(Component.translatable("itemGroup.xiricolico.machines"))
                .icon(() -> new ItemStack(Items.FURNACE))
                .displayItems((parameters, output) -> {
                    // Machine blocks will be populated here
                }).build());

    public static void init() {
        XiricolicoMod.LOGGER.info("Initializing Xiricolico Creative Tabs");
    }
}
