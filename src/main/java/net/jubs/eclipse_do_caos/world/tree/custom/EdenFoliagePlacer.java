package net.jubs.eclipse_do_caos.world.tree.custom;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.jubs.eclipse_do_caos.world.tree.ModFoliagePlacerTypes;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.foliage.FoliagePlacerType;

public class EdenFoliagePlacer extends FoliagePlacer {


    public static final Codec<EdenFoliagePlacer> CODEC = RecordCodecBuilder.create(EdenFoliagePlacerInstance ->
            fillFoliagePlacerFields(EdenFoliagePlacerInstance).and(Codec.intRange(0, 12).fieldOf("height")
                    .forGetter(instance -> instance.height)).apply(EdenFoliagePlacerInstance, EdenFoliagePlacer::new));
    private final int height;

    public EdenFoliagePlacer(IntProvider radius, IntProvider offset, int height) {
        super(radius, offset);
        this.height = height;
    }

    @Override
    protected FoliagePlacerType<?> getType() {
        return ModFoliagePlacerTypes.EDEN_FOLIAGE_PLACER;
    }

    @Override
    protected void generate(TestableWorld world, BlockPlacer placer, Random random, TreeFeatureConfig config, int trunkHeight,
                            TreeNode treeNode, int foliageHeight, int radius, int offset) {

        // generateSquare(world, placer, random, config, tree.Node.getCenter());
        // radius on how many blocks it extends into x and z direction
        // y how much offset in the y direction from treeNode.getCente()
        // y if it is dependent on i, also offsets each new layers in the y direction


        generateSquare(world, placer, random, config, treeNode.getCenter().up(0), 2, -2, treeNode.isGiantTrunk());
        generateSquare(world, placer, random, config, treeNode.getCenter().up(1), 2, -2, treeNode.isGiantTrunk());
        generateSquare(world, placer, random, config, treeNode.getCenter().up(2), 2, -2, treeNode.isGiantTrunk());
    }

    @Override
    public int getRandomHeight(Random random, int trunkHeight, TreeFeatureConfig config) {
        return this.height;
    }

    @Override
    protected boolean isInvalidForLeaves(Random random, int dx, int y, int dz, int radius, boolean giantTrunk) {
        return false;
    }
}
