package io.github.justfeewee.justfeewees_pinchofspice.init;

import io.github.justfeewee.justfeewees_pinchofspice.PinchOfSpice;
import io.github.justfeewee.justfeewees_pinchofspice.entities.*;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EntityInit {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, PinchOfSpice.MODID);

    // SKELETON MINER
    public static final RegistryObject<EntityType<SkeletonMiner>> SKELETON_MINER = ENTITIES.register("skeleton_miner", () -> EntityType.Builder.of(SkeletonMiner:: new, MobCategory.MONSTER).clientTrackingRange(20).sized(0.6F, 1.99F).build(PinchOfSpice.MODID + "skeleton_miner"));

    // FORGOTTEN SKELETON
    public static final RegistryObject<EntityType<ForgottenSkeleton>> FORGOTTEN_SKELETON = ENTITIES.register("forgotten_skeleton", () -> EntityType.Builder.of(ForgottenSkeleton:: new, MobCategory.MONSTER).clientTrackingRange(20).sized(0.6F, 1.99F).build(PinchOfSpice.MODID + "forgotten_skeleton"));

    // CORAL SKELETON
    public static final RegistryObject<EntityType<CoralSkeleton>> CORAL_SKELETON = ENTITIES.register("coral_skeleton", () -> EntityType.Builder.of(CoralSkeleton:: new, MobCategory.MONSTER).clientTrackingRange(20).sized(0.6F, 1.99F).build(PinchOfSpice.MODID + "coral_skeleton"));

    // FISHERMAN SKELETON
    public static final RegistryObject<EntityType<FishermanSkeleton>> FISHERMAN_SKELETON = ENTITIES.register("fisherman_skeleton", () -> EntityType.Builder.of(FishermanSkeleton:: new, MobCategory.MONSTER).clientTrackingRange(20).sized(0.6F, 1.99F).build(PinchOfSpice.MODID + "fisherman_skeleton"));

    // FLOWERED_SKELETON
    public static final RegistryObject<EntityType<FloweredSkeleton>> FLOWERED_SKELETON = ENTITIES.register("flowered_skeleton", () -> EntityType.Builder.of(FloweredSkeleton:: new, MobCategory.MONSTER).clientTrackingRange(20).sized(0.6F, 1.99F).build(PinchOfSpice.MODID + "flowered_skeleton"));

    // HUSK SKELETON
    public static final RegistryObject<EntityType<HuskSkeleton>> HUSK_SKELETON = ENTITIES.register("husk_skeleton", () -> EntityType.Builder.of(HuskSkeleton:: new, MobCategory.MONSTER).clientTrackingRange(20).sized(0.6F, 1.99F).build(PinchOfSpice.MODID + "husk_skeleton"));

    // BURIED_SKELETON
    public static final RegistryObject<EntityType<BuriedSkeleton>> BURIED_SKELETON = ENTITIES.register("buried_skeleton", () -> EntityType.Builder.of(BuriedSkeleton:: new, MobCategory.MONSTER).clientTrackingRange(20).sized(0.6F, 1.99F).build(PinchOfSpice.MODID + "buried_skeleton"));

    // PIRATE_SKELETON
    public static final RegistryObject<EntityType<PirateSkeleton>> PIRATE_SKELETON = ENTITIES.register("pirate_skeleton", () -> EntityType.Builder.of(PirateSkeleton:: new, MobCategory.MONSTER).clientTrackingRange(20).sized(0.6F, 1.99F).build(PinchOfSpice.MODID + "pirate_skeleton"));

    // MUMMY
    public static final RegistryObject<EntityType<Mummy>> MUMMY = ENTITIES.register("mummy", () -> EntityType.Builder.of(Mummy:: new, MobCategory.MONSTER).clientTrackingRange(20).sized(0.6F, 1.99F).build(PinchOfSpice.MODID + "mummy"));

    // GIANT_SKELETON
    public static final RegistryObject<EntityType<GiantSkeleton>> GIANT_SKELETON = ENTITIES.register("giant_skeleton", () -> EntityType.Builder.of(GiantSkeleton:: new, MobCategory.MONSTER).clientTrackingRange(20).sized(0.6F, 1.99F).build(PinchOfSpice.MODID + "giant_skeleton"));

    // OVERGROWN ZOMBIE
    public static final RegistryObject<EntityType<OvergrownZombie>> OVERGROWN_ZOMBIE = ENTITIES.register("overgrown_zombie", () -> EntityType.Builder.of(OvergrownZombie:: new, MobCategory.MONSTER).clientTrackingRange(20).sized(0.6F, 1.99F).build(PinchOfSpice.MODID + "overgrown_zombie"));

    // TOMB ZOMBIE
    public static final RegistryObject<EntityType<TombZombie>> TOMB_ZOMBIE = ENTITIES.register("tomb_zombie", () -> EntityType.Builder.of(TombZombie:: new, MobCategory.MONSTER).clientTrackingRange(20).sized(0.6F, 1.99F).build(PinchOfSpice.MODID + "tomb_zombie"));

    // TEMPLE ZOMBIE
    public static final RegistryObject<EntityType<TempleZombie>> TEMPLE_ZOMBIE = ENTITIES.register("temple_zombie", () -> EntityType.Builder.of(TempleZombie:: new, MobCategory.MONSTER).clientTrackingRange(20).sized(0.6F, 1.99F).build(PinchOfSpice.MODID + "temple_zombie"));

    // SKULK ZOMBIE
    public static final RegistryObject<EntityType<SkulkZombie>> SKULK_ZOMBIE = ENTITIES.register("skulk_zombie", () -> EntityType.Builder.of(SkulkZombie:: new, MobCategory.MONSTER).clientTrackingRange(20).sized(0.6F, 1.99F).build(PinchOfSpice.MODID + "skulk_zombie"));

    // FROZEN ZOMBIE
    public static final RegistryObject<EntityType<FrozenZombie>> FROZEN_ZOMBIE = ENTITIES.register("frozen_zombie", () -> EntityType.Builder.of(FrozenZombie:: new, MobCategory.MONSTER).clientTrackingRange(20).sized(0.6F, 1.99F).build(PinchOfSpice.MODID + "frozen_zombie"));

    // FROZEN ZOMBIE MINER
    public static final RegistryObject<EntityType<FrozenZombieMiner>> FROZEN_ZOMBIE_MINER = ENTITIES.register("frozen_zombie_miner", () -> EntityType.Builder.of(FrozenZombieMiner:: new, MobCategory.MONSTER).clientTrackingRange(20).sized(0.6F, 1.99F).build(PinchOfSpice.MODID + "frozen_zombie_miner"));

    // POSSESSED DUMMY
    public static final RegistryObject<EntityType<PossessedDummy>> POSSESSED_DUMMY = ENTITIES.register("possessed_dummy", () -> EntityType.Builder.of(PossessedDummy:: new, MobCategory.MONSTER).clientTrackingRange(20).sized(0.6F, 1.99F).build(PinchOfSpice.MODID + "possessed_dummy"));

    // ZOMBIE MINER
    public static final RegistryObject<EntityType<ZombieMiner>> ZOMBIE_MINER = ENTITIES.register("zombie_miner", () -> EntityType.Builder.of(ZombieMiner:: new, MobCategory.MONSTER).clientTrackingRange(20).sized(0.6F, 1.99F).build(PinchOfSpice.MODID + "zombie_miner"));

    // SKELETON SORCERER
    public static final RegistryObject<EntityType<SkeletonSorcerer>> SKELETON_SORCERER = ENTITIES.register("skeleton_sorcerer", () -> EntityType.Builder.of(SkeletonSorcerer:: new, MobCategory.MONSTER).clientTrackingRange(20).sized(0.6F, 1.99F).build(PinchOfSpice.MODID + "skeleton_sorcerer"));

    // ZOMBIE BRUTE
    public static final RegistryObject<EntityType<ZombieBrute>> ZOMBIE_BRUTE = ENTITIES.register("zombie_brute", () -> EntityType.Builder.of(ZombieBrute:: new, MobCategory.MONSTER).clientTrackingRange(20).sized(0.6F, 1.99F).build(PinchOfSpice.MODID + "zombie_brute"));

}
