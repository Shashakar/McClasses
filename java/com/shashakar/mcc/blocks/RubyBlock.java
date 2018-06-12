package com.shashakar.mcc.blocks;

import com.shashakar.mcc.McClasses;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class RubyBlock extends BlockBase {

    public RubyBlock(String name, Material material) {
        super(name, material);

        //Sound when walking over
        setSoundType(SoundType.METAL);
        //How long it takes to break it (Diamond block is 5.0F)
        setHardness(5.0F);
        //Explosion Resistance (15 is average)
        setResistance(15.0F);
        //Sets tool and requirement (level 2 is iron)
        setHarvestLevel("pickaxe", 2);
        //How much light is emitted by block (glowstone is 15)
        setLightLevel(1.0F);
        //How much light is allowed through the block (1 is transparent)
        setLightLevel(1);
        //Block becomes unbreakable
        //setBlockUnbreakable();
        //sets creative tab
        setCreativeTab(McClasses.tabMcClasses);
    }
}
