package com.tutmod.tutmod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import com.tutmod.tutmod.creativetabs.TabMain;
import com.tutmod.tutmod.proxy.CommonProxy;

@Mod(modid = MainClass.MODID, name = "TutorialMod",version = MainClass.VERSION
public class MainClass{
	public static final String MODID = "tutmod";
	public static final String VERSION = "0.1";
    	public static CommonProxy proxy;
    	public static CreativeTabs tabMain = new TabMain("tabMain");
@SidedProxy(clientSide = "com.tutmod.tutmod.proxy.ClientProxy", serverSide = "com.tutmod.tutmod.proxy.CommonProxy")

    @EventHandler
    public void preInit(FMLPreInitializationEvent event){
    	RegListEvent.init();
        proxy.preInit(event);
    }
    @EventHandler
    public void init(FMLInitializationEvent event){
        proxy.init(event);
    }
    @EventHandler
    public void postInit(FMLPostInitializationEvent event){
        proxy.postInit(event);
    }
}
