package net.jubs.eclipse_do_caos;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.jubs.eclipse_do_caos.blocks.ModBlocks;
import net.minecraft.client.render.RenderLayer;

public class EclipseDoCaosClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BROMELIAD, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.POTTED_BROMELIAD, RenderLayer.getCutout());

    }
}
