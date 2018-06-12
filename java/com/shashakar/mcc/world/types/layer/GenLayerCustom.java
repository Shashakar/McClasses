package com.shashakar.mcc.world.types.layer;

import com.google.common.collect.ImmutableList;
import com.shashakar.mcc.init.ModBiomes;
import net.minecraft.init.Biomes;
import net.minecraft.util.WeightedRandom;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.ChunkGeneratorSettings;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;
import net.minecraftforge.common.BiomeManager;

import java.util.ArrayList;
import java.util.List;

public class GenLayerCustom extends GenLayer {
    private List<BiomeManager.BiomeEntry>[] biomes = new ArrayList[BiomeManager.BiomeType.values().length];
    private final ChunkGeneratorSettings settings;

    public GenLayerCustom(long p_i45560_1_, GenLayer p_i45560_3_, WorldType p_i45560_4_, ChunkGeneratorSettings p_i45560_5_) {
        super(p_i45560_1_);
        this.parent = p_i45560_3_;
        BiomeManager.BiomeType[] var6 = BiomeManager.BiomeType.values();
        int var7 = var6.length;

        for(int var8 = 0; var8 < var7; ++var8) {
            BiomeManager.BiomeType type = var6[var8];
            ImmutableList<BiomeManager.BiomeEntry> biomesToAdd = BiomeManager.getBiomes(type);
            int idx = type.ordinal();
            if (this.biomes[idx] == null) {
                this.biomes[idx] = new ArrayList();
            }

            if (biomesToAdd != null) {
                this.biomes[idx].addAll(biomesToAdd);
            }
        }

        int desertIdx = BiomeManager.BiomeType.DESERT.ordinal();
        this.biomes[desertIdx].add(new BiomeManager.BiomeEntry(Biomes.EXTREME_HILLS, 30));
        this.biomes[desertIdx].add(new BiomeManager.BiomeEntry(ModBiomes.COPPER, 30));


        if (p_i45560_4_ == WorldType.DEFAULT_1_1) {
            this.biomes[desertIdx].clear();
            this.biomes[desertIdx].add(new BiomeManager.BiomeEntry(Biomes.EXTREME_HILLS, 10));
            this.biomes[desertIdx].add(new BiomeManager.BiomeEntry(ModBiomes.COPPER, 10));
            this.settings = null;
        } else {
            this.settings = p_i45560_5_;
        }

    }

    public int[] getInts(int areaX, int areaY, int areaWidth, int areaHeight) {
        int[] aint = this.parent.getInts(areaX, areaY, areaWidth, areaHeight);
        int[] aint1 = IntCache.getIntCache(areaWidth * areaHeight);

        for(int i = 0; i < areaHeight; ++i) {
            for(int j = 0; j < areaWidth; ++j) {
                this.initChunkSeed((long)(j + areaX), (long)(i + areaY));
                int k = aint[j + i * areaWidth];
                int l = (k & 3840) >> 8;
                k &= -3841;
                if (this.settings != null && this.settings.fixedBiome >= 0) {
                    aint1[j + i * areaWidth] = this.settings.fixedBiome;
                } else if (isBiomeOceanic(k)) {
                    aint1[j + i * areaWidth] = k;
                } else if (k == Biome.getIdForBiome(Biomes.MUSHROOM_ISLAND)) {
                    aint1[j + i * areaWidth] = k;
                } else if (k == 1) {
                    if (l > 0) {
                        if (this.nextInt(3) == 0) {
                            aint1[j + i * areaWidth] = Biome.getIdForBiome(Biomes.MESA_CLEAR_ROCK);
                        } else {
                            aint1[j + i * areaWidth] = Biome.getIdForBiome(Biomes.MESA_ROCK);
                        }
                    } else {
                        aint1[j + i * areaWidth] = Biome.getIdForBiome(this.getWeightedBiomeEntry(BiomeManager.BiomeType.DESERT).biome);
                    }
                } else if (k == 2) {
                    if (l > 0) {
                        aint1[j + i * areaWidth] = Biome.getIdForBiome(Biomes.JUNGLE);
                    } else {
                        aint1[j + i * areaWidth] = Biome.getIdForBiome(this.getWeightedBiomeEntry(BiomeManager.BiomeType.WARM).biome);
                    }
                } else if (k == 3) {
                    if (l > 0) {
                        aint1[j + i * areaWidth] = Biome.getIdForBiome(Biomes.REDWOOD_TAIGA);
                    } else {
                        aint1[j + i * areaWidth] = Biome.getIdForBiome(this.getWeightedBiomeEntry(BiomeManager.BiomeType.COOL).biome);
                    }
                } else if (k == 4) {
                    aint1[j + i * areaWidth] = Biome.getIdForBiome(this.getWeightedBiomeEntry(BiomeManager.BiomeType.ICY).biome);
                } else {
                    aint1[j + i * areaWidth] = Biome.getIdForBiome(Biomes.MUSHROOM_ISLAND);
                }
            }
        }

        return aint1;
    }

    protected BiomeManager.BiomeEntry getWeightedBiomeEntry(BiomeManager.BiomeType type) {
        List<BiomeManager.BiomeEntry> biomeList = this.biomes[type.ordinal()];
        int totalWeight = WeightedRandom.getTotalWeight(biomeList);
        int weight = BiomeManager.isTypeListModded(type) ? this.nextInt(totalWeight) : this.nextInt(totalWeight / 10) * 10;
        return (BiomeManager.BiomeEntry)WeightedRandom.getRandomItem(biomeList, weight);
    }
}