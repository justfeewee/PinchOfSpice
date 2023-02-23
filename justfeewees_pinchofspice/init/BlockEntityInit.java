package io.github.justfeewee.justfeewees_pinchofspice.init;

import io.github.justfeewee.justfeewees_pinchofspice.PinchOfSpice;
import io.github.justfeewee.justfeewees_pinchofspice.blockentities.TinkerersWorkshopEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockEntityInit {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, PinchOfSpice.MODID);

    public static final RegistryObject<BlockEntityType<TinkerersWorkshopEntity>> TINKERERS_WORKSHOP = BLOCK_ENTITIES.register("tinkerers_workshop", () -> BlockEntityType.Builder.of(TinkerersWorkshopEntity:: new, BlockInit.TINKERERS_WORKSHOP.get()).build(null));
}
