package com.alexanderstri.rosequartz.world.features;

import com.alexanderstri.rosequartz.RoseQuartz;
import com.alexanderstri.rosequartz.block.ModBlocks;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;

import java.util.List;

import static net.minecraft.data.worldgen.features.OreFeatures.DEEPSLATE_ORE_REPLACEABLES;
import static net.minecraft.data.worldgen.features.OreFeatures.STONE_ORE_REPLACEABLES;

public class OreFeatures {
    public static final DeferredRegister<ConfiguredFeature<?, ?>> ORE_FEATURES_DEFERRED_REGISTER =
            DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, RoseQuartz.MOD_ID);
    public static final List<OreConfiguration.TargetBlockState> ORE_ROSE_QUARTZ_TARGET_LIST = List.of(OreConfiguration.target
            (STONE_ORE_REPLACEABLES, ModBlocks.ROSE_QUARTZ_ORE.get().defaultBlockState()), OreConfiguration.target(DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_ROSE_QUARTZ_ORE.get().defaultBlockState()));
    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> ORE_ROSE_QUARTZ = FeatureUtils.register
            ("rose_quartz_ore_feature", Feature.ORE, new OreConfiguration(ORE_ROSE_QUARTZ_TARGET_LIST, 12));

    public static void register(IEventBus eventBus)
    {
        ORE_FEATURES_DEFERRED_REGISTER.register(eventBus);
    }
}
