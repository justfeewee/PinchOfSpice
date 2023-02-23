package io.github.justfeewee.justfeewees_pinchofspice.client.render;

import io.github.justfeewee.justfeewees_pinchofspice.PinchOfSpice;
import io.github.justfeewee.justfeewees_pinchofspice.client.models.MummyModel;
import io.github.justfeewee.justfeewees_pinchofspice.entities.Mummy;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class MummyRenderer extends MobRenderer<Mummy, MummyModel> {
    private static ResourceLocation TEXTURE = new ResourceLocation(PinchOfSpice.MODID, "textures/entities/mummy.png");
    public MummyRenderer(EntityRendererProvider.Context context) {
        super(context, new MummyModel(context.bakeLayer(MummyModel.LAYER_LOCATION)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(Mummy entity) {
        return TEXTURE;
    }
}
