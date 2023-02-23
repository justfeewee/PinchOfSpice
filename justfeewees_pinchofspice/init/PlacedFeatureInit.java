package io.github.justfeewee.justfeewees_pinchofspice.init;

import io.github.justfeewee.justfeewees_pinchofspice.PinchOfSpice;
import net.minecraft.core.Registry;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class PlacedFeatureInit {
    public static final DeferredRegister<PlacedFeature> PLACED_FEATURES = DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, PinchOfSpice.MODID);

    private static List<PlacementModifier> commonOrePlacement(int countPerChunk, PlacementModifier height) {
        return orePlacement(CountPlacement.of(countPerChunk), height);
    }

    private static List<PlacementModifier> orePlacement(PlacementModifier count, PlacementModifier height) {
        return List.of(count, InSquarePlacement.spread(), height, BiomeFilter.biome());
    }

    public static final RegistryObject<PlacedFeature> GLOWING_EMBERS_ORE = PLACED_FEATURES.register("glowing_embers_ore",
            () -> new PlacedFeature(ConfiguredFeatureInit.GLOWING_EMBERS_ORE.getHolder().get(), commonOrePlacement(30, HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.top()))));

    public static final RegistryObject<PlacedFeature> EXPERIENCE_ORE = PLACED_FEATURES.register("experience_ore",
            () -> new PlacedFeature(ConfiguredFeatureInit.EXPERIENCE_ORE.getHolder().get(), commonOrePlacement(2, HeightRangePlacement.triangle(VerticalAnchor.bottom(), VerticalAnchor.absolute(0)))));
    }
