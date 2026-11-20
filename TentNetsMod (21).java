package com.tentnets;

import com.tentnets.client.ClientSetup;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.loading.FMLEnvironment;

@Mod(TentNetsMod.MODID)
public class TentNetsMod {
    public static final String MODID = "tentnets";

    public TentNetsMod(IEventBus modBus) {
        ModRegistry.ITEMS.register(modBus);
        ModRegistry.ENTITIES.register(modBus);
        modBus.addListener(this::addToCreativeTab);
        if (FMLEnvironment.dist == Dist.CLIENT) {
            ClientSetup.init(modBus);
        }
    }

    private void addToCreativeTab(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            event.accept(ModRegistry.ANTI_DRONE_NET.get());
            event.accept(ModRegistry.MASK_NET.get());
        }
    }
}
