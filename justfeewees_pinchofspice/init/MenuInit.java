package io.github.justfeewee.justfeewees_pinchofspice.init;

import io.github.justfeewee.justfeewees_pinchofspice.PinchOfSpice;
import io.github.justfeewee.justfeewees_pinchofspice.menus.TinkerersWorkshopMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.awt.*;

public final class MenuInit {
    public static final DeferredRegister<MenuType<?>> MENUS = DeferredRegister.create(ForgeRegistries.MENU_TYPES, PinchOfSpice.MODID);

    public static final RegistryObject<MenuType<TinkerersWorkshopMenu>> TINKERERS_WORKSHOP = MENUS.register("tinkerers_workshop", () -> new MenuType<>(TinkerersWorkshopMenu::getClientMenu));
}
