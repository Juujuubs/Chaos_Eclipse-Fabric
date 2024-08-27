package net.jubs.eclipse_do_caos.util;

import net.jubs.eclipse_do_caos.EclipseDoCaos;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> DELS_UNKNOWN_BLOCKS =
                createTag("dels_unknown_blocks");
        public static final TagKey<Block> PAXEL_MINEABLE =
                createTag("paxel/mineable");

        public static final TagKey<Block> SAW_EATER_MINEABLE =
                createTag("saw_eater/mineable");


        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, new Identifier(EclipseDoCaos.MOD_ID, name));
}
    }
    public static class Items {
        public static final TagKey<Item> LOST_WEAPONS =
                createTag("lost_weapons");

        public static final TagKey<Item> GRIMOIRES =
                createTag("grimoires");

        public static final TagKey<Item> STAFFS =
                createTag("staffs");

        public static final TagKey<Item> RANGED_WEAPONS =
                createTag("ranged_weapons");

        public static final TagKey<Item> WANDS =
                createTag("wands");

        public static final TagKey<Item> BOWS =
                createTag("bows");

        public static final TagKey<Item> SHIELDS =
                createTag("shields");

        public static final TagKey<Item> GUNS =
                createTag("guns");


        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, new Identifier(EclipseDoCaos.MOD_ID, name));
            }
        }
}
