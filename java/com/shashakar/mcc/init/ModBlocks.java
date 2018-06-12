package com.shashakar.mcc.init;

import com.shashakar.mcc.blocks.*;
import com.shashakar.mcc.blocks.machines.sinterer.BlockFurnaceSintering;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import java.util.ArrayList;
import java.util.List;

public class ModBlocks {
    public static final List<Block> BLOCKS = new ArrayList<Block>();

    //Blocks
    public static final Block RUBY_BLOCK = new RubyBlock("ruby_block", Material.IRON);

    //Ores
    public static final Block ORE_END = new BlockOres("ore_end", "end");
    public static final Block ORE_OVERWORLD = new BlockOres("ore_overworld", "overworld");
    public static final Block ORE_NETHER = new BlockOres("ore_nether", "nether");

    //Wood and Trees
    public static final Block PLANKS = new BlockPlank("planks");
    public static final Block LOGS = new BlockLogs("log");
    public static final Block LEAVES = new BlockLeaf("leaves");
    public static final Block SAPLINGS = new BlockSaplings("sapling");

    public static final Block HAT_SANTA = new BlockHatSanta("hat_santa");
    public static final Block FURNACE_SINTERING = new BlockFurnaceSintering("furnace_sintering");
}
