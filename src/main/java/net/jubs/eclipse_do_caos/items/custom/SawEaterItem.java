package net.jubs.eclipse_do_caos.items.custom;

import com.google.common.collect.ImmutableMap;
import net.jubs.eclipse_do_caos.blocks.ModBlocks;
import net.jubs.eclipse_do_caos.items.ModToolMaterial;
import net.jubs.eclipse_do_caos.sound.ModSounds;
import net.jubs.eclipse_do_caos.util.ModTags;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.block.*;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.HoneycombItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.SwordItem;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldEvents;
import net.minecraft.world.event.GameEvent;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class SawEaterItem extends SwordItem {
    public SawEaterItem(ModToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }
    protected static final Map<Block, Block> STRIPPED_BLOCKS = new ImmutableMap.Builder<Block, Block>().put(Blocks.OAK_WOOD, Blocks.STRIPPED_OAK_WOOD)
            .put(Blocks.OAK_LOG, Blocks.STRIPPED_OAK_LOG).put(Blocks.DARK_OAK_WOOD, Blocks.STRIPPED_DARK_OAK_WOOD)
            .put(Blocks.DARK_OAK_LOG, Blocks.STRIPPED_DARK_OAK_LOG).put(Blocks.ACACIA_WOOD, Blocks.STRIPPED_ACACIA_WOOD)
            .put(Blocks.ACACIA_LOG, Blocks.STRIPPED_ACACIA_LOG).put(Blocks.CHERRY_WOOD, Blocks.STRIPPED_CHERRY_WOOD)
            .put(Blocks.CHERRY_LOG, Blocks.STRIPPED_CHERRY_LOG).put(Blocks.BIRCH_WOOD, Blocks.STRIPPED_BIRCH_WOOD)
            .put(Blocks.BIRCH_LOG, Blocks.STRIPPED_BIRCH_LOG).put(Blocks.JUNGLE_WOOD, Blocks.STRIPPED_JUNGLE_WOOD)
            .put(Blocks.JUNGLE_LOG, Blocks.STRIPPED_JUNGLE_LOG).put(Blocks.SPRUCE_WOOD, Blocks.STRIPPED_SPRUCE_WOOD)
            .put(Blocks.SPRUCE_LOG, Blocks.STRIPPED_SPRUCE_LOG).put(Blocks.WARPED_STEM, Blocks.STRIPPED_WARPED_STEM)
            .put(Blocks.WARPED_HYPHAE, Blocks.STRIPPED_WARPED_HYPHAE).put(Blocks.CRIMSON_STEM, Blocks.STRIPPED_CRIMSON_STEM)
            .put(Blocks.CRIMSON_HYPHAE, Blocks.STRIPPED_CRIMSON_HYPHAE).put(Blocks.MANGROVE_WOOD, Blocks.STRIPPED_MANGROVE_WOOD)
            .put(Blocks.MANGROVE_LOG, Blocks.STRIPPED_MANGROVE_LOG).put(Blocks.BAMBOO_BLOCK, Blocks.STRIPPED_BAMBOO_BLOCK)
            .put(ModBlocks.EDEN_LOG, ModBlocks.STRIPPED_EDEN_LOG).put(ModBlocks.EDEN_WOOD, ModBlocks.STRIPPED_EDEN_WOOD).build();

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        attacker.getWorld().playSoundFromEntity(null, target, ModSounds.SAW_EATER_HIT, SoundCategory.PLAYERS, 1, 1);
        attacker.addStatusEffect(new StatusEffectInstance(StatusEffects.SATURATION, 20, 0));


        // Chance de 50% de aplicar esses efeitos nos ataques
        if (new java.util.Random().nextFloat() < 0.5) {
            target.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 20, 1));
            target.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 20, 1));
        }

        return super.postHit(stack, target, attacker);
    }


    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        BlockPos blockPos = context.getBlockPos();
        PlayerEntity playerEntity = context.getPlayer();
        BlockState blockState = world.getBlockState(blockPos);
        Optional<BlockState> optional = this.getStrippedState(blockState);
        Optional<BlockState> optional2 = Oxidizable.getDecreasedOxidationState(blockState);
        Optional<BlockState> optional3 = Optional.ofNullable((Block) HoneycombItem.WAXED_TO_UNWAXED_BLOCKS.get().get(blockState.getBlock())).map(block -> block.getStateWithProperties(blockState));
        ItemStack itemStack = context.getStack();
        Optional<BlockState> optional4 = Optional.empty();
        if (optional.isPresent()) {
            world.playSound(playerEntity, blockPos, SoundEvents.ITEM_AXE_STRIP, SoundCategory.BLOCKS, 1.0f, 1.0f);
            optional4 = optional;
        } else if (optional2.isPresent()) {
            world.playSound(playerEntity, blockPos, SoundEvents.ITEM_AXE_SCRAPE, SoundCategory.BLOCKS, 1.0f, 1.0f);
            world.syncWorldEvent(playerEntity, WorldEvents.BLOCK_SCRAPED, blockPos, 0);
            optional4 = optional2;
        } else if (optional3.isPresent()) {
            world.playSound(playerEntity, blockPos, SoundEvents.ITEM_AXE_WAX_OFF, SoundCategory.BLOCKS, 1.0f, 1.0f);
            world.syncWorldEvent(playerEntity, WorldEvents.WAX_REMOVED, blockPos, 0);
            optional4 = optional3;
        }
        if (optional4.isPresent()) {
            if (playerEntity instanceof ServerPlayerEntity) {
                Criteria.ITEM_USED_ON_BLOCK.trigger((ServerPlayerEntity) playerEntity, blockPos, itemStack);
            }
            world.setBlockState(blockPos, (BlockState) optional4.get(), Block.NOTIFY_ALL | Block.REDRAW_ON_MAIN_THREAD);
            world.emitGameEvent(GameEvent.BLOCK_CHANGE, blockPos, GameEvent.Emitter.of(playerEntity, (BlockState) optional4.get()));
            if (playerEntity != null) {
                itemStack.damage(1, playerEntity, p -> p.sendToolBreakStatus(context.getHand()));

            }
            return ActionResult.success(world.isClient);
        }
        return ActionResult.PASS;
    }
    private Optional<BlockState> getStrippedState(BlockState state) {
        return Optional.ofNullable(STRIPPED_BLOCKS.get(state.getBlock())).map(block -> (BlockState)block.getDefaultState().with(PillarBlock.AXIS, state.get(PillarBlock.AXIS)));
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (!world.isClient()) {

            for (int i = 0; i < 80; i++) {
                double offsetX = Math.random() * 0.5;
                double offsetY = Math.random() * 2;
                double offsetZ = Math.random() * 0.5;
                ((ServerWorld) world).spawnParticles(ParticleTypes.ENCHANTED_HIT,
                        user.getX() + offsetX, user.getY() + offsetY, user.getZ() + offsetZ,
                        1, 0, 0, 0, 0.1);
            }

            user.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 400, 0));
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.HASTE, 400, 0));
            world.playSound(null, user.getX(), user.getY(), user.getZ(), ModSounds.SAW_EATER_SLASHER, SoundCategory.PLAYERS, 1F, 1.0F);
            user.getItemCooldownManager().set(this, 550);


        }

        return super.use(world, user, hand);


    }
    @Override
    public float getMiningSpeedMultiplier(ItemStack stack, BlockState state) {

        return state.isIn(ModTags.Blocks.SAW_EATER_MINEABLE) ? 12.5f : 12.0f;
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.saw_eater.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.saw_eaterline2.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.space.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.saw_eater2.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.space.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.saw_eatereffect.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.saw_eatereffect2.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.space.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.saw_eater3.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.saw_eaterself.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.saw_eatereffect3.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.space.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.saw_eaterentities.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.saw_eatereffect4.tooltip"));
        tooltip.add(Text.translatable("tooltip.eclipse_do_caos.saw_eatereffect5.tooltip"));
        super.appendTooltip(stack, world, tooltip, context);
    }
}


