package net.jubs.eclipse_do_caos.items;

import com.terraformersmc.terraform.boat.api.item.TerraformBoatItemHelper;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.jubs.eclipse_do_caos.EclipseDoCaos;
import net.jubs.eclipse_do_caos.blocks.ModBlocks;
import net.jubs.eclipse_do_caos.entity.ModBoats;
import net.jubs.eclipse_do_caos.items.custom.*;
import net.jubs.eclipse_do_caos.sound.ModSounds;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static net.jubs.eclipse_do_caos.blocks.ModBlocks.*;


public class ModItems {
    public static final Item CONTRACT = registerItem("contract", new Item(new FabricItemSettings().maxCount(1)));
    public static final Item ESSENCE = registerItem("essence", new Item(new FabricItemSettings()));
    public static final Item SYMBOL = registerItem("symbol", new Item(new FabricItemSettings().maxCount(1)));
    public static final Item VOX = registerItem("vox", new Item(new FabricItemSettings()));
    public static final Item DEVIL_HORN = registerItem("devil_horn", new Item(new FabricItemSettings()));
    public static final Item GOBLIN_EYE = registerItem("goblin_eye", new Item(new FabricItemSettings().food(ModFoodComponents.GOBLIN_EYE)));
    public static final Item ELF_EAR = registerItem("elf_ear", new Item(new FabricItemSettings().food(ModFoodComponents.ELF_EAR)));
    public static final Item HUMAN_TOOTH = registerItem("human_tooth", new Item(new FabricItemSettings()));
    public static final Item TICKET_ARCANUMRAILS = registerItem("ticket_arcanumrails", new Item(new FabricItemSettings()));
    public static final Item TICKET_DELUXE_ARCANUMRAILS = registerItem("ticket_deluxe_arcanumrails", new Item(new FabricItemSettings()));
    public static final Item ECLIPSE = registerItem("eclipse", new Item(new FabricItemSettings().maxCount(1)));


    public static final Item ECLIPSE_BEGINS_MUSIC_DISC = registerItem("eclipse_begins_music_disc",
            new MusicDiscItem(7, ModSounds.ECLIPSE_BEGINS, new FabricItemSettings().maxCount(1),211));


    public static final Item DELS = registerItem("dels",
            new DelsItem(new FabricItemSettings().maxDamage(512).fireproof()));


    public static final Item QUARTERSTAFF = registerItem("quarterstaff",
            new QuarterstaffItem(ModToolMaterial.ESSENCE, 6,-2.8f, new FabricItemSettings()));
    public static final Item LADON_DRAGON_GLAIVE = registerItem("ladon_dragon_glaive",
            new LadonDragonGlaiveItem(ModToolMaterial.ESSENCE, 8,-3.2f, new FabricItemSettings().fireproof()));
    public static final Item HELENA_BASEBALL_BAT = registerItem("helena_baseball_bat",
            new HelenaBaseballBatItem(ModToolMaterial.ESSENCE, 4,-2.6f, new FabricItemSettings()));

    public static final Item CHALI_II_LANCE = registerItem("chali_ii_lance",
            new ChaliIILanceItem(ModToolMaterial.ESSENCE, 5,-2.75f, new FabricItemSettings().fireproof()));

    public static final Item SAW_EATER = registerItem("saw_eater",
            new SawEaterItem(ModToolMaterial.ESSENCE, 10,-3.5f, new FabricItemSettings().fireproof()));
    public static final Item ARTORIAS_DESPAIR = registerItem("artorias_despair",
            new ArtoriasDespairItem(ModToolMaterial.ESSENCE, 12,-3.75f, new FabricItemSettings().fireproof()));

    public static final Item GAUNTLET = registerItem("gauntlet",
            new GauntletItem(ModToolMaterial.ESSENCE, 2,-1.5f, new FabricItemSettings()));

    public static final Item ERAK_BATTLEAXE = registerItem("erak_battleaxe",
            new ErakBattleaxeItem(ModToolMaterial.ESSENCE, 16,-3.85f, new FabricItemSettings().fireproof()));
    public static final Item NORR_FORR_HAMMER = registerItem("norr_forr_hammer",
            new NorrForrHammerItem(ModToolMaterial.ESSENCE, 11,-3.65f, new FabricItemSettings().fireproof()));
    public static final Item CLAWS = registerItem("claws",
            new ClawsItem(ModToolMaterial.ESSENCE, -3,2f, new FabricItemSettings().fireproof()));
    public static final Item AKIRA_KATANA = registerItem("akira_katana",
            new AkiraKatanaItem(ModToolMaterial.ESSENCE, 8,-2.2f, new FabricItemSettings().fireproof()));
    public static final Item ODIN_DAGGER = registerItem("odin_dagger",
            new OdinDaggerItem(ModToolMaterial.ESSENCE, -1,1f, new FabricItemSettings().fireproof()));
    public static final Item HILDA_SICKLE = registerItem("hilda_sickle",
            new HildaSickleItem(ModToolMaterial.ESSENCE, 0,0.5f, new FabricItemSettings()));
    public static final Item SAI = registerItem("sai",
            new SaiItem(ModToolMaterial.ESSENCE, -2,1.5f, new FabricItemSettings().fireproof()));
    public static final Item DIEGO_RAPIER = registerItem("diego_rapier",
            new DiegoRapierItem(ModToolMaterial.ESSENCE, 1,-1f, new FabricItemSettings().fireproof()));
    public static final Item REUS_WALKING_CANE = registerItem("reus_walking_cane",
            new ReusWalkingCaneItem(ModToolMaterial.ESSENCE, 3,-2f, new FabricItemSettings().fireproof()));
    public static final Item AGATHA_BONESAW = registerItem("agatha_bonesaw",
            new AgathaBonesawItem(ModToolMaterial.ESSENCE, 7,-3.1f, new FabricItemSettings().fireproof()));
    public static final Item GRIMOIRE = registerItem("grimoire", new GrimoireItem(new FabricItemSettings().maxCount(1).maxDamage(3000)));
    public static final Item BELAIOS_WAND = registerItem("belaios_wand", new BelaiosWandItem(new FabricItemSettings().maxCount(1).maxDamage(3000)));
    public static final Item OLD_GRIMOIRE = registerItem("old_grimoire", new OldGrimoireItem(new FabricItemSettings().maxCount(1).maxDamage(3000)));
    public static final Item ASGORE_GRIMOIRE = registerItem("asgore_grimoire", new AsgoreGrimoireItem(new FabricItemSettings().maxCount(1).maxDamage(3000)));
    public static final Item NOVUS_GRIMOIRE = registerItem("novus_grimoire", new NovusGrimoireItem(new FabricItemSettings().maxCount(1).maxDamage(3000).fireproof()));
    public static final Item BEANS_SACK = registerItem("beans_sack", new BeansSackItem(new FabricItemSettings().maxCount(1).maxDamage(3000)));
    public static final Item FROG = registerItem("frog", new FrogItem(new FabricItemSettings().maxCount(1).maxDamage(3000)));
    public static final Item VEIGAR_STAFF = registerItem("veigar_staff", new VeigarStaffItem(new FabricItemSettings().maxCount(1).maxDamage(3000).fireproof()));
    public static final Item QRAZ_STAFF = registerItem("qraz_staff", new QrazStaffItem(new FabricItemSettings().maxCount(1).maxDamage(3000)));
    public static final Item SYLVERIA_STAFF = registerItem("sylveria_staff", new SylveriaStaffItem(new FabricItemSettings().maxCount(1).maxDamage(3000).fireproof()));
    public static final Item CATALYST = registerItem("catalyst", new CatalystItem(new FabricItemSettings().maxCount(3).fireproof()));
    public static final Item CATALYST_EMPTY = registerItem("catalyst_empty", new Item(new FabricItemSettings().maxCount(64)));
    public static final Item CARSON_CANNON = registerItem("carson_cannon", new CarsonCannonItem(new FabricItemSettings().maxCount(1).maxDamage(3000).fireproof()));
    public static final Item ZORA_BOW = registerItem("zora_bow", new ZoraBowItem(new FabricItemSettings().maxDamage(3000)));
    public static final Item PALLIS_SHIELD = registerItem("pallis_shield",
            new PallisShieldItem(new FabricItemSettings().maxCount(1).maxDamage(3000).fireproof()));

    public static final Item EDEN_SIGN = registerItem("eden_sign",
            new SignItem(new FabricItemSettings().maxCount(16), ModBlocks.EDEN_SIGN, ModBlocks.EDEN_WALL_SIGN));
    public static final Item EDEN_HANGING_SIGN = registerItem("eden_hanging_sign",
            new HangingSignItem(ModBlocks.EDEN_HANGING_SIGN, ModBlocks.EDEN_HANGING_WALL_SIGN, new FabricItemSettings().maxCount(16)));

    public static final Item ESSENCE_PAXEL = registerItem("essence_paxel",
            new PaxelItem(ModToolMaterial.ESSENCE, 1.5f,-2.9f, new FabricItemSettings().fireproof()));


    public static final Item EDEN_BOAT = TerraformBoatItemHelper.registerBoatItem(ModBoats.EDEN_BOAT_ID, ModBoats.EDEN_BOAT_KEY, false);
    public static final Item EDEN_CHEST_BOAT = TerraformBoatItemHelper.registerBoatItem(ModBoats.EDEN_CHEST_BOAT_ID, ModBoats.EDEN_BOAT_KEY, true);



    public static final Item TILAPIA = registerItem("tilapia", new Item(new FabricItemSettings().food(ModFoodComponents.TILAPIA)));
    public static final Item FRIED_TILAPIA = registerItem("fried_tilapia", new Item(new FabricItemSettings().food(ModFoodComponents.FRIED_TILAPIA)));
    public static final Item SUSHI_TILAPIA = registerItem("sushi_tilapia", new Item(new FabricItemSettings().food(ModFoodComponents.SUSHI_TILAPIA)));
    public static final Item LIGHTNING_STRIKE = registerItem("lightning_strike", new LightningStrikeItem(new FabricItemSettings()));
    public static final Item POISON_BOLT = registerItem("poison_bolt", new PoisonBoltItem(new FabricItemSettings()));
    public static final Item CANNONBALL = registerItem("cannonball", new Item(new FabricItemSettings()));
    public static final Item BEAN = registerItem("bean", new BeanItem(ModBlocks.BEAN_CROP, new FabricItemSettings().food(ModFoodComponents.BEAN)));
    public static final Item COOKED_BEAN = registerItem("cooked_bean", new CookedBeanItem(new FabricItemSettings().food(ModFoodComponents.COOKED_BEAN)));
    public static final Item EDEN_TREE_APPLE = registerItem("eden_tree_apple", new Item(new FabricItemSettings().food(ModFoodComponents.EDEN_TREE_APPLE)));
    public static final Item EDEN_APPLE = registerItem("eden_apple", new Item(new FabricItemSettings().food(ModFoodComponents.EDEN_APPLE)));

    private static void addItemsToToolsItemGroup(FabricItemGroupEntries entries) {

        entries.add(EDEN_CHEST_BOAT);
        entries.add(EDEN_BOAT);
        entries.add(ECLIPSE_BEGINS_MUSIC_DISC);
        entries.add(DELS);
        entries.add(ESSENCE_PAXEL);
        entries.add(SAW_EATER);
        entries.add(ARTORIAS_DESPAIR);
        entries.add(NORR_FORR_HAMMER);
        entries.add(ERAK_BATTLEAXE);
    }

    private static void addItemsToIngredientItemGroup(FabricItemGroupEntries entries) {

        entries.add(SYMBOL);
        entries.add(CONTRACT);
        entries.add(VOX);
        entries.add(TICKET_ARCANUMRAILS);
        entries.add(TICKET_DELUXE_ARCANUMRAILS);
        entries.add(ESSENCE);
        entries.add(DEVIL_HORN);
        entries.add(GOBLIN_EYE);
        entries.add(ELF_EAR);
        entries.add(HUMAN_TOOTH);
        entries.add(LIGHTNING_STRIKE);
        entries.add(POISON_BOLT);
    }

    private static void addItemsToNaturalItemGroup(FabricItemGroupEntries entries) {

        entries.add(BEAN);
    }

    private static void addItemsToCombatItemGroup(FabricItemGroupEntries entries) {

        entries.add(QUARTERSTAFF);
        entries.add(OLD_GRIMOIRE);
        entries.add(GRIMOIRE);
        entries.add(FROG);
        entries.add(CATALYST);
        entries.add(CLAWS);
        entries.add(PALLIS_SHIELD);
        entries.add(ASGORE_GRIMOIRE);
        entries.add(BEANS_SACK);
        entries.add(ARTORIAS_DESPAIR);
        entries.add(AGATHA_BONESAW);
        entries.add(HELENA_BASEBALL_BAT);
        entries.add(HILDA_SICKLE);
        entries.add(DIEGO_RAPIER);
        entries.add(AKIRA_KATANA);
        entries.add(ODIN_DAGGER);
        entries.add(SAI);
        entries.add(VEIGAR_STAFF);
        entries.add(QRAZ_STAFF);
        entries.add(SYLVERIA_STAFF);
        entries.add(NOVUS_GRIMOIRE);
        entries.add(CARSON_CANNON);
        entries.add(ZORA_BOW);
        entries.add(CANNONBALL);
        entries.add(SAW_EATER);
        entries.add(LADON_DRAGON_GLAIVE);
        entries.add(ERAK_BATTLEAXE);
        entries.add(BELAIOS_WAND);
        entries.add(GAUNTLET);
        entries.add(NORR_FORR_HAMMER);
        entries.add(CHALI_II_LANCE);
        entries.add(ESSENCE_PAXEL);
    }

    private static void addItemsToFoodAndDrinkItemGroup(FabricItemGroupEntries entries) {

        entries.add(CATALYST);
        entries.add(CATALYST_EMPTY);
        entries.add(TILAPIA);
        entries.add(FRIED_TILAPIA);
        entries.add(SUSHI_TILAPIA);
        entries.add(BEAN);
        entries.add(COOKED_BEAN);
        entries.add(EDEN_APPLE);
        entries.add(EDEN_TREE_APPLE);
        entries.add(GOBLIN_EYE);
        entries.add(ELF_EAR);
    }

    private static void addItemsToFunctionalItemGroup(FabricItemGroupEntries entries) {

        entries.add(EDEN_SIGN);
        entries.add(EDEN_HANGING_SIGN);
        entries.add(CATALYST_INFUSER);
        entries.add(RADIO_ANNOUNCER);
        entries.add(SAMARA_PLUSHIE);
    }
    private static void addItemsToOperatorItemGroup(FabricItemGroupEntries entries) {

        entries.add(ECLIPSE);
    }
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(EclipseDoCaos.MOD_ID, name), item);
    }

    public static void registerModItem() {
        EclipseDoCaos.LOGGER.info("Registrando Itens do Mod para " + EclipseDoCaos.MOD_ID);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientItemGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(ModItems::addItemsToToolsItemGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(ModItems::addItemsToCombatItemGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(ModItems::addItemsToFoodAndDrinkItemGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.OPERATOR).register(ModItems::addItemsToOperatorItemGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(ModItems::addItemsToNaturalItemGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(ModItems::addItemsToFunctionalItemGroup);
    }
}
