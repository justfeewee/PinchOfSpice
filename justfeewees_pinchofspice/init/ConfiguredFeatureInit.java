package io.github.justfeewee.justfeewees_pinchofspice.init;

import com.google.common.base.Suppliers;
import io.github.justfeewee.justfeewees_pinchofspice.PinchOfSpice;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;
import java.util.function.Supplier;

public class ConfiguredFeatureInit {

    public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES =
            DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, PinchOfSpice.MODID);

//----------------------------------------------------------------------------------------------------------------------
    // NEW ORES!

    // GLOWING EMBERS
    private static final Supplier<List<OreConfiguration.TargetBlockState>> GLOWING_EMBERS_GEN = Suppliers.memoize(() ->
            List.of(OreConfiguration.target(OreFeatures.NETHERRACK, BlockInit.GLOWING_EMBERS_ORE.get().defaultBlockState())));
    public static final RegistryObject<ConfiguredFeature<?, ?>> GLOWING_EMBERS_ORE = CONFIGURED_FEATURES.register("glowing_embers_ore", () ->
            new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(GLOWING_EMBERS_GEN.get(), 8)));

    // EXPERIENCE ORE
    private static final Supplier<List<OreConfiguration.TargetBlockState>> EXPERIENCE_ORE_GEN = Suppliers.memoize(() ->
            List.of(OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, BlockInit.EXPERIENCE_ORE.get().defaultBlockState())));
    public static final RegistryObject<ConfiguredFeature<?, ?>> EXPERIENCE_ORE = CONFIGURED_FEATURES.register("experience_ore", () ->
            new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(EXPERIENCE_ORE_GEN.get(), 4)));
}

