package com.shashakar.mcc.world.gen;

import com.shashakar.mcc.blocks.BlockOres;
import com.shashakar.mcc.init.ModBlocks;
import com.shashakar.mcc.util.handlers.EnumHandler;
import com.shashakar.mcc.world.biomes.BiomeCopper;
import com.shashakar.mcc.world.gen.generators.WorldGenAluminiumTree;
import com.shashakar.mcc.world.gen.generators.WorldGenCopperTree;
import com.shashakar.mcc.world.gen.generators.WorldGenStructure;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeForest;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;
import scala.actors.threadpool.Arrays;

import java.util.ArrayList;
import java.util.Random;

public class WorldGenCustomStructures implements IWorldGenerator
{
    public static final WorldGenStructure ARMOURY = new WorldGenStructure("armoury");

    private final WorldGenerator COPPER = new WorldGenCopperTree();
    private final WorldGenerator ALUMINIUM = new WorldGenAluminiumTree();

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider)
    {
        switch(world.provider.getDimension())
        {
            case 2:

                break;

            case 1:

                break;

            case 0:

                generateStructure(ARMOURY, world, random, chunkX, chunkZ, 20, Blocks.GRASS, BiomeCopper.class);
                generateTree(COPPER, world, random, chunkX, chunkZ, 5, ModBlocks.RUBY_BLOCK, BiomeCopper.class);
                generateTree(ALUMINIUM, world, random, chunkX, chunkZ, 5, Blocks.GRASS, BiomeForest.class);

                break;

            case -1:

        }
    }

    private void generateStructure(WorldGenerator generator, World world, Random random, int chunkX, int chunkZ, int chance, Block topBlock, Class<?>... classes)
    {
        ArrayList<Class<?>> classesList = new ArrayList<Class<?>>(Arrays.asList(classes));

        int x = (chunkX * 16) + random.nextInt(15) + 8;
        int z = (chunkZ * 16) + random.nextInt(15) + 8;
        int y = calculateGenerationHeight(world, x, z, topBlock);
        BlockPos pos = new BlockPos(x,y,z);

        Class<?> biome = world.provider.getBiomeForCoords(pos).getClass();

        if(world.getWorldType() != WorldType.FLAT)
        {
            if(classesList.contains(biome))
            {
                if(random.nextInt(chance) == 0)
                {
                    generator.generate(world, random, pos);
                }
            }
        }
    }

    private void generateTree(WorldGenerator generator, World world, Random random, int chunkX, int chunkZ, int chance, Block topBlock, Class<?>... classes)
    {
        ArrayList<Class<?>> classesList = new ArrayList<Class<?>>(Arrays.asList(classes));

        int x = (chunkX * 16) + random.nextInt(15) + 8;
        int z = (chunkZ * 16) + random.nextInt(15) + 8;
        int y = calculateGenerationHeight(world, x, z, topBlock);
        BlockPos pos = new BlockPos(x,y,z);

        Class<?> biome = world.provider.getBiomeForCoords(pos).getClass();

        if(world.getWorldType() != WorldType.FLAT)
        {
            if(classesList.contains(biome))
            {
                if(random.nextInt(chance) == 0)
                {
                    generator.generate(world, random, pos);
                }
            }
        }
    }

    private static int calculateGenerationHeight(World world, int x, int z, Block topBlock)
    {
        int y = world.getHeight();
        boolean foundGround = false;

        while(!foundGround && y-- >= 0)
        {
            Block block = world.getBlockState(new BlockPos(x,y,z)).getBlock();
            foundGround = block == topBlock;
        }

        return y;
    }
}