package com.shashakar.mcc.util.handlers;

import com.shashakar.mcc.blocks.machines.sinterer.TileEntityFurnaceSintering;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class TileEntityHandler
{
    public static void registerTileEntities()
    {
        GameRegistry.registerTileEntity(TileEntityFurnaceSintering.class, "furnace_sintering");
    }
}
