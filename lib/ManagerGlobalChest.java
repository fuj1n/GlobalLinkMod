package fuj1n.globalChestMod.lib;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import fuj1n.globalChestMod.GlobalChests;
import fuj1n.globalChestMod.common.inventory.InventoryGlobalChest;

public class ManagerGlobalChest {

	private ArrayList<Integer> stackList = new ArrayList();
	private ArrayList<Integer> priceList = new ArrayList();
	private ArrayList<Integer> banList = new ArrayList();
	
	private ArrayList<String> oreDictStackList = new ArrayList();
	private ArrayList<Integer> oreDictPriceList = new ArrayList();
	private ArrayList<String> oreDictBanList = new ArrayList();
	
	private ArrayList<ItemStack> cheatItemList = new ArrayList();

	private ArrayList<Integer> stackLimit = new ArrayList();

	public final int maxWeight;

	public ManagerGlobalChest(int par1) {
		maxWeight = par1 > 0 ? par1 : 4096;
		populatePriceList();
	}

	public void populatePriceList() {
		// Blocks
		addItemToList(Block.stone.blockID, 1);
		addItemToList(Block.grass.blockID, 1);
		addItemToList(Block.dirt.blockID, 1);
		addItemToList(Block.cobblestone.blockID, 1);
		addItemToList(Block.planks.blockID, 1);
		addItemToList(Block.sapling.blockID, 1);
		addItemToBanList(Block.bedrock.blockID);
		addItemToList(Block.gravel.blockID, 1);
		addItemToBanList(Block.oreGold.blockID);
		addItemToBanList(Block.oreIron.blockID);
		addItemToBanList(Block.oreCoal.blockID);
		addItemToList(Block.wood.blockID, 4);
		addItemToList(Block.sand.blockID, 1);
		addItemToList(Block.leaves.blockID, 1);
		addItemToList(Block.sponge.blockID, 1);
		addItemToList(Block.glass.blockID, 1);
		addItemToBanList(Block.oreLapis.blockID);
		addItemToList(Block.blockLapis.blockID, 9);
		addItemToList(Block.dispenser.blockID, 11);
		addItemToList(Block.sandStone.blockID, 1);
		addItemToList(Block.music.blockID, 16);
		addItemToBanList(Block.web.blockID);
		addItemToList(Block.tallGrass.blockID, 1);
		addItemToList(Block.cloth.blockID, 4);
		addItemToList(Block.plantRed.blockID, 2);
		addItemToList(Block.plantYellow.blockID, 2);
		addItemToList(Block.mushroomBrown.blockID, 4);
		addItemToList(Block.mushroomRed.blockID, 4);
		addItemToList(Block.blockGold.blockID, 108);
		addItemToList(Block.blockIron.blockID, 90);
		addItemToList(Block.stoneSingleSlab.blockID, 1);
		addItemToList(Block.brick.blockID, 4);
		addItemToList(Block.tnt.blockID, 10);
		addItemToList(Block.bookShelf.blockID, 15);
		addItemToList(Block.cobblestoneMossy.blockID, 2);
		addItemToList(Block.obsidian.blockID, 4);
		addItemToList(Block.torchWood.blockID, 1);
		addItemToList(Block.fire.blockID, 1);
		addItemToList(Block.mobSpawner.blockID, 46);
		addItemToList(Block.stairsWoodOak.blockID, 1);
		addItemToList(Block.chest.blockID, 8);
		addItemToBanList(Block.oreDiamond.blockID);
		addItemToList(Block.blockDiamond.blockID, 576);
		addItemToList(Block.workbench.blockID, 4);
		addItemToList(Block.furnaceIdle.blockID, 2);
		addItemToList(Block.pressurePlatePlanks.blockID, 6);
		addItemToList(Block.ladder.blockID, 1);
		addItemToList(Block.stairsCobblestone.blockID, 1);
		addItemToList(Block.lever.blockID, 1);
		addItemToList(Block.pressurePlateStone.blockID, 2);
		addItemToBanList(Block.oreRedstone.blockID);
		addItemToList(Block.stoneButton.blockID, 1);
		addItemToList(Block.snow.blockID, 1);
		addItemToList(Block.cactus.blockID, 1);
		addItemToList(Block.blockClay.blockID, 4);
		addItemToList(Block.jukebox.blockID, 72);
		addItemToList(Block.fence.blockID, 3);
		addItemToList(Block.pumpkin.blockID, 2);
		addItemToList(Block.netherrack.blockID, 1);
		addItemToList(Block.slowSand.blockID, 1);
		addItemToList(Block.glowStone.blockID, 4);
		addItemToList(Block.pumpkinLantern.blockID, 2);
		addItemToList(Block.trapdoor.blockID, 6);
		addItemToList(Block.mushroomCapBrown.blockID, 12);
		addItemToList(Block.mushroomCapRed.blockID, 12);
		addItemToList(Block.fenceIron.blockID, 54);
		addItemToList(Block.melon.blockID, 6);
		addItemToList(Block.vine.blockID, 1);
		addItemToList(Block.fenceGate.blockID, 4);
		addItemToList(Block.netherFence.blockID, 3);
		addItemToList(Block.stairsBrick.blockID, 1);
		addItemToList(Block.stairsStoneBrick.blockID, 1);
		addItemToList(Block.mycelium.blockID, 1);
		addItemToList(Block.waterlily.blockID, 1);
		addItemToList(Block.netherBrick.blockID, 4);
		addItemToList(Block.netherFence.blockID, 1);
		addItemToList(Block.stairsNetherBrick.blockID, 1);
		addItemToList(Block.enchantmentTable.blockID, 135);
		addItemToBanList(Block.dragonEgg.blockID);
		addItemToList(Block.whiteStone.blockID, 1);
		addItemToList(Block.stairsSandStone.blockID, 1);
		addItemToBanList(Block.oreEmerald.blockID);
		addItemToList(Block.enderChest.blockID, 96);
		addItemToList(Block.blockEmerald.blockID, 136);
		addItemToBanList(Block.commandBlock.blockID);
		addItemToList(Block.stairsWoodSpruce.blockID, 1);
		addItemToList(Block.stairsWoodBirch.blockID, 1);
		addItemToList(Block.stairsWoodJungle.blockID, 1);
		addItemToBanList(Block.beacon.blockID);
		addItemToList(Block.cobblestoneWall.blockID, 2);
		addItemToList(Block.woodenButton.blockID, 1);
		addItemToList(Block.anvil.blockID, 31);
		addItemToList(Block.chestTrapped.blockID, 9);
		addItemToList(Block.pressurePlateGold.blockID, 24);
		addItemToList(Block.pressurePlateIron.blockID, 18);
		addItemToList(Block.daylightSensor.blockID, 6);
		addItemToList(Block.blockRedstone.blockID, 9);
		addItemToBanList(Block.oreNetherQuartz.blockID);
		addItemToList(Block.blockNetherQuartz.blockID, 1);
		addItemToList(Block.stairsNetherQuartz.blockID, 1);
		addItemToList(Block.dropper.blockID, 27);
		// Items
		addItemToList(Item.shovelIron.itemID, 9);
		addItemToList(Item.pickaxeIron.itemID, 27);
		addItemToList(Item.axeIron.itemID, 27);
		addItemToList(Item.flintAndSteel.itemID, 11);
		addItemToList(Item.bow.itemID, 3);
		addItemToList(Item.arrow.itemID, 2);
		addItemToList(Item.coal.itemID, 2);
		addItemToList(Item.diamond.itemID, 64);
		addItemToList(Item.ingotIron.itemID, 9);
		addItemToList(Item.ingotGold.itemID, 12);
		addItemToList(Item.swordIron.itemID, 18);
		addItemToList(Item.swordWood.itemID, 2);
		addItemToList(Item.shovelWood.itemID, 1);
		addItemToList(Item.pickaxeWood.itemID, 3);
		addItemToList(Item.axeWood.itemID, 3);
		addItemToList(Item.swordDiamond.itemID, 128);
		addItemToList(Item.shovelDiamond.itemID, 64);
		addItemToList(Item.pickaxeDiamond.itemID, 192);
		addItemToList(Item.axeDiamond.itemID, 192);
		addItemToList(Item.bowlEmpty.itemID, 3);
		addItemToList(Item.bowlSoup.itemID, 11);
		addItemToList(Item.swordGold.itemID, 24);
		addItemToList(Item.shovelGold.itemID, 12);
		addItemToList(Item.pickaxeGold.itemID, 36);
		addItemToList(Item.axeGold.itemID, 36);
		addItemToList(Item.silk.itemID, 1);
		addItemToList(Item.gunpowder.itemID, 3);
		addItemToList(Item.hoeWood.itemID, 3);
		addItemToList(Item.hoeIron.itemID, 18);
		addItemToList(Item.hoeDiamond.itemID, 128);
		addItemToList(Item.hoeGold.itemID, 24);
		addItemToList(Item.seeds.itemID, 1);
		addItemToList(Item.wheat.itemID, 1);
		addItemToList(Item.bread.itemID, 3);
		addItemToList(Item.helmetLeather.itemID, 5);
		addItemToList(Item.plateLeather.itemID, 8);
		addItemToList(Item.legsLeather.itemID, 7);
		addItemToList(Item.bootsLeather.itemID, 4);
		addItemToList(Item.helmetIron.itemID, 45);
		addItemToList(Item.plateIron.itemID, 72);
		addItemToList(Item.legsIron.itemID, 63);
		addItemToList(Item.bootsIron.itemID, 36);
		addItemToList(Item.helmetChain.itemID, 5);
		addItemToList(Item.plateChain.itemID, 8);
		addItemToList(Item.legsChain.itemID, 7);
		addItemToList(Item.bootsChain.itemID, 4);
		addItemToList(Item.helmetDiamond.itemID, 320);
		addItemToList(Item.plateDiamond.itemID, 512);
		addItemToList(Item.legsDiamond.itemID, 448);
		addItemToList(Item.bootsDiamond.itemID, 256);
		addItemToList(Item.helmetGold.itemID, 60);
		addItemToList(Item.plateGold.itemID, 96);
		addItemToList(Item.legsGold.itemID, 84);
		addItemToList(Item.bootsGold.itemID, 48);
		addItemToList(Item.flint.itemID, 1);
		addItemToList(Item.porkRaw.itemID, 1);
		addItemToList(Item.porkCooked.itemID, 1);
		addItemToList(Item.painting.itemID, 8);
		addItemToList(Item.appleGold.itemID, 11);
		addItemToList(Item.sign.itemID, 6);
		addItemToList(Item.doorWood.itemID, 6);
		addItemToList(Item.bucketEmpty.itemID, 27);
		addItemToBanList(Item.bucketWater.itemID);
		addItemToBanList(Item.bucketLava.itemID);
		addItemToList(Item.minecartEmpty.itemID, 45);
		addItemToList(Item.saddle.itemID, 5);
		addItemToList(Item.doorIron.itemID, 54);
		addItemToList(Item.redstone.itemID, 1);
		addItemToList(Item.boat.itemID, 5);
		addItemToList(Item.leather.itemID, 1);
		addItemToList(Item.bucketMilk.itemID, 28);
		addItemToList(Item.brick.itemID, 1);
		addItemToList(Item.clay.itemID, 1);
		addItemToList(Item.reed.itemID, 1);
		addItemToList(Item.paper.itemID, 1);
		addItemToList(Item.book.itemID, 4);
		addItemToList(Item.slimeBall.itemID, 1);
		addItemToList(Item.minecartCrate.itemID, 53);
		addItemToList(Item.minecartPowered.itemID, 53);
		addItemToList(Item.egg.itemID, 1);
		addItemToList(Item.compass.itemID, 37);
		addItemToList(Item.fishingRod.itemID, 3);
		addItemToList(Item.pocketSundial.itemID, 49);
		addItemToList(Item.lightStoneDust.itemID, 1);
		addItemToList(Item.fishRaw.itemID, 1);
		addItemToList(Item.fishCooked.itemID, 1);
		addItemToList(Item.dyePowder.itemID, 1);
		addItemToList(Item.bone.itemID, 1);
		addItemToList(Item.sugar.itemID, 1);
		addItemToList(Item.cake.itemID, 89);
		addItemToList(Item.bed.itemID, 6);
		addItemToList(Item.map.itemID, 45);
		addItemToList(Item.redstoneRepeater.itemID, 4);
		addItemToList(Item.cookie.itemID, 1);
		addItemToList(Item.map.itemID, 45);
		addItemToList(Item.shears.itemID, 18);
		addItemToList(Item.melon.itemID, 1);
		addItemToList(Item.pumpkinSeeds.itemID, 1);
		addItemToList(Item.melonSeeds.itemID, 1);
		addItemToList(Item.beefRaw.itemID, 1);
		addItemToList(Item.beefCooked.itemID, 1);
		addItemToList(Item.chickenRaw.itemID, 1);
		addItemToList(Item.chickenCooked.itemID, 1);
		addItemToList(Item.rottenFlesh.itemID, 1);
		addItemToList(Item.enderPearl.itemID, 64);
		addItemToList(Item.blazeRod.itemID, 8);
		addItemToList(Item.netherStalkSeeds.itemID, 4);
		addItemToBanList(Item.potion.itemID);
		addItemToList(Item.glassBottle.itemID, 1);
		addItemToList(Item.spiderEye.itemID, 1);
		addItemToList(Item.fermentedSpiderEye.itemID, 3);
		addItemToList(Item.blazePowder.itemID, 4);
		addItemToList(Item.magmaCream.itemID, 4);
		addItemToList(Item.brewingStand.itemID, 16);
		addItemToList(Item.cauldron.itemID, 63);
		addItemToList(Item.eyeOfEnder.itemID, 68);
		addItemToList(Item.speckledMelon.itemID, 16);
		addItemToBanList(Item.monsterPlacer.itemID);
		addItemToList(Item.expBottle.itemID, 4);
		addItemToList(Item.fireballCharge.itemID, 4);
		addItemToList(Item.writableBook.itemID, 64);
		addItemToList(Item.writtenBook.itemID, 64);
		addItemToList(Item.emerald.itemID, 16);
		addItemToList(Item.itemFrame.itemID, 9);
		addItemToList(Item.flowerPot.itemID, 1);
		addItemToList(Item.carrot.itemID, 1);
		addItemToList(Item.potato.itemID, 1);
		addItemToList(Item.bakedPotato.itemID, 1);
		addItemToList(Item.poisonousPotato.itemID, 1);
		addItemToList(Item.emptyMap.itemID, 45);
		addItemToList(Item.goldenCarrot.itemID, 16);
		addItemToList(Item.skull.itemID, 1);
		addItemToList(Item.carrotOnAStick.itemID, 4);
		addItemToList(Item.netherStar.itemID, 1024);
		addItemToList(Item.pumpkinPie.itemID, 32);
		addItemToList(Item.firework.itemID, 1);
		addItemToList(Item.fireworkCharge.itemID, 1);
		addItemToBanList(Item.enchantedBook.itemID);
		addItemToList(Item.comparator.itemID, 5);
		addItemToList(Item.netherrackBrick.itemID, 1);
		addItemToList(Item.netherQuartz.itemID, 1);
		addItemToList(Item.minecartTnt.itemID, 6);
		addItemToList(Item.minecartHopper.itemID, 6);
		// This mod items
		addItemToList(GlobalChests.globalChest.blockID, -64, 1);
		addItemToList(GlobalChests.globalLink.itemID, -16, 1);
		addItemToList(GlobalChests.voidStone.itemID, -128, 2);
		
		// Cheat/creative only stuff
		addCheatToList(new ItemStack(GlobalChests.multiItem.itemID, 1, MultiItemReference.VALUE_CHEATSTORAGE));
	}

	/**
	 * Retrieves the weight of the item.
	 * @param par1ItemStack The ItemStack to test the weight for.
	 * @return Weight of the item.
	 */
	public int getItemPrice(ItemStack par1ItemStack) {
		if (par1ItemStack != null) {
			for(int i = 0; i < oreDictStackList.size(); i++){
				List<ItemStack> oreDictItems = OreDictionary.getOres(oreDictStackList.get(i));
				for(int j = 0; j < oreDictItems.size(); j++){
					if(oreDictItems.get(j).isItemEqual(par1ItemStack)){
						return oreDictPriceList.get(i);
					}
				}
			}
			
			if (stackList.contains(par1ItemStack.getItem().itemID)) {
				int index = stackList.indexOf(par1ItemStack.getItem().itemID);
				return priceList.get(index) * par1ItemStack.stackSize;
			} else if (!banList.contains(par1ItemStack.getItem().itemID)) {
				return 0;
			} else {
				return maxWeight + 1;
			}
		}
		return 0;
	}

	/**
	 * Tests to see if the item is banned from the inventory.
	 * @param par1ItemStack The ItemStack to test.
	 * @return Whether the item is banned.
	 */
	public boolean isItemBanned(ItemStack par1ItemStack) {
		for(int i = 0; i < oreDictBanList.size(); i++){
			List<ItemStack> oreDictItems = OreDictionary.getOres(oreDictBanList.get(i));
			for(int j = 0; j < oreDictItems.size(); j++){
				if(oreDictItems.get(j).isItemEqual(par1ItemStack)){
					return true;
				}
			}
		}
		
		return banList.contains(par1ItemStack.getItem().itemID);
	}
	
	/**
	 * Checks if there is a limit on how many items can fit.
	 * @param par1ItemStack The ItemStack to test.
	 * @return Whether the stack is limited.
	 */
	public boolean isItemStackLimited(ItemStack par1ItemStack) {
		if (stackList.contains(par1ItemStack.getItem().itemID)) {
			int index = stackList.indexOf(par1ItemStack.getItem().itemID);
			return stackLimit.get(index) > 0 ? true : false;
		} else {
			return false;
		}
	}

	/**
	 * Gets the limit on how many items can fit.
	 * @param par1ItemStack The ItemStack to test.
	 * @return The limit of the stack.
	 */
	public int getStackLimit(ItemStack par1ItemStack) {
		if (stackList.contains(par1ItemStack.getItem().itemID)) {
			int index = stackList.indexOf(par1ItemStack.getItem().itemID);
			return stackLimit.get(index);
		} else {
			return 0;
		}
	}

	/**
	 * Adds the ID to the list of items.
	 * @param ID The item ID
	 * @param price The item weight
	 */
	public void addItemToList(int ID, int price) {
		stackList.add(ID);
		priceList.add(price);
		stackLimit.add(0);
	}

	/**
	 * Adds the ID and the StackLimit to the list of items.
	 * @param ID The item ID
	 * @param price The item weight
	 */
	public void addItemToList(int ID, int price, int stackLimit) {
		stackList.add(ID);
		priceList.add(price);
		this.stackLimit.add(stackLimit);
	}
	
	/**
	 * The OreDictionary version of addItemToList(int ID, int price).
	 */
	public void addItemToList(String name, int price){
		oreDictStackList.add(name);
		oreDictPriceList.add(price);
	}

	/**
	 * Add an infinite storage item to list
	 * @param is Using itemstacks because it is ideal to be metadata sensitive.
	 */
	public void addCheatToList(ItemStack is){
		cheatItemList.add(is);
	}
	
	/**
	 * Detects the number of a particular number of a certain item in inventory.
	 * @param par1InventoryGlobalChest The inventory to search
	 * @param par2ItemStack The ItemStack containing the item to search for.
	 * @return The number of items.
	 */
	public int getNumOfItemStackInInventory(InventoryGlobalChest par1InventoryGlobalChest, ItemStack par2ItemStack) {
		int returnValue = 0;
		for (int i = 0; i < par1InventoryGlobalChest.getSizeInventory(); i++) {
			ItemStack workingStack = par1InventoryGlobalChest.getStackInSlot(i);
			if (workingStack != null) {
				if (workingStack.getItem().itemID == par2ItemStack.getItem().itemID) {
					returnValue += workingStack.stackSize;
				}
			}
		}
		return returnValue;
	}

	/**
	 * Adds the item to ban list.
	 * @param ID The ID of the item.
	 */
	public void addItemToBanList(int ID) {
		banList.add(ID);
	}
	
	/**
	 * The OreDictionary version of addItemToBanList(int ID)
	 */
	public void addItemToBanList(String name){
		oreDictBanList.add(name);
	}
	
	/**
	 * Checks to see if the item is a cheat item.
	 * @param par1ItemStack The ItemStack to test.
	 * @return If the item is a cheat item.
	 */
	public boolean isItemCheatItem(ItemStack par1ItemStack){
		for(int i = 0; i < cheatItemList.size(); i++){
			if(par1ItemStack != null && par1ItemStack.itemID == cheatItemList.get(i).itemID){
				if(par1ItemStack.getItemDamage() == cheatItemList.get(i).getItemDamage()){
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * Checks if the inventory has a cheat item.
	 * @param inv The inventory.
	 * @return if the cheat item exists in the inventory.
	 */
	public boolean cheatItemExists(InventoryBasic inv){
		for(int i = 0; i < inv.getSizeInventory(); i++){
			for(int j = 0; j < cheatItemList.size(); j++){
				if(inv.getStackInSlot(i) != null){
					if(cheatItemList.get(j).itemID == inv.getStackInSlot(i).itemID){
						if(cheatItemList.get(j).getItemDamage() == inv.getStackInSlot(i).getItemDamage()){
							return true;
						}
					}
				}
			}
		}
		return false;
	}

}
