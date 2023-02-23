package io.github.justfeewee.justfeewees_pinchofspice;


import io.github.justfeewee.justfeewees_pinchofspice.init.*;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.jetbrains.annotations.NotNull;

@Mod(PinchOfSpice.MODID)
public class PinchOfSpice {

    // MODID IS justfeewees_pinchofspice
    public static final String MODID = "justfeewees_pinchofspice";

    // MAKING SURE STUFF WORKS WELL
    public PinchOfSpice() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        ItemInit.ITEMS.register(bus);
        BlockInit.BLOCKS.register(bus);
        ConfiguredFeatureInit.CONFIGURED_FEATURES.register(bus);
        PlacedFeatureInit.PLACED_FEATURES.register(bus);
        EntityInit.ENTITIES.register(bus);
        BlockEntityInit.BLOCK_ENTITIES.register(bus);
        MenuInit.MENUS.register(bus);

    }
//----------------------------------------------------------------------------------------------------------------------

        public static final CreativeModeTab TAB = new CreativeModeTab(MODID) {
            @Override
            public @NotNull ItemStack makeIcon() {
                return ItemInit.GOLD_COINS.get().getDefaultInstance();
            }
        };
    }
