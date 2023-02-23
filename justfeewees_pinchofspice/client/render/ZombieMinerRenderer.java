package io.github.justfeewee.justfeewees_pinchofspice.client.render;

import io.github.justfeewee.justfeewees_pinchofspice.PinchOfSpice;
import io.github.justfeewee.justfeewees_pinchofspice.client.models.ZombieMinerModel;
import io.github.justfeewee.justfeewees_pinchofspice.entities.ZombieMiner;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class ZombieMinerRenderer extends MobRenderer<ZombieMiner, ZombieMinerModel> {
    private static ResourceLocation TEXTURE = new ResourceLocation(PinchOfSpice.MODID, "textures/entities/zombie_miner.png");
    public ZombieMinerRenderer(EntityRendererProvider.Context context) {
        super(context, new ZombieMinerModel(context.bakeLayer(ZombieMinerModel.LAYER_LOCATION)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(ZombieMiner entity) {
        return TEXTURE;
    }
}
