package com.shashakar.mcc.items;

import com.shashakar.mcc.McClasses;
import com.shashakar.mcc.init.ModItems;
import com.shashakar.mcc.util.IHasModel;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

import static net.minecraft.client.Minecraft.getMinecraft;

public class ItemScrollFighter extends Item implements IHasModel {

    public ItemScrollFighter(String name) {
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(McClasses.tabMcClasses);
        ModItems.ITEMS.add(this);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        String className;
        className = playerIn.getEntityData().getString("McClass");
        if (className == "fighter") {
            if (worldIn.isRemote) { getMinecraft().player.sendChatMessage("You are already a fighter."); }
            else { System.out.println(playerIn + " is already a fighter"); }
        } else {
            playerIn.getEntityData().setString("McClass", "fighter");
            if (worldIn.isRemote) {
                getMinecraft().player.sendChatMessage("You are now a fighter.");
            } else {
                System.out.println(playerIn + " is now a fighter");
            }
        }
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }

    @Override
    public void registerModels() {
        McClasses.proxy.registerItemRenderer(this, 0, "inventory");

    }
}
