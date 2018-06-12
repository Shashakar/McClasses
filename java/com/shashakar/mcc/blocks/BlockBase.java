package com.shashakar.mcc.blocks;

import com.shashakar.mcc.McClasses;
import com.shashakar.mcc.init.ModBlocks;
import com.shashakar.mcc.init.ModItems;
import com.shashakar.mcc.util.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class BlockBase extends Block implements IHasModel {
    public BlockBase(String name, Material material)
    {
        super(material);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(McClasses.tabMcClasses);

        ModBlocks.BLOCKS.add(this);
        ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
    }

    @Override
    public void registerModels() {
        McClasses.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");

    }
}
