package com.alexanderstri.rosequartz.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {
    public static final CreativeModeTab ROSE_QUARTZ_TAB = new CreativeModeTab("rosequartztab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.ROSE_QUARTZ.get());
        }
    };
}
