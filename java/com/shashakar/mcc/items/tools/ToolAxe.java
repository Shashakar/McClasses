package com.shashakar.mcc.items.tools;

import com.shashakar.mcc.McClasses;
import com.shashakar.mcc.init.ModItems;
import com.shashakar.mcc.util.IHasModel;
import net.minecraft.item.Item;
import net.minecraft.item.ItemAxe;

public class ToolAxe extends ItemAxe implements IHasModel {
    public ToolAxe(String name, ToolMaterial material)
        {
            super(material, 6.0F, -3.2F);
            setUnlocalizedName(name);
            setRegistryName(name);
            setCreativeTab(McClasses.tabMcClasses);
            ModItems.ITEMS.add(this);
        }

    @Override
    public void registerModels() {
        McClasses.proxy.registerItemRenderer(this, 0, "inventory");

    }
}