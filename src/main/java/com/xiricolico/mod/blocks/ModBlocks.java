package com.xiricolico.mod.blocks;

import com.xiricolico.mod.XiricolicoMod;
import com.xiricolico.mod.core.ModRegistries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

/**
 * Central registration for all mod blocks
 */
public class ModBlocks {
    
    // Decorative Blocks
    public static final RegistryObject<Block> CRYSTAL_BLOCK = registerBlock("crystal_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.DIAMOND)
                    .strength(3.0F, 6.0F)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.AMETHYST)));
    
    public static final RegistryObject<Block> ESSENCE_ORE = registerBlock("essence_ore",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.STONE)
                    .strength(3.0F, 3.0F)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.STONE)));
    
    public static final RegistryObject<Block> PURIFIED_STONE = registerBlock("purified_stone",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.QUARTZ)
                    .strength(2.0F, 6.0F)
                    .sound(SoundType.STONE)));
    
    // Machine Blocks
    public static final RegistryObject<Block> ESSENCE_EXTRACTOR = registerBlock("essence_extractor",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.METAL)
                    .strength(4.0F, 6.0F)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.METAL)));
    
    public static final RegistryObject<Block> CRYSTALLIZATION_CHAMBER = registerBlock("crystallization_chamber",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.METAL)
                    .strength(5.0F, 8.0F)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.METAL)));
    
    public static final RegistryObject<Block> FUSION_FORGE = registerBlock("fusion_forge",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_BLACK)
                    .strength(6.0F, 12.0F)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.ANVIL)));
    
    // Utility Blocks
    public static final RegistryObject<Block> GROWTH_ACCELERATOR = registerBlock("growth_accelerator",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.EMERALD)
                    .strength(2.0F, 4.0F)
                    .sound(SoundType.WOOD)));

    /**
     * Helper method to register blocks with automatic BlockItem creation
     */
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = ModRegistries.BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModRegistries.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void init() {
        XiricolicoMod.LOGGER.info("Initializing Xiricolico Blocks");
    }
}
