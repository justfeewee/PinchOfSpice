package io.github.justfeewee.justfeewees_pinchofspice.client.render;

import io.github.justfeewee.justfeewees_pinchofspice.PinchOfSpice;
import io.github.justfeewee.justfeewees_pinchofspice.client.models.TempleZombieModel;
import io.github.justfeewee.justfeewees_pinchofspice.entities.TempleZombie;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class TempleZombieRenderer extends MobRenderer<TempleZombie, TempleZombieModel> {
    private static ResourceLocation TEXTURE = new ResourceLocation(PinchOfSpice.MODID, "textures/entities/temple_zombie.png");
    public TempleZombieRenderer(EntityRendererProvider.Context context) {
        super(context, new TempleZombieModel(context.bakeLayer(TempleZombieModel.LAYER_LOCATION)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(TempleZombie entity) {
        return TEXTURE;
    }
}
