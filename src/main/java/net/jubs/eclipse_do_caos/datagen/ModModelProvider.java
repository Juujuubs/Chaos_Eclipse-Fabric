package net.jubs.eclipse_do_caos.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.jubs.eclipse_do_caos.blocks.ModBlocks;
import net.jubs.eclipse_do_caos.blocks.custom.BeanCropBlock;
import net.jubs.eclipse_do_caos.items.ModItems;
import net.minecraft.data.client.*;
import net.minecraft.data.family.BlockFamilies;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ESSENCE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ESSENCE_ORE_BLOCK);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MEAT_BLOCK);


        blockStateModelGenerator.registerLog(ModBlocks.EDEN_LOG).log(ModBlocks.EDEN_LOG).wood(ModBlocks.EDEN_WOOD);
        blockStateModelGenerator.registerLog(ModBlocks.STRIPPED_EDEN_LOG).log(ModBlocks.STRIPPED_EDEN_LOG).wood(ModBlocks.STRIPPED_EDEN_WOOD);
        BlockStateModelGenerator.BlockTexturePool edenPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.EDEN_PLANKS);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.EDEN_LEAVES);
        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.EDEN_SAPLING, ModBlocks.POTTED_EDEN_SAPLING, BlockStateModelGenerator.TintType.NOT_TINTED);

        edenPool.family(BlockFamilies.register(ModBlocks.EDEN_PLANKS).sign(ModBlocks.EDEN_SIGN, ModBlocks.EDEN_WALL_SIGN).build());
        blockStateModelGenerator.registerHangingSign(ModBlocks.STRIPPED_EDEN_LOG, ModBlocks.EDEN_HANGING_SIGN, ModBlocks.EDEN_HANGING_WALL_SIGN);

        edenPool.stairs(ModBlocks.EDEN_STAIRS);
        edenPool.slab(ModBlocks.EDEN_SLAB);
        edenPool.button(ModBlocks.EDEN_BUTTON);
        edenPool.pressurePlate(ModBlocks.EDEN_PRESSURE_PLATE);
        edenPool.fence(ModBlocks.EDEN_FENCE);
        edenPool.fenceGate(ModBlocks.EDEN_FENCE_GATE);

        blockStateModelGenerator.registerDoor(ModBlocks.EDEN_DOOR);
        blockStateModelGenerator.registerOrientableTrapdoor(ModBlocks.EDEN_TRAPDOOR);


        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.BROMELIAD, ModBlocks.POTTED_BROMELIAD, BlockStateModelGenerator.TintType.NOT_TINTED);


        blockStateModelGenerator.registerCrop(ModBlocks.BEAN_CROP, BeanCropBlock.AGE, 0, 1, 2, 3, 4, 5);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.ESSENCE, Models.GENERATED);
        itemModelGenerator.register(ModItems.CONTRACT, Models.GENERATED);
        itemModelGenerator.register(ModItems.DELS, Models.GENERATED);
        itemModelGenerator.register(ModItems.SYMBOL, Models.GENERATED);
        itemModelGenerator.register(ModItems.VOX, Models.GENERATED);
        itemModelGenerator.register(ModItems.GRIMOIRE, Models.GENERATED);
        itemModelGenerator.register(ModItems.QUARTERSTAFF, Models.HANDHELD);
        itemModelGenerator.register(ModItems.FROG, Models.GENERATED);
        itemModelGenerator.register(ModItems.OLD_GRIMOIRE, Models.GENERATED);
        itemModelGenerator.register(ModItems.CATALYST, Models.GENERATED);
        itemModelGenerator.register(ModItems.CATALYST_EMPTY, Models.GENERATED);
        itemModelGenerator.register(ModItems.TILAPIA, Models.GENERATED);
        itemModelGenerator.register(ModItems.FRIED_TILAPIA, Models.GENERATED);
        itemModelGenerator.register(ModItems.SUSHI_TILAPIA, Models.GENERATED);
        itemModelGenerator.register(ModItems.DEVIL_HORN, Models.GENERATED);
        itemModelGenerator.register(ModItems.GOBLIN_EYE, Models.GENERATED);
        itemModelGenerator.register(ModItems.ELF_EAR, Models.GENERATED);
        itemModelGenerator.register(ModItems.HUMAN_TOOTH, Models.GENERATED);
        itemModelGenerator.register(ModItems.CLAWS, Models.GENERATED);
        itemModelGenerator.register(ModItems.PALLIS_SHIELD, Models.GENERATED);
        itemModelGenerator.register(ModItems.ASGORE_GRIMOIRE, Models.GENERATED);
        itemModelGenerator.register(ModItems.POISON_BOLT, Models.GENERATED);
        itemModelGenerator.register(ModItems.LIGHTNING_STRIKE, Models.GENERATED);
        itemModelGenerator.register(ModItems.TICKET_ARCANUMRAILS, Models.GENERATED);
        itemModelGenerator.register(ModItems.TICKET_DELUXE_ARCANUMRAILS, Models.GENERATED);
        itemModelGenerator.register(ModItems.BEANS_SACK, Models.GENERATED);
        itemModelGenerator.register(ModItems.COOKED_BEAN, Models.GENERATED);
        itemModelGenerator.register(ModItems.ARTORIAS_DESPAIR, Models.HANDHELD);
        itemModelGenerator.register(ModItems.HELENA_BASEBALL_BAT, Models.HANDHELD);
        itemModelGenerator.register(ModItems.HILDA_SCYTHE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.DIEGO_RAPIER, Models.HANDHELD);
        itemModelGenerator.register(ModItems.AKIRA_KATANA, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ODIN_DAGGER, Models.HANDHELD);
        itemModelGenerator.register(ModItems.SAI, Models.HANDHELD);
        itemModelGenerator.register(ModItems.VEIGAR_STAFF, Models.HANDHELD);
        itemModelGenerator.register(ModItems.QRAZ_STAFF, Models.HANDHELD);
        itemModelGenerator.register(ModItems.SYLVERIA_STAFF, Models.HANDHELD);
        itemModelGenerator.register(ModItems.NOVUS_GRIMOIRE, Models.GENERATED);
        itemModelGenerator.register(ModItems.CARSON_CANNON, Models.HANDHELD);
        itemModelGenerator.register(ModItems.CANNONBALL, Models.GENERATED);
        itemModelGenerator.register(ModItems.EDEN_TREE_APPLE, Models.GENERATED);
        itemModelGenerator.register(ModItems.EDEN_APPLE, Models.GENERATED);
        itemModelGenerator.register(ModItems.SAW_EATER, Models.HANDHELD);
        itemModelGenerator.register(ModItems.LADON_DRAGON_GLAIVE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ERAK_BATTLEAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.BELAIOS_WAND, Models.HANDHELD);
        itemModelGenerator.register(ModItems.GAUNTLET, Models.GENERATED);
        itemModelGenerator.register(ModItems.NORR_FORR_HAMMER, Models.HANDHELD);
        itemModelGenerator.register(ModItems.EDEN_CHEST_BOAT, Models.GENERATED);
        itemModelGenerator.register(ModItems.EDEN_BOAT, Models.GENERATED);
        itemModelGenerator.register(ModItems.CHALI_II_LANCE, Models.HANDHELD);


        itemModelGenerator.register(ModItems.ECLIPSE_BEGINS_MUSIC_DISC, Models.GENERATED);
    }
}
