package net.jubs.eclipse_do_caos.util;

import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.jubs.eclipse_do_caos.blocks.ModBlocks;
import net.jubs.eclipse_do_caos.items.ModItems;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.VillagerProfession;

public class ModCustomTrades {
    public static void registerCustomTrades() {
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.FISHERMAN, 1,
        factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    //Item que você paga (dá para adicionar mais 1 item, assim você precisaria dos dois para fazer a troca)
                    new ItemStack(Items.EMERALD, 2),
                    //Compra abaixo
                    new ItemStack(ModItems.TILAPIA, 4),
                    7, 4, 0.10f));
                    //Para adicionar mais trocas por nível, copiar o factories.add até a parte do max uses, etc...
        });
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.FISHERMAN, 2,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 6),
                            //Compra abaixo
                            new ItemStack(ModItems.FRIED_TILAPIA, 8),
                            6, 4, 0.2f));

                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(ModItems.FRIED_TILAPIA, 2),
                            //Compra abaixo
                            new ItemStack(Items.EMERALD, 3),
                            6, 4, 0.2f));

                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 16),
                            //Compra abaixo
                            new ItemStack(ModItems.SUSHI_TILAPIA, 4),
                            3, 6, 0.8f));

                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(ModItems.SUSHI_TILAPIA, 6),
                            //Compra abaixo
                            new ItemStack(Items.EMERALD, 14),
                            4, 4, 0.4f));

                });
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.FARMER, 1,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 2),
                            //Compra abaixo
                            new ItemStack(ModItems.BEAN, 6),
                            8, 2, 0.15f));

                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(ModItems.BEAN, 28),
                            //Compra abaixo
                            new ItemStack(Items.EMERALD, 1),
                            6, 3, 0.3f));

                });
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.FARMER, 2,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 10),
                            //Compra abaixo
                            new ItemStack(ModItems.COOKED_BEAN, 3),
                            4, 3, 0.35f));

                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(ModItems.COOKED_BEAN, 14),
                            //Compra abaixo
                            new ItemStack(Items.EMERALD, 4),
                            4, 3, 0.4f));

                });
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.TOOLSMITH, 2,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 20),
                            //Compra abaixo
                            new ItemStack(ModItems.CANNONBALL, 8),
                            4, 3, 0.55f));

                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(ModItems.CANNONBALL, 8),
                            new ItemStack(Items.IRON_INGOT, 4),
                            //Compra abaixo
                            new ItemStack(Items.EMERALD, 16),
                            3, 5, 0.8f));

                });
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.CARTOGRAPHER, 1,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.COPPER_INGOT, 3),
                            //Compra abaixo
                            new ItemStack(ModItems.VOX, 1),
                            5, 2, 0.10f));

                });
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.CARTOGRAPHER, 2,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.GOLD_NUGGET, 2),
                            new ItemStack(Items.IRON_NUGGET, 40),
                            //Compra abaixo
                            new ItemStack(ModItems.TICKET_ARCANUMRAILS, 1),
                            6, 2, 0.40f));

                });
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.CARTOGRAPHER, 3,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.GOLD_NUGGET, 6),
                            new ItemStack(Items.IRON_NUGGET, 50),
                            //Compra abaixo
                            new ItemStack(ModItems.TICKET_DELUXE_ARCANUMRAILS, 1),
                            4, 4, 0.80f));

                });
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.CARTOGRAPHER, 2,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(ModItems.TICKET_ARCANUMRAILS, 12),
                            //Compra abaixo
                            new ItemStack(Items.EMERALD, 25),
                            4, 4, 0.80f));

                });
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.CARTOGRAPHER, 2,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(ModItems.TICKET_DELUXE_ARCANUMRAILS, 25),
                            //Compra abaixo
                            new ItemStack(Items.NETHERITE_SCRAP, 4),
                            2, 5, 0.90f));

                });
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.CARTOGRAPHER, 3,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(ModItems.TICKET_ARCANUMRAILS, 30),
                            new ItemStack(ModItems.TICKET_DELUXE_ARCANUMRAILS, 20),
                            //Compra abaixo
                            new ItemStack(Items.NETHERITE_INGOT, 2),
                            2, 6, 1.0f));

                });
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.CARTOGRAPHER, 3,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(ModItems.TICKET_ARCANUMRAILS, 35),
                            new ItemStack(ModItems.TICKET_DELUXE_ARCANUMRAILS, 30),
                            //Compra abaixo
                            new ItemStack(ModItems.ESSENCE, 25),
                            2, 7, 1.10f));

                });
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.CLERIC, 2,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 30),
                            //Compra abaixo
                            new ItemStack(ModItems.CATALYST_EMPTY, 4),
                            3, 5, 0.20f));

                });
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.BUTCHER, 3,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 20),
                            new ItemStack(ModItems.ESSENCE, 4),
                            //Compra abaixo
                            new ItemStack(ModItems.ELF_EAR, 6),
                            3, 7, 0.5f));

                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 30),
                            new ItemStack(ModItems.ESSENCE, 6),
                            //Compra abaixo
                            new ItemStack(ModItems.DEVIL_HORN, 8),
                            2, 7, 0.7f));

                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 16),
                            new ItemStack(ModItems.ESSENCE, 3),
                            //Compra abaixo
                            new ItemStack(ModItems.GOBLIN_EYE, 5),
                            5, 3, 0.4f));

                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 14),
                            new ItemStack(ModItems.ESSENCE, 2),
                            //Compra abaixo
                            new ItemStack(ModItems.HUMAN_TOOTH, 5),
                            4, 4, 0.5f));

                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 27),
                            //Compra abaixo
                            new ItemStack(ModBlocks.MEAT_BLOCK, 4),
                            4, 3, 0.7f));

                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 13),
                            //Compra abaixo
                            new ItemStack(ModBlocks.EYE_BLOCK, 6),
                            4, 3, 0.5f));

                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 14),
                            //Compra abaixo
                            new ItemStack(ModBlocks.TEETH_BLOCK, 3),
                            5, 4, 0.65f));

                    //Trocas Invertidas

                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(ModItems.ELF_EAR, 2),
                            //Compra abaixo
                            new ItemStack(Items.EMERALD, 6),
                            3, 7, 0.5f));

                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(ModItems.DEVIL_HORN, 3),
                            //Compra abaixo
                            new ItemStack(Items.EMERALD, 12),
                            2, 7, 0.7f));

                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(ModItems.GOBLIN_EYE, 12),
                            //Compra abaixo
                            new ItemStack(Items.EMERALD, 2),
                            5, 3, 0.4f));

                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(ModItems.HUMAN_TOOTH, 10),
                            //Compra abaixo
                            new ItemStack(Items.EMERALD, 5),
                            4, 4, 0.5f));

                });
        TradeOfferHelper.registerWanderingTraderOffers(1,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 8),
                            //Compra abaixo
                            new ItemStack(ModItems.VOX, 2),
                            6, 2, 0.1f));

        });
        TradeOfferHelper.registerWanderingTraderOffers(2,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 64),
                            //Compra abaixo
                            new ItemStack(ModItems.ESSENCE, 2),
                            2, 8, 0.8f));

                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.GOLD_NUGGET, 5),
                            new ItemStack(Items.IRON_NUGGET, 60),
                            //Compra abaixo
                            new ItemStack(ModItems.TICKET_DELUXE_ARCANUMRAILS, 1),
                            3, 3, 1.2f));

        });
    }
}
