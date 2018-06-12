package com.shashakar.mcc.blocks;

import javafx.scene.chart.Axis;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockHatSanta extends BlockBase {

    public static final AxisAlignedBB HAT_SANTA_AABB = new AxisAlignedBB((3/16D), 0, (3/16D), 1 - (3/16D), 10/16D, 1 - (3/16D));

    public BlockHatSanta(String name) {
        super(name, Material.CLOTH);
    }

    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    @Override
    public boolean isFullCube(IBlockState state) {
        return false;
    }

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        return HAT_SANTA_AABB;
    }
}
