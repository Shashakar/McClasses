package com.shashakar.mcc.util.handlers;

import com.shashakar.mcc.blocks.machines.sinterer.ContainerFurnaceSintering;
import com.shashakar.mcc.blocks.machines.sinterer.GuiFurnaceSintering;
import com.shashakar.mcc.blocks.machines.sinterer.TileEntityFurnaceSintering;
import com.shashakar.mcc.util.Reference;


import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler
{
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        if(ID == Reference.GUI_FURNACE_SINTERING) return new ContainerFurnaceSintering(player.inventory, (TileEntityFurnaceSintering)world.getTileEntity(new BlockPos(x,y,z)));
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        if(ID == Reference.GUI_FURNACE_SINTERING) return new GuiFurnaceSintering(player.inventory, (TileEntityFurnaceSintering)world.getTileEntity(new BlockPos(x,y,z)));
        return null;
    }

}