package fuj1n.globalChestMod;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import fuj1n.globalChestMod.common.CommonProxyGlobalChests;
import fuj1n.globalChestMod.common.blocks.BlockGlobalChest;

@Mod(modid = "fuj1n.GlobalChests", name = CommonProxyGlobalChests.modName, version = CommonProxyGlobalChests.version)
@NetworkMod(clientSideRequired=true, serverSideRequired=false)

public class GlobalChests {
	@SidedProxy(clientSide="fuj1n.globalChestMod.client.ClientProxyGlobalChests", serverSide="fuj1n.globalChestMod.common.CommonPorxyGlobalChests")
	public static CommonProxyGlobalChests proxy;
	public static Configuration config;
	
	public static int globalChestId = 2564;
	
	public static Block globalChest;
	
	@PreInit
	public void PreInit(FMLPreInitializationEvent event){
		proxy.PreInit();
		config = new Configuration(event.getSuggestedConfigurationFile());
		config.load();
		config.getBlock("Global Chest Id", globalChestId);
		config.save();
	}
	
	@Init
	public void Init(FMLInitializationEvent event){
		proxy.Init();
		initAllBlocks();
		registerAllBlocks();
		addAllNames();
	}
	
	@PostInit
	public void PostInit(FMLPostInitializationEvent event){
		proxy.PostInit();
	}
	
	public void initAllBlocks(){
		globalChest = new BlockGlobalChest(globalChestId).setCreativeTab(CreativeTabs.tabAllSearch).setHardness(3.0F).setResistance(10F).setUnlocalizedName("fuj1n.globalChests.GlobalChest");
	}
	
	public void registerAllBlocks(){
		GameRegistry.registerBlock(globalChest, "fuj1n.globalChests.GlobalChest");
	}
	
	public void addAllNames(){
		LanguageRegistry.addName(globalChest, "Global Chest");
	}
	
}
