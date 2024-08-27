package net.jubs.eclipse_do_caos.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import net.jubs.eclipse_do_caos.EclipseDoCaos;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class CatalystInfuserScreen extends HandledScreen<CatalystInfuserScreenHandler> {
    private static final Identifier TEXTURE = new Identifier(EclipseDoCaos.MOD_ID, "textures/gui/catalyst_infuser_gui.png");

    public CatalystInfuserScreen(CatalystInfuserScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }

    @Override
    protected void init() {
        super.init();
        titleY = 1000;
        playerInventoryTitleY = 1000;
        // tira os títulos da tela
    }


    @Override
    protected void drawBackground(DrawContext context, float delta, int mouseX, int mouseY) {
        RenderSystem.setShader(GameRenderer::getPositionProgram);
        RenderSystem.setShaderColor(1f, 1f, 1f, 1f);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int x = (width - backgroundWidth) / 2;
        int y = (height - backgroundHeight) / 2;

        context.drawTexture(TEXTURE, x, y, 0, 0, backgroundWidth, backgroundHeight);

        renderProgressBar(context, x, y);


    }

    private void renderProgressBar(DrawContext context, int x, int y) {
        if(handler.isCrafting()) {
            context.drawTexture(TEXTURE, x + 14, y + 72, 14, 166, handler.getScaledProgress(), 2);
        }
    }
@Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        renderBackground(context); //tem algo errado aqui?
        super.render(context, mouseX, mouseY, delta);
        drawMouseoverTooltip(context, mouseX, mouseY);
}

}
