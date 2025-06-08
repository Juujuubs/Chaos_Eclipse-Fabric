package net.jubs.eclipse_do_caos.items;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.jubs.eclipse_do_caos.EclipseDoCaos;
import net.jubs.eclipse_do_caos.blocks.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup ECLIPSE_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(EclipseDoCaos.MOD_ID, "eclipse"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.eclipse"))
                    .icon(() -> new ItemStack(ModItems.ECLIPSE)).entries((displayContext, entries) -> {
                        entries.add(ModItems.SYMBOL);
                        entries.add(ModItems.CONTRACT);
                        entries.add(ModItems.VOX);
                        entries.add(ModItems.TICKET_ARCANUMRAILS);
                        entries.add(ModItems.TICKET_DELUXE_ARCANUMRAILS);
                        entries.add(ModItems.DEVIL_HORN);
                        entries.add(ModItems.GOBLIN_EYE);
                        entries.add(ModItems.ELF_EAR);
                        entries.add(ModItems.HUMAN_TOOTH);

                        entries.add(ModItems.TILAPIA);
                        entries.add(ModItems.FRIED_TILAPIA);
                        entries.add(ModItems.SUSHI_TILAPIA);
                        entries.add(ModItems.BEAN);
                        entries.add(ModItems.COOKED_BEAN);
                        entries.add(ModItems.EDEN_TREE_APPLE);
                        entries.add(ModItems.EDEN_APPLE);

                        entries.add(ModBlocks.BROMELIAD);
                        entries.add(ModItems.ECLIPSE);
                        entries.add(ModBlocks.ESSENCE_ORE_BLOCK);
                        entries.add(ModBlocks.ESSENCE_BLOCK);

                        entries.add(ModItems.ESSENCE);

                        entries.add(ModBlocks.RADIO_ANNOUNCER);
                        entries.add(ModBlocks.SAMARA_PLUSHIE);
                        entries.add(ModBlocks.CATALYST_INFUSER);

                        entries.add(ModBlocks.EYE_BLOCK);
                        entries.add(ModBlocks.MEAT_BLOCK);
                        entries.add(ModBlocks.TEETH_BLOCK);

                        entries.add(ModBlocks.EDEN_LOG);
                        entries.add(ModBlocks.EDEN_WOOD);
                        entries.add(ModBlocks.STRIPPED_EDEN_LOG);
                        entries.add(ModBlocks.STRIPPED_EDEN_WOOD);
                        entries.add(ModBlocks.EDEN_PLANKS);
                        entries.add(ModBlocks.EDEN_DOOR);
                        entries.add(ModBlocks.EDEN_STAIRS);
                        entries.add(ModBlocks.EDEN_FENCE);
                        entries.add(ModBlocks.EDEN_FENCE_GATE);
                        entries.add(ModBlocks.EDEN_HANGING_SIGN);
                        entries.add(ModBlocks.EDEN_SIGN);
                        entries.add(ModItems.EDEN_CHEST_BOAT);
                        entries.add(ModItems.EDEN_BOAT);
                        entries.add(ModBlocks.EDEN_SLAB);
                        entries.add(ModBlocks.EDEN_TRAPDOOR);
                        entries.add(ModBlocks.EDEN_PRESSURE_PLATE);
                        entries.add(ModBlocks.EDEN_BUTTON);
                        entries.add(ModBlocks.EDEN_LEAVES);
                        entries.add(ModBlocks.EDEN_SAPLING);

                        entries.add(ModItems.ECLIPSE_BEGINS_MUSIC_DISC);

                        entries.add(ModItems.DELS);
                        entries.add(ModItems.ESSENCE_PAXEL);

                        entries.add(ModItems.QUARTERSTAFF);
                        entries.add(ModItems.HELENA_BASEBALL_BAT);
                        entries.add(ModItems.QRAZ_STAFF);
                        entries.add(ModItems.SYLVERIA_STAFF);
                        entries.add(ModItems.VEIGAR_STAFF);
                        entries.add(ModItems.LADON_DRAGON_GLAIVE);
                        entries.add(ModItems.NORR_FORR_HAMMER);
                        entries.add(ModItems.ERAK_BATTLEAXE);
                        entries.add(ModItems.ARTORIAS_DESPAIR);
                        entries.add(ModItems.SAW_EATER);
                        entries.add(ModItems.CHALI_II_LANCE);
                        entries.add(ModItems.AKIRA_KATANA);
                        entries.add(ModItems.DIEGO_RAPIER);
                        entries.add(ModItems.CLAWS);
                        entries.add(ModItems.SAI);
                        entries.add(ModItems.HILDA_SICKLE);
                        entries.add(ModItems.ODIN_DAGGER);
                        entries.add(ModItems.GAUNTLET);
                        entries.add(ModItems.BEANS_SACK);
                        entries.add(ModItems.FROG);
                        entries.add(ModItems.BELAIOS_WAND);
                        entries.add(ModItems.GRIMOIRE);
                        entries.add(ModItems.OLD_GRIMOIRE);
                        entries.add(ModItems.ASGORE_GRIMOIRE);
                        entries.add(ModItems.NOVUS_GRIMOIRE);
                        entries.add(ModItems.ZORA_BOW);
                        entries.add(ModItems.CARSON_CANNON);
                        entries.add(ModItems.PALLIS_SHIELD);
                        entries.add(ModItems.CATALYST);
                        entries.add(ModItems.CATALYST_EMPTY);
                        entries.add(ModItems.CANNONBALL);
                        entries.add(ModItems.POISON_BOLT);
                        entries.add(ModItems.LIGHTNING_STRIKE);

                    }).build());



    public static void registerItemGroups() {
        EclipseDoCaos.LOGGER.info("Registrando Grupos de Itens do Mod para " + EclipseDoCaos.MOD_ID);
    }
}
