package io.github.justfeewee.justfeewees_pinchofspice.client.render;

import io.github.justfeewee.justfeewees_pinchofspice.PinchOfSpice;
import io.github.justfeewee.justfeewees_pinchofspice.client.models.OvergrownZombieModel;
import io.github.justfeewee.justfeewees_pinchofspice.entities.OvergrownZombie;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class OvergrownZombieRenderer extends MobRenderer<OvergrownZombie, OvergrownZombieModel> {
    private static ResourceLocation TEXTURE = new ResourceLocation(PinchOfSpice.MODID, "textures/entities/overgrown_zombie.png");
    public OvergrownZombieRenderer(EntityRendererProvider.Context context) {
        super(context, new OvergrownZombieModel(context.bakeLayer(OvergrownZombieModel.LAYER_LOCATION)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(OvergrownZombie entity) {
        return TEXTURE;
    }
}
