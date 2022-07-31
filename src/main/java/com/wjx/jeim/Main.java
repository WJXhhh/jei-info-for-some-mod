package com.wjx.jeim;

import com.wjx.jeim.proxy.CommonProxy;
import com.wjx.jeim.util.Reference;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION,dependencies = "required-after:jei")
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
		logger.info("Mod_Loaded!");


    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {


    }
    @Mod.EventHandler
    public void postinit(FMLPostInitializationEvent event){}

}
