package net.jubs.eclipse_do_caos.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.jubs.eclipse_do_caos.blocks.ModBlocks;
import net.jubs.eclipse_do_caos.util.ModTags;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
getOrCreateTagBuilder(ModTags.Blocks.DELS_UNKNOWN_BLOCKS)
        .add(ModBlocks.ESSENCE_ORE_BLOCK)
        .add(ModBlocks.ESSENCE_BLOCK)
        .add(ModBlocks.RADIO_ANNOUNCER)
        .add(ModBlocks.BROMELIAD)
        .add(ModBlocks.POTTED_BROMELIAD)
        .add(ModBlocks.EDEN_LOG)
        .add(ModBlocks.EDEN_WOOD)
        .add(ModBlocks.STRIPPED_EDEN_LOG)
        .add(ModBlocks.STRIPPED_EDEN_WOOD)
        .add(ModBlocks.SAMARA_PLUSHIE)
        .add(ModBlocks.EDEN_SAPLING)
        .add(ModBlocks.POTTED_EDEN_SAPLING)
        .add(ModBlocks.CATALYST_INFUSER);

getOrCreateTagBuilder(BlockTags.AXE_MINEABLE)
        .add(ModBlocks.CATALYST_INFUSER)
        .add(ModBlocks.SAMARA_PLUSHIE);

getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
        .add(ModBlocks.ESSENCE_ORE_BLOCK)
        .add(ModBlocks.ESSENCE_BLOCK)
        .add(ModBlocks.RADIO_ANNOUNCER);

getOrCreateTagBuilder(ModTags.Blocks.PAXEL_MINEABLE)
        .forceAddTag(BlockTags.PICKAXE_MINEABLE)
        .forceAddTag(BlockTags.SHOVEL_MINEABLE)
        .forceAddTag(BlockTags.AXE_MINEABLE);

getOrCreateTagBuilder(ModTags.Blocks.SAW_EATER_MINEABLE)
        .forceAddTag(BlockTags.AXE_MINEABLE);

getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
        .add(ModBlocks.ESSENCE_BLOCK)
        .add(ModBlocks.RADIO_ANNOUNCER)
        .add(ModBlocks.CATALYST_INFUSER);

getOrCreateTagBuilder(BlockTags.CROPS)
        .add(ModBlocks.BEAN_CROP);

getOrCreateTagBuilder(BlockTags.MAINTAINS_FARMLAND)
        .add(ModBlocks.BEAN_CROP);

getOrCreateTagBuilder(BlockTags.FLOWERS)
        .add(ModBlocks.BROMELIAD);
getOrCreateTagBuilder(BlockTags.SMALL_FLOWERS)
        .add(ModBlocks.BROMELIAD);

getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN)
        .add(ModBlocks.EDEN_LOG)
        .add(ModBlocks.EDEN_WOOD)
        .add(ModBlocks.STRIPPED_EDEN_LOG)
        .add(ModBlocks.STRIPPED_EDEN_WOOD);
getOrCreateTagBuilder(BlockTags.LOGS)
        .add(ModBlocks.EDEN_LOG)
        .add(ModBlocks.EDEN_WOOD)
        .add(ModBlocks.STRIPPED_EDEN_LOG)
        .add(ModBlocks.STRIPPED_EDEN_WOOD);

getOrCreateTagBuilder(BlockTags.PLANKS)
        .add(ModBlocks.EDEN_PLANKS);

getOrCreateTagBuilder(BlockTags.STAIRS)
        .add(ModBlocks.EDEN_STAIRS);
getOrCreateTagBuilder(BlockTags.WOODEN_STAIRS)
        .add(ModBlocks.EDEN_STAIRS);

getOrCreateTagBuilder(BlockTags.PRESSURE_PLATES)
        .add(ModBlocks.EDEN_PRESSURE_PLATE);
getOrCreateTagBuilder(BlockTags.WOODEN_PRESSURE_PLATES)
        .add(ModBlocks.EDEN_PRESSURE_PLATE);

getOrCreateTagBuilder(BlockTags.BUTTONS)
        .add(ModBlocks.EDEN_BUTTON);
getOrCreateTagBuilder(BlockTags.WOODEN_BUTTONS)
        .add(ModBlocks.EDEN_BUTTON);

getOrCreateTagBuilder(BlockTags.SLABS)
        .add(ModBlocks.EDEN_SLAB);
getOrCreateTagBuilder(BlockTags.WOODEN_SLABS)
        .add(ModBlocks.EDEN_SLAB);

getOrCreateTagBuilder(BlockTags.LEAVES)
        .add(ModBlocks.EDEN_LEAVES);
getOrCreateTagBuilder(BlockTags.SAPLINGS)
        .add(ModBlocks.EDEN_SAPLING);

getOrCreateTagBuilder(BlockTags.FENCES)
        .add(ModBlocks.EDEN_FENCE);
getOrCreateTagBuilder(BlockTags.WOODEN_FENCES)
        .add(ModBlocks.EDEN_FENCE);
getOrCreateTagBuilder(BlockTags.FENCE_GATES)
        .add(ModBlocks.EDEN_FENCE_GATE);
getOrCreateTagBuilder(BlockTags.DOORS)
        .add(ModBlocks.EDEN_DOOR);
getOrCreateTagBuilder(BlockTags.WOODEN_DOORS)
        .add(ModBlocks.EDEN_DOOR);
getOrCreateTagBuilder(BlockTags.TRAPDOORS)
        .add(ModBlocks.EDEN_TRAPDOOR);
getOrCreateTagBuilder(BlockTags.WOODEN_TRAPDOORS)
        .add(ModBlocks.EDEN_TRAPDOOR);

getOrCreateTagBuilder(BlockTags.SIGNS)
        .add(ModBlocks.EDEN_SIGN)
        .add(ModBlocks.EDEN_WALL_SIGN)
        .add(ModBlocks.EDEN_HANGING_SIGN)
        .add(ModBlocks.EDEN_HANGING_WALL_SIGN);

getOrCreateTagBuilder(BlockTags.STANDING_SIGNS)
        .add(ModBlocks.EDEN_SIGN);
getOrCreateTagBuilder(BlockTags.WALL_POST_OVERRIDE)
        .add(ModBlocks.EDEN_SIGN)
        .add(ModBlocks.EDEN_PRESSURE_PLATE);
getOrCreateTagBuilder(BlockTags.ALL_SIGNS)
        .add(ModBlocks.EDEN_SIGN)
        .add(ModBlocks.EDEN_WALL_SIGN)
        .add(ModBlocks.EDEN_HANGING_SIGN)
        .add(ModBlocks.EDEN_HANGING_WALL_SIGN);

getOrCreateTagBuilder(BlockTags.WALL_SIGNS)
        .add(ModBlocks.EDEN_WALL_SIGN)
        .add(ModBlocks.EDEN_SIGN);

getOrCreateTagBuilder(BlockTags.WALL_HANGING_SIGNS)
        .add(ModBlocks.EDEN_HANGING_WALL_SIGN);
getOrCreateTagBuilder(BlockTags.ALL_HANGING_SIGNS)
        .add(ModBlocks.EDEN_HANGING_SIGN)
        .add(ModBlocks.EDEN_HANGING_WALL_SIGN);
getOrCreateTagBuilder(BlockTags.CEILING_HANGING_SIGNS)
        .add(ModBlocks.EDEN_HANGING_SIGN)
        .add(ModBlocks.EDEN_HANGING_WALL_SIGN);

getOrCreateTagBuilder(TagKey.of(RegistryKeys.BLOCK, new Identifier("fabric", "needs_tool_level_4")))
        .add(ModBlocks.ESSENCE_ORE_BLOCK);
    }

}
