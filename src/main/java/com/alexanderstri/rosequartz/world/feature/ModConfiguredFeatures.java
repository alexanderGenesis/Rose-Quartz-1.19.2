package com.alexanderstri.rosequartz.world.feature;

import com.alexanderstri.rosequartz.RoseQuartz;
import com.alexanderstri.rosequartz.block.ModBlocks;
import com.google.common.base.Suppliers;
import java.util.function.Supplier;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;


public class ModConfiguredFeatures {
    public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES =
            DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, RoseQuartz.MOD_ID);

    //Defining what families of ore can replace.
    public static final Supplier<List<OreConfiguration.TargetBlockState>> OVERWORLD_ROSE_QUARTZ_ORE = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModBlocks.ROSE_QUARTZ_ORE.get().defaultBlockState()),
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_ROSE_QUARTZ_ORE.get().defaultBlockState())));

    //Defining where each feature of ore spawns and how much.
    public static final RegistryObject<ConfiguredFeature<?, ?>> ROSE_QUARTZ_ORE_LOWER = CONFIGURED_FEATURES.register("rose_quartz_ore_lower",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(OVERWORLD_ROSE_QUARTZ_ORE.get(), 6 /*MaxVeinSize*/)));
    public static final RegistryObject<ConfiguredFeature<?, ?>> ROSE_QUARTZ_ORE_UPPER = CONFIGURED_FEATURES.register("rose_quartz_ore_upper",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(OVERWORLD_ROSE_QUARTZ_ORE.get(), 7 /*MaxVeinSize*/)));

    public static void register(IEventBus eventBus) {
        CONFIGURED_FEATURES.register(eventBus);
    }
}
