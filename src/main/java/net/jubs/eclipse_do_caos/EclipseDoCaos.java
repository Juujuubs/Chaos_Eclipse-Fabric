package net.jubs.eclipse_do_caos;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.jubs.eclipse_do_caos.blocks.ModBlocks;
import net.jubs.eclipse_do_caos.blocks.entity.ModBlocksEntities;
import net.jubs.eclipse_do_caos.entity.ModBoats;
import net.jubs.eclipse_do_caos.entity.custom.CannonballDispenserBehavior;
import net.jubs.eclipse_do_caos.items.ModItemGroups;
import net.jubs.eclipse_do_caos.items.ModItems;
import net.jubs.eclipse_do_caos.painting.ModPaintings;
import net.jubs.eclipse_do_caos.screen.ModScreenHandlers;
import net.jubs.eclipse_do_caos.sound.ModSounds;
import net.jubs.eclipse_do_caos.util.ModCustomTrades;
import net.jubs.eclipse_do_caos.util.ModLootTableModifiers;
import net.jubs.eclipse_do_caos.world.gen.ModWorldGeneration;
import net.jubs.eclipse_do_caos.world.tree.ModFoliagePlacerTypes;
import net.jubs.eclipse_do_caos.world.tree.ModTrunkPlacerTypes;
import net.minecraft.block.ComposterBlock;
import net.minecraft.block.DispenserBlock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class EclipseDoCaos implements ModInitializer {
	public static final String MOD_ID = "eclipse_do_caos";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);


	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();

		ModItems.registerModItem();
		ModBlocks.registerModBlocks();

		ModLootTableModifiers.modifyLootTables();
		ModCustomTrades.registerCustomTrades();

		ModSounds.registerSounds();

		ModPaintings.registerPaintings();

		ModWorldGeneration.generateModWorldGen();
		ModTrunkPlacerTypes.register();
		ModFoliagePlacerTypes.register();

		ModBlocksEntities.registerBlockEntities();
		ModScreenHandlers.registerScreenHandlers();

		DispenserBlock.registerBehavior(ModItems.CANNONBALL, new CannonballDispenserBehavior());

		ModBoats.registarBoats();

		StrippableBlockRegistry.register(ModBlocks.EDEN_LOG, ModBlocks.STRIPPED_EDEN_LOG);
		StrippableBlockRegistry.register(ModBlocks.EDEN_WOOD, ModBlocks.STRIPPED_EDEN_WOOD);

		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.EDEN_LOG, 2, 3);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.EDEN_WOOD, 2, 3);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_EDEN_LOG, 2, 3);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_EDEN_WOOD, 2, 3);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.EDEN_PLANKS, 6, 16);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.EDEN_LEAVES, 20, 40);

		ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.EDEN_APPLE, 0.5f);
		ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.EDEN_TREE_APPLE, 0.8f);
		ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.BEAN, 0.2f);
		ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.COOKED_BEAN, 0.35f);
		ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModBlocks.EDEN_SAPLING, 0.45f);
		ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModBlocks.BROMELIAD, 0.65f);
		ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModBlocks.EDEN_LEAVES, 0.4f);
	}
}