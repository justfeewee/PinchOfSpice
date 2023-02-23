package io.github.justfeewee.justfeewees_pinchofspice.client.render;

import io.github.justfeewee.justfeewees_pinchofspice.PinchOfSpice;
import io.github.justfeewee.justfeewees_pinchofspice.client.models.TombZombieModel;
import io.github.justfeewee.justfeewees_pinchofspice.entities.TombZombie;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class TombZombieRenderer extends MobRenderer<TombZombie, TombZombieModel> {
    private static ResourceLocation TEXTURE = new ResourceLocation(PinchOfSpice.MODID, "textures/entities/tomb_zombie.png");
    public TombZombieRenderer(EntityRendererProvider.Context context) {
        super(context, new TombZombieModel(context.bakeLayer(TombZombieModel.LAYER_LOCATION)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(TombZombie entity) {
        return TEXTURE;
    }
}
