package com.alexanderstri.rosequartz.world.feature;

import com.alexanderstri.rosequartz.RoseQuartz;
import net.minecraft.core.Registry;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class ModPlacedFeatures {
    public static final DeferredRegister<PlacedFeature> PLACED_FEATURES =
            DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, RoseQuartz.MOD_ID);

    public static final RegistryObject<PlacedFeature> ROSE_QUARTZ_ORE_LOWER_PLACED = PLACED_FEATURES.register("rose_quartz_ore_lower_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.ROSE_QUARTZ_ORE_LOWER.getHolder().get(),
                    commonOrePlacement(20, //VeinsPerChunk
                            HeightRangePlacement.triangle(VerticalAnchor.absolute(-48), VerticalAnchor.absolute(32)))));
    public static final RegistryObject<PlacedFeature> ROSE_QUARTZ_ORE_UPPER_PLACED = PLACED_FEATURES.register("rose_quartz_ore_upper_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.ROSE_QUARTZ_ORE_UPPER.getHolder().get(),
                    commonOrePlacement(20, //VeinsPerChunk
                            HeightRangePlacement.triangle(VerticalAnchor.absolute(130), VerticalAnchor.absolute(222)))));

    public static List<PlacementModifier> orePlacement(PlacementModifier p_195347_, PlacementModifier p_195348_) {
        return List.of(p_195347_, InSquarePlacement.spread(), p_195348_, BiomeFilter.biome());
    }

    public static List<PlacementModifier> commonOrePlacement(int p_195344_, PlacementModifier p_195345_) {
        return orePlacement(CountPlacement.of(p_195344_), p_195345_);
    }

    public static List<PlacementModifier> rareOrePlacement(int p_195350_, PlacementModifier p_195351_) {
        return orePlacement(RarityFilter.onAverageOnceEvery(p_195350_), p_195351_);
    }

    public static void register(IEventBus eventBus) {
        PLACED_FEATURES.register(eventBus);
    }
}
