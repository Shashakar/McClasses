package com.shashakar.mcc.blocks.machines.sinterer;

import java.util.Map;
import java.util.Map.Entry;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Maps;
import com.google.common.collect.Table;

import com.shashakar.mcc.init.ModBlocks;
import com.shashakar.mcc.init.ModItems;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class FurnaceSinteringRecipes
{
    private static final FurnaceSinteringRecipes INSTANCE = new FurnaceSinteringRecipes();
    private final Table<ItemStack, ItemStack, ItemStack> smeltingList = HashBasedTable.<ItemStack, ItemStack, ItemStack>create(); //stores recipes in table
    private final Map<ItemStack, Float> experienceList = Maps.<ItemStack, Float>newHashMap(); //gets xp amount

    public static FurnaceSinteringRecipes getInstance()
    {
        return INSTANCE;
    }

    private FurnaceSinteringRecipes()
    {
        //inputs must be from the same package/mod. Two mc items or two mcclasses items, etc
        addSinteringRecipe(new ItemStack(ModBlocks.RUBY_BLOCK), new ItemStack(ModBlocks.ORE_OVERWORLD), new ItemStack(Blocks.ACACIA_FENCE), 5.0F);
        addSinteringRecipe(new ItemStack(Blocks.ACACIA_FENCE), new ItemStack(Blocks.ACACIA_FENCE_GATE), new ItemStack(ModBlocks.FURNACE_SINTERING), 5.0F);
        addSinteringRecipe(new ItemStack(Blocks.DIRT), new ItemStack(Blocks.PLANKS), new ItemStack(Items.DIAMOND), 40.0F);
        addSinteringRecipe(new ItemStack(ModBlocks.LOGS), new ItemStack(ModBlocks.RUBY_BLOCK), new ItemStack(ModItems.RUBY_PICKAXE), 2.0F);
    }


    public void addSinteringRecipe(ItemStack input1, ItemStack input2, ItemStack result, float experience)
    {
        if(getSinteringResult(input1, input2) != ItemStack.EMPTY) return;
        this.smeltingList.put(input1, input2, result);
        this.experienceList.put(result, Float.valueOf(experience));
    }

    public ItemStack getSinteringResult(ItemStack input1, ItemStack input2)
    {
        for(Entry<ItemStack, Map<ItemStack, ItemStack>> entry : this.smeltingList.columnMap().entrySet())
        {
            if(this.compareItemStacks(input1, (ItemStack)entry.getKey()))
            {
                for(Entry<ItemStack, ItemStack> ent : entry.getValue().entrySet())
                {
                    if(this.compareItemStacks(input2, (ItemStack)ent.getKey()))
                    {
                        return (ItemStack)ent.getValue();
                    }
                }
            }
        }
        return ItemStack.EMPTY;
    }

    private boolean compareItemStacks(ItemStack stack1, ItemStack stack2)
    {
        return stack2.getItem() == stack1.getItem() && (stack2.getMetadata() == 32767 || stack2.getMetadata() == stack1.getMetadata());
    }

    public Table<ItemStack, ItemStack, ItemStack> getDualSmeltingList()
    {
        return this.smeltingList;
    }

    public float getSinteringExperience(ItemStack stack)
    {
        for (Entry<ItemStack, Float> entry : this.experienceList.entrySet())
        {
            if(this.compareItemStacks(stack, (ItemStack)entry.getKey()))
            {
                return ((Float)entry.getValue()).floatValue();
            }
        }
        return 0.0F;
    }
}