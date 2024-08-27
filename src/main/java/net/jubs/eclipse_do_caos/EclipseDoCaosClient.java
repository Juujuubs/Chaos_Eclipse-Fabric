package net.jubs.eclipse_do_caos;

import com.terraformersmc.terraform.boat.api.client.TerraformBoatClientHelper;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.jubs.eclipse_do_caos.blocks.ModBlocks;
import net.jubs.eclipse_do_caos.blocks.entity.ModBlocksEntities;
import net.jubs.eclipse_do_caos.entity.ModBoats;
import net.jubs.eclipse_do_caos.util.ModModelPredicateProvider;
import net.jubs.eclipse_do_caos.screen.CatalystInfuserScreen;
import net.jubs.eclipse_do_caos.screen.ModScreenHandlers;
import net.jubs.eclipse_do_caos.util.ModWoodTypes;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.TexturedRenderLayers;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import net.minecraft.client.render.block.entity.HangingSignBlockEntityRenderer;
import net.minecraft.client.render.block.entity.SignBlockEntityRenderer;

public class EclipseDoCaosClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BROMELIAD, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.POTTED_BROMELIAD, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.EDEN_LEAVES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.EDEN_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.POTTED_EDEN_SAPLING, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SAMARA_PLUSHIE, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BEAN_CROP, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getTranslucent(), ModBlocks.CATALYST_INFUSER);


        HandledScreens.register(ModScreenHandlers.CATALYST_INFUSER_SCREEN_HANDLER, CatalystInfuserScreen::new);

        ModModelPredicateProvider.registerModModels();

        BlockEntityRendererFactories.register(ModBlocksEntities.MOD_SIGN_BLOCK_ENTITY, SignBlockEntityRenderer::new);
        BlockEntityRendererFactories.register(ModBlocksEntities.MOD_HANGING_SIGN_BLOCK_ENTITY, HangingSignBlockEntityRenderer::new);


        TexturedRenderLayers.SIGN_TYPE_TEXTURES.put(ModWoodTypes.EDEN, TexturedRenderLayers.getSignTextureId(ModWoodTypes.EDEN));

        TerraformBoatClientHelper.registerModelLayers(ModBoats.EDEN_BOAT_ID, false);
    }
}
