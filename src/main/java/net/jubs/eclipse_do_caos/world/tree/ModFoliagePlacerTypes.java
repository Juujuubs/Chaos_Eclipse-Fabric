package net.jubs.eclipse_do_caos.world.tree;

import net.jubs.eclipse_do_caos.EclipseDoCaos;
import net.jubs.eclipse_do_caos.mixin.FoliagePlacerTypeInvoker;
import net.jubs.eclipse_do_caos.world.tree.custom.EdenFoliagePlacer;
import net.minecraft.world.gen.foliage.FoliagePlacerType;

public class ModFoliagePlacerTypes {
    public static final FoliagePlacerType<?> EDEN_FOLIAGE_PLACER = FoliagePlacerTypeInvoker.callRegister("eden_foliage_placer", EdenFoliagePlacer.CODEC);

    public static void register() {
        EclipseDoCaos.LOGGER.info("Registrando Foliage Placers para " + EclipseDoCaos.MOD_ID);
    }
}
