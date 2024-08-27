package net.jubs.eclipse_do_caos.util;

import net.fabricmc.fabric.api.object.builder.v1.block.type.WoodTypeRegistry;
import net.jubs.eclipse_do_caos.EclipseDoCaos;
import net.minecraft.block.BlockSetType;
import net.minecraft.block.WoodType;
import net.minecraft.util.Identifier;

public class ModWoodTypes {
    public static final WoodType EDEN = WoodTypeRegistry.register(new Identifier(EclipseDoCaos.MOD_ID, "eden"), BlockSetType.OAK);
}
