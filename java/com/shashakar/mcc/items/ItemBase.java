package com.shashakar.mcc.items;

import com.shashakar.mcc.McClasses;
import com.shashakar.mcc.init.ModItems;
import com.shashakar.mcc.util.IHasModel;
import net.minecraft.item.Item;

public class ItemBase extends Item implements IHasModel  {

    public ItemBase(String name)
    {
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
