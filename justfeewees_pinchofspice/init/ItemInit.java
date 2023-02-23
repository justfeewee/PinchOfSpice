package io.github.justfeewee.justfeewees_pinchofspice.init;

import io.github.justfeewee.justfeewees_pinchofspice.PinchOfSpice;
import io.github.justfeewee.justfeewees_pinchofspice.base.ModArmorMaterial;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.Nullable;

import java.rmi.registry.Registry;

public class ItemInit {

    // SETTING UP REGISTRIES AND SUCH
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, PinchOfSpice.MODID);

    private static Item.Properties goToTab() {
        return new Item.Properties().tab(PinchOfSpice.TAB); }
//----------------------------------------------------------------------------------------------------------------------
    // CURRENCY

    // GOLD COIN
    public static final RegistryObject<Item> GOLD_COINS = ITEMS.register("gold_coins", () -> new Item(goToTab()));

    // SILVER COIN
    public static final RegistryObject<Item> SILVER_COINS = ITEMS.register("silver_coins", () -> new Item(goToTab()));

//----------------------------------------------------------------------------------------------------------------------
    // FOOD ITEMS

    // CAVE CARROT
    public static final RegistryObject<Item> CAVE_CARROT = ITEMS.register("cave_carrot", () -> new Item(goToTab().food(Foods.CAVE_CARROT)));

    // CHRYSANTHEMUM SALVE
    public static final RegistryObject<Item> CHRYSANTHEMUM_SALVE = ITEMS.register("chrysanthemum_salve", () -> new Item(goToTab().food(Foods.CHRYSANTHEMUM_SALVE)));

    // FOXGLOVE SALVE
    public static final RegistryObject<Item> FOXGLOVE_SALVE = ITEMS.register("foxglove_salve", () -> new Item(goToTab().food(Foods.FOXGLOVE_SALVE)));

    // ALOE VERA SALVE
    public static final RegistryObject<Item> ALOE_VERA_SALVE = ITEMS.register("aloe_vera_salve", () -> new Item(goToTab().food(Foods.ALOE_VERA_SALVE)));

    // BERSERKER MUSHROOM
    public static final RegistryObject<Item> BERSERKER_MUSHROOM = ITEMS.register("berserker_mushroom", () -> new Item(goToTab().food(Foods.BERSERKER_MUSHROOM)));

    //----------------------------------------------------------------------------------------------------------------------
    // GIVES FOODS THEIR ATTRIBUTES
    public static class Foods {

        // CAVE CARROT
        public static final FoodProperties CAVE_CARROT = new FoodProperties.Builder().nutrition(3).fast().saturationMod(.3f).effect(() -> new MobEffectInstance(MobEffects.NIGHT_VISION, 300, 0), .8f).effect(() -> new MobEffectInstance(MobEffects.HUNGER, 200, 2), .2f).build();

        // FOXGLOVE SALVE
        public static final FoodProperties FOXGLOVE_SALVE = new FoodProperties.Builder().nutrition(2).saturationMod(.2f).effect(() -> new MobEffectInstance(MobEffects.HEAL, 200, 0), 1).effect(() -> new MobEffectInstance(MobEffects.HEALTH_BOOST, 200, 0), 1).effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 200, 0), 1).build();

        // ALOE VERA SALVE
        public static final FoodProperties ALOE_VERA_SALVE = new FoodProperties.Builder().nutrition(2).saturationMod(.2f).effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 200), 1).build();

        // BERSERKER MUSHROOM
        public static final FoodProperties BERSERKER_MUSHROOM = new FoodProperties.Builder().nutrition(2).saturationMod(.2f).effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 200, 0), 1).effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 200, 0), 1).effect(() -> new MobEffectInstance(MobEffects.CONFUSION, 200, 1), 1).build();

        // CHRYSANTHEMUM SALVE
        public static final FoodProperties CHRYSANTHEMUM_SALVE = new FoodProperties.Builder().nutrition(2).saturationMod(.2f).effect(() -> new MobEffectInstance(MobEffects.CONFUSION, -200, 2), 1).effect(() -> new MobEffectInstance(MobEffects.POISON, -200, 2), 1).effect(() -> new MobEffectInstance(MobEffects.HUNGER, -500, 2), 1).build();
    }
//----------------------------------------------------------------------------------------------------------------------
    // TOOLS AND ARMOR

    // FLINT SHORTSWORD
    public static final RegistryObject<SwordItem> FLINT_SHORTSWORD = ITEMS.register("flint_shortsword", () -> new SwordItem(ToolTiers.FLINT, 2, -2.0f, goToTab()));

    // COPPER SWORD
    public static final RegistryObject<SwordItem> COPPER_SWORD = ITEMS.register("copper_sword", () -> new SwordItem(ToolTiers.COPPER, 3, -2.8f, goToTab()));

    // COPPER AXE
    public static final RegistryObject<AxeItem> COPPER_AXE = ITEMS.register("copper_axe", () -> new AxeItem(ToolTiers.COPPER, 5.5f, -3f, goToTab()));

    // COPPER PICKAXE
    public static final RegistryObject<PickaxeItem> COPPER_PICKAXE = ITEMS.register("copper_pickaxe", () -> new PickaxeItem(ToolTiers.COPPER, 1, -3.0f, goToTab()));

    // COPPER SHOVEL
    public static final RegistryObject<ShovelItem> COPPER_SHOVEL = ITEMS.register("copper_shovel", () -> new ShovelItem(ToolTiers.COPPER, 0, -3.0f, goToTab()));

    // COPPER HOE
    public static final RegistryObject<HoeItem> COPPER_HOE = ITEMS.register("copper_hoe", () -> new HoeItem(ToolTiers.COPPER, 0, -3.0f, goToTab()));

    // COPPER HELMET
    public static final RegistryObject<ArmorItem> COPPER_HELMET = ITEMS.register("copper_helmet", () -> new ArmorItem(ArmorTiers.COPPER, EquipmentSlot.HEAD, goToTab()));

    // COPPER CHESTPLATE
    public static final RegistryObject<ArmorItem> COPPER_CHESTPLATE = ITEMS.register("copper_chestplate", () -> new ArmorItem(ArmorTiers.COPPER, EquipmentSlot.CHEST, goToTab()));

    // COPPER LEGGINGS
    public static final RegistryObject<ArmorItem> COPPER_LEGGINGS = ITEMS.register("copper_leggings", () -> new ArmorItem(ArmorTiers.COPPER, EquipmentSlot.LEGS, goToTab()));

    // COPPER BOOTS
    public static final RegistryObject<ArmorItem> COPPER_BOOTS = ITEMS.register("copper_boots", () -> new ArmorItem(ArmorTiers.COPPER, EquipmentSlot.FEET, goToTab()));

    //----------------------------------------------------------------------------------------------------------------------
    // Individual Items


    // SILT DUST
    public static final RegistryObject<Item> SILT_DUST = ITEMS.register("silt_dust", () -> new Item(goToTab()));

    // CHRYSANTHEMUM PETALS
    public static final RegistryObject<Item> CHRYSANTHEMUM_PETALS = ITEMS.register("chrysanthemum_petals", () -> new Item(goToTab()));

    // FOXGLOVE PETALS
    public static final RegistryObject<Item> FOXGLOVE_PETALS = ITEMS.register("foxglove_petals", () -> new Item(goToTab()));

    // ALOE VERA STEMS
    public static final RegistryObject<Item> ALOE_VERA_STEMS = ITEMS.register("aloe_vera_stems", () -> new Item(goToTab()));

//----------------------------------------------------------------------------------------------------------------------
    // MINERALS AND ORES

    // ENCHANTED STEEL
    public static final RegistryObject<Item> ENCHANTED_STEEL = ITEMS.register("enchanted_steel", () -> new Item(goToTab()));

    // EXPERIENCE_CLUSTERS
    public static final RegistryObject<Item> EXPERIENCE_CLUSTERS = ITEMS.register("experience_clusters", () -> new Item(goToTab()));

    // GLOWING EMBERS
    public static final RegistryObject<Item> GLOWING_EMBERS = ITEMS.register("glowing_embers", () -> new Item(goToTab()) {
                @Override
                public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
                    return 800;
                }
            });

//----------------------------------------------------------------------------------------------------------------------
    // SPAWN EGGS

    // FISHERMAN SKELETON SPAWN EGG
    public static final RegistryObject<ForgeSpawnEggItem> FISHERMAN_SKELETON_SPAWN_EGG = ITEMS.register("fisherman_skeleton_spawn_egg",
        () -> new ForgeSpawnEggItem(EntityInit.FISHERMAN_SKELETON, 0x808080, 0x964B00, goToTab().stacksTo(16)));

    // BURIED SKELETON SPAWN EGG
    public static final RegistryObject<ForgeSpawnEggItem> BURIED_SKELETON_SPAWN_EGG = ITEMS.register("buried_skeleton_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityInit.BURIED_SKELETON, 0x808080, 0x023020, goToTab().stacksTo(16)));

    // CORAL SKELETON SPAWN EGG
    public static final RegistryObject<ForgeSpawnEggItem> CORAL_SKELETON_SPAWN_EGG = ITEMS.register("coral_skeleton_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityInit.CORAL_SKELETON, 0x808080, 0xff7f50, goToTab().stacksTo(16)));

    // FLOWERED SKELETON SPAWN EGG
    public static final RegistryObject<ForgeSpawnEggItem> FLOWERED_SKELETON_SPAWN_EGG = ITEMS.register("flowered_skeleton_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityInit.FLOWERED_SKELETON, 0x808080, 0xFFC0CB, goToTab().stacksTo(16)));

    // FORGOTTEN SKELETON SPAWN EGG
    public static final RegistryObject<ForgeSpawnEggItem> FORGOTTEN_SKELETON_SPAWN_EGG = ITEMS.register("forgotten_skeleton_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityInit.FORGOTTEN_SKELETON, 0x808080, 0x50C878, goToTab().stacksTo(16)));

    // GIANT SKELETON SPAWN EGG
    public static final RegistryObject<ForgeSpawnEggItem> GIANT_SKELETON_SPAWN_EGG = ITEMS.register("giant_skeleton_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityInit.GIANT_SKELETON, 0x808080, 0xa9a9a9, goToTab().stacksTo(16)));

    // FROZEN ZOMBIE SPAWN EGG
    public static final RegistryObject<ForgeSpawnEggItem> FROZEN_ZOMBIE_SPAWN_EGG = ITEMS.register("frozen_zombie_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityInit.FROZEN_ZOMBIE, 0x006400, 0x368BC1, goToTab().stacksTo(16)));

    // FROZEN ZOMBIE MINER SPAWN EGG
    public static final RegistryObject<ForgeSpawnEggItem> FROZEN_ZOMBIE_MINER_SPAWN_EGG = ITEMS.register("frozen_zombie_miner_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityInit.FROZEN_ZOMBIE_MINER, 0x368BC1, 0xFFF684, goToTab().stacksTo(16)));

    // HUSK SKELETON SPAWN EGG
    public static final RegistryObject<ForgeSpawnEggItem> HUSK_SKELETON_SPAWN_EGG = ITEMS.register("husk_skeleton_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityInit.HUSK_SKELETON, 0x808080, 0xd2aa6d, goToTab().stacksTo(16)));

    // MUMMY SPAWN EGG
    public static final RegistryObject<ForgeSpawnEggItem> MUMMY_SPAWN_EGG = ITEMS.register("mummy_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityInit.MUMMY, 0x808080, 0xe1a95f, goToTab().stacksTo(16)));

    // OVERGROWN ZOMBIE SPAWN EGG
    public static final RegistryObject<ForgeSpawnEggItem> OVERGROWN_ZOMBIE_SPAWN_EGG = ITEMS.register("overgrown_zombie_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityInit.OVERGROWN_ZOMBIE, 0x006400, 0x34A56F, goToTab().stacksTo(16)));

    // PIRATE SKELETON SPAWN EGG
    public static final RegistryObject<ForgeSpawnEggItem> PIRATE_SKELETON_SPAWN_EGG = ITEMS.register("pirate_skeleton_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityInit.PIRATE_SKELETON, 0x808080, 0xFF0000, goToTab().stacksTo(16)));

    // POSSESSED DUMMY SPAWN EGG
    public static final RegistryObject<ForgeSpawnEggItem> POSSESSED_DUMMY_SPAWN_EGG = ITEMS.register("possessed_dummy_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityInit.POSSESSED_DUMMY, 0xdac586, 0xFFFF00, goToTab().stacksTo(16)));

    // SKELETON MINER SPAWN EGG
    public static final RegistryObject<ForgeSpawnEggItem> SKELETON_MINER_SPAWN_EGG = ITEMS.register("skeleton_miner_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityInit.SKELETON_MINER, 0x808080, 0xFFFF00, goToTab().stacksTo(16)));

    // SKELETON SORCERER SPAWN EGG
    public static final RegistryObject<ForgeSpawnEggItem> SKELETON_SORCERER_SPAWN_EGG = ITEMS.register("skeleton_sorcerer_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityInit.SKELETON_SORCERER, 0x808080, 0xFF00FF, goToTab().stacksTo(16)));

    // SKULK ZOMBIE SPAWN EGG
    public static final RegistryObject<ForgeSpawnEggItem> SKULK_ZOMBIE_SPAWN_EGG = ITEMS.register("skulk_zombie_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityInit.SKULK_ZOMBIE, 0x808080, 0x040720, goToTab().stacksTo(16)));

    // TEMPLE ZOMBIE SPAWN EGG
    public static final RegistryObject<ForgeSpawnEggItem> TEMPLE_ZOMBIE_SPAWN_EGG = ITEMS.register("temple_zombie_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityInit.TEMPLE_ZOMBIE, 0x333333, 0x964B00, goToTab().stacksTo(16)));

    // TOMB ZOMBIE SPAWN EGG
    public static final RegistryObject<ForgeSpawnEggItem> TOMB_ZOMBIE_SPAWN_EGG = ITEMS.register("tomb_zombie_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityInit.TOMB_ZOMBIE, 0xF4A460, 0xFFA500, goToTab().stacksTo(16)));

    // ZOMBIE BRUTE SPAWN EGG
    public static final RegistryObject<ForgeSpawnEggItem> ZOMBIE_BRUTE_SPAWN_EGG = ITEMS.register("zombie_brute_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityInit.ZOMBIE_BRUTE, 0x34A56F, 0x008080, goToTab().stacksTo(16)));

    // ZOMBIE MINER SPAWN EGG
    public static final RegistryObject<ForgeSpawnEggItem> ZOMBIE_MINER_SPAWN_EGG = ITEMS.register("zombie_miner_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityInit.ZOMBIE_MINER, 0x75816b, 0xFFFF00, goToTab().stacksTo(16)));

    // TIERS

    public static class ToolTiers {

        // COPPER TOOLS
        public static final Tier COPPER = new ForgeTier(1, 160, 4.0f, 2.0f, 16, null, () -> Ingredient.EMPTY);

        // FLINT TOOLS
        public static final Tier FLINT = new ForgeTier(2, 150, 3.0F, 2F, 14, null, () -> Ingredient.EMPTY);
    }

    // COPPER ARMOR TIER
    public static class ArmorTiers {
        public static final ArmorMaterial COPPER = new ModArmorMaterial("copper", 7, new int[] {13,15,16,11}, 18, SoundEvents.ARMOR_EQUIP_IRON, 0.0f, 0.0f, () -> Ingredient.EMPTY);
    }
}