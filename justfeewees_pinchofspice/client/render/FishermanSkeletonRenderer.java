package io.github.justfeewee.justfeewees_pinchofspice.client.render;

import io.github.justfeewee.justfeewees_pinchofspice.PinchOfSpice;
import io.github.justfeewee.justfeewees_pinchofspice.client.models.CoralSkeletonModel;
import io.github.justfeewee.justfeewees_pinchofspice.client.models.FishermanSkeletonModel;
import io.github.justfeewee.justfeewees_pinchofspice.entities.CoralSkeleton;
import io.github.justfeewee.justfeewees_pinchofspice.entities.FishermanSkeleton;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class FishermanSkeletonRenderer extends MobRenderer<FishermanSkeleton, FishermanSkeletonModel> {
    private static ResourceLocation TEXTURE = new ResourceLocation(PinchOfSpice.MODID, "textures/entities/fisherman_skeleton.png");
    public FishermanSkeletonRenderer(EntityRendererProvider.Context context) {
        super(context, new FishermanSkeletonModel(context.bakeLayer(FishermanSkeletonModel.LAYER_LOCATION)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(FishermanSkeleton p_114482_) {
        return TEXTURE;
    }
}
