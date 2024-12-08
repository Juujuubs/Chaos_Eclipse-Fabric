package net.jubs.eclipse_do_caos.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.jubs.eclipse_do_caos.blocks.ModBlocks;
import net.jubs.eclipse_do_caos.items.ModItems;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends FabricRecipeProvider {
    private static final List<ItemConvertible> ESSENCE_SMELTABLES = List.of(ModBlocks.ESSENCE_ORE_BLOCK);

    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }


    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        offerSmelting(exporter, ESSENCE_SMELTABLES, RecipeCategory.MISC, ModItems.ESSENCE,
                0.7f, 200,"essence");
        offerBlasting(exporter, ESSENCE_SMELTABLES, RecipeCategory.MISC, ModItems.ESSENCE,
                0.7f, 100,"essence");


        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.ESSENCE,RecipeCategory.BUILDING_BLOCKS,
                ModBlocks.ESSENCE_BLOCK);

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.DELS, 1)
                .pattern("#A#")
                .pattern("ECE")
                .pattern("#A#")
                .input('#', ModItems.ESSENCE)
                .input('A', Items.AMETHYST_SHARD)
                .input('E', Items.ECHO_SHARD)
                .input('C', Items.COMPASS)
                .criterion(hasItem(Items.ECHO_SHARD), conditionsFromItem(Items.ECHO_SHARD))
                .criterion(hasItem(ModItems.ESSENCE), conditionsFromItem(ModItems.ESSENCE))
                .criterion(hasItem(Items.AMETHYST_SHARD), conditionsFromItem(Items.AMETHYST_SHARD))
                .criterion(hasItem(Items.COMPASS), conditionsFromItem(Items.COMPASS))
                .offerTo(exporter, new Identifier((getRecipeName(ModItems.DELS))));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.TOOLS,ModItems.ESSENCE_PAXEL, 1)
                .input(Items.NETHERITE_PICKAXE)
                .input(Items.NETHERITE_AXE)
                .input(Items.NETHERITE_SHOVEL)
                .input(ModBlocks.ESSENCE_BLOCK)
                .criterion(FabricRecipeProvider.hasItem(Items.NETHERITE_PICKAXE),
                        FabricRecipeProvider.conditionsFromItem(Items.NETHERITE_PICKAXE))
                .criterion(FabricRecipeProvider.hasItem(Items.NETHERITE_AXE),
                        FabricRecipeProvider.conditionsFromItem(Items.NETHERITE_AXE))
                .criterion(FabricRecipeProvider.hasItem(Items.NETHERITE_SHOVEL),
                        FabricRecipeProvider.conditionsFromItem(Items.NETHERITE_SHOVEL))
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.ESSENCE_BLOCK),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.ESSENCE_BLOCK))
                .offerTo(exporter, new Identifier((getRecipeName((ModItems.ESSENCE_PAXEL)))));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.RADIO_ANNOUNCER, 1)
                .pattern("###")
                .pattern("#J#")
                .pattern("###")
                .input('#', ModItems.ESSENCE)
                .input('J', Items.JUKEBOX)
                .criterion(hasItem(Items.JUKEBOX), conditionsFromItem(Items.JUKEBOX))
                .criterion(hasItem(ModItems.ESSENCE), conditionsFromItem(ModItems.ESSENCE))
                .offerTo(exporter, new Identifier((getRecipeName(ModBlocks.RADIO_ANNOUNCER))));


        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.CATALYST_INFUSER, 1)
                .pattern("G#C")
                .pattern("BJP")
                .pattern("SLS")
                .input('#', ModItems.CATALYST_EMPTY)
                .input('C', Items.CAULDRON)
                .input('J', ModItems.ESSENCE)
                .input('P', Ingredient.fromTag(ItemTags.PLANKS))
                .input('L', Ingredient.fromTag(ItemTags.WOODEN_SLABS))
                .input('S', Items.STICK)
                .input('B', Items.CHEST)
                .input('G', Items.GLASS_BOTTLE)
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .criterion(hasItem(ModItems.ESSENCE), conditionsFromItem(ModItems.ESSENCE))
                .offerTo(exporter, new Identifier((getRecipeName(ModBlocks.CATALYST_INFUSER))));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC,Items.RED_DYE).input(ModBlocks.BROMELIAD).criterion(FabricRecipeProvider.hasItem(ModBlocks.BROMELIAD),
                FabricRecipeProvider.conditionsFromItem(ModBlocks.BROMELIAD)).offerTo(exporter, new Identifier((getRecipeName((ModBlocks.BROMELIAD)))));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC,Items.BONE_MEAL).input(ModItems.HUMAN_TOOTH).criterion(FabricRecipeProvider.hasItem(ModItems.HUMAN_TOOTH),
                FabricRecipeProvider.conditionsFromItem(ModItems.HUMAN_TOOTH)).offerTo(exporter, new Identifier((getRecipeName((ModItems.HUMAN_TOOTH)))));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC,Items.BONE_MEAL, 2).input(ModItems.DEVIL_HORN).criterion(FabricRecipeProvider.hasItem(ModItems.DEVIL_HORN),
                FabricRecipeProvider.conditionsFromItem(ModItems.DEVIL_HORN)).offerTo(exporter, new Identifier((getRecipeName((ModItems.DEVIL_HORN)))));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SAMARA_PLUSHIE, 1)
                .pattern("EHE")
                .pattern("LBG")
                .pattern("EDE")
                .input('E', ModItems.ESSENCE)
                .input('H', ModItems.HUMAN_TOOTH)
                .input('G', ModItems.GOBLIN_EYE)
                .input('D', ModItems.DEVIL_HORN)
                .input('L', ModItems.ELF_EAR)
                .input('B', Items.BEEF)
                .criterion(hasItem(Items.BEEF), conditionsFromItem(Items.BEEF))
                .criterion(hasItem(ModItems.ESSENCE), conditionsFromItem(ModItems.ESSENCE))
                .offerTo(exporter, new Identifier((getRecipeName(ModBlocks.SAMARA_PLUSHIE))));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.CATALYST_EMPTY, 3)
                .pattern("###")
                .pattern("#E#")
                .pattern("###")
                .input('#', Items.GLASS_BOTTLE)
                .input('E', ModItems.ESSENCE)
                .criterion(hasItem(Items.GLASS_BOTTLE), conditionsFromItem(Items.GLASS_BOTTLE))
                .criterion(hasItem(ModItems.ESSENCE), conditionsFromItem(ModItems.ESSENCE))
                .offerTo(exporter, new Identifier((getRecipeName(ModItems.CATALYST_EMPTY))));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC,Items.GLASS_BOTTLE, 7).input(ModItems.CATALYST_EMPTY).criterion(FabricRecipeProvider.hasItem(ModItems.CATALYST_EMPTY),
                FabricRecipeProvider.conditionsFromItem(ModItems.CATALYST_EMPTY)).offerTo(exporter, new Identifier("eclipse_do_caos","glass_bottle_from_catalyst_empty"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD,ModItems.SUSHI_TILAPIA, 4)
                .input(ModItems.TILAPIA)
                .input(Items.DRIED_KELP)
                .criterion(FabricRecipeProvider.hasItem(ModItems.TILAPIA),
                FabricRecipeProvider.conditionsFromItem(ModItems.TILAPIA))
                .criterion(FabricRecipeProvider.hasItem(Items.DRIED_KELP),
                        FabricRecipeProvider.conditionsFromItem(Items.DRIED_KELP))
                .offerTo(exporter, new Identifier((getRecipeName((ModItems.SUSHI_TILAPIA)))));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.COMBAT,ModItems.CANNONBALL, 4)
                .input(Items.IRON_INGOT)
                .input(Items.IRON_INGOT)
                .input(Items.COAL)
                .input(Items.GUNPOWDER)
                .criterion(FabricRecipeProvider.hasItem(Items.IRON_INGOT),
                        FabricRecipeProvider.conditionsFromItem(Items.IRON_INGOT))
                .criterion(FabricRecipeProvider.hasItem(Items.GUNPOWDER),
                        FabricRecipeProvider.conditionsFromItem(Items.GUNPOWDER))
                .offerTo(exporter, new Identifier((getRecipeName((ModItems.CANNONBALL)))));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC,Items.IRON_NUGGET, 4).input(ModItems.CANNONBALL).criterion(FabricRecipeProvider.hasItem(ModItems.CANNONBALL),
                FabricRecipeProvider.conditionsFromItem(ModItems.CANNONBALL)).offerTo(exporter, new Identifier("eclipse_do_caos","iron_nugget_from_cannonball"));


        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS,ModBlocks.EDEN_PLANKS, 4)
                .input(ModBlocks.EDEN_LOG)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.EDEN_LOG),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.EDEN_LOG))
                .offerTo(exporter, new Identifier("eclipse_do_caos", "eden_planks_from_log"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS,ModBlocks.EDEN_PLANKS, 4)
                .input(ModBlocks.EDEN_WOOD)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.EDEN_WOOD),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.EDEN_WOOD))
                .offerTo(exporter, new Identifier("eclipse_do_caos", "eden_planks_from_wood"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS,ModBlocks.EDEN_PLANKS, 4)
                .input(ModBlocks.STRIPPED_EDEN_LOG)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.STRIPPED_EDEN_LOG),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.STRIPPED_EDEN_LOG))
                .offerTo(exporter, new Identifier("eclipse_do_caos", "eden_planks_from_stripped_log"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS,ModBlocks.EDEN_PLANKS, 4)
                .input(ModBlocks.STRIPPED_EDEN_WOOD)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.STRIPPED_EDEN_WOOD),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.STRIPPED_EDEN_WOOD))
                .offerTo(exporter, new Identifier("eclipse_do_caos", "eden_planks_from_stripped_wood"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.EDEN_WOOD, 3)
                .pattern("##")
                .pattern("##")
                .input('#', ModBlocks.EDEN_LOG)
                .criterion(hasItem(ModBlocks.EDEN_LOG), conditionsFromItem(ModBlocks.EDEN_LOG))
                .offerTo(exporter, new Identifier((getRecipeName(ModBlocks.EDEN_WOOD))));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.TEETH_BLOCK, 1)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .input('#', ModItems.HUMAN_TOOTH)
                .criterion(hasItem(ModItems.HUMAN_TOOTH), conditionsFromItem(ModItems.HUMAN_TOOTH))
                .offerTo(exporter, new Identifier((getRecipeName(ModBlocks.TEETH_BLOCK))));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC,ModItems.HUMAN_TOOTH, 9).input(ModBlocks.TEETH_BLOCK).criterion(FabricRecipeProvider.hasItem(ModBlocks.TEETH_BLOCK),
                FabricRecipeProvider.conditionsFromItem(ModBlocks.TEETH_BLOCK)).offerTo(exporter, new Identifier("eclipse_do_caos","human_tooth_from_teeth_block"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.EYE_BLOCK, 1)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .input('#', ModItems.GOBLIN_EYE)
                .criterion(hasItem(ModItems.GOBLIN_EYE), conditionsFromItem(ModItems.GOBLIN_EYE))
                .offerTo(exporter, new Identifier((getRecipeName(ModBlocks.EYE_BLOCK))));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC,ModItems.GOBLIN_EYE, 9).input(ModBlocks.EYE_BLOCK).criterion(FabricRecipeProvider.hasItem(ModBlocks.EYE_BLOCK),
                FabricRecipeProvider.conditionsFromItem(ModBlocks.EYE_BLOCK)).offerTo(exporter, new Identifier("eclipse_do_caos","goblin_eye_from_eye_block"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.MEAT_BLOCK, 1)
                .pattern("###")
                .pattern("#E#")
                .pattern("###")
                .input('#', Items.ROTTEN_FLESH)
                .input('E', ModItems.ELF_EAR)
                .criterion(hasItem(ModItems.ELF_EAR), conditionsFromItem(ModItems.ELF_EAR))
                .criterion(hasItem(Items.ROTTEN_FLESH), conditionsFromItem(Items.ROTTEN_FLESH))
                .offerTo(exporter, new Identifier((getRecipeName(ModBlocks.MEAT_BLOCK))));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC,ModItems.ELF_EAR, 1).input(ModBlocks.MEAT_BLOCK).criterion(FabricRecipeProvider.hasItem(ModBlocks.MEAT_BLOCK),
                FabricRecipeProvider.conditionsFromItem(ModBlocks.MEAT_BLOCK)).offerTo(exporter, new Identifier("eclipse_do_caos","elf_ear_from_meat_block"));



        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.STRIPPED_EDEN_WOOD, 3)
                .pattern("##")
                .pattern("##")
                .input('#', ModBlocks.STRIPPED_EDEN_LOG)
                .criterion(hasItem(ModBlocks.STRIPPED_EDEN_LOG), conditionsFromItem(ModBlocks.STRIPPED_EDEN_LOG))
                .offerTo(exporter, new Identifier((getRecipeName(ModBlocks.STRIPPED_EDEN_WOOD))));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TRANSPORTATION, ModItems.EDEN_CHEST_BOAT, 1)
                .pattern("C")
                .pattern("#")
                .input('#', ModItems.EDEN_BOAT)
                .input('C', Items.CHEST)
                .criterion(hasItem(ModItems.EDEN_BOAT), conditionsFromItem(ModItems.EDEN_BOAT))
                .criterion(hasItem(Items.CHEST), conditionsFromItem(Items.CHEST))
                .offerTo(exporter, new Identifier((getRecipeName(ModItems.EDEN_CHEST_BOAT))));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TRANSPORTATION, ModItems.EDEN_BOAT, 1)
                .pattern("# #")
                .pattern("###")
                .input('#', ModBlocks.EDEN_PLANKS)
                .criterion(hasItem(ModBlocks.EDEN_PLANKS), conditionsFromItem(ModBlocks.EDEN_PLANKS))
                .offerTo(exporter, new Identifier((getRecipeName(ModItems.EDEN_BOAT))));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.EDEN_SIGN, 3)
                .pattern("###")
                .pattern("###")
                .pattern(" S ")
                .input('#', ModBlocks.EDEN_PLANKS)
                .input('S', Items.STICK)
                .criterion(hasItem(ModBlocks.EDEN_PLANKS), conditionsFromItem(ModBlocks.EDEN_PLANKS))
                .offerTo(exporter, new Identifier((getRecipeName(ModBlocks.EDEN_SIGN))));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.EDEN_HANGING_SIGN, 6)
                .pattern("C C")
                .pattern("###")
                .pattern("###")
                .input('#', ModBlocks.EDEN_PLANKS)
                .input('C', Items.CHAIN)
                .criterion(hasItem(ModBlocks.EDEN_PLANKS), conditionsFromItem(ModBlocks.EDEN_PLANKS))
                .offerTo(exporter, new Identifier((getRecipeName(ModBlocks.EDEN_HANGING_SIGN))));

        createFenceGateRecipe(ModBlocks.EDEN_FENCE_GATE, Ingredient.ofItems(ModBlocks.EDEN_PLANKS))
                .criterion(hasItem(ModBlocks.EDEN_PLANKS), conditionsFromItem(ModBlocks.EDEN_PLANKS))
                .offerTo(exporter, new Identifier((getRecipeName(ModBlocks.EDEN_FENCE_GATE))));

        createFenceRecipe(ModBlocks.EDEN_FENCE, Ingredient.ofItems(ModBlocks.EDEN_PLANKS))
                .criterion(hasItem(ModBlocks.EDEN_PLANKS), conditionsFromItem(ModBlocks.EDEN_PLANKS))
                .offerTo(exporter, new Identifier((getRecipeName(ModBlocks.EDEN_FENCE))));

        createStairsRecipe(ModBlocks.EDEN_STAIRS, Ingredient.ofItems(ModBlocks.EDEN_PLANKS))
                .criterion(hasItem(ModBlocks.EDEN_PLANKS), conditionsFromItem(ModBlocks.EDEN_PLANKS))
                .offerTo(exporter, new Identifier((getRecipeName(ModBlocks.EDEN_STAIRS))));

        createDoorRecipe(ModBlocks.EDEN_DOOR, Ingredient.ofItems(ModBlocks.EDEN_PLANKS))
                .criterion(hasItem(ModBlocks.EDEN_PLANKS), conditionsFromItem(ModBlocks.EDEN_PLANKS))
                .offerTo(exporter, new Identifier((getRecipeName(ModBlocks.EDEN_DOOR))));

        createTrapdoorRecipe(ModBlocks.EDEN_TRAPDOOR, Ingredient.ofItems(ModBlocks.EDEN_PLANKS))
                .criterion(hasItem(ModBlocks.EDEN_PLANKS), conditionsFromItem(ModBlocks.EDEN_PLANKS))
                .offerTo(exporter, new Identifier((getRecipeName(ModBlocks.EDEN_TRAPDOOR))));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.EDEN_SLAB, 6)
                .pattern("###")
                .input('#', ModBlocks.EDEN_PLANKS)
                .criterion(hasItem(ModBlocks.EDEN_PLANKS), conditionsFromItem(ModBlocks.EDEN_PLANKS))
                .offerTo(exporter, new Identifier((getRecipeName(ModBlocks.EDEN_SLAB))));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.EDEN_PRESSURE_PLATE, 1)
                .pattern("##")
                .input('#', ModBlocks.EDEN_PLANKS)
                .criterion(hasItem(ModBlocks.EDEN_PLANKS), conditionsFromItem(ModBlocks.EDEN_PLANKS))
                .offerTo(exporter, new Identifier((getRecipeName(ModBlocks.EDEN_PRESSURE_PLATE))));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS,ModBlocks.EDEN_BUTTON).input(ModBlocks.EDEN_PLANKS)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.EDEN_PLANKS),
                FabricRecipeProvider.conditionsFromItem(ModBlocks.EDEN_PLANKS)).offerTo(exporter, new Identifier((getRecipeName((ModBlocks.EDEN_BUTTON)))));
    }
}

