package io.github.justfeewee.justfeewees_pinchofspice.client.render;

import io.github.justfeewee.justfeewees_pinchofspice.PinchOfSpice;
import io.github.justfeewee.justfeewees_pinchofspice.client.models.ZombieBruteModel;
import io.github.justfeewee.justfeewees_pinchofspice.entities.ZombieBrute;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class ZombieBruteRenderer extends MobRenderer<ZombieBrute, ZombieBruteModel> {
    private static ResourceLocation TEXTURE = new ResourceLocation(PinchOfSpice.MODID, "textures/entities/zombie_brute.png");
    public ZombieBruteRenderer(EntityRendererProvider.Context context) {
        super(context, new ZombieBruteModel(context.bakeLayer(ZombieBruteModel.LAYER_LOCATION)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(ZombieBrute entity) {
        return TEXTURE;
    }
}
