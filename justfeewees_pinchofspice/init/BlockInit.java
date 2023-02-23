package io.github.justfeewee.justfeewees_pinchofspice.init;

import com.mojang.datafixers.types.templates.Tag;
import io.github.justfeewee.justfeewees_pinchofspice.PinchOfSpice;
import io.github.justfeewee.justfeewees_pinchofspice.blocks.QuickSandBlock;
import io.github.justfeewee.justfeewees_pinchofspice.blocks.TinkerersWorkshop;
import net.minecraft.client.resources.sounds.Sound;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class BlockInit {

    // CREATING REGISTRIES AND SUCH
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, PinchOfSpice.MODID);

    private static Item.Properties goToTab() {
        return new Item.Properties().tab(PinchOfSpice.TAB);
    }
//----------------------------------------------------------------------------------------------------------------------

    // QUICKSAND

    public static final RegistryObject<QuickSandBlock> QUICKSAND_BLOCK = register("quicksand_block", () -> new QuickSandBlock(BlockBehaviour.Properties.of(Material.POWDER_SNOW).strength(0.2F).sound(SoundType.SAND)), goToTab());
    // TINKERER'S WORKSHOP
    public static final RegistryObject<TinkerersWorkshop> TINKERERS_WORKSHOP = register("tinkerers_workshop", () -> new TinkerersWorkshop(BlockBehaviour.Properties.of(Material.WOOD).strength(3.5f).sound(SoundType.MUD_BRICKS)), goToTab());

    // CRATE BLOCK
    public static final RegistryObject<Block> CRATE = register("crate", () -> new Block(BlockBehaviour.Properties.of(Material.WOOD).strength(0.5f, 5).sound(SoundType.WOOD)), goToTab());

    // SILT BLOCK
    public static final RegistryObject<Block> SILT = register("silt", () -> new Block(BlockBehaviour.Properties.of(Material.SAND).strength(1.0f, 10).sound(SoundType.GRAVEL)), goToTab());

    // GLOWING EMBERS ORE
    public static final RegistryObject<Block> GLOWING_EMBERS_ORE = register("glowing_embers_ore", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(2.5f, 20).sound(SoundType.NETHERRACK)), goToTab());

    // EXPERIENCE ORE
    public static final RegistryObject<Block> EXPERIENCE_ORE = register("experience_ore", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(4.0f, 35).sound(SoundType.STONE)), goToTab());

    // FOXGLOVES FLOWER
    public static final RegistryObject<FlowerBlock> FOXGLOVES = register("foxgloves", () -> new FlowerBlock(MobEffects.HEAL, 300, BlockBehaviour.Properties.copy(Blocks.DANDELION)), goToTab());

    // CHRYSANTHEMUM FLOWER
    public static final RegistryObject<FlowerBlock> CHRYSANTHEMUM = register("chrysanthemum", () -> new FlowerBlock(MobEffects.MOVEMENT_SPEED, 300, BlockBehaviour.Properties.copy(Blocks.DANDELION)), goToTab());

    // ALOE VERA PLANT
    public static final RegistryObject<FlowerBlock> ALOE_VERA = register("aloe_vera", () -> new FlowerBlock(MobEffects.SATURATION, 300, BlockBehaviour.Properties.copy(Blocks.DANDELION)), goToTab());

    // BERSERKER MUSHROOM PLANT
    public static final RegistryObject<FlowerBlock> BERSERKER_MUSHROOM_PLANT = register("berserker_mushroom_plant", () -> new FlowerBlock(MobEffects.DAMAGE_BOOST, 300, BlockBehaviour.Properties.copy(Blocks.BROWN_MUSHROOM)), goToTab());
    //------------------------------------------------------------------------------------------------------------------

    // REGISTERS BLOCK IN BOTH ItemInit AND BlockInit AT SAME TIME
    private static <T extends Block> RegistryObject<T> register(String name, Supplier<T> supplier, Item.Properties properties) {
        RegistryObject<T> block = BLOCKS.register(name, supplier);
        ItemInit.ITEMS.register(name, () -> new BlockItem(block.get(), properties));
        return block;
    }
    }