package io.github.justfeewee.justfeewees_pinchofspice.events;

import io.github.justfeewee.justfeewees_pinchofspice.PinchOfSpice;
import io.github.justfeewee.justfeewees_pinchofspice.entities.*;
import io.github.justfeewee.justfeewees_pinchofspice.init.EntityInit;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.monster.Skeleton;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod.EventBusSubscriber(modid = PinchOfSpice.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModCommonEvents {

    @SubscribeEvent
    public static void entityAttribute(EntityAttributeCreationEvent event) {
        event.put(EntityInit.SKELETON_MINER.get(), SkeletonMiner.getSkeletonMinerAttributes().build());
        event.put(EntityInit.FORGOTTEN_SKELETON.get(), ForgottenSkeleton.getForgottenSkeletonAttributes().build());
        event.put(EntityInit.CORAL_SKELETON.get(), CoralSkeleton.getCoralSkeletonAttributes().build());
        event.put(EntityInit.FISHERMAN_SKELETON.get(), FishermanSkeleton.getFishermanSkeletonAttributes().build());
        event.put(EntityInit.FLOWERED_SKELETON.get(), FloweredSkeleton.getFloweredSkeletonAttributes().build());
        event.put(EntityInit.HUSK_SKELETON.get(), HuskSkeleton.getHuskSkeletonAttributes().build());
        event.put(EntityInit.BURIED_SKELETON.get(), BuriedSkeleton.getBuriedSkeletonAttributes().build());
        event.put(EntityInit.PIRATE_SKELETON.get(), PirateSkeleton.getPirateSkeletonAttributes().build());
        event.put(EntityInit.GIANT_SKELETON.get(), GiantSkeleton.getGiantSkeletonAttributes().build());
        event.put(EntityInit.MUMMY.get(), Mummy.getMummyAttributes().build());
        event.put(EntityInit.OVERGROWN_ZOMBIE.get(), OvergrownZombie.getOvergrownZombieAttributes().build());
        event.put(EntityInit.TOMB_ZOMBIE.get(), TombZombie.getTombZombieAttributes().build());
        event.put(EntityInit.TEMPLE_ZOMBIE.get(), TempleZombie.getTempleZombieAttributes().build());
        event.put(EntityInit.SKULK_ZOMBIE.get(), SkulkZombie.getSkulkZombieAttributes().build());
        event.put(EntityInit.FROZEN_ZOMBIE_MINER.get(), FrozenZombieMiner.getFrozenZombieMinerAttributes().build());
        event.put(EntityInit.FROZEN_ZOMBIE.get(), FrozenZombie.getFrozenZombieAttributes().build());
        event.put(EntityInit.POSSESSED_DUMMY.get(), PossessedDummy.getPossessedDummyAttributes().build());
        event.put(EntityInit.ZOMBIE_MINER.get(), ZombieMiner.getZombieMinerAttributes().build());
        event.put(EntityInit.SKELETON_SORCERER.get(), SkeletonSorcerer.getSkeletonSorcererAttributes().build());
        event.put(EntityInit.ZOMBIE_BRUTE.get(), ZombieBrute.getZombieBruteAttributes().build());
    }

    @SubscribeEvent
    public static void commonSetup(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            SpawnPlacements.register(EntityInit.SKELETON_MINER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.WORLD_SURFACE, SkeletonMiner::canSpawn);
            SpawnPlacements.register(EntityInit.ZOMBIE_BRUTE.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.WORLD_SURFACE, ZombieBrute:: canSpawn);
        });
        }
    }

