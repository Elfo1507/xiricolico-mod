package com.xiricolico.mod;

import com.mojang.logging.LogUtils;
import com.xiricolico.mod.client.ClientSetup;
import com.xiricolico.mod.config.XiricolicoConfig;
import com.xiricolico.mod.core.ModRegistries;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

/**
 * Main class for Xiricolico Mod
 * A comprehensive Minecraft mod featuring diverse technomage content
 */
@Mod(XiricolicoMod.MODID)
public class XiricolicoMod {
    public static final String MODID = "xiricolico";
    public static final Logger LOGGER = LogUtils.getLogger();

    public XiricolicoMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Register all deferred registers
        ModRegistries.register(modEventBus);
        
        // Register mod event listeners
        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::addCreative);

        // Register configuration
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, XiricolicoConfig.SPEC);

        // Register for server and other game events
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        LOGGER.info("Xiricolico Mod - Common setup phase");
        
        event.enqueueWork(() -> {
            LOGGER.info("Xiricolico Mod - Post-initialization complete");
        });
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        // Items are automatically added via ModTabs configuration
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        LOGGER.info("Xiricolico Mod - Server starting");
    }

    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            ClientSetup.init();
        }
    }
}
