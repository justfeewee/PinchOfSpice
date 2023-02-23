package io.github.justfeewee.justfeewees_pinchofspice.client.render;

import io.github.justfeewee.justfeewees_pinchofspice.PinchOfSpice;
import io.github.justfeewee.justfeewees_pinchofspice.client.models.FrozenZombieMinerModel;
import io.github.justfeewee.justfeewees_pinchofspice.entities.FrozenZombieMiner;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class FrozenZombieMinerRenderer extends MobRenderer<FrozenZombieMiner, FrozenZombieMinerModel> {
    private static ResourceLocation TEXTURE = new ResourceLocation(PinchOfSpice.MODID, "textures/entities/frozen_zombie_miner.png");
    public FrozenZombieMinerRenderer(EntityRendererProvider.Context context) {
        super(context, new FrozenZombieMinerModel(context.bakeLayer(FrozenZombieMinerModel.LAYER_LOCATION)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(FrozenZombieMiner entity) {
        return TEXTURE;
    }
}
