package io.github.justfeewee.justfeewees_pinchofspice.client.render;

import io.github.justfeewee.justfeewees_pinchofspice.PinchOfSpice;
import io.github.justfeewee.justfeewees_pinchofspice.client.models.HuskSkeletonModel;
import io.github.justfeewee.justfeewees_pinchofspice.entities.HuskSkeleton;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class HuskSkeletonRenderer extends MobRenderer<HuskSkeleton, HuskSkeletonModel> {
    private static ResourceLocation TEXTURE = new ResourceLocation(PinchOfSpice.MODID, "textures/entities/husk_skeleton.png");
    public HuskSkeletonRenderer(EntityRendererProvider.Context context) {
        super(context, new HuskSkeletonModel(context.bakeLayer(HuskSkeletonModel.LAYER_LOCATION)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(HuskSkeleton p_114482_) {
        return TEXTURE;
    }
}
