package com.shashakar.mcc.world.biomes;

import com.shashakar.mcc.blocks.BlockOres;
import com.shashakar.mcc.blocks.BlockPlank;
import com.shashakar.mcc.init.ModBlocks;
import com.shashakar.mcc.util.handlers.EnumHandler;
import com.shashakar.mcc.world.gen.generators.WorldGenCopperTree;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenMinable;

import java.util.Random;

public class BiomeCopper extends Biome {

    //Initializes default tree for Biome
    protected static final WorldGenAbstractTree TREE = new WorldGenCopperTree();

    public BiomeCopper() {
        super(new BiomeProperties("Copper").setBaseHeight(1.5F).setHeightVariation(1.2F).setTemperature(0.6F).setRainDisabled().setWaterColor(16711680));

        //Top Block of Biome
        topBlock = ModBlocks.RUBY_BLOCK.getDefaultState();

        //Top 5? below Top Block
        //fillerBlock = ModBlocks.ORE_OVERWORLD.getDefaultState().withProperty(BlockOres.VARIANT, EnumHandler.EnumType.ALUMINIUM);
        fillerBlock = ModBlocks.HAT_SANTA.getDefaultState();

        //replaces coal with Copper Planks
        this.decorator.coalGen = new WorldGenMinable(ModBlocks.PLANKS.getDefaultState().withProperty(BlockPlank.VARIANT, EnumHandler.EnumType.COPPER), 10);

        this.decorator.treesPerChunk = 2;

        this.spawnableCaveCreatureList.clear();
        this.spawnableCreatureList.clear();
        this.spawnableMonsterList.clear();
        this.spawnableWaterCreatureList.clear();

        this.spawnableCreatureList.add(new SpawnListEntry(EntityWither.class, 10, 1, 5));
        this.spawnableCreatureList.add(new SpawnListEntry(EntityDragon.class, 5, 1, 2));
    }

    @Override
    public WorldGenAbstractTree getRandomTreeFeature(Random rand)
    {
        return TREE;
    }
}