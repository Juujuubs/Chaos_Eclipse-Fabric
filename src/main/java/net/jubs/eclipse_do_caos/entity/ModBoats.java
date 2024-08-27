package net.jubs.eclipse_do_caos.entity;

import com.terraformersmc.terraform.boat.api.TerraformBoatType;
import com.terraformersmc.terraform.boat.api.TerraformBoatTypeRegistry;
import net.jubs.eclipse_do_caos.EclipseDoCaos;
import net.jubs.eclipse_do_caos.blocks.ModBlocks;
import net.jubs.eclipse_do_caos.items.ModItems;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

public class ModBoats {
    public static final Identifier EDEN_BOAT_ID = new Identifier(EclipseDoCaos.MOD_ID, "eden_boat");
    public static final Identifier EDEN_CHEST_BOAT_ID = new Identifier(EclipseDoCaos.MOD_ID, "eden_chest_boat");

    public static final RegistryKey<TerraformBoatType> EDEN_BOAT_KEY = TerraformBoatTypeRegistry.createKey(EDEN_BOAT_ID);

    public static void registarBoats() {
        TerraformBoatType edenBoat = new TerraformBoatType.Builder()
                .item(ModItems.EDEN_BOAT)
                .chestItem(ModItems.EDEN_CHEST_BOAT)
                .planks(ModBlocks.EDEN_PLANKS.asItem())
                .build();

        Registry.register(TerraformBoatTypeRegistry.INSTANCE, EDEN_BOAT_KEY, edenBoat);
    }
}
