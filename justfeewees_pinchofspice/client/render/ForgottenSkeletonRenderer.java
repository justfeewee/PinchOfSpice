package io.github.justfeewee.justfeewees_pinchofspice.client.render;

import io.github.justfeewee.justfeewees_pinchofspice.PinchOfSpice;
import io.github.justfeewee.justfeewees_pinchofspice.client.models.ForgottenSkeletonModel;
import io.github.justfeewee.justfeewees_pinchofspice.client.models.SkeletonMinerModel;
import io.github.justfeewee.justfeewees_pinchofspice.entities.ForgottenSkeleton;
import io.github.justfeewee.justfeewees_pinchofspice.entities.SkeletonMiner;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class ForgottenSkeletonRenderer extends MobRenderer<ForgottenSkeleton, ForgottenSkeletonModel> {
    private static ResourceLocation TEXTURE = new ResourceLocation(PinchOfSpice.MODID, "textures/entities/forgotten_skeleton.png");
    public ForgottenSkeletonRenderer(EntityRendererProvider.Context context) {
        super(context, new ForgottenSkeletonModel(context.bakeLayer(ForgottenSkeletonModel.LAYER_LOCATION)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(ForgottenSkeleton p_114482_) {
        return TEXTURE;
    }
}
