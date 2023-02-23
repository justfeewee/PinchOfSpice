package io.github.justfeewee.justfeewees_pinchofspice.client.render;

import io.github.justfeewee.justfeewees_pinchofspice.PinchOfSpice;
import io.github.justfeewee.justfeewees_pinchofspice.client.models.PossessedDummyModel;
import io.github.justfeewee.justfeewees_pinchofspice.entities.PossessedDummy;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class PossessedDummyRenderer extends MobRenderer<PossessedDummy, PossessedDummyModel> {
    private static ResourceLocation TEXTURE = new ResourceLocation(PinchOfSpice.MODID, "textures/entities/possessed_dummy.png");
    public PossessedDummyRenderer(EntityRendererProvider.Context context) {
        super(context, new PossessedDummyModel(context.bakeLayer(PossessedDummyModel.LAYER_LOCATION)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(PossessedDummy entity) {
        return TEXTURE;
    }
}
