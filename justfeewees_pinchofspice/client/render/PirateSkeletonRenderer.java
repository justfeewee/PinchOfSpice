package io.github.justfeewee.justfeewees_pinchofspice.client.render;

import io.github.justfeewee.justfeewees_pinchofspice.PinchOfSpice;
import io.github.justfeewee.justfeewees_pinchofspice.client.models.PirateSkeletonModel;
import io.github.justfeewee.justfeewees_pinchofspice.entities.PirateSkeleton;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class PirateSkeletonRenderer extends MobRenderer<PirateSkeleton, PirateSkeletonModel> {
    private static ResourceLocation TEXTURE = new ResourceLocation(PinchOfSpice.MODID, "textures/entities/pirate_skeleton.png");
    public PirateSkeletonRenderer(EntityRendererProvider.Context context) {
        super(context, new PirateSkeletonModel(context.bakeLayer(PirateSkeletonModel.LAYER_LOCATION)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(PirateSkeleton p_114482_) {
        return TEXTURE;
    }
}
