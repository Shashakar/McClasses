package com.shashakar.mcc.blocks.machines.sinterer.slots;

import com.shashakar.mcc.blocks.machines.sinterer.TileEntityFurnaceSintering;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotFurnaceSinteringFuel extends Slot
{
    public SlotFurnaceSinteringFuel(IInventory inventory, int index, int x, int y)
    {
        super(inventory, index, x, y);
    }

    @Override
    public boolean isItemValid(ItemStack stack)
    {
        return TileEntityFurnaceSintering.isItemFuel(stack);
    }

    @Override
    public int getItemStackLimit(ItemStack stack)
    {
        return super.getItemStackLimit(stack);
    }
}