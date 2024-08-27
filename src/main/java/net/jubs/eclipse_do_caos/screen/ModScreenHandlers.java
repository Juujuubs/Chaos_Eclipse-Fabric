package net.jubs.eclipse_do_caos.screen;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.jubs.eclipse_do_caos.EclipseDoCaos;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

public class ModScreenHandlers {
    public static final ScreenHandlerType<CatalystInfuserScreenHandler> CATALYST_INFUSER_SCREEN_HANDLER =
            Registry.register(Registries.SCREEN_HANDLER, new Identifier(EclipseDoCaos.MOD_ID, "catalyst_infusing"),
                    new ExtendedScreenHandlerType<>(CatalystInfuserScreenHandler::new));

    public static void registerScreenHandlers() {
        EclipseDoCaos.LOGGER.info("Registrando Screen Handlers para " + EclipseDoCaos.MOD_ID);
    }
}
