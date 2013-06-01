package fuj1n.globalLinkMod;

//May(should) be renamed to Global Links once this mod progresses.
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.EnumHelper;
import net.minecraftforge.common.Property;
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
import fuj1n.globalLinkMod.client.CreativeTabGlobalChestMod;
import fuj1n.globalLinkMod.client.gui.GuiHandler;
import fuj1n.globalLinkMod.client.nbt.NBTData;
import fuj1n.globalLinkMod.common.CommonProxyGlobalChests;
import fuj1n.globalLinkMod.common.blocks.BlockGlobalChest;
import fuj1n.globalLinkMod.common.blocks.BlockLibrary;
import fuj1n.globalLinkMod.common.blocks.BlockSatLink;
import fuj1n.globalLinkMod.common.enchantment.EnchantmentRange;
import fuj1n.globalLinkMod.common.items.ItemDecoBook;
import fuj1n.globalLinkMod.common.items.ItemGlobalLink;
import fuj1n.globalLinkMod.common.items.ItemMulti;
import fuj1n.globalLinkMod.common.items.ItemPocketLink;
import fuj1n.globalLinkMod.common.items.ItemVoidStone;
import fuj1n.globalLinkMod.common.items.recipe.RecipePocketLinkUpgrade;
import fuj1n.globalLinkMod.common.items.recipe.RecipeVoidStone;
import fuj1n.globalLinkMod.common.modcompat.ModCompatibilityGlobalChests;
import fuj1n.globalLinkMod.common.tileentity.TileEntityGlobalChest;
import fuj1n.globalLinkMod.common.tileentity.TileEntityLibrary;
import fuj1n.globalLinkMod.common.tileentity.TileEntitySatLink;
import fuj1n.globalLinkMod.lib.BookLibraryReference;
import fuj1n.globalLinkMod.lib.DecoBookReference;
import fuj1n.globalLinkMod.lib.ManagerGlobalChest;
import fuj1n.globalLinkMod.lib.MultiItemReference;

@Mod(modid = "fuj1n.GlobalChests", name = CommonProxyGlobalChests.modName, version = CommonProxyGlobalChests.version)
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class GlobalChests {

	public static NBTData[] chestNBT = { new NBTData(NBTData.filenames.NAME_GLOBALCHEST, "Creative"), new NBTData(NBTData.filenames.NAME_GLOBALCHEST, "Survival"), new NBTData(NBTData.filenames.NAME_GLOBALCHEST, "Adventure"), new NBTData(NBTData.filenames.NAME_GLOBALCHEST, "Misc") };

	public static NBTTagCompound globalChestCreative;
	public static NBTTagCompound globalChestSurvival;
	public static NBTTagCompound globalChestAdventure;
	public static NBTTagCompound globalChestMisc;

	@SidedProxy(clientSide = "fuj1n.globalLinkMod.client.ClientProxyGlobalChests", serverSide = "fuj1n.globalLinkMod.common.CommonProxyGlobalChests")
	public static CommonProxyGlobalChests proxy;
	public static Configuration config;

	public static CreativeTabs creativeTabGlobalChest;

	// Block IDs
	public static int globalChestId = 2564;
	public static int bookLibraryId = 2565;
	public static int satLinkId = 2566;

	// Item IDs
	public static int globalLinkId = 6328;
	public static int voidStoneId = 6329;
	public static int pocketGlobalChestId = 6330;
	public static int itemMultiId = 6331;
	public static int decoBookId = 6332;

	// Enchantment IDs
	public static int rangeEnchantmentId = 0;

	// Misc config
	public static int maxGlobalChestPrice = 4096;
	public static int maxPocketLinkRange = 16;
	public static boolean allowDecoStorage = false;

	// Blocks
	public static Block globalChest;
	public static Block bookLibrary;
	public static Block satLink;
	
	public static Block enderChest;

	// Items
	public static Item globalLink;
	public static Item voidStone;
	public static Item pocketLink;
	public static Item multiItem;
	public static Item decoBook;

	public static File modLocation;

	// Enchantments
	public static Enchantment enchantmentRange;

	// Global Chest Manager
	public static ManagerGlobalChest globalChestManager;

	// Compatibility Stuff
	public static ModCompatibilityGlobalChests modCompat;

	// Removed recipe array
	private ArrayList<Integer> removedRecipes = new ArrayList<Integer>();
	
	// Reference Classes
	MultiItemReference multiItemReference = new MultiItemReference();
	DecoBookReference decoBookReference = new DecoBookReference();
	BookLibraryReference libraryStorageReference = new BookLibraryReference();

	// Enum
	public static EnumEnchantmentType pocketLinkEnchantment = EnumHelper.addEnchantmentType("pocketLinkEnchantment");

	@Instance("fuj1n.GlobalChests")
	public static GlobalChests instance;

	@PreInit
	public void PreInit(FMLPreInitializationEvent event) {
		//Forced to override the ender chest until the BlockDropEvent PR gets approved(assuming it does)
		Block.blocksList[Block.enderChest.blockID] = null;
		enderChest = new fuj1n.globalLinkMod.common.blocks.BlockEnderChest(Block.enderChest.blockID).setHardness(22.5F).setResistance(1000.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("enderChest").setLightValue(0.5F);;
		
		addAllRemovedRecipes();
		modLocation = event.getSourceFile();
		proxy.PreInit();
		configPreInit();
		config = new Configuration(event.getSuggestedConfigurationFile(), true);
		config.load();
		// Blocks
		globalChestId = config.getBlock("Global Chest Id", globalChestId).getInt();
		bookLibraryId = config.getBlock("Library Id", bookLibraryId).getInt();
		satLinkId = config.getBlock("SatLink Id", satLinkId).getInt();
		// Items
		globalLinkId = config.getItem("Global Link Id", globalLinkId).getInt();
		voidStoneId = config.getItem("Void Stone Id", voidStoneId).getInt();
		pocketGlobalChestId = config.getItem("Pocket Link Id", pocketGlobalChestId).getInt();
		itemMultiId = config.getItem("Multi Item Id", itemMultiId).getInt();
		decoBookId = config.getItem("Decoration Book Id", decoBookId).getInt();
		// Misc
		Property propRangeEnchantment = config.get("Enchantments", "Pocket Link Range Enchantment Id", rangeEnchantmentId);
		propRangeEnchantment.comment = "This enchantment ID is automatically allocated and you should not have to change it.";
		rangeEnchantmentId = propRangeEnchantment.getInt();
		maxGlobalChestPrice = config.get("Global Linking Configuration", "Max Total Content Weight", maxGlobalChestPrice).getInt();
		maxPocketLinkRange = config.get("Global Linking Configuration", "Max Pocket Link Range", maxPocketLinkRange).getInt();
		// Deco Config
		Property propAllowDecoStorage = config.get("Decoration Configuration", "Allow Decoration Storage", allowDecoStorage);
		propAllowDecoStorage.comment = "Whether to allow more than 1 item to fit into the decoration slot. (The only effect is cheap storage for decoration books :p";
		allowDecoStorage = propAllowDecoStorage.getBoolean(allowDecoStorage);
		config.save();
		libraryStorageReference.populateBooksList();
		modCompat = new ModCompatibilityGlobalChests();
	}

	public void addAllRemovedRecipes(){
		removedRecipes.add(Block.enderChest.blockID);
	}
	
	public void configPreInit() {
		rangeEnchantmentId = getNextAvailableID(Enchantment.enchantmentsList);
	}

	@Init
	public void Init(FMLInitializationEvent event) {
		proxy.Init();
		initCreativeTab();
		initAllBlocks();
		initAllItems();
		initAllEnchantments();
		registerAllBlocks();
		mapAllTileEntities();
		addAllNames();
		removeUnwantedRecipes();
		addAllRecipes();
		globalChestManager = new ManagerGlobalChest(maxGlobalChestPrice);
		NetworkRegistry.instance().registerGuiHandler(instance, new GuiHandler());
	}

	@PostInit
	public void PostInit(FMLPostInitializationEvent event) {
		proxy.PostInit();
		modCompat.postInit();
	}

	public void initAllBlocks() {
		globalChest = new BlockGlobalChest(globalChestId).setCreativeTab(creativeTabGlobalChest).setHardness(3.0F).setResistance(10F).setUnlocalizedName("fuj1n.globalChests.GlobalChest");
		bookLibrary = new BlockLibrary(bookLibraryId).setCreativeTab(creativeTabGlobalChest).setHardness(3.0F).setResistance(10F).setUnlocalizedName("fuj1n.globalChests.bookLibrary");
		satLink = new BlockSatLink(satLinkId).setCreativeTab(creativeTabGlobalChest).setHardness(3.0F).setResistance(10F).setUnlocalizedName("fuj1n.globalChests.satLink");
	}

	public void initAllItems() {
		globalLink = new ItemGlobalLink(globalLinkId).setCreativeTab(creativeTabGlobalChest).setUnlocalizedName("fuj1n.GlobalChests.globalLink");
		voidStone = new ItemVoidStone(voidStoneId).setCreativeTab(creativeTabGlobalChest).setUnlocalizedName("fuj1n.GlobalChests.voidStone");
		pocketLink = new ItemPocketLink(pocketGlobalChestId).setCreativeTab(creativeTabGlobalChest).setUnlocalizedName("fuj1n.GlobalChests.pocketLink");
		multiItem = new ItemMulti(itemMultiId).setCreativeTab(creativeTabGlobalChest).setUnlocalizedName("fuj1n.GlobalChests.multiItem");
		decoBook = new ItemDecoBook(decoBookId).setCreativeTab(creativeTabGlobalChest).setUnlocalizedName("fuj1n.GlobalChests.decoBook");
	}

	public void initAllEnchantments() {
		enchantmentRange = new EnchantmentRange(rangeEnchantmentId, 1, true).setName("fuj1n.GlobalChests.enchanmentRange");
	}

	public int getNextAvailableID(Object[] array) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == null) {
				return i;
			}
		}
		return 0;
	}

	public void registerAllBlocks() {
		GameRegistry.registerBlock(globalChest, "fuj1n.globalChests.GlobalChest");
		GameRegistry.registerBlock(bookLibrary, "fuj1n.globalChests.BookLibrary");
		GameRegistry.registerBlock(satLink, "fuj1n.globalChests.SatelliteLink");
	}

	public void mapAllTileEntities() {
		GameRegistry.registerTileEntity(TileEntityGlobalChest.class, "fuj1n.GlobalChests.tileEntityGlobalChest");
		GameRegistry.registerTileEntity(TileEntitySatLink.class, "fuj1n.GlobalChests.tileEntitySatLink");
		GameRegistry.registerTileEntity(TileEntityLibrary.class, "fuj1n.GlobalChests.tileEntityLibrary");
	}

	public void addAllNames() {
		LanguageRegistry.addName(globalChest, "Global Chest");
		LanguageRegistry.addName(bookLibrary, "Library");
		LanguageRegistry.addName(satLink, "Sat Link");
		LanguageRegistry.addName(globalLink, "Global Link");
		LanguageRegistry.addName(voidStone, "Void Stone");
		LanguageRegistry.addName(pocketLink, "Pocket Link");
		LanguageRegistry.addName(multiItem, "Unknown Multi Item");
		LanguageRegistry.addName(decoBook, "Unknown Book");

		LanguageRegistry.instance().addStringLocalization("enchantment.fuj1n.GlobalChests.enchantmentRange", "Range");
		LanguageRegistry.instance().addStringLocalization("itemGroup.fuj1n.GlobalChests.creativeTab", "Global Chests Mod");

		for (int i = 0; i < MultiItemReference.NAMES.length; i++) {
			LanguageRegistry.addName(new ItemStack(multiItem, 0, i), MultiItemReference.NAMES[i]);
		}
		
		for (int i = 0; i < DecoBookReference.NAMES.length; i++) {
			LanguageRegistry.addName(new ItemStack(decoBook, 0, i), DecoBookReference.NAMES[i]);
		}
	}

	public void removeUnwantedRecipes() {
		Iterator<IRecipe> i1 = CraftingManager.getInstance().getRecipeList().iterator();
		
		while(i1.hasNext()){
			IRecipe recipe = i1.next();
			if(recipe.getRecipeOutput() != null){
				if(removedRecipes.contains(recipe.getRecipeOutput().itemID)){
					i1.remove();
				}
			}
		}
	}

	public void addAllRecipes() {
		GameRegistry.addRecipe(new ItemStack(globalLink, 1), new Object[] { "GEG", "ENE", "GEG", 'G', Item.ingotGold, 'E', Item.enderPearl, 'N', Item.netherStar });

		GameRegistry.addRecipe(new ItemStack(globalChest, 1), new Object[] { "BDB", "GEG", "ILI", 'B', Block.blockIron, 'I', Item.ingotIron, 'D', Item.diamond, 'L', globalLink, 'G', Item.ingotGold, 'E', Block.enderChest });

		GameRegistry.addRecipe(new ItemStack(voidStone, 1), new Object[] { "GOG", "ONO", "GOG", 'G', Item.ingotGold, 'O', Block.obsidian, 'N', Item.netherrackBrick });

		GameRegistry.addRecipe(new ItemStack(multiItem, 1, MultiItemReference.VALUE_RETROPEARL), new Object[] { "GEG", "BGB", "GEG", 'G', Block.glass, 'E', Item.enderPearl, 'B', Item.blazePowder });

		GameRegistry.addRecipe(new RecipeVoidStone());

		GameRegistry.addRecipe(new ItemStack(Block.enderChest, 1), new Object[] { "###", "#E#", "#C#", '#', Block.obsidian, 'E', new ItemStack(multiItem, 1, MultiItemReference.VALUE_RETROPEARL), 'C', Block.chest });
		
		GameRegistry.addRecipe(new ItemStack(pocketLink, 1), new Object[] { "BDI", "SGS", "IDB",  'B', Block.blockIron, 'D', Item.diamond, 'I', Item.ingotIron, 'S', satLink, 'G', globalLink });
		//addRangeEnchantmentRecipes();
		GameRegistry.addRecipe(new RecipePocketLinkUpgrade());
	}
	
	public void initCreativeTab() {
		creativeTabGlobalChest = new CreativeTabGlobalChestMod("fuj1n.GlobalChests.creativeTab");
	}

	public static <var> void log(var s, Level level) {
		FMLLog.log(level, "[Global Chests] %s", s);
	}

}
