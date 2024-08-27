package net.jubs.eclipse_do_caos.blocks;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.jubs.eclipse_do_caos.EclipseDoCaos;
import net.jubs.eclipse_do_caos.blocks.custom.*;
import net.jubs.eclipse_do_caos.util.ModWoodTypes;
import net.jubs.eclipse_do_caos.world.tree.EdenSaplingGenerator;
import net.minecraft.block.*;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {
    public static final Block ESSENCE_BLOCK = registerBlock("essence_block",
            new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).sounds(BlockSoundGroup.SCULK)));
    public static final Block ESSENCE_ORE_BLOCK = registerBlock("essence_ore_block",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.DIAMOND_ORE).sounds(BlockSoundGroup.DECORATED_POT), UniformIntProvider.create(2, 5)));
    public static final Block RADIO_ANNOUNCER = registerBlock("radio_announcer",
            new RadioAnnouncerBlock(FabricBlockSettings.copyOf(Blocks.COPPER_BLOCK).nonOpaque().sounds(BlockSoundGroup.COPPER)));
    public static final Block SAMARA_PLUSHIE = registerBlock("samara_plushie",
            new SamaraPlushieBlock(FabricBlockSettings.copyOf(Blocks.HAY_BLOCK).nonOpaque().sounds(BlockSoundGroup.SNOW)));
    public static final Block CATALYST_INFUSER = registerBlock("catalyst_infuser",
            new CatalystInfuserBlock(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS).nonOpaque().sounds(BlockSoundGroup.WOOD)));
    public static final Block BROMELIAD = registerBlock("bromeliad",
            new FlowerBlock(StatusEffects.REGENERATION, 10,
                    FabricBlockSettings.copyOf(Blocks.POPPY).nonOpaque().noCollision()));
    public static final Block POTTED_BROMELIAD = Registry.register(Registries.BLOCK, new Identifier(EclipseDoCaos.MOD_ID, "potted_bromeliad"),
            new FlowerPotBlock(BROMELIAD, FabricBlockSettings.copyOf(Blocks.POTTED_POPPY).nonOpaque()));

    public static final Block BEAN_CROP = Registry.register(Registries.BLOCK, new Identifier(EclipseDoCaos.MOD_ID, "bean_crop"),
            new BeanCropBlock(FabricBlockSettings.copyOf(Blocks.CARROTS)));

    //Árvore de Éden
    public static final Block EDEN_LOG = registerBlock("eden_log",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG).strength(2f).sounds(BlockSoundGroup.WOOD)));
    public static final Block EDEN_WOOD = registerBlock("eden_wood",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_WOOD).strength(2f).sounds(BlockSoundGroup.WOOD)));
    public static final Block STRIPPED_EDEN_LOG = registerBlock("stripped_eden_log",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_LOG).strength(2f).sounds(BlockSoundGroup.WOOD)));
    public static final Block STRIPPED_EDEN_WOOD = registerBlock("stripped_eden_wood",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_WOOD).strength(2f).sounds(BlockSoundGroup.WOOD)));

    public static final Block EDEN_PLANKS = registerBlock("eden_planks",
            new Block(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS).strength(2f).sounds(BlockSoundGroup.WOOD)));

    public static final Block EDEN_STAIRS = registerBlock("eden_stairs",
            new StairsBlock(ModBlocks.EDEN_PLANKS.getDefaultState(), FabricBlockSettings.copyOf(Blocks.OAK_STAIRS).strength(2f).sounds(BlockSoundGroup.WOOD)));
    public static final Block EDEN_SLAB = registerBlock("eden_slab",
            new SlabBlock(FabricBlockSettings.copyOf(Blocks.OAK_SLAB).strength(2f).sounds(BlockSoundGroup.WOOD)));
    public static final Block EDEN_BUTTON = registerBlock("eden_button",
            new ButtonBlock(FabricBlockSettings.copyOf(Blocks.OAK_BUTTON), BlockSetType.OAK, 10, true));
    public static final Block EDEN_PRESSURE_PLATE = registerBlock("eden_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING,
                    FabricBlockSettings.copyOf(Blocks.OAK_PRESSURE_PLATE).strength(2f).sounds(BlockSoundGroup.WOOD), BlockSetType.OAK));
    public static final Block EDEN_FENCE = registerBlock("eden_fence",
            new FenceBlock(FabricBlockSettings.copyOf(Blocks.OAK_FENCE).strength(2f).sounds(BlockSoundGroup.WOOD)));
    public static final Block EDEN_FENCE_GATE = registerBlock("eden_fence_gate",
            new FenceGateBlock(FabricBlockSettings.copyOf(Blocks.OAK_FENCE_GATE).strength(2f), WoodType.OAK));
    public static final Block EDEN_LEAVES = registerBlock("eden_leaves",
            new LeavesBlock(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES).nonOpaque()));
    public static final Block EDEN_DOOR = registerBlock("eden_door",
            new DoorBlock(FabricBlockSettings.copyOf(Blocks.OAK_DOOR).strength(2f).sounds(BlockSoundGroup.WOOD), BlockSetType.OAK));
    public static final Block EDEN_TRAPDOOR = registerBlock("eden_trapdoor",
            new TrapdoorBlock(FabricBlockSettings.copyOf(Blocks.BIRCH_TRAPDOOR).strength(2f).sounds(BlockSoundGroup.WOOD), BlockSetType.OAK));

    public static final Block EDEN_SAPLING = registerBlock("eden_sapling",
            new SaplingBlock(new EdenSaplingGenerator(), FabricBlockSettings.copyOf(Blocks.OAK_SAPLING)));
    public static final Block POTTED_EDEN_SAPLING = Registry.register(Registries.BLOCK, new Identifier(EclipseDoCaos.MOD_ID, "potted_eden_sapling"),
            new FlowerPotBlock(EDEN_SAPLING, FabricBlockSettings.copyOf(Blocks.POTTED_OAK_SAPLING).nonOpaque()));

    public static final Block EDEN_SIGN = registerBlockWithoutBlockItem("eden_sign",
            new ModStandingSignBlock(FabricBlockSettings.copyOf(Blocks.OAK_SIGN).mapColor(MapColor.BROWN), ModWoodTypes.EDEN));
    public static final Block EDEN_WALL_SIGN = registerBlockWithoutBlockItem("eden_wall_sign",
            new ModWallSignBlock(FabricBlockSettings.copyOf(Blocks.OAK_WALL_SIGN).dropsLike(EDEN_SIGN).mapColor(MapColor.BROWN), ModWoodTypes.EDEN));
    public static final Block EDEN_HANGING_SIGN = registerBlockWithoutBlockItem("eden_hanging_sign",
            new ModHangingSignBlock(FabricBlockSettings.copyOf(Blocks.OAK_HANGING_SIGN).mapColor(MapColor.BROWN), ModWoodTypes.EDEN));
    public static final Block EDEN_HANGING_WALL_SIGN = registerBlockWithoutBlockItem("eden_hanging_wall_sign",
            new ModWallHangingSignBlock(FabricBlockSettings.copyOf(Blocks.OAK_WALL_HANGING_SIGN).dropsLike(EDEN_HANGING_SIGN).mapColor(MapColor.BROWN), ModWoodTypes.EDEN));


    private static Block registerBlockWithoutBlockItem(String name, Block block) {
        return Registry.register(Registries.BLOCK, new Identifier(EclipseDoCaos.MOD_ID, name), block);
    }


    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(EclipseDoCaos.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(EclipseDoCaos.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks() {
        EclipseDoCaos.LOGGER.info("Registrando Blocos do Mod para " + EclipseDoCaos.MOD_ID);
    }
}