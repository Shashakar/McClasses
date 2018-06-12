package com.shashakar.mcc.init;

import com.shashakar.mcc.items.ItemBase;
import com.shashakar.mcc.items.ItemScrollFighter;
import com.shashakar.mcc.items.ItemScrollMage;
import com.shashakar.mcc.items.ItemScrollRogue;
import com.shashakar.mcc.items.tools.ToolPickaxe;
import com.shashakar.mcc.items.tools.ToolSpade;
import com.shashakar.mcc.items.tools.ToolAxe;
import com.shashakar.mcc.items.tools.ToolSword;
import net.minecraft.item.*;
import net.minecraftforge.common.util.EnumHelper;

import java.util.ArrayList;
import java.util.List;

public class ModItems
{
    public static final List<Item> ITEMS = new ArrayList<Item>();

    //Materials
    public static final Item.ToolMaterial MATERIAL_RUBY = EnumHelper.addToolMaterial("material_ruby", 3, 250, 8.0F, 3.0F, 10);

    //Items
    public static final Item RUBY = new ItemBase("ruby");

    //Class Scrolls
    public static final Item SCROLL_FIGHTER = new ItemScrollFighter("scroll_fighter");
    public static final Item SCROLL_ROGUE = new ItemScrollRogue("scroll_rogue");
    public static final Item SCROLL_MAGE = new ItemScrollMage("scroll_mage");

    //Tools
    public static final ItemSword RUBY_SWORD = new ToolSword("ruby_sword", MATERIAL_RUBY);
    public static final ItemAxe RUBY_AXE = new ToolAxe("ruby_axe", MATERIAL_RUBY);
    public static final ItemSpade RUBY_SHOVEL = new ToolSpade("ruby_shovel", MATERIAL_RUBY);
    public static final ItemPickaxe RUBY_PICKAXE = new ToolPickaxe("ruby_pickaxe", MATERIAL_RUBY);

}
