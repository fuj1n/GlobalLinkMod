package fuj1n.globalChestMod;
//May(should) be renamed to Global Links once this mod progresses.
import java.util.logging.Level;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import fuj1n.globalChestMod.client.CreativeTabGlobalChestMod;
import fuj1n.globalChestMod.client.gui.GuiHandler;
import fuj1n.globalChestMod.client.nbt.GlobalChestNBT;
import fuj1n.globalChestMod.common.CommonProxyGlobalChests;
import fuj1n.globalChestMod.common.blocks.BlockGlobalChest;
import fuj1n.globalChestMod.common.items.ItemGlobalLink;
import fuj1n.globalChestMod.common.items.ItemVoidStone;
import fuj1n.globalChestMod.common.items.recipe.RecipeVoidStone;
import fuj1n.globalChestMod.common.tileentity.TileEntityGlobalChest;

@Mod(modid = "fuj1n.GlobalChests", name = CommonProxyGlobalChests.modName, version = CommonProxyGlobalChests.version)
@NetworkMod(clientSideRequired=true, serverSideRequired=false)

public class GlobalChests {
	
	public static GlobalChestNBT[] chestNBT = {new GlobalChestNBT("Creative"), new GlobalChestNBT("Survival"), new GlobalChestNBT("Adventure"), new GlobalChestNBT("Misc")};
	
	public static NBTTagCompound globalChestCreative;
	public static NBTTagCompound globalChestSurvival;
	public static NBTTagCompound globalChestAdventure;
	public static NBTTagCompound globalChestMisc;
	
	@SidedProxy(clientSide="fuj1n.globalChestMod.client.ClientProxyGlobalChests", serverSide="fuj1n.globalChestMod.common.CommonProxyGlobalChests")
	public static CommonProxyGlobalChests proxy;
	public static Configuration config;
	
	public static CreativeTabs creativeTabGlobalChest;
	
	//Block IDs
	public static int globalChestId = 2564;
	
	//Item IDs
	public static int globalLinkId = 6328;
	public static int voidStoneId = 6329;
	
	//Blocks
	public static Block globalChest;
	
	//Items
	public static Item globalLink;
	public static Item voidStone;
	
	@Instance("fuj1n.GlobalChests")
	public static GlobalChests instance;
	
	@PreInit
	public void PreInit(FMLPreInitializationEvent event){
		proxy.PreInit();
		config = new Configuration(event.getSuggestedConfigurationFile());
		config.load();
		globalChestId = config.getBlock("Global Chest Id", globalChestId).getInt();
		globalLinkId = config.getItem("Global Link Id", globalLinkId).getInt();
		voidStoneId = config.getItem("Void Stone Id", voidStoneId).getInt();
		config.save();
	}
	
	@Init
	public void Init(FMLInitializationEvent event){
		proxy.Init();
		initCreativeTab();
		initAllBlocks();
		initAllItems();
		registerAllBlocks();
		mapAllTileEntities();
		addAllNames();
		addAllRecipes();
		NetworkRegistry.instance().registerGuiHandler(instance, new GuiHandler());
	}
	
	@PostInit
	public void PostInit(FMLPostInitializationEvent event){
		proxy.PostInit();
	}
	
	public void initAllBlocks(){
		globalChest = new BlockGlobalChest(globalChestId).setCreativeTab(creativeTabGlobalChest).setHardness(3.0F).setResistance(10F).setUnlocalizedName("fuj1n.globalChests.GlobalChest");
	}
	
	public void initAllItems(){
		globalLink = new ItemGlobalLink(globalLinkId).setCreativeTab(creativeTabGlobalChest).setUnlocalizedName("fuj1n.GlobalChests.globalLink");
		voidStone = new ItemVoidStone(voidStoneId).setCreativeTab(creativeTabGlobalChest).setUnlocalizedName("fuj1n.GlobalChests.voidStone");
	}
	
	public void registerAllBlocks(){
		GameRegistry.registerBlock(globalChest, "fuj1n.globalChests.GlobalChest");
	}
	
	public void mapAllTileEntities(){
		GameRegistry.registerTileEntity(TileEntityGlobalChest.class, "fuj1n.GlobalChests.tileEntityGlobalChest");
	}
	
	public void addAllNames(){
		LanguageRegistry.addName(globalChest, "Global Chest");
		LanguageRegistry.addName(globalLink, "Global Link");
		LanguageRegistry.addName(voidStone, "Void Stone");
		
		LanguageRegistry.instance().addStringLocalization("itemGroup.fuj1n.GlobalChests.creativeTab", "Global Chests Mod");
	}
	
	public void addAllRecipes(){
		GameRegistry.addRecipe(new ItemStack(globalLink, 1), new Object[]{
			"GEG", "ENE", "GEG", Character.valueOf('G'), Item.ingotGold, Character.valueOf('E'), Item.enderPearl, Character.valueOf('N'), Item.netherStar
		});
		
		GameRegistry.addRecipe(new ItemStack(globalChest, 1), new Object[]{
			"BDB", "GLG", "IGI", Character.valueOf('B'), Block.blockSteel, Character.valueOf('I'), Item.ingotIron, Character.valueOf('D'), Item.diamond, Character.valueOf('L'), globalLink, Character.valueOf('G'), Item.ingotGold
		});
		
		GameRegistry.addRecipe(new ItemStack(voidStone, 1), new Object[]{
			"GOG", "ONO", "GOG", Character.valueOf('G'), Item.ingotGold, Character.valueOf('O'), Block.obsidian, Character.valueOf('N'), Item.field_94584_bZ
		});
		
		GameRegistry.addRecipe(new RecipeVoidStone());
	}
	
	public void initCreativeTab(){
		creativeTabGlobalChest = new CreativeTabGlobalChestMod("fuj1n.GlobalChests.creativeTab");
	}
	
	public static <var> void log(var s, Level level){
		FMLLog.log(level, "[Global Chests] %s", s);
	}
	
}
