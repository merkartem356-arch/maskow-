package com.tentnets;

import com.tentnets.net.NetEntity;
import com.tentnets.net.NetItem;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.minecraft.core.registries.Registries;
import net.neoforged.neoforge.registries.DeferredHolder;

public final class ModRegistry {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(Registries.ITEM, TentNetsMod.MODID);
    public static final DeferredRegister<EntityType<?>> ENTITIES =
            DeferredRegister.create(Registries.ENTITY_TYPE, TentNetsMod.MODID);

    public static final DeferredHolder<EntityType<?>, EntityType<NetEntity>> NET = ENTITIES.register("net",
            () -> EntityType.Builder.<NetEntity>of(NetEntity::new, MobCategory.MISC)
                    .sized(0.5F, 0.5F)
                    .clientTrackingRange(16)
                    .updateInterval(Integer.MAX_VALUE)
                    .fireImmune()
                    .noSummon()
                    .build("net"));

    public static final DeferredHolder<Item, Item> ANTI_DRONE_NET = ITEMS.register("anti_drone_net",
            () -> new NetItem(NetEntity.Kind.ANTI, new Item.Properties().stacksTo(16)));

    public static final DeferredHolder<Item, Item> MASK_NET = ITEMS.register("mask_net",
            () -> new NetItem(NetEntity.Kind.MASK, new Item.Properties().stacksTo(16)));

    private ModRegistry() {
    }
}
