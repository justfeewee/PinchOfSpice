package io.github.justfeewee.justfeewees_pinchofspice.client.render;

import io.github.justfeewee.justfeewees_pinchofspice.PinchOfSpice;
import io.github.justfeewee.justfeewees_pinchofspice.client.models.SkeletonMinerModel;
import io.github.justfeewee.justfeewees_pinchofspice.entities.SkeletonMiner;
import net.minecraft.client.model.ArmedModel;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.ItemInHandRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.CustomHeadLayer;
import net.minecraft.client.renderer.entity.layers.ElytraLayer;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

public class SkeletonMinerRenderer extends MobRenderer<SkeletonMiner, SkeletonMinerModel> {
    private static ResourceLocation TEXTURE = new ResourceLocation(PinchOfSpice.MODID, "textures/entities/skeleton_miner.png");

    public SkeletonMinerRenderer(EntityRendererProvider.Context context) {
        super(context, new SkeletonMinerModel(context.bakeLayer(SkeletonMinerModel.LAYER_LOCATION)), 0.5f);
        this.addLayer(new ItemInHandLayer<>(this, context.getItemInHandRenderer()));
    }

        @Override
        public ResourceLocation getTextureLocation (SkeletonMiner entity){
            return TEXTURE;
        }
    }
