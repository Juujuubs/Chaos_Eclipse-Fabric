package net.jubs.eclipse_do_caos.util;


import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.jubs.eclipse_do_caos.blocks.ModBlocks;
import net.jubs.eclipse_do_caos.items.ModItems;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ModLootTableModifiers {
private static final Identifier ZOMBIE_ID =
        new Identifier("minecraft","entities/zombie");
    private static final Identifier DROWNED_ID =
            new Identifier("minecraft","entities/drowned");
    private static final Identifier HUSK_ID =
            new Identifier("minecraft","entities/husk");
    private static final Identifier ZOMBIE_VILLAGER_ID =
            new Identifier("minecraft","entities/zombie_villager");
    private static final Identifier ZOMBIFIED_PIGLIN_ID =
            new Identifier("minecraft","entities/zombified_piglin");
    private static final Identifier PIGLIN_ID =
            new Identifier("minecraft","entities/piglin");
    private static final Identifier PIGLIN_BRUTE_ID =
            new Identifier("minecraft","entities/piglin_brute");
    private static final Identifier SKELETON_ID =
            new Identifier("minecraft","entities/skeleton");
    private static final Identifier STRAY_ID =
            new Identifier("minecraft","entities/stray");
    private static final Identifier WITHER_SKELETON_ID =
            new Identifier("minecraft","entities/wither_skeleton");
    private static final Identifier WITHER_ID =
            new Identifier("minecraft","entities/wither");
    private static final Identifier ENDERMAN_ID =
            new Identifier("minecraft","entities/enderman");
    private static final Identifier ENDER_DRAGON_ID =
            new Identifier("minecraft","entities/ender_dragon");
    private static final Identifier VILLAGER_ID =
            new Identifier("minecraft","entities/villager");
    private static final Identifier WANDERING_TRADER_ID =
            new Identifier("minecraft","entities/wandering_trader");
    private static final Identifier PILLAGER_ID =
            new Identifier("minecraft","entities/pillager");
    private static final Identifier RAVAGER_ID =
            new Identifier("minecraft","entities/ravager");
    private static final Identifier VINDICATOR_ID =
            new Identifier("minecraft","entities/vindicator");
    private static final Identifier EVOKER_ID =
            new Identifier("minecraft","entities/evoker");
    private static final Identifier WITCH_ID =
            new Identifier("minecraft","entities/witch");
    private static final Identifier WARDEN_ID =
            new Identifier("minecraft","entities/warden");
    private static final Identifier FROG_ID =
            new Identifier("minecraft","entities/frog");

    private static final Identifier FISH_ID =
            new Identifier("minecraft","gameplay/fishing/fish");
    private static final Identifier TREASURE_ID =
            new Identifier("minecraft","gameplay/fishing/treasure");
    private static final Identifier JUNK_ID =
            new Identifier("minecraft","gameplay/fishing/junk");
    private static final Identifier SNIFFER_DIGGING_ID =
            new Identifier("minecraft","gameplay/sniffer_digging");

    private static final Identifier SUSPICIOUS_SAND_ID =
            new Identifier("minecraft","archaeology/desert_pyramid");

    private static final Identifier ANCIENT_CITY_ID =
            new Identifier("minecraft","chests/ancient_city");

    private static final Identifier ANCIENT_CITY_ICE_BOX_ID =
            new Identifier("minecraft","chests/ancient_city_ice_box");

    private static final Identifier ABANDONED_MINESHAFT_ID =
            new Identifier("minecraft","chests/abandoned_mineshaft");

    private static final Identifier BASTION_TREASURE_ID =
            new Identifier("minecraft","chests/bastion_treasure");

    private static final Identifier DESERT_PYRAMID_ID =
            new Identifier("minecraft","chests/desert_pyramid");

    private static final Identifier END_CITY_TREASURE_ID =
            new Identifier("minecraft","chests/end_city_treasure");

    private static final Identifier JUNGLE_TEMPLE_ID =
            new Identifier("minecraft","chests/jungle_temple");

    private static final Identifier PILLAGER_OUTPOST_ID =
            new Identifier("minecraft","chests/pillager_outpost");

    private static final Identifier IGLOO_CHEST_ID =
            new Identifier("minecraft","chests/igloo_chest");

    private static final Identifier SIMPLE_DUNGEON_ID =
            new Identifier("minecraft","chests/simple_dungeon");

    private static final Identifier WOODLAND_MANSION_ID =
            new Identifier("minecraft","chests/woodland_mansion");

    private static final Identifier STRONGHOLD_LIBRARY_ID =
            new Identifier("minecraft","chests/stronghold_library");

    private static final Identifier UNDERWATER_RUIN_BIG_ID =
            new Identifier("minecraft","chests/underwater_ruin_big");

    private static final Identifier UNDERWATER_RUIN_SMALL_ID =
            new Identifier("minecraft","chests/underwater_ruin_small");

    private static final Identifier SHIPWRECK_TREASURE_ID =
            new Identifier("minecraft","chests/shipwreck_treasure");

    private static final Identifier BURIED_TREASURE_ID =
            new Identifier("minecraft","chests/buried_treasure");

    private static final Identifier RUINED_PORTAL_ID =
            new Identifier("minecraft","chests/ruined_portal");

public static void modifyLootTables() {
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if(ZOMBIE_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(2))
                        .conditionally(RandomChanceLootCondition.builder(0.35f)) // 1 = Dropa 100% das vezes
                        .with(ItemEntry.builder(ModItems.ELF_EAR))
                        .with(ItemEntry.builder(ModItems.GOBLIN_EYE))
                        .with(ItemEntry.builder(ModItems.HUMAN_TOOTH))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());
}
            if(DROWNED_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(2))
                        .conditionally(RandomChanceLootCondition.builder(0.45f))
                        .with(ItemEntry.builder(ModItems.ELF_EAR))
                        .with(ItemEntry.builder(ModItems.GOBLIN_EYE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }
            if(HUSK_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(2))
                        .conditionally(RandomChanceLootCondition.builder(0.25f))
                        .with(ItemEntry.builder(ModItems.HUMAN_TOOTH))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }

            if(ZOMBIFIED_PIGLIN_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(3))
                        .conditionally(RandomChanceLootCondition.builder(0.45f))
                        .with(ItemEntry.builder(ModItems.ELF_EAR))
                        .with(ItemEntry.builder(ModItems.GOBLIN_EYE))
                        .with(ItemEntry.builder(ModItems.DEVIL_HORN))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }
            if(PIGLIN_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(2))
                        .conditionally(RandomChanceLootCondition.builder(0.45f))
                        .with(ItemEntry.builder(ModItems.ELF_EAR))
                        .with(ItemEntry.builder(ModItems.GOBLIN_EYE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }
            if(PIGLIN_BRUTE_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(2))
                        .conditionally(RandomChanceLootCondition.builder(0.55f))
                        .with(ItemEntry.builder(ModItems.ELF_EAR))
                        .with(ItemEntry.builder(ModItems.GOBLIN_EYE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }
            if(SKELETON_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(2))
                        .conditionally(RandomChanceLootCondition.builder(0.35f))
                        .with(ItemEntry.builder(ModItems.HUMAN_TOOTH))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }
            if(STRAY_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(3))
                        .conditionally(RandomChanceLootCondition.builder(0.45f))
                        .with(ItemEntry.builder(ModItems.HUMAN_TOOTH))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }
            if(WITHER_SKELETON_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(3))
                        .conditionally(RandomChanceLootCondition.builder(0.25f))
                        .with(ItemEntry.builder(ModItems.DEVIL_HORN))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }
            if(WITHER_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(6))
                        .conditionally(RandomChanceLootCondition.builder(0.45f))
                        .with(ItemEntry.builder(ModItems.DEVIL_HORN))
                        .with(ItemEntry.builder(ModItems.ESSENCE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }
            if(ENDERMAN_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(2))
                        .conditionally(RandomChanceLootCondition.builder(0.5f))
                        .with(ItemEntry.builder(ModItems.ELF_EAR))
                        .with(ItemEntry.builder(ModItems.DEVIL_HORN))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }
            if(ENDER_DRAGON_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(8))
                        .conditionally(RandomChanceLootCondition.builder(0.7f))
                        .with(ItemEntry.builder(ModItems.DEVIL_HORN))
                        .with(ItemEntry.builder(ModItems.ESSENCE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }
            if(ZOMBIE_VILLAGER_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(2))
                        .conditionally(RandomChanceLootCondition.builder(0.45f))
                        .with(ItemEntry.builder(ModItems.HUMAN_TOOTH))
                        .with(ItemEntry.builder(ModItems.GOBLIN_EYE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }
            if(VILLAGER_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.25f))
                        .with(ItemEntry.builder(ModItems.HUMAN_TOOTH))
                        .with(ItemEntry.builder(ModItems.GOBLIN_EYE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }
            if(PILLAGER_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.25f))
                        .with(ItemEntry.builder(ModItems.HUMAN_TOOTH))
                        .with(ItemEntry.builder(ModItems.ELF_EAR))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }
            if(EVOKER_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(2))
                        .conditionally(RandomChanceLootCondition.builder(0.35f))
                        .with(ItemEntry.builder(ModItems.HUMAN_TOOTH))
                        .with(ItemEntry.builder(ModItems.ELF_EAR))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }
            if(VINDICATOR_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(2))
                        .conditionally(RandomChanceLootCondition.builder(0.45f))
                        .with(ItemEntry.builder(ModItems.HUMAN_TOOTH))
                        .with(ItemEntry.builder(ModItems.ELF_EAR))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }
            if(WITCH_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(3))
                        .conditionally(RandomChanceLootCondition.builder(0.65f))
                        .with(ItemEntry.builder(ModItems.HUMAN_TOOTH))
                        .with(ItemEntry.builder(ModItems.ELF_EAR))
                        .with(ItemEntry.builder(ModItems.GOBLIN_EYE))
                        .with(ItemEntry.builder(ModItems.DEVIL_HORN))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }
            if(RAVAGER_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(4))
                        .conditionally(RandomChanceLootCondition.builder(0.5f))
                        .with(ItemEntry.builder(ModItems.HUMAN_TOOTH))
                        .with(ItemEntry.builder(ModItems.ELF_EAR))
                        .with(ItemEntry.builder(ModItems.DEVIL_HORN))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }
            if(WARDEN_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(7))
                        .conditionally(RandomChanceLootCondition.builder(0.55f))
                        .with(ItemEntry.builder(ModItems.HUMAN_TOOTH))
                        .with(ItemEntry.builder(ModItems.ESSENCE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }
            if(FROG_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.05f))
                        .with(ItemEntry.builder(ModItems.FROG))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }
            if(WANDERING_TRADER_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(2))
                        .conditionally(RandomChanceLootCondition.builder(0.15f))
                        .with(ItemEntry.builder(ModItems.HUMAN_TOOTH))
                        .with(ItemEntry.builder(ModItems.GOBLIN_EYE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }
            if(ANCIENT_CITY_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(6))
                        .conditionally(RandomChanceLootCondition.builder(1f))
                        .with(ItemEntry.builder(ModItems.ESSENCE))
                        .with(ItemEntry.builder(ModItems.DEVIL_HORN))
                        .with(ItemEntry.builder(ModItems.HUMAN_TOOTH))
                        .with(ItemEntry.builder(ModItems.GOBLIN_EYE))
                        .with(ItemEntry.builder(ModItems.ELF_EAR))
                        .with(ItemEntry.builder(ModItems.CATALYST_EMPTY))
                        .with(ItemEntry.builder(ModItems.CANNONBALL))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }
            if(ANCIENT_CITY_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.08f))
                        .with(ItemEntry.builder(ModItems.GRIMOIRE))
                        .with(ItemEntry.builder(ModItems.QUARTERSTAFF))
                        .with(ItemEntry.builder(ModItems.CLAWS))
                        .with(ItemEntry.builder(ModItems.ODIN_DAGGER))
                        .with(ItemEntry.builder(ModItems.OLD_GRIMOIRE))
                        .with(ItemEntry.builder(ModItems.ARTORIAS_DESPAIR))
                        .with(ItemEntry.builder(ModItems.SAW_EATER))
                        .with(ItemEntry.builder(ModItems.ASGORE_GRIMOIRE))
                        .with(ItemEntry.builder(ModItems.NOVUS_GRIMOIRE))
                        .with(ItemEntry.builder(ModItems.PALLIS_SHIELD))
                        .with(ItemEntry.builder(ModItems.SYLVERIA_STAFF))
                        .with(ItemEntry.builder(ModItems.CARSON_CANNON))
                        .with(ItemEntry.builder(ModItems.ZORA_BOW))
                        .with(ItemEntry.builder(ModItems.EDEN_APPLE))
                        .with(ItemEntry.builder(ModItems.LADON_DRAGON_GLAIVE))
                        .with(ItemEntry.builder(ModItems.ERAK_BATTLEAXE))
                        .with(ItemEntry.builder(ModItems.BELAIOS_WAND))
                        .with(ItemEntry.builder(ModItems.GAUNTLET))
                        .with(ItemEntry.builder(ModItems.NORR_FORR_HAMMER))
                        .with(ItemEntry.builder(ModItems.CHALI_II_LANCE))
                        .with(ItemEntry.builder(ModItems.DELS))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }
            if(ANCIENT_CITY_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.3f))
                        .with(ItemEntry.builder(ModItems.ECLIPSE_BEGINS_MUSIC_DISC))
                        .with(ItemEntry.builder(ModItems.VOX))
                        .with(ItemEntry.builder(ModItems.TICKET_DELUXE_ARCANUMRAILS))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }
            if(ANCIENT_CITY_ICE_BOX_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.10f))
                        .with(ItemEntry.builder(ModItems.CLAWS))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }
            if(ABANDONED_MINESHAFT_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(3))
                        .conditionally(RandomChanceLootCondition.builder(0.9f))
                        .with(ItemEntry.builder(ModItems.HUMAN_TOOTH))
                        .with(ItemEntry.builder(ModItems.GOBLIN_EYE))
                        .with(ItemEntry.builder(ModItems.ELF_EAR))
                        .with(ItemEntry.builder(ModItems.BEAN))
                        .with(ItemEntry.builder(ModItems.VOX))
                        .with(ItemEntry.builder(ModItems.CATALYST_EMPTY))
                        .with(ItemEntry.builder(ModItems.TICKET_ARCANUMRAILS))
                        .with(ItemEntry.builder(ModItems.CANNONBALL))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }
            if(ABANDONED_MINESHAFT_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.01f))
                        .with(ItemEntry.builder(ModItems.BEANS_SACK))
                        .with(ItemEntry.builder(ModItems.QRAZ_STAFF))
                        .with(ItemEntry.builder(ModItems.DIEGO_RAPIER))
                        .with(ItemEntry.builder(ModItems.HILDA_SICKLE))
                        .with(ItemEntry.builder(ModItems.OLD_GRIMOIRE))
                        .with(ItemEntry.builder(ModItems.HELENA_BASEBALL_BAT))
                        .with(ItemEntry.builder(ModItems.CARSON_CANNON))
                        .with(ItemEntry.builder(ModItems.ZORA_BOW))
                        .with(ItemEntry.builder(ModItems.LADON_DRAGON_GLAIVE))
                        .with(ItemEntry.builder(ModItems.ERAK_BATTLEAXE))
                        .with(ItemEntry.builder(ModItems.BELAIOS_WAND))
                        .with(ItemEntry.builder(ModItems.NORR_FORR_HAMMER))
                        .with(ItemEntry.builder(ModItems.CHALI_II_LANCE))
                        .with(ItemEntry.builder(ModItems.ESSENCE_PAXEL))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }
            if(BASTION_TREASURE_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(3))
                        .conditionally(RandomChanceLootCondition.builder(1f))
                        .with(ItemEntry.builder(ModItems.DEVIL_HORN))
                        .with(ItemEntry.builder(ModItems.GOBLIN_EYE))
                        .with(ItemEntry.builder(ModItems.ELF_EAR))
                        .with(ItemEntry.builder(ModItems.CATALYST_EMPTY))
                        .with(ItemEntry.builder(ModItems.TICKET_DELUXE_ARCANUMRAILS))
                        .with(ItemEntry.builder(ModItems.CANNONBALL))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }
            if(BASTION_TREASURE_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.03f))
                        .with(ItemEntry.builder(ModItems.AKIRA_KATANA))
                        .with(ItemEntry.builder(ModItems.GRIMOIRE))
                        .with(ItemEntry.builder(ModItems.QUARTERSTAFF))
                        .with(ItemEntry.builder(ModItems.CATALYST))
                        .with(ItemEntry.builder(ModItems.PALLIS_SHIELD))
                        .with(ItemEntry.builder(ModItems.REUS_WALKING_CANE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }
            if(RUINED_PORTAL_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.01f))
                        .with(ItemEntry.builder(ModItems.AKIRA_KATANA))
                        .with(ItemEntry.builder(ModItems.GRIMOIRE))
                        .with(ItemEntry.builder(ModItems.QUARTERSTAFF))
                        .with(ItemEntry.builder(ModItems.CATALYST))
                        .with(ItemEntry.builder(ModItems.PALLIS_SHIELD))
                        .with(ItemEntry.builder(ModItems.REUS_WALKING_CANE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }
            if(DESERT_PYRAMID_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(2))
                        .conditionally(RandomChanceLootCondition.builder(0.8f))
                        .with(ItemEntry.builder(ModItems.DEVIL_HORN))
                        .with(ItemEntry.builder(ModItems.HUMAN_TOOTH))
                        .with(ItemEntry.builder(ModItems.GOBLIN_EYE))
                        .with(ItemEntry.builder(ModItems.ELF_EAR))
                        .with(ItemEntry.builder(ModItems.BEAN))
                        .with(ItemEntry.builder(ModItems.VOX))
                        .with(ItemEntry.builder(ModItems.CATALYST_EMPTY))
                        .with(ItemEntry.builder(ModItems.TICKET_ARCANUMRAILS))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }
            if(DESERT_PYRAMID_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.01f))
                        .with(ItemEntry.builder(ModItems.BEANS_SACK))
                        .with(ItemEntry.builder(ModItems.QRAZ_STAFF))
                        .with(ItemEntry.builder(ModItems.PALLIS_SHIELD))
                        .with(ItemEntry.builder(ModItems.CARSON_CANNON))
                        .with(ItemEntry.builder(ModItems.BELAIOS_WAND))
                        .with(ItemEntry.builder(ModItems.GAUNTLET))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }
            if(END_CITY_TREASURE_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(2))
                        .conditionally(RandomChanceLootCondition.builder(1f))
                        .with(ItemEntry.builder(ModItems.DEVIL_HORN))
                        .with(ItemEntry.builder(ModItems.HUMAN_TOOTH))
                        .with(ItemEntry.builder(ModItems.CATALYST))
                        .with(ItemEntry.builder(ModItems.TICKET_DELUXE_ARCANUMRAILS))
                        .with(ItemEntry.builder(ModItems.CANNONBALL))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }
            if(END_CITY_TREASURE_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.12f))
                        .with(ItemEntry.builder(ModItems.GRIMOIRE))
                        .with(ItemEntry.builder(ModItems.ASGORE_GRIMOIRE))
                        .with(ItemEntry.builder(ModItems.OLD_GRIMOIRE))
                        .with(ItemEntry.builder(ModItems.ODIN_DAGGER))
                        .with(ItemEntry.builder(ModItems.PALLIS_SHIELD))
                        .with(ItemEntry.builder(ModItems.QUARTERSTAFF))
                        .with(ItemEntry.builder(ModItems.HELENA_BASEBALL_BAT))
                        .with(ItemEntry.builder(ModItems.ARTORIAS_DESPAIR))
                        .with(ItemEntry.builder(ModItems.SAW_EATER))
                        .with(ItemEntry.builder(ModItems.AKIRA_KATANA))
                        .with(ItemEntry.builder(ModItems.BEANS_SACK))
                        .with(ItemEntry.builder(ModItems.DIEGO_RAPIER))
                        .with(ItemEntry.builder(ModItems.HILDA_SICKLE))
                        .with(ItemEntry.builder(ModItems.FROG))
                        .with(ItemEntry.builder(ModItems.CLAWS))
                        .with(ItemEntry.builder(ModItems.CATALYST))
                        .with(ItemEntry.builder(ModItems.SAI))
                        .with(ItemEntry.builder(ModItems.QRAZ_STAFF))
                        .with(ItemEntry.builder(ModItems.VEIGAR_STAFF))
                        .with(ItemEntry.builder(ModItems.SYLVERIA_STAFF))
                        .with(ItemEntry.builder(ModItems.NOVUS_GRIMOIRE))
                        .with(ItemEntry.builder(ModItems.CARSON_CANNON))
                        .with(ItemEntry.builder(ModItems.ZORA_BOW))
                        .with(ItemEntry.builder(ModItems.LADON_DRAGON_GLAIVE))
                        .with(ItemEntry.builder(ModItems.ERAK_BATTLEAXE))
                        .with(ItemEntry.builder(ModItems.BELAIOS_WAND))
                        .with(ItemEntry.builder(ModItems.GAUNTLET))
                        .with(ItemEntry.builder(ModItems.NORR_FORR_HAMMER))
                        .with(ItemEntry.builder(ModItems.CHALI_II_LANCE))
                        .with(ItemEntry.builder(ModItems.AGATHA_BONESAW))
                        .with(ItemEntry.builder(ModItems.REUS_WALKING_CANE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }
            if(JUNGLE_TEMPLE_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(3))
                        .conditionally(RandomChanceLootCondition.builder(1f))
                        .with(ItemEntry.builder(ModItems.GOBLIN_EYE))
                        .with(ItemEntry.builder(ModItems.HUMAN_TOOTH))
                        .with(ItemEntry.builder(ModItems.BEAN))
                        .with(ItemEntry.builder(ModItems.CATALYST_EMPTY))
                        .with(ItemEntry.builder(ModItems.TICKET_DELUXE_ARCANUMRAILS))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }
            if(JUNGLE_TEMPLE_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.04f))
                        .with(ItemEntry.builder(ModItems.BEANS_SACK))
                        .with(ItemEntry.builder(ModItems.QRAZ_STAFF))
                        .with(ItemEntry.builder(ModItems.SYLVERIA_STAFF))
                        .with(ItemEntry.builder(ModItems.OLD_GRIMOIRE))
                        .with(ItemEntry.builder(ModItems.ZORA_BOW))
                        .with(ItemEntry.builder(ModItems.BELAIOS_WAND))
                        .with(ItemEntry.builder(ModItems.GAUNTLET))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }
            if(PILLAGER_OUTPOST_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(2))
                        .conditionally(RandomChanceLootCondition.builder(0.7f))
                        .with(ItemEntry.builder(ModItems.GOBLIN_EYE))
                        .with(ItemEntry.builder(ModItems.HUMAN_TOOTH))
                        .with(ItemEntry.builder(ModItems.ELF_EAR))
                        .with(ItemEntry.builder(ModItems.CATALYST_EMPTY))
                        .with(ItemEntry.builder(ModItems.TICKET_ARCANUMRAILS))
                        .with(ItemEntry.builder(ModItems.VOX))
                        .with(ItemEntry.builder(ModItems.CANNONBALL))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }
            if(PILLAGER_OUTPOST_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.02f))
                        .with(ItemEntry.builder(ModItems.ARTORIAS_DESPAIR))
                        .with(ItemEntry.builder(ModItems.SAW_EATER))
                        .with(ItemEntry.builder(ModItems.HELENA_BASEBALL_BAT))
                        .with(ItemEntry.builder(ModItems.AKIRA_KATANA))
                        .with(ItemEntry.builder(ModItems.DIEGO_RAPIER))
                        .with(ItemEntry.builder(ModItems.OLD_GRIMOIRE))
                        .with(ItemEntry.builder(ModItems.NOVUS_GRIMOIRE))
                        .with(ItemEntry.builder(ModItems.CLAWS))
                        .with(ItemEntry.builder(ModItems.PALLIS_SHIELD))
                        .with(ItemEntry.builder(ModItems.SYLVERIA_STAFF))
                        .with(ItemEntry.builder(ModItems.VEIGAR_STAFF))
                        .with(ItemEntry.builder(ModItems.SAI))
                        .with(ItemEntry.builder(ModItems.LADON_DRAGON_GLAIVE))
                        .with(ItemEntry.builder(ModItems.GAUNTLET))
                        .with(ItemEntry.builder(ModItems.NORR_FORR_HAMMER))
                        .with(ItemEntry.builder(ModItems.CHALI_II_LANCE))
                        .with(ItemEntry.builder(ModItems.DELS))
                        .with(ItemEntry.builder(ModItems.REUS_WALKING_CANE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }
            if(IGLOO_CHEST_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(4))
                        .conditionally(RandomChanceLootCondition.builder(0.5f))
                        .with(ItemEntry.builder(ModItems.GOBLIN_EYE))
                        .with(ItemEntry.builder(ModItems.HUMAN_TOOTH))
                        .with(ItemEntry.builder(ModItems.CATALYST_EMPTY))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }
            if(IGLOO_CHEST_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.04f))
                        .with(ItemEntry.builder(ModItems.CLAWS))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }
            if(SIMPLE_DUNGEON_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(6))
                        .conditionally(RandomChanceLootCondition.builder(0.75f))
                        .with(ItemEntry.builder(ModItems.GOBLIN_EYE))
                        .with(ItemEntry.builder(ModItems.ELF_EAR))
                        .with(ItemEntry.builder(ModItems.HUMAN_TOOTH))
                        .with(ItemEntry.builder(ModItems.DEVIL_HORN))
                        .with(ItemEntry.builder(ModItems.CATALYST_EMPTY))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }
            if(SIMPLE_DUNGEON_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.03f))
                        .with(ItemEntry.builder(ModItems.GRIMOIRE))
                        .with(ItemEntry.builder(ModItems.ASGORE_GRIMOIRE))
                        .with(ItemEntry.builder(ModItems.OLD_GRIMOIRE))
                        .with(ItemEntry.builder(ModItems.NOVUS_GRIMOIRE))
                        .with(ItemEntry.builder(ModItems.QUARTERSTAFF))
                        .with(ItemEntry.builder(ModItems.HILDA_SICKLE))
                        .with(ItemEntry.builder(ModItems.FROG))
                        .with(ItemEntry.builder(ModItems.VEIGAR_STAFF))
                        .with(ItemEntry.builder(ModItems.SYLVERIA_STAFF))
                        .with(ItemEntry.builder(ModItems.ZORA_BOW))
                        .with(ItemEntry.builder(ModItems.BELAIOS_WAND))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }
            if(WOODLAND_MANSION_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(6))
                        .conditionally(RandomChanceLootCondition.builder(0.8f))
                        .with(ItemEntry.builder(ModItems.GOBLIN_EYE))
                        .with(ItemEntry.builder(ModItems.HUMAN_TOOTH))
                        .with(ItemEntry.builder(ModItems.DEVIL_HORN))
                        .with(ItemEntry.builder(ModItems.CATALYST_EMPTY))
                        .with(ItemEntry.builder(ModItems.TICKET_DELUXE_ARCANUMRAILS))
                        .with(ItemEntry.builder(ModItems.TICKET_ARCANUMRAILS))
                        .with(ItemEntry.builder(ModItems.CANNONBALL))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }
            if(WOODLAND_MANSION_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.04f))
                        .with(ItemEntry.builder(ModItems.ARTORIAS_DESPAIR))
                        .with(ItemEntry.builder(ModItems.SAW_EATER))
                        .with(ItemEntry.builder(ModItems.HELENA_BASEBALL_BAT))
                        .with(ItemEntry.builder(ModItems.AKIRA_KATANA))
                        .with(ItemEntry.builder(ModItems.DIEGO_RAPIER))
                        .with(ItemEntry.builder(ModItems.OLD_GRIMOIRE))
                        .with(ItemEntry.builder(ModItems.SYLVERIA_STAFF))
                        .with(ItemEntry.builder(ModItems.NOVUS_GRIMOIRE))
                        .with(ItemEntry.builder(ModItems.CLAWS))
                        .with(ItemEntry.builder(ModItems.PALLIS_SHIELD))
                        .with(ItemEntry.builder(ModItems.VEIGAR_STAFF))
                        .with(ItemEntry.builder(ModItems.NORR_FORR_HAMMER))
                        .with(ItemEntry.builder(ModItems.CHALI_II_LANCE))
                        .with(ItemEntry.builder(ModItems.DELS))
                        .with(ItemEntry.builder(ModItems.REUS_WALKING_CANE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }
            if(STRONGHOLD_LIBRARY_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(7))
                        .conditionally(RandomChanceLootCondition.builder(0.9f))
                        .with(ItemEntry.builder(ModItems.GOBLIN_EYE))
                        .with(ItemEntry.builder(ModItems.HUMAN_TOOTH))
                        .with(ItemEntry.builder(ModItems.DEVIL_HORN))
                        .with(ItemEntry.builder(ModItems.CATALYST_EMPTY))
                        .with(ItemEntry.builder(ModItems.TICKET_DELUXE_ARCANUMRAILS))
                        .with(ItemEntry.builder(ModItems.TICKET_ARCANUMRAILS))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }
            if(STRONGHOLD_LIBRARY_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.05f))
                        .with(ItemEntry.builder(ModItems.ODIN_DAGGER))
                        .with(ItemEntry.builder(ModItems.PALLIS_SHIELD))
                        .with(ItemEntry.builder(ModItems.QUARTERSTAFF))
                        .with(ItemEntry.builder(ModItems.HELENA_BASEBALL_BAT))
                        .with(ItemEntry.builder(ModItems.ARTORIAS_DESPAIR))
                        .with(ItemEntry.builder(ModItems.SAW_EATER))
                        .with(ItemEntry.builder(ModItems.AKIRA_KATANA))
                        .with(ItemEntry.builder(ModItems.DIEGO_RAPIER))
                        .with(ItemEntry.builder(ModItems.HILDA_SICKLE))
                        .with(ItemEntry.builder(ModItems.CLAWS))
                        .with(ItemEntry.builder(ModItems.FROG))
                        .with(ItemEntry.builder(ModItems.QRAZ_STAFF))
                        .with(ItemEntry.builder(ModItems.GRIMOIRE))
                        .with(ItemEntry.builder(ModItems.ASGORE_GRIMOIRE))
                        .with(ItemEntry.builder(ModItems.NOVUS_GRIMOIRE))
                        .with(ItemEntry.builder(ModItems.OLD_GRIMOIRE))
                        .with(ItemEntry.builder(ModItems.LADON_DRAGON_GLAIVE))
                        .with(ItemEntry.builder(ModItems.CHALI_II_LANCE))
                        .with(ItemEntry.builder(ModItems.REUS_WALKING_CANE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }
            if(UNDERWATER_RUIN_BIG_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(3))
                        .conditionally(RandomChanceLootCondition.builder(0.75f))
                        .with(ItemEntry.builder(ModItems.GOBLIN_EYE))
                        .with(ItemEntry.builder(ModItems.HUMAN_TOOTH))
                        .with(ItemEntry.builder(ModItems.BEAN))
                        .with(ItemEntry.builder(ModItems.CATALYST_EMPTY))
                        .with(ItemEntry.builder(ModItems.CANNONBALL))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }
            if(UNDERWATER_RUIN_BIG_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.04f))
                        .with(ItemEntry.builder(ModItems.FROG))
                        .with(ItemEntry.builder(ModItems.BEANS_SACK))
                        .with(ItemEntry.builder(ModItems.SAI))
                        .with(ItemEntry.builder(ModItems.VEIGAR_STAFF))
                        .with(ItemEntry.builder(ModItems.QRAZ_STAFF))
                        .with(ItemEntry.builder(ModItems.CLAWS))
                        .with(ItemEntry.builder(ModItems.ERAK_BATTLEAXE))
                        .with(ItemEntry.builder(ModItems.AGATHA_BONESAW))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }
            if(UNDERWATER_RUIN_SMALL_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(3))
                        .conditionally(RandomChanceLootCondition.builder(0.65f))
                        .with(ItemEntry.builder(ModItems.GOBLIN_EYE))
                        .with(ItemEntry.builder(ModItems.HUMAN_TOOTH))
                        .with(ItemEntry.builder(ModItems.BEAN))
                        .with(ItemEntry.builder(ModItems.CATALYST_EMPTY))
                        .with(ItemEntry.builder(ModItems.CANNONBALL))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }
            if(UNDERWATER_RUIN_SMALL_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.03f))
                        .with(ItemEntry.builder(ModItems.FROG))
                        .with(ItemEntry.builder(ModItems.BEANS_SACK))
                        .with(ItemEntry.builder(ModItems.SAI))
                        .with(ItemEntry.builder(ModItems.VEIGAR_STAFF))
                        .with(ItemEntry.builder(ModItems.QRAZ_STAFF))
                        .with(ItemEntry.builder(ModItems.CLAWS))
                        .with(ItemEntry.builder(ModItems.ERAK_BATTLEAXE))
                        .with(ItemEntry.builder(ModItems.AGATHA_BONESAW))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }
            if(SHIPWRECK_TREASURE_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(2))
                        .conditionally(RandomChanceLootCondition.builder(0.25f))
                        .with(ItemEntry.builder(ModItems.TICKET_DELUXE_ARCANUMRAILS))
                        .with(ItemEntry.builder(ModItems.EDEN_APPLE))
                        .with(ItemEntry.builder(ModItems.BEAN))
                        .with(ItemEntry.builder(ModItems.CATALYST_EMPTY))
                        .with(ItemEntry.builder(ModItems.CANNONBALL))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }
            if(SHIPWRECK_TREASURE_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.05f))
                        .with(ItemEntry.builder(ModItems.FROG))
                        .with(ItemEntry.builder(ModItems.BEANS_SACK))
                        .with(ItemEntry.builder(ModItems.SAI))
                        .with(ItemEntry.builder(ModItems.VEIGAR_STAFF))
                        .with(ItemEntry.builder(ModItems.QRAZ_STAFF))
                        .with(ItemEntry.builder(ModItems.CLAWS))
                        .with(ItemEntry.builder(ModItems.ERAK_BATTLEAXE))
                        .with(ItemEntry.builder(ModItems.AGATHA_BONESAW))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }
            if(BURIED_TREASURE_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.35f))
                        .with(ItemEntry.builder(ModItems.TICKET_DELUXE_ARCANUMRAILS))
                        .with(ItemEntry.builder(ModItems.EDEN_TREE_APPLE))
                        .with(ItemEntry.builder(ModItems.CANNONBALL))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }
            if(BURIED_TREASURE_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.06f))
                        .with(ItemEntry.builder(ModItems.FROG))
                        .with(ItemEntry.builder(ModItems.BEANS_SACK))
                        .with(ItemEntry.builder(ModItems.SAI))
                        .with(ItemEntry.builder(ModItems.VEIGAR_STAFF))
                        .with(ItemEntry.builder(ModItems.QRAZ_STAFF))
                        .with(ItemEntry.builder(ModItems.CLAWS))
                        .with(ItemEntry.builder(ModItems.ERAK_BATTLEAXE))
                        .with(ItemEntry.builder(ModItems.BELAIOS_WAND))
                        .with(ItemEntry.builder(ModItems.AGATHA_BONESAW))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }
            //Separada para não tirar chance dos outros
            if(BURIED_TREASURE_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.03f))
                        .with(ItemEntry.builder(ModBlocks.SAMARA_PLUSHIE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }
        });
    LootTableEvents.REPLACE.register((resourceManager, lootManager, id, original, source) -> {
        if(SUSPICIOUS_SAND_ID.equals(id)) {
            List<LootPoolEntry> entries = new ArrayList<>(Arrays.asList(original.pools[0].entries));
            entries.add(ItemEntry.builder(ModItems.VOX).build());
            entries.add(ItemEntry.builder(ModItems.CONTRACT).conditionally(RandomChanceLootCondition.builder(0.01f)).build());
            entries.add(ItemEntry.builder(ModItems.TICKET_DELUXE_ARCANUMRAILS).build());

            LootPool.Builder pool = LootPool.builder().with(entries);
            return LootTable.builder().pool(pool).build();
        }
        if(SNIFFER_DIGGING_ID.equals(id)) {
            List<LootPoolEntry> entries = new ArrayList<>(Arrays.asList(original.pools[0].entries));
            entries.add(ItemEntry.builder(ModBlocks.BROMELIAD).build());

            LootPool.Builder pool = LootPool.builder().with(entries);
            return LootTable.builder().pool(pool).build();
        }
        if(FISH_ID.equals(id)) {
            List<LootPoolEntry> entries = new ArrayList<>(Arrays.asList(original.pools[0].entries));
            entries.add(ItemEntry.builder(ModItems.TILAPIA).weight(35).build());

            LootPool.Builder pool = LootPool.builder().with(entries);
            return LootTable.builder().pool(pool).build();
        }
        if(TREASURE_ID.equals(id)) {
            List<LootPoolEntry> entries = new ArrayList<>(Arrays.asList(original.pools[0].entries));
            entries.add(ItemEntry.builder(ModItems.FROG).conditionally(RandomChanceLootCondition.builder(0.05f)).build());
            entries.add(ItemEntry.builder(ModItems.BEANS_SACK).conditionally(RandomChanceLootCondition.builder(0.05f)).build());
            entries.add(ItemEntry.builder(ModItems.AGATHA_BONESAW).conditionally(RandomChanceLootCondition.builder(0.05f)).build());
            entries.add(ItemEntry.builder(ModItems.ESSENCE).conditionally(RandomChanceLootCondition.builder(0.05f)).build());
            entries.add(ItemEntry.builder(ModItems.CATALYST_EMPTY).conditionally(RandomChanceLootCondition.builder(0.05f)).build());
            entries.add(ItemEntry.builder(ModItems.TICKET_DELUXE_ARCANUMRAILS).conditionally(RandomChanceLootCondition.builder(0.05f)).build());

            LootPool.Builder pool = LootPool.builder().with(entries);
            return LootTable.builder().pool(pool).build();
        }
        if(JUNK_ID.equals(id)) {
            List<LootPoolEntry> entries = new ArrayList<>(Arrays.asList(original.pools[0].entries));
            entries.add(ItemEntry.builder(ModItems.HUMAN_TOOTH).conditionally(RandomChanceLootCondition.builder(0.15f)).build());
            entries.add(ItemEntry.builder(ModItems.DEVIL_HORN).conditionally(RandomChanceLootCondition.builder(0.15f)).build());
            entries.add(ItemEntry.builder(ModItems.VOX).conditionally(RandomChanceLootCondition.builder(0.15f)).build());
            entries.add(ItemEntry.builder(ModItems.TICKET_ARCANUMRAILS).conditionally(RandomChanceLootCondition.builder(0.15f)).build());
            entries.add(ItemEntry.builder(ModItems.BEAN).conditionally(RandomChanceLootCondition.builder(0.15f)).build());

            LootPool.Builder pool = LootPool.builder().with(entries);
            return LootTable.builder().pool(pool).build();
        }
        return null;
    });
    }
}
