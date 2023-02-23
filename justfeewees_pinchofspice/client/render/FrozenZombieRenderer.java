package io.github.justfeewee.justfeewees_pinchofspice.client.render;

import io.github.justfeewee.justfeewees_pinchofspice.PinchOfSpice;
import io.github.justfeewee.justfeewees_pinchofspice.client.models.FrozenZombieModel;
import io.github.justfeewee.justfeewees_pinchofspice.entities.FrozenZombie;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class FrozenZombieRenderer extends MobRenderer<FrozenZombie, FrozenZombieModel> {
    private static ResourceLocation TEXTURE = new ResourceLocation(PinchOfSpice.MODID, "textures/entities/frozen_zombie.png");
    public FrozenZombieRenderer(EntityRendererProvider.Context context) {
        super(context, new FrozenZombieModel(context.bakeLayer(FrozenZombieModel.LAYER_LOCATION)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(FrozenZombie entity) {
        return TEXTURE;
    }
}
