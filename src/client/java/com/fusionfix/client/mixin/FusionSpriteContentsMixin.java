package com.fusionfix.client.mixin;

import com.mojang.blaze3d.buffers.GpuBufferSlice;
import com.mojang.blaze3d.systems.CommandEncoder;
import com.mojang.blaze3d.textures.GpuTexture;
import com.mojang.blaze3d.platform.NativeImage;
import com.supermartijn642.fusion.api.texture.custom.ImageHelper;
import com.supermartijn642.fusion.texture.FusionSpriteContents;
import net.minecraft.client.renderer.texture.SpriteContents;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(FusionSpriteContents.class)
public abstract class FusionSpriteContentsMixin extends SpriteContents {

    private FusionSpriteContentsMixin() { super(null, null, null, null, null, null); }

    @Redirect(
        method = "uploadToTexture",
        at = @At(
            value = "INVOKE",
            target = "Lcom/mojang/blaze3d/systems/CommandEncoder;copyBufferToTexture(Lcom/mojang/blaze3d/buffers/GpuBufferSlice;IIIILcom/mojang/blaze3d/textures/GpuTexture;IIIIII)V"
        )
    )
    private void fusionIntelFix$cpuUpload(
        CommandEncoder encoder,
        GpuBufferSlice source,
        int sourceX, int sourceY, int sourceWidth, int sourceHeight,
        GpuTexture destination,
        int destinationX, int destinationY,
        int copyWidth, int copyHeight,
        int mipLevel, int arrayLayer
    ) {
        NativeImage cropped = ImageHelper.createCrop(this.byMipLevel[mipLevel], sourceX, sourceY, copyWidth, copyHeight, false);
        encoder.writeToTexture(destination, cropped, mipLevel, arrayLayer, destinationX, destinationY);
        cropped.close();
    }
}