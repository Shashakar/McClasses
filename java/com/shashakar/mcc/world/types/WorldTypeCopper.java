package com.shashakar.mcc.world.types;

import com.shashakar.mcc.init.ModBiomes;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeProvider;
import net.minecraft.world.biome.BiomeProviderSingle;


public class WorldTypeCopper extends WorldType
{
    public WorldTypeCopper()
    {
        super("Copper");
    }

    @Override
    public BiomeProvider getBiomeProvider(World world)
    {
        return new BiomeProviderSingle(ModBiomes.COPPER);
    }
}
