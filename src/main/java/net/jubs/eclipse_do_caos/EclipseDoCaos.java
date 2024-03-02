package net.jubs.eclipse_do_caos;
import net.fabricmc.api.ModInitializer;

import net.jubs.eclipse_do_caos.blocks.ModBlocks;
import net.jubs.eclipse_do_caos.effect.ModEffects;
import net.jubs.eclipse_do_caos.items.ModItemGroups;
import net.jubs.eclipse_do_caos.items.ModItems;
import net.jubs.eclipse_do_caos.sound.ModSounds;
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

		ModSounds.registerSounds();

		ModEffects.registerEffects();
	}
}