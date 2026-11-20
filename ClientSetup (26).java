package com.tentnets.client;

import com.tentnets.ModRegistry;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.bus.api.IEventBus;

/** Только клиент. Загружается из TentNetsMod лишь при Dist.CLIENT. */
public final class ClientSetup {
    private ClientSetup() {
    }

    public static void init(IEventBus modBus) {
        modBus.addListener(ClientSetup::registerRenderers);
        NeoForge.EVENT_BUS.addListener(ClientEvents::onNameTag);
    }

    private static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(ModRegistry.NET.get(), NetRenderer::new);
    }
}
