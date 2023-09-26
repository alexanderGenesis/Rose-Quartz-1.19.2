package com.alexanderstri.rosequartz.world.placement;

import com.alexanderstri.rosequartz.RoseQuartz;
import com.alexanderstri.rosequartz.world.features.OreFeatures;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;

import java.util.List;

public class OrePlacements {
    public static final DeferredRegister<PlacedFeature> ORE_PLACEMENTS_DEFERRED_REGISTER =
            DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, RoseQuartz.MOD_ID);


    public static final Holder<PlacedFeature> ORE_ROSE_QUARTZ;

    static {
        ORE_ROSE_QUARTZ = PlacementUtils.register("rose_quartz_ore_placed", OreFeatures.ORE_ROSE_QUARTZ,
                commonOrePlacement(30, HeightRangePlacement.uniform(VerticalAnchor.absolute(136), VerticalAnchor.top())));
    }


    private static List<PlacementModifier> orePlacement(PlacementModifier p_195347_, PlacementModifier p_195348_) {
        return List.of(p_195347_, InSquarePlacement.spread(), p_195348_, BiomeFilter.biome());
    }

    private static List<PlacementModifier> commonOrePlacement(int p_195344_, PlacementModifier p_195345_) {
        return orePlacement(CountPlacement.of(p_195344_), p_195345_);
    }

    private static List<PlacementModifier> rareOrePlacement(int p_195350_, PlacementModifier p_195351_) {
        return orePlacement(RarityFilter.onAverageOnceEvery(p_195350_), p_195351_);
    }

    public static void register(IEventBus eventBus) {
        ORE_PLACEMENTS_DEFERRED_REGISTER.register(eventBus);
    }
}
