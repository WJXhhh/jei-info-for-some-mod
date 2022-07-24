package com.wjx.jei_info_for_some_mod;

import com.wjx.jei_info_for_some_mod.proxy.CommonProxy;
import com.wjx.jei_info_for_some_mod.util.Reference;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import org.apache.logging.log4j.Logger;

@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION)
public class Main {
    @Mod.Instance
    public static Main instance;

    @SidedProxy(clientSide = Reference.CLIENT,serverSide = Reference.COMMON)
    public static CommonProxy proxy;

    public static Logger logger;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();


    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {


    }
    @Mod.EventHandler
    public void postinit(FMLPostInitializationEvent event){}

}
