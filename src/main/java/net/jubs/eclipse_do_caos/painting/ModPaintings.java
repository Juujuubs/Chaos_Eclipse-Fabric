package net.jubs.eclipse_do_caos.painting;

import net.jubs.eclipse_do_caos.EclipseDoCaos;
import net.minecraft.entity.decoration.painting.PaintingVariant;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModPaintings {
    public static final PaintingVariant THE_FIRST_KIN = registerPainting("the_first_kin", new PaintingVariant(128, 64));
    public static final PaintingVariant GODWELLING = registerPainting("godwelling", new PaintingVariant(64, 32));
    public static final PaintingVariant GODWELLING_NOW = registerPainting("godwelling_now", new PaintingVariant(32, 32));
    public static final PaintingVariant BELAIOS = registerPainting("belaios", new PaintingVariant(16, 16));
    public static final PaintingVariant JUNO = registerPainting("juno", new PaintingVariant(16, 16));
    public static final PaintingVariant QRAZ = registerPainting("qraz", new PaintingVariant(16, 16));
    public static final PaintingVariant RAVEN = registerPainting("raven", new PaintingVariant(16, 16));
    public static final PaintingVariant VEIGAR = registerPainting("veigar", new PaintingVariant(16, 16));
    public static final PaintingVariant VEX = registerPainting("vex", new PaintingVariant(16, 16));
    public static final PaintingVariant BELORIA_BONISSIMO = registerPainting("beloria_bonissimo", new PaintingVariant(16, 32));
private static PaintingVariant registerPainting(String name, PaintingVariant paintingVariant) {
    return Registry.register(Registries.PAINTING_VARIANT, new Identifier(EclipseDoCaos.MOD_ID, name), paintingVariant);
}

    public static  void registerPaintings() {
        EclipseDoCaos.LOGGER.debug("Registrando Pinturas para " + EclipseDoCaos.MOD_ID);
    }
}
