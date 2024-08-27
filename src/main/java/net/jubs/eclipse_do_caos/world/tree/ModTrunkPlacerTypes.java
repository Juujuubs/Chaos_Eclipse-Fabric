package net.jubs.eclipse_do_caos.world.tree;

import net.jubs.eclipse_do_caos.EclipseDoCaos;
import net.jubs.eclipse_do_caos.mixin.TrunkPlacerTypeInvoker;
import net.jubs.eclipse_do_caos.world.tree.custom.EdenTrunkPlacer;
import net.minecraft.world.gen.trunk.TrunkPlacerType;

public class ModTrunkPlacerTypes {
    public static final TrunkPlacerType<?> EDEN_TRUNK_PLACER = TrunkPlacerTypeInvoker.callRegister("eden_trunk_placer", EdenTrunkPlacer.CODEC);

    public static void register() {
        EclipseDoCaos.LOGGER.info("Registrando Trunk Placers para " + EclipseDoCaos.MOD_ID);

    }
}
