package net.jubs.eclipse_do_caos.blocks.entity;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.jubs.eclipse_do_caos.EclipseDoCaos;
import net.jubs.eclipse_do_caos.blocks.ModBlocks;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocksEntities {
    public static final BlockEntityType<CatalystInfuserBlockEntity> CATALYST_INFUSER_BLOCK_ENTITY =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(EclipseDoCaos.MOD_ID,"catalyst_infuser_be"),
                    FabricBlockEntityTypeBuilder.create(CatalystInfuserBlockEntity::new,
                            ModBlocks.CATALYST_INFUSER).build());


    public static final BlockEntityType<ModSignBlockEntity> MOD_SIGN_BLOCK_ENTITY = Registry.register(Registries.BLOCK_ENTITY_TYPE,
            new Identifier(EclipseDoCaos.MOD_ID, "mod_sign_entity"),
            FabricBlockEntityTypeBuilder.create(ModSignBlockEntity::new,
                    ModBlocks.EDEN_SIGN, ModBlocks.EDEN_WALL_SIGN).build());

    public static final BlockEntityType<ModHangingSignBlockEntity> MOD_HANGING_SIGN_BLOCK_ENTITY = Registry.register(Registries.BLOCK_ENTITY_TYPE,
            new Identifier(EclipseDoCaos.MOD_ID, "mod_hanging_sign_entity"),
            FabricBlockEntityTypeBuilder.create(ModHangingSignBlockEntity::new,
                    ModBlocks.EDEN_HANGING_SIGN, ModBlocks.EDEN_HANGING_WALL_SIGN).build());

    public static void registerBlockEntities() {
        EclipseDoCaos.LOGGER.info("Registrando Block Entities para " + EclipseDoCaos.MOD_ID);
    }
}
