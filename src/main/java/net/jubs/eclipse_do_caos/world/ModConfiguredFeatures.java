package net.jubs.eclipse_do_caos.world;

import net.jubs.eclipse_do_caos.EclipseDoCaos;
import net.jubs.eclipse_do_caos.blocks.ModBlocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;

import java.util.List;

public class ModConfiguredFeatures {
    public  static  final    RegistryKey<ConfiguredFeature<?, ?>> ESSENCE_ORE_BLOCK_KEY = registerKey("essence_ore_block");
    public  static  final    RegistryKey<ConfiguredFeature<?, ?>> NETHER_ESSENCE_ORE_BLOCK_KEY = registerKey("nether_essence_ore_block");

    public static final RegistryKey<ConfiguredFeature<?, ?>> EDEN_KEY = registerKey("eden");

    public static  void boostrap(Registerable<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplacebles = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplacebles = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherReplacebles = new TagMatchRuleTest(BlockTags.BASE_STONE_NETHER);

        List<OreFeatureConfig.Target> overworldEssenceOres =
                List.of(OreFeatureConfig.createTarget(stoneReplacebles, ModBlocks.ESSENCE_ORE_BLOCK.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateReplacebles, ModBlocks.ESSENCE_ORE_BLOCK.getDefaultState()));

        List<OreFeatureConfig.Target> netherEssenceOres =
                List.of(OreFeatureConfig.createTarget(netherReplacebles, ModBlocks.ESSENCE_ORE_BLOCK.getDefaultState()));

        register(context, ESSENCE_ORE_BLOCK_KEY, Feature.ORE, new OreFeatureConfig(overworldEssenceOres, 4));
        register(context, NETHER_ESSENCE_ORE_BLOCK_KEY, Feature.ORE, new OreFeatureConfig(netherEssenceOres, 5));

        register(context, EDEN_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.EDEN_LOG),
                new StraightTrunkPlacer(2, 3, 2),

                BlockStateProvider.of(ModBlocks.EDEN_LEAVES),
                new BlobFoliagePlacer(ConstantIntProvider.create(3), ConstantIntProvider.create(2), 2),

                new TwoLayersFeatureSize(1, 0, 2)).build());
    }



    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(EclipseDoCaos.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
