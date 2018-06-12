package com.shashakar.mcc;

import com.shashakar.mcc.init.ModItems;
import com.shashakar.mcc.init.ModRecipes;
import com.shashakar.mcc.proxy.CommonProxy;
import com.shashakar.mcc.util.Reference;
import com.shashakar.mcc.util.handlers.RegistryHandler;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MOD_ID, name = Reference.NAME, version = Reference.VERSION, acceptedMinecraftVersions = Reference.ACCEPTED_VERSIONS)
public class McClasses {

    @Mod.Instance
    public static McClasses instance;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.COMMON_PROXY_CLASS)
    public static CommonProxy proxy;

    @Mod.EventHandler
    public static void PreInit(FMLPreInitializationEvent event)
    {
        RegistryHandler.preInitRegistries();
    }
    public static void Init(FMLInitializationEvent event)
    {
        RegistryHandler.initRegistries();
    }

    public static void PostInit(FMLPostInitializationEvent event)
    {
        RegistryHandler.postInitRegistries();
    }

    public static CreativeTabs tabMcClasses = new CreativeTabs("tab_mcclasses") {
        @Override
        public ItemStack getTabIconItem() {
            return new ItemStack(ModItems.RUBY);
        }
    };
    }
