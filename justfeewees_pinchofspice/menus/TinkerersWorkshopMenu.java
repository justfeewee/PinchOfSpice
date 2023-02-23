package io.github.justfeewee.justfeewees_pinchofspice.menus;

import io.github.justfeewee.justfeewees_pinchofspice.blockentities.TinkerersWorkshopEntity;
import io.github.justfeewee.justfeewees_pinchofspice.init.BlockInit;
import io.github.justfeewee.justfeewees_pinchofspice.init.MenuInit;
import net.minecraft.core.BlockPos;
import net.minecraft.core.IdMap;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.SlotItemHandler;
import org.jetbrains.annotations.Nullable;

public class TinkerersWorkshopMenu extends AbstractContainerMenu {
    private final ContainerLevelAccess levelAccess;

    protected TinkerersWorkshopMenu(int id, Inventory playerInv, IItemHandler slots, BlockPos pos) {
        super(MenuInit.TINKERERS_WORKSHOP.get(), id);
        this.levelAccess = ContainerLevelAccess.create(playerInv.player.getLevel(), pos);

        addSlot(new SlotItemHandler(slots, 0, 20, 20));
        addSlot(new SlotItemHandler(slots, 1, 40, 40));
        addSlot(new SlotItemHandler(slots, 2, 60, 60));
        addSlot(new SlotItemHandler(slots, 3, 40, 20));
        addSlot(new SlotItemHandler(slots, 4, 60, 20));
        addSlot(new SlotItemHandler(slots, 5, 20, 40));
        addSlot(new SlotItemHandler(slots, 6, 20, 60));
        addSlot(new SlotItemHandler(slots, 7, 40, 60));
        addSlot(new SlotItemHandler(slots, 8, 60, 40));
        addSlot(new SlotWithRestriction(slots, 9, 40, 100));

        final int slotSizePlus2 = 18;
        final int startX = 8;
        final int startY = 84;
        final int hotbarY = 142;

        for(int row = 0; row < 3; ++row) {
            for(int column = 0; column < 9; ++column) {
                addSlot(new Slot(playerInv, column + row * 9 + 9, startX + column * slotSizePlus2, startY + row * slotSizePlus2));
            }
        }

        for(int column = 0; column < 9; ++column) {
            addSlot(new Slot(playerInv, column, startX + column * slotSizePlus2, hotbarY));
        }
    }

    public static TinkerersWorkshopMenu getClientMenu(int id, Inventory playerInv) {
        return new TinkerersWorkshopMenu(id, playerInv, new ItemStackHandler(10), BlockPos.ZERO);
    }

    public static MenuConstructor getServerMenu(TinkerersWorkshopEntity blockEntity, BlockPos pos) {
        return(id, playerInv, player) -> new TinkerersWorkshopMenu(id, playerInv, blockEntity.getInventory(), pos);
    }

    @Override
    public ItemStack quickMoveStack(Player player, int index) {
        ItemStack itemStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(index);
        if (slot.hasItem()) {
            ItemStack current = slot.getItem();
            itemStack = current.copy();
            if (index < 10) {
                if (!this.moveItemStackTo(current, 10, this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            }
            else if (!this.moveItemStackTo(current, 0, 10, false)) {
                    return ItemStack.EMPTY;
                }

                if (current.isEmpty()) {
                    slot.set(ItemStack.EMPTY);
                }
                else {
                    slot.setChanged();
                }
            }

            return itemStack;
        }


    @Override
    public boolean stillValid(Player player) {
        return stillValid(this.levelAccess, player, BlockInit.TINKERERS_WORKSHOP.get());
    }
}
