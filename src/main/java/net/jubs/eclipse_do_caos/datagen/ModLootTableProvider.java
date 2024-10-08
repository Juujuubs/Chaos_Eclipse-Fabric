package net.jubs.eclipse_do_caos.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.jubs.eclipse_do_caos.blocks.ModBlocks;
import net.jubs.eclipse_do_caos.blocks.custom.BeanCropBlock;
import net.jubs.eclipse_do_caos.items.ModItems;
import net.minecraft.block.Block;
import net.minecraft.data.server.loottable.BlockLootTableGenerator;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.loot.condition.TableBonusLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.predicate.StatePredicate;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
addDrop(ModBlocks.ESSENCE_BLOCK);
addDrop(ModBlocks.ESSENCE_ORE_BLOCK, copperLikeOreDrops(ModBlocks.ESSENCE_ORE_BLOCK, ModItems.ESSENCE));
addDrop(ModBlocks.RADIO_ANNOUNCER);
addDrop(ModBlocks.SAMARA_PLUSHIE);
addDrop(ModBlocks.CATALYST_INFUSER);

addDrop(ModBlocks.TEETH_BLOCK);
addDrop(ModBlocks.EYE_BLOCK);
addDrop(ModBlocks.MEAT_BLOCK);

addDrop(ModBlocks.BROMELIAD);
addPottedPlantDrops(ModBlocks.POTTED_BROMELIAD);

        addDrop(ModBlocks.EDEN_LOG);
        addDrop(ModBlocks.EDEN_WOOD);
        addDrop(ModBlocks.STRIPPED_EDEN_LOG);
        addDrop(ModBlocks.STRIPPED_EDEN_WOOD);
        addDrop(ModBlocks.EDEN_PLANKS);
        addDrop(ModBlocks.EDEN_SAPLING);
        addPottedPlantDrops(ModBlocks.POTTED_EDEN_SAPLING);

        addDrop(ModBlocks.EDEN_STAIRS);
        addDrop(ModBlocks.EDEN_BUTTON);
        addDrop(ModBlocks.EDEN_PRESSURE_PLATE);
        addDrop(ModBlocks.EDEN_FENCE);
        addDrop(ModBlocks.EDEN_FENCE_GATE);
        addDrop(ModBlocks.EDEN_TRAPDOOR);
        addDrop(ModBlocks.EDEN_SIGN);
        addDrop(ModBlocks.EDEN_HANGING_SIGN);
        addDrop(ModBlocks.EDEN_WALL_SIGN);
        addDrop(ModBlocks.EDEN_HANGING_WALL_SIGN);

        addDrop(ModBlocks.EDEN_SLAB, slabDrops(ModBlocks.EDEN_SLAB));
        addDrop(ModBlocks.EDEN_DOOR, doorDrops(ModBlocks.EDEN_DOOR));

        addDrop(ModBlocks.EDEN_LEAVES, edenLeavesDrops(ModBlocks.EDEN_LEAVES,
                ModBlocks.EDEN_SAPLING, new float[]{0.04f, 0.08f, 0.12f, 0.16f},
                ModItems.EDEN_APPLE, new float[]{0.009f, 0.018f, 0.027f, 0.036f},
                ModItems.EDEN_TREE_APPLE, new float[]{0.005f, 0.01f, 0.015f, 0.02f},
                Items.STICK, new float[]{0.03f, 0.06f, 0.09f, 0.12f}));



        addDrop(ModBlocks.BEAN_CROP, createCropDrops(ModBlocks.BEAN_CROP, ModItems.BEAN));
    }

    private static LootTable.Builder createCropDrops(Block block, Item crop) {
        LootPool.Builder matureCropPool = LootPool.builder()
                .rolls(ConstantLootNumberProvider.create(1))
                .with(ItemEntry.builder(crop)
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(3.0f, 5.0f)))
                        .apply(ApplyBonusLootFunction.oreDrops(Enchantments.FORTUNE)))
                .conditionally(BlockStatePropertyLootCondition.builder(block).properties(StatePredicate.Builder.create().exactMatch(BeanCropBlock.AGE, 5)));

        LootPool.Builder immature0CropPool = LootPool.builder()
                .rolls(ConstantLootNumberProvider.create(1))
                .with(ItemEntry.builder(crop))
                .conditionally(BlockStatePropertyLootCondition.builder(block).properties(StatePredicate.Builder.create().exactMatch(BeanCropBlock.AGE, 0)));

        LootPool.Builder immature1CropPool = LootPool.builder()
                .rolls(ConstantLootNumberProvider.create(1))
                .with(ItemEntry.builder(crop))
                .conditionally(BlockStatePropertyLootCondition.builder(block).properties(StatePredicate.Builder.create().exactMatch(BeanCropBlock.AGE, 1)));

        LootPool.Builder immature2CropPool = LootPool.builder()
                .rolls(ConstantLootNumberProvider.create(1))
                .with(ItemEntry.builder(crop))
                .conditionally(BlockStatePropertyLootCondition.builder(block).properties(StatePredicate.Builder.create().exactMatch(BeanCropBlock.AGE, 2)));

        LootPool.Builder immature3CropPool = LootPool.builder()
                .rolls(ConstantLootNumberProvider.create(1))
                .with(ItemEntry.builder(crop))
                .conditionally(BlockStatePropertyLootCondition.builder(block).properties(StatePredicate.Builder.create().exactMatch(BeanCropBlock.AGE, 3)));

        LootPool.Builder immature4CropPool = LootPool.builder()
                .rolls(ConstantLootNumberProvider.create(1))
                .with(ItemEntry.builder(crop))
                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 2.0f)))
                .conditionally(BlockStatePropertyLootCondition.builder(block).properties(StatePredicate.Builder.create().exactMatch(BeanCropBlock.AGE, 4)));



        return LootTable.builder().pool(matureCropPool).pool(immature4CropPool).pool(immature3CropPool).pool(immature2CropPool).pool(immature1CropPool).pool(immature0CropPool);
    }

    public LootTable.Builder copperLikeOreDrops(Block drop, Item item) {
        return BlockLootTableGenerator.dropsWithSilkTouch(drop, (LootPoolEntry.Builder)this.applyExplosionDecay(drop,
                ((LeafEntry.Builder) ItemEntry.builder(item).apply(SetCountLootFunction
                        .builder(UniformLootNumberProvider.create(2.0f, 5.0f))))
                        .apply(ApplyBonusLootFunction.oreDrops(Enchantments.FORTUNE))));
    }

    public LootTable.Builder edenLeavesDrops(Block leaves, Block sapling, float[] saplingChance, Item badApple, float[] badAppleChance, Item goodApple, float[] goodAppleChance, Item stick, float[] stickChance) {
        return this.leavesDrops(leaves, sapling, saplingChance)
                .pool(LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1.0f))
                        .conditionally(WITHOUT_SILK_TOUCH_NOR_SHEARS)
                        .with(((LeafEntry.Builder<?>)this.addSurvivesExplosionCondition(leaves, ItemEntry.builder(sapling)))
                                .conditionally(TableBonusLootCondition.builder(Enchantments.FORTUNE, saplingChance))))
                .pool(LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1.0f))
                        .conditionally(WITHOUT_SILK_TOUCH_NOR_SHEARS)
                        .with(((LeafEntry.Builder<?>)this.addSurvivesExplosionCondition(leaves, ItemEntry.builder(badApple)))
                                .conditionally(TableBonusLootCondition.builder(Enchantments.FORTUNE, badAppleChance))))
                .pool(LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1.0f))
                        .conditionally(WITHOUT_SILK_TOUCH_NOR_SHEARS)
                        .with(((LeafEntry.Builder<?>)this.addSurvivesExplosionCondition(leaves, ItemEntry.builder(goodApple)))
                                .conditionally(TableBonusLootCondition.builder(Enchantments.FORTUNE, goodAppleChance))))
                .pool(LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1.0f))
                        .conditionally(WITHOUT_SILK_TOUCH_NOR_SHEARS)
                        .with(((LeafEntry.Builder<?>)this.addSurvivesExplosionCondition(leaves, ItemEntry.builder(stick)))
                                .conditionally(TableBonusLootCondition.builder(Enchantments.FORTUNE, stickChance))));
    }





}
