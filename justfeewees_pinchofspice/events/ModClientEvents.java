package io.github.justfeewee.justfeewees_pinchofspice.events;

import io.github.justfeewee.justfeewees_pinchofspice.PinchOfSpice;
import io.github.justfeewee.justfeewees_pinchofspice.client.models.*;
import io.github.justfeewee.justfeewees_pinchofspice.client.render.*;
import io.github.justfeewee.justfeewees_pinchofspice.entities.OvergrownZombie;
import io.github.justfeewee.justfeewees_pinchofspice.entities.TempleZombie;
import io.github.justfeewee.justfeewees_pinchofspice.entities.TombZombie;
import io.github.justfeewee.justfeewees_pinchofspice.init.BlockInit;
import io.github.justfeewee.justfeewees_pinchofspice.init.EntityInit;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = PinchOfSpice.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModClientEvents {

    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent event) {
        ItemBlockRenderTypes.setRenderLayer(BlockInit.FOXGLOVES.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BlockInit.CHRYSANTHEMUM.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BlockInit.ALOE_VERA.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BlockInit.BERSERKER_MUSHROOM_PLANT.get(), RenderType.cutout());
    }

    @SubscribeEvent
    public static void entityRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(EntityInit.SKELETON_MINER.get(), SkeletonMinerRenderer:: new);
        event.registerEntityRenderer(EntityInit.FORGOTTEN_SKELETON.get(), ForgottenSkeletonRenderer:: new);
        event.registerEntityRenderer(EntityInit.CORAL_SKELETON.get(), CoralSkeletonRenderer:: new);
        event.registerEntityRenderer(EntityInit.FISHERMAN_SKELETON.get(), FishermanSkeletonRenderer:: new);
        event.registerEntityRenderer(EntityInit.FLOWERED_SKELETON.get(), FloweredSkeletonRenderer:: new);
        event.registerEntityRenderer(EntityInit.HUSK_SKELETON.get(), HuskSkeletonRenderer:: new);
        event.registerEntityRenderer(EntityInit.BURIED_SKELETON.get(), BuriedSkeletonRenderer:: new);
        event.registerEntityRenderer(EntityInit.PIRATE_SKELETON.get(), PirateSkeletonRenderer:: new);
        event.registerEntityRenderer(EntityInit.GIANT_SKELETON.get(), GiantSkeletonRenderer:: new);
        event.registerEntityRenderer(EntityInit.MUMMY.get(), MummyRenderer:: new);
        event.registerEntityRenderer(EntityInit.OVERGROWN_ZOMBIE.get(), OvergrownZombieRenderer:: new);
        event.registerEntityRenderer(EntityInit.TOMB_ZOMBIE.get(), TombZombieRenderer:: new);
        event.registerEntityRenderer(EntityInit.TEMPLE_ZOMBIE.get(), TempleZombieRenderer:: new);
        event.registerEntityRenderer(EntityInit.SKULK_ZOMBIE.get(), SkulkZombieRenderer:: new);
        event.registerEntityRenderer(EntityInit.FROZEN_ZOMBIE_MINER.get(), FrozenZombieMinerRenderer:: new);
        event.registerEntityRenderer(EntityInit.FROZEN_ZOMBIE.get(), FrozenZombieRenderer:: new);
        event.registerEntityRenderer(EntityInit.POSSESSED_DUMMY.get(), PossessedDummyRenderer:: new);
        event.registerEntityRenderer(EntityInit.ZOMBIE_MINER.get(), ZombieMinerRenderer:: new);
        event.registerEntityRenderer(EntityInit.SKELETON_SORCERER.get(), SkeletonSorcererRenderer:: new);
        event.registerEntityRenderer(EntityInit.ZOMBIE_BRUTE.get(), ZombieBruteRenderer:: new);



    }

    @SubscribeEvent
    public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(SkeletonMinerModel.LAYER_LOCATION, SkeletonMinerModel:: createBodyLayer);
        event.registerLayerDefinition(ForgottenSkeletonModel.LAYER_LOCATION, ForgottenSkeletonModel:: createBodyLayer);
        event.registerLayerDefinition(CoralSkeletonModel.LAYER_LOCATION, CoralSkeletonModel:: createBodyLayer);
        event.registerLayerDefinition(FishermanSkeletonModel.LAYER_LOCATION, FishermanSkeletonModel:: createBodyLayer);
        event.registerLayerDefinition(FloweredSkeletonModel.LAYER_LOCATION, FloweredSkeletonModel:: createBodyLayer);
        event.registerLayerDefinition(HuskSkeletonModel.LAYER_LOCATION, HuskSkeletonModel:: createBodyLayer);
        event.registerLayerDefinition(BuriedSkeletonModel.LAYER_LOCATION, BuriedSkeletonModel:: createBodyLayer);
        event.registerLayerDefinition(PirateSkeletonModel.LAYER_LOCATION, PirateSkeletonModel:: createBodyLayer);
        event.registerLayerDefinition(GiantSkeletonModel.LAYER_LOCATION, GiantSkeletonModel:: createBodyLayer);
        event.registerLayerDefinition(MummyModel.LAYER_LOCATION, MummyModel:: createBodyLayer);
        event.registerLayerDefinition(OvergrownZombieModel.LAYER_LOCATION, OvergrownZombieModel:: createBodyLayer);
        event.registerLayerDefinition(TombZombieModel.LAYER_LOCATION, TombZombieModel:: createBodyLayer);
        event.registerLayerDefinition(TempleZombieModel.LAYER_LOCATION, TempleZombieModel:: createBodyLayer);
        event.registerLayerDefinition(SkulkZombieModel.LAYER_LOCATION, SkulkZombieModel:: createBodyLayer);
        event.registerLayerDefinition(FrozenZombieMinerModel.LAYER_LOCATION, FrozenZombieMinerModel:: createBodyLayer);
        event.registerLayerDefinition(FrozenZombieModel.LAYER_LOCATION, FrozenZombieModel:: createBodyLayer);
        event.registerLayerDefinition(PossessedDummyModel.LAYER_LOCATION, PossessedDummyModel:: createBodyLayer);
        event.registerLayerDefinition(ZombieMinerModel.LAYER_LOCATION, ZombieMinerModel:: createBodyLayer);
        event.registerLayerDefinition(SkeletonSorcererModel.LAYER_LOCATION, SkeletonSorcererModel:: createBodyLayer);
        event.registerLayerDefinition(ZombieBruteModel.LAYER_LOCATION, ZombieBruteModel:: createBodyLayer);


    }
}
