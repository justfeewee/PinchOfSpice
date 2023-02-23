package io.github.justfeewee.justfeewees_pinchofspice.blockentities;

import io.github.justfeewee.justfeewees_pinchofspice.PinchOfSpice;
import io.github.justfeewee.justfeewees_pinchofspice.init.BlockEntityInit;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.items.ItemStackHandler;

public class TinkerersWorkshopEntity extends BlockEntity {
    public TinkerersWorkshopEntity(BlockPos pos, BlockState state) {
        super(BlockEntityInit.TINKERERS_WORKSHOP.get(), pos, state);
    }

    private final ItemStackHandler inventory = new ItemStackHandler(10);

    public static final Component TITLE = Component.translatable("container." + PinchOfSpice.MODID + ".tinkerers_workshop");

    public ItemStackHandler getInventory() {
        return inventory;
    }
}
