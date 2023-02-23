package io.github.justfeewee.justfeewees_pinchofspice.client.render;

import io.github.justfeewee.justfeewees_pinchofspice.PinchOfSpice;
import io.github.justfeewee.justfeewees_pinchofspice.client.models.FloweredSkeletonModel;
import io.github.justfeewee.justfeewees_pinchofspice.entities.FloweredSkeleton;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class FloweredSkeletonRenderer extends MobRenderer<FloweredSkeleton, FloweredSkeletonModel> {
    private static ResourceLocation TEXTURE = new ResourceLocation(PinchOfSpice.MODID, "textures/entities/flowered_skeleton.png");
    public FloweredSkeletonRenderer(EntityRendererProvider.Context context) {
        super(context, new FloweredSkeletonModel(context.bakeLayer(FloweredSkeletonModel.LAYER_LOCATION)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(FloweredSkeleton p_114482_) {
        return TEXTURE;
    }
}
