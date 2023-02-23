package io.github.justfeewee.justfeewees_pinchofspice.client.render;

import io.github.justfeewee.justfeewees_pinchofspice.PinchOfSpice;
import io.github.justfeewee.justfeewees_pinchofspice.client.models.CoralSkeletonModel;
import io.github.justfeewee.justfeewees_pinchofspice.entities.CoralSkeleton;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class CoralSkeletonRenderer extends MobRenderer<CoralSkeleton, CoralSkeletonModel> {
    private static ResourceLocation TEXTURE = new ResourceLocation(PinchOfSpice.MODID, "textures/entities/coral_skeleton.png");
    public CoralSkeletonRenderer(EntityRendererProvider.Context context) {
        super(context, new CoralSkeletonModel(context.bakeLayer(CoralSkeletonModel.LAYER_LOCATION)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(CoralSkeleton p_114482_) {
        return TEXTURE;
    }
}
