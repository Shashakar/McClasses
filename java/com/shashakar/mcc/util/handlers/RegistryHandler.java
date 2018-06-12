package com.shashakar.mcc.util.handlers;

import com.shashakar.mcc.McClasses;
import com.shashakar.mcc.init.*;
import com.shashakar.mcc.util.IHasModel;
import com.shashakar.mcc.world.gen.WorldGenCustomOres;
import com.shashakar.mcc.world.gen.WorldGenCustomStructures;
import com.shashakar.mcc.world.gen.WorldGenCustomTrees;
import com.shashakar.mcc.world.types.WorldTypeCopper;
import com.shashakar.mcc.world.types.WorldTypeCustom;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.world.WorldType;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod.EventBusSubscriber
public class RegistryHandler
{
    @SubscribeEvent
    public static void onItemRegister(RegistryEvent.Register<Item> event)
    {
    event.getRegistry().registerAll(ModItems.ITEMS.toArray(new Item[0]));
    }

    @SubscribeEvent
    public static void onBlockRegister(RegistryEvent.Register<Block> event)
    {
        event.getRegistry().registerAll(ModBlocks.BLOCKS.toArray(new Block[0]));
        TileEntityHandler.registerTileEntities();
    }

    @SubscribeEvent
    public static void onModelRegister(ModelRegistryEvent event)
    {
        for(Item item : ModItems.ITEMS)
        {
            if(item instanceof IHasModel) { ((IHasModel)item).registerModels(); }
        }

        for(Block block : ModBlocks.BLOCKS)
        {
            if(block instanceof IHasModel) { ((IHasModel)block).registerModels(); }
        }
    }

    public static void preInitRegistries(){
        GameRegistry.registerWorldGenerator(new WorldGenCustomOres(), 0);
        GameRegistry.registerWorldGenerator(new WorldGenCustomStructures(), 0);

        ModBiomes.registerBiomes();
        ModEntities.registerEntities();
        RenderHandler.registerEntityRenders();
    }

    public static void initRegistries(){

        ModRecipes.init();

        SoundsHandler.registerSounds();
        NetworkRegistry.INSTANCE.registerGuiHandler(McClasses.instance, new GuiHandler());
    }

    public static void postInitRegistries()
    {
        WorldType COPPER = new WorldTypeCopper();
        WorldType CUSTOM = new WorldTypeCustom();
    }
}
