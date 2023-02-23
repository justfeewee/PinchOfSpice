package io.github.justfeewee.justfeewees_pinchofspice.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

public class QuickSandBlock extends Block {
    public QuickSandBlock(Properties properties) {
        super(properties);
    }

    public boolean skipRendering(BlockState p_154268_, BlockState p_154269_, Direction p_154270_) {
        return p_154269_.is(this) ? true : super.skipRendering(p_154268_, p_154269_, p_154270_);
    }

    public @NotNull VoxelShape getOcclusionShape(BlockState p_154272_, BlockGetter p_154273_, BlockPos p_154274_) {
        return Shapes.empty();
    }
}
