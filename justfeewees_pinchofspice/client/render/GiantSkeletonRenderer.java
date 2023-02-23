package io.github.justfeewee.justfeewees_pinchofspice.client.render;

import io.github.justfeewee.justfeewees_pinchofspice.PinchOfSpice;
import io.github.justfeewee.justfeewees_pinchofspice.client.models.GiantSkeletonModel;
import io.github.justfeewee.justfeewees_pinchofspice.entities.GiantSkeleton;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class GiantSkeletonRenderer extends MobRenderer<GiantSkeleton, GiantSkeletonModel> {
    private static ResourceLocation TEXTURE = new ResourceLocation(PinchOfSpice.MODID, "textures/entities/giant_skeleton.png");
    public GiantSkeletonRenderer(EntityRendererProvider.Context context) {
        super(context, new GiantSkeletonModel(context.bakeLayer(GiantSkeletonModel.LAYER_LOCATION)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(GiantSkeleton p_114482_) {
        return TEXTURE;
    }
}
