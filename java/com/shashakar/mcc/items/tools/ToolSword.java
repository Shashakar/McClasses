package com.shashakar.mcc.items.tools;

import com.shashakar.mcc.McClasses;
import com.shashakar.mcc.init.ModItems;
import com.shashakar.mcc.util.IHasModel;
import net.minecraft.item.ItemSword;

public class ToolSword extends ItemSword implements IHasModel {

    public ToolSword(String name, ToolMaterial material)
    {
        super(material);
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
