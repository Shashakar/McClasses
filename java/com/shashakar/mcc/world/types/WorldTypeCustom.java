package com.shashakar.mcc.world.types;

import com.shashakar.mcc.init.ModBiomes;
import com.shashakar.mcc.world.types.layer.GenLayerCustom;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeProvider;
import net.minecraft.world.biome.BiomeProviderSingle;
import net.minecraft.world.gen.ChunkGeneratorSettings;
import net.minecraft.world.gen.layer.GenLayer;


public class WorldTypeCustom extends WorldType
{
    public WorldTypeCustom()
    {
        super("Custom");
    }

    @Override
    public GenLayer getBiomeLayer(long worldSeed, GenLayer parentLayer, ChunkGeneratorSettings chunkSettings) {
        return new GenLayerCustom(worldSeed, parentLayer, this, chunkSettings);
    }
}
