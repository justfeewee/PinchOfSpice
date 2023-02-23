package io.github.justfeewee.justfeewees_pinchofspice.client.render;

import io.github.justfeewee.justfeewees_pinchofspice.PinchOfSpice;
import io.github.justfeewee.justfeewees_pinchofspice.client.models.SkulkZombieModel;
import io.github.justfeewee.justfeewees_pinchofspice.entities.SkulkZombie;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class SkulkZombieRenderer extends MobRenderer<SkulkZombie, SkulkZombieModel> {
    private static ResourceLocation TEXTURE = new ResourceLocation(PinchOfSpice.MODID, "textures/entities/skulk_zombie.png");
    public SkulkZombieRenderer(EntityRendererProvider.Context context) {
        super(context, new SkulkZombieModel(context.bakeLayer(SkulkZombieModel.LAYER_LOCATION)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(SkulkZombie entity) {
        return TEXTURE;
    }
}
