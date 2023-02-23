package io.github.justfeewee.justfeewees_pinchofspice.client.render;

import io.github.justfeewee.justfeewees_pinchofspice.PinchOfSpice;
import io.github.justfeewee.justfeewees_pinchofspice.client.models.BuriedSkeletonModel;
import io.github.justfeewee.justfeewees_pinchofspice.entities.BuriedSkeleton;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class BuriedSkeletonRenderer extends MobRenderer<BuriedSkeleton, BuriedSkeletonModel> {
    private static ResourceLocation TEXTURE = new ResourceLocation(PinchOfSpice.MODID, "textures/entities/buried_skeleton.png");
    public BuriedSkeletonRenderer(EntityRendererProvider.Context context) {
        super(context, new BuriedSkeletonModel(context.bakeLayer(BuriedSkeletonModel.LAYER_LOCATION)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(BuriedSkeleton p_114482_) {
        return TEXTURE;
    }
}
