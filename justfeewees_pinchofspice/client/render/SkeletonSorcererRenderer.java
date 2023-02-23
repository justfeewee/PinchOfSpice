package io.github.justfeewee.justfeewees_pinchofspice.client.render;

import io.github.justfeewee.justfeewees_pinchofspice.PinchOfSpice;
import io.github.justfeewee.justfeewees_pinchofspice.client.models.SkeletonSorcererModel;
import io.github.justfeewee.justfeewees_pinchofspice.entities.SkeletonSorcerer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class SkeletonSorcererRenderer extends MobRenderer<SkeletonSorcerer, SkeletonSorcererModel> {
    private static ResourceLocation TEXTURE = new ResourceLocation(PinchOfSpice.MODID, "textures/entities/skeleton_sorcerer.png");
    public SkeletonSorcererRenderer(EntityRendererProvider.Context context) {
        super(context, new SkeletonSorcererModel(context.bakeLayer(SkeletonSorcererModel.LAYER_LOCATION)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(SkeletonSorcerer entity) {
        return TEXTURE;
    }
}
