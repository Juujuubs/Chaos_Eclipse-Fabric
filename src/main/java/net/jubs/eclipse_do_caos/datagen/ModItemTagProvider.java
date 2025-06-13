package net.jubs.eclipse_do_caos.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.jubs.eclipse_do_caos.blocks.ModBlocks;
import net.jubs.eclipse_do_caos.items.ModItems;
import net.jubs.eclipse_do_caos.util.ModTags;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
            protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(ItemTags.MUSIC_DISCS)
                .add(ModItems.ECLIPSE_BEGINS_MUSIC_DISC);

        getOrCreateTagBuilder(ItemTags.CREEPER_DROP_MUSIC_DISCS)
                .add(ModItems.ECLIPSE_BEGINS_MUSIC_DISC);

        getOrCreateTagBuilder(ItemTags.SWORDS)
                .add(ModItems.QUARTERSTAFF)
                .add(ModItems.HELENA_BASEBALL_BAT)
                .add(ModItems.CLAWS)
                .add(ModItems.HILDA_SICKLE)
                .add(ModItems.DIEGO_RAPIER)
                .add(ModItems.AKIRA_KATANA)
                .add(ModItems.ODIN_DAGGER)
                .add(ModItems.SAW_EATER)
                .add(ModItems.LADON_DRAGON_GLAIVE)
                .add(ModItems.CHALI_II_LANCE)
                .add(ModItems.AGATHA_BONESAW)
                .add(ModItems.REUS_WALKING_CANE)
                .add(ModItems.SAI);

        getOrCreateTagBuilder(ItemTags.FISHES)
                .add(ModItems.TILAPIA);

        getOrCreateTagBuilder(ModTags.Items.GRIMOIRES)
                .add(ModItems.GRIMOIRE)
                .add(ModItems.ASGORE_GRIMOIRE)
                .add(ModItems.OLD_GRIMOIRE)
                .add(ModItems.NOVUS_GRIMOIRE);

        getOrCreateTagBuilder(ModTags.Items.STAFFS)
                .add(ModItems.VEIGAR_STAFF)
                .add(ModItems.QRAZ_STAFF)
                .add(ModItems.SYLVERIA_STAFF)
                .add(ModItems.QUARTERSTAFF);

        getOrCreateTagBuilder(ModTags.Items.WANDS)
                .add(ModItems.BELAIOS_WAND);

        getOrCreateTagBuilder(ItemTags.AXES)
                .add(ModItems.ESSENCE_PAXEL)
                .add(ModItems.ARTORIAS_DESPAIR)
                .add(ModItems.SAW_EATER)
                .add(ModItems.NORR_FORR_HAMMER)
                .add(ModItems.ERAK_BATTLEAXE);

        getOrCreateTagBuilder(ItemTags.PICKAXES)
                .add(ModItems.ESSENCE_PAXEL);

        getOrCreateTagBuilder(ItemTags.SHOVELS)
                .add(ModItems.ESSENCE_PAXEL);

        getOrCreateTagBuilder(ItemTags.TOOLS)
                .add(ModItems.ESSENCE_PAXEL)
                .add(ModItems.DELS)
                .add(ModItems.ARTORIAS_DESPAIR)
                .add(ModItems.SAW_EATER)
                .add(ModItems.NORR_FORR_HAMMER)
                .add(ModItems.ERAK_BATTLEAXE);

        getOrCreateTagBuilder(ModTags.Items.SHIELDS)
                .add(ModItems.PALLIS_SHIELD);
        getOrCreateTagBuilder(ModTags.Items.BOWS)
                .add(ModItems.ZORA_BOW);
        getOrCreateTagBuilder(ModTags.Items.GUNS)
                .add(ModItems.CARSON_CANNON);
        getOrCreateTagBuilder(ModTags.Items.BOSS_WEAPONS)
                .add(ModItems.DIEGO_RAPIER)
                .add(ModItems.CHALI_II_LANCE)
                .add(ModItems.AGATHA_BONESAW)
                .add(ModItems.AKIRA_KATANA);

        getOrCreateTagBuilder(ItemTags.PIGLIN_LOVED)
                .add(ModItems.GRIMOIRE)
                .add(ModItems.ASGORE_GRIMOIRE)
                .add(ModItems.OLD_GRIMOIRE)
                .add(ModItems.CARSON_CANNON)
                .add(ModItems.ODIN_DAGGER);

        getOrCreateTagBuilder(ItemTags.BEACON_PAYMENT_ITEMS)
                .add(ModItems.ESSENCE);

        getOrCreateTagBuilder(ItemTags.BOOKSHELF_BOOKS)
                .add(ModItems.GRIMOIRE)
                .add(ModItems.ASGORE_GRIMOIRE)
                .add(ModItems.OLD_GRIMOIRE)
                .add(ModItems.NOVUS_GRIMOIRE)
                .add(ModItems.VOX);

        getOrCreateTagBuilder(ItemTags.VILLAGER_PLANTABLE_SEEDS)
                .add(ModItems.BEAN);


        getOrCreateTagBuilder(ItemTags.PLANKS)
                .add(ModBlocks.EDEN_PLANKS.asItem());

        getOrCreateTagBuilder(ItemTags.LEAVES)
                .add(ModBlocks.EDEN_LEAVES.asItem());

        getOrCreateTagBuilder(ItemTags.SAPLINGS)
                .add(ModBlocks.EDEN_SAPLING.asItem());

        getOrCreateTagBuilder(ItemTags.FENCES)
                .add(ModBlocks.EDEN_FENCE.asItem());
        getOrCreateTagBuilder(ItemTags.WOODEN_FENCES)
                .add(ModBlocks.EDEN_FENCE.asItem());
        getOrCreateTagBuilder(ItemTags.FENCE_GATES)
                .add(ModBlocks.EDEN_FENCE_GATE.asItem());

        getOrCreateTagBuilder(ItemTags.STAIRS)
                .add(ModBlocks.EDEN_STAIRS.asItem());
        getOrCreateTagBuilder(ItemTags.WOODEN_STAIRS)
                .add(ModBlocks.EDEN_STAIRS.asItem());

        getOrCreateTagBuilder(ItemTags.SLABS)
                .add(ModBlocks.EDEN_SLAB.asItem());
        getOrCreateTagBuilder(ItemTags.WOODEN_SLABS)
                .add(ModBlocks.EDEN_SLAB.asItem());

        getOrCreateTagBuilder(ItemTags.BUTTONS)
                .add(ModBlocks.EDEN_BUTTON.asItem());
        getOrCreateTagBuilder(ItemTags.WOODEN_BUTTONS)
                .add(ModBlocks.EDEN_BUTTON.asItem());

        getOrCreateTagBuilder(ItemTags.DOORS)
                .add(ModBlocks.EDEN_DOOR.asItem());
        getOrCreateTagBuilder(ItemTags.WOODEN_DOORS)
                .add(ModBlocks.EDEN_DOOR.asItem());

        getOrCreateTagBuilder(ItemTags.TRAPDOORS)
                .add(ModBlocks.EDEN_TRAPDOOR.asItem());
        getOrCreateTagBuilder(ItemTags.WOODEN_TRAPDOORS)
                .add(ModBlocks.EDEN_TRAPDOOR.asItem());

        getOrCreateTagBuilder(ItemTags.SIGNS)
                .add(ModBlocks.EDEN_SIGN.asItem());
        getOrCreateTagBuilder(ItemTags.HANGING_SIGNS)
                .add(ModBlocks.EDEN_HANGING_SIGN.asItem());

        getOrCreateTagBuilder(ItemTags.WOODEN_PRESSURE_PLATES)
                .add(ModBlocks.EDEN_PRESSURE_PLATE.asItem());

        getOrCreateTagBuilder(ItemTags.FLOWERS)
                .add(ModBlocks.BROMELIAD.asItem());
        getOrCreateTagBuilder(ItemTags.SMALL_FLOWERS)
                .add(ModBlocks.BROMELIAD.asItem());

        getOrCreateTagBuilder(ItemTags.LOGS)
                .add(ModBlocks.EDEN_LOG.asItem())
                .add(ModBlocks.EDEN_WOOD.asItem())
                .add(ModBlocks.STRIPPED_EDEN_LOG.asItem())
                .add(ModBlocks.STRIPPED_EDEN_WOOD.asItem());
        getOrCreateTagBuilder(ItemTags.LOGS_THAT_BURN)
                .add(ModBlocks.EDEN_LOG.asItem())
                .add(ModBlocks.EDEN_WOOD.asItem())
                .add(ModBlocks.STRIPPED_EDEN_LOG.asItem())
                .add(ModBlocks.STRIPPED_EDEN_WOOD.asItem());

        getOrCreateTagBuilder(ItemTags.BOATS)
                .add(ModItems.EDEN_BOAT)
                .add(ModItems.EDEN_CHEST_BOAT);
        getOrCreateTagBuilder(ItemTags.CHEST_BOATS)
                .add(ModItems.EDEN_CHEST_BOAT);

        getOrCreateTagBuilder(ModTags.Items.RANGED_WEAPONS)
                .add(ModItems.ASGORE_GRIMOIRE)
                .add(ModItems.BEANS_SACK)
                .add(ModItems.CARSON_CANNON)
                .add(ModItems.GRIMOIRE)
                .add(ModItems.NOVUS_GRIMOIRE)
                .add(ModItems.OLD_GRIMOIRE)
                .add(ModItems.QRAZ_STAFF)
                .add(ModItems.SYLVERIA_STAFF)
                .add(ModItems.VEIGAR_STAFF)
                .add(ModItems.ZORA_BOW)
                .add(ModItems.BELAIOS_WAND)
                .add(ModItems.FROG);

        getOrCreateTagBuilder(ModTags.Items.NOT_FROM_THIS_WORLD)
                .add(ModItems.ASGORE_GRIMOIRE)
                .add(ModItems.ARTORIAS_DESPAIR)
                .add(ModItems.HELENA_BASEBALL_BAT)
                .add(ModItems.HILDA_SICKLE)
                .add(ModItems.DIEGO_RAPIER)
                .add(ModItems.ODIN_DAGGER)
                .add(ModItems.CARSON_CANNON)
                .add(ModItems.SAW_EATER)
                .add(ModItems.LADON_DRAGON_GLAIVE)
                .add(ModItems.ERAK_BATTLEAXE)
                .add(ModItems.CHALI_II_LANCE)
                .add(ModItems.ZORA_BOW);

        getOrCreateTagBuilder(ModTags.Items.LOST_WEAPONS)
                .add(ModItems.QUARTERSTAFF)
                .add(ModItems.OLD_GRIMOIRE)
                .add(ModItems.GRIMOIRE)
                .add(ModItems.FROG)
                .add(ModItems.CATALYST)
                .add(ModItems.CLAWS)
                .add(ModItems.PALLIS_SHIELD)
                .add(ModItems.ASGORE_GRIMOIRE)
                .add(ModItems.BEANS_SACK)
                .add(ModItems.ARTORIAS_DESPAIR)
                .add(ModItems.HELENA_BASEBALL_BAT)
                .add(ModItems.HILDA_SICKLE)
                .add(ModItems.DIEGO_RAPIER)
                .add(ModItems.AKIRA_KATANA)
                .add(ModItems.ODIN_DAGGER)
                .add(ModItems.SAI)
                .add(ModItems.VEIGAR_STAFF)
                .add(ModItems.QRAZ_STAFF)
                .add(ModItems.SYLVERIA_STAFF)
                .add(ModItems.NOVUS_GRIMOIRE)
                .add(ModItems.CARSON_CANNON)
                .add(ModItems.SAW_EATER)
                .add(ModItems.LADON_DRAGON_GLAIVE)
                .add(ModItems.ERAK_BATTLEAXE)
                .add(ModItems.BELAIOS_WAND)
                .add(ModItems.GAUNTLET)
                .add(ModItems.NORR_FORR_HAMMER)
                .add(ModItems.CHALI_II_LANCE)
                .add(ModItems.AGATHA_BONESAW)
                .add(ModItems.REUS_WALKING_CANE)
                .add(ModItems.ZORA_BOW);
    }

}
