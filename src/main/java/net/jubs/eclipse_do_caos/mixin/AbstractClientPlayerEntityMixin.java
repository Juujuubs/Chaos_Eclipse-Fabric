package net.jubs.eclipse_do_caos.mixin;

import net.jubs.eclipse_do_caos.items.ModItems;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(AbstractClientPlayerEntity.class)
public class AbstractClientPlayerEntityMixin {
    @Inject(method = "getFovMultiplier", at = @At("HEAD"), cancellable = true)
    private void getFovMultiplier(CallbackInfoReturnable<Float> info) {
        PlayerEntity player = (PlayerEntity) (Object) this;
        if (player.isUsingItem() && player.getActiveItem().isOf(ModItems.ZORA_BOW)) {
            float pullProgress = (float) (player.getActiveItem().getMaxUseTime() - player.getItemUseTimeLeft()) / 20.0f;
            pullProgress = Math.min(pullProgress, 1.0F); // Adiciona um limite no zoom de puxar o arco em relação ao limite do quanto foi puxado

            info.setReturnValue(1.0F - pullProgress * 0.15F);
        }
    }
}

