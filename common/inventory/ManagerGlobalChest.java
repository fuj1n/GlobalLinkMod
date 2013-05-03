package fuj1n.globalChestMod.common.inventory;

import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import fuj1n.globalChestMod.GlobalChests;
import fuj1n.globalChestMod.lib.MultiItemReference;

public class ManagerGlobalChest {

	private ArrayList<Integer> stackList = new ArrayList();
	private ArrayList<Integer> priceList = new ArrayList();
	private ArrayList<Integer> banList = new ArrayList();
	
	private ArrayList<ItemStack> cheatItemList = new ArrayList();

	private ArrayList<Integer> stackLimit = new ArrayList();

	public final int maxWeight;

	public ManagerGlobalChest(int par1) {
		maxWeight = par1 > 0 ? par1 : 4096;
		populatePriceList();
	}

	public void populatePriceList() {
		// Blocks
		addItemToList(Block.planks.blockID, 1);
		addItemToList(Block.sapling.blockID, 1);
		addItemToBanList(Block.bedrock.blockID);
		addItemToList(Block.gravel.blockID, 1);
		addItemToBanList(Block.oreIron.blockID);
		addItemToBanList(Block.oreCoal.blockID);
		addItemToList(Block.wood.blockID, 4);
		addItemToBanList(Block.oreLapis.blockID);
		addItemToList(Block.blockLapis.blockID, 9);
		addItemToList(Block.sandStone.blockID, 1);
		addItemToList(Block.music.blockID, 16);
		addItemToBanList(Block.web.blockID);
		addItemToList(Block.cloth.blockID, 4);
		addItemToList(Block.plantRed.blockID, 2);
		addItemToList(Block.plantYellow.blockID, 2);
		addItemToList(Block.mushroomBrown.blockID, 4);
		addItemToList(Block.mushroomRed.blockID, 4);
		addItemToList(Block.blockGold.blockID, 108);
		addItemToList(Block.blockSteel.blockID, 90);
		addItemToList(Block.stoneSingleSlab.blockID, 1);
		addItemToList(Block.brick.blockID, 4);
		addItemToList(Block.tnt.blockID, 10);
		addItemToList(Block.bookShelf.blockID, 15);
		addItemToList(Block.cobblestoneMossy.blockID, 2);
		addItemToList(Block.obsidian.blockID, 4);
		addItemToList(Block.chest.blockID, 8);
		addItemToBanList(Block.oreDiamond.blockID);
		addItemToList(Block.blockDiamond.blockID, 576);
		addItemToList(Block.workbench.blockID, 4);
		addItemToList(Block.furnaceIdle.blockID, 2);
		addItemToList(Block.pressurePlatePlanks.blockID, 6);
		addItemToBanList(Block.oreRedstone.blockID);
		addItemToList(Block.cactus.blockID, 1);
		addItemToList(Block.blockClay.blockID, 4);
		addItemToList(Block.jukebox.blockID, 72);
		addItemToList(Block.fence.blockID, 3);
		addItemToList(Block.slowSand.blockID, 1);
		addItemToList(Block.glowStone.blockID, 4);
		addItemToList(Block.trapdoor.blockID, 6);
		addItemToList(Block.mushroomCapBrown.blockID, 12);
		addItemToList(Block.mushroomCapRed.blockID, 12);
		addItemToList(Block.fenceIron.blockID, 54);
		addItemToList(Block.melon.blockID, 6);
		addItemToList(Block.fenceGate.blockID, 4);
		addItemToList(Block.netherFence.blockID, 3);
		addItemToList(Block.enchantmentTable.blockID, 135);
		addItemToBanList(Block.dragonEgg.blockID);
		addItemToBanList(Block.oreEmerald.blockID);
		addItemToList(Block.enderChest.blockID, 96);
		addItemToList(Block.blockEmerald.blockID, 136);
		addItemToBanList(Block.commandBlock.blockID);
		addItemToBanList(Block.beacon.blockID);
		addItemToList(Block.pressurePlateGold.blockID, 24);
		addItemToList(Block.pressurePlateIron.blockID, 18);
		addItemToList(Block.blockRedstone.blockID, 9);
		addItemToBanList(Block.oreNetherQuartz.blockID);
		// Items
		addItemToList(Item.shovelSteel.itemID, 9);
		addItemToList(Item.pickaxeSteel.itemID, 27);
		addItemToList(Item.axeSteel.itemID, 27);
		addItemToList(Item.flintAndSteel.itemID, 11);
		addItemToList(Item.bow.itemID, 3);
		addItemToList(Item.coal.itemID, 2);
		addItemToList(Item.diamond.itemID, 64);
		addItemToList(Item.ingotIron.itemID, 9);
		addItemToList(Item.ingotGold.itemID, 12);
		addItemToList(Item.swordSteel.itemID, 18);
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
		addItemToList(Item.hoeWood.itemID, 2);
		addItemToList(Item.hoeSteel.itemID, 18);
		addItemToList(Item.hoeDiamond.itemID, 128);
		addItemToList(Item.hoeGold.itemID, 24);
		addItemToList(Item.wheat.itemID, 1);
		addItemToList(Item.bread.itemID, 3);
		addItemToList(Item.helmetSteel.itemID, 45);
		addItemToList(Item.plateSteel.itemID, 72);
		addItemToList(Item.legsSteel.itemID, 63);
		addItemToList(Item.bootsSteel.itemID, 36);
		addItemToList(Item.helmetDiamond.itemID, 320);
		addItemToList(Item.plateDiamond.itemID, 512);
		addItemToList(Item.legsDiamond.itemID, 448);
		addItemToList(Item.bootsDiamond.itemID, 256);
		addItemToList(Item.helmetGold.itemID, 60);
		addItemToList(Item.plateGold.itemID, 96);
		addItemToList(Item.legsGold.itemID, 84);
		addItemToList(Item.bootsGold.itemID, 48);
		addItemToList(Item.flint.itemID, 1);
		addItemToList(Item.appleGold.itemID, 11);
		addItemToList(Item.bucketEmpty.itemID, 27);
		addItemToBanList(Item.bucketWater.itemID);
		addItemToBanList(Item.bucketLava.itemID);
		addItemToList(Item.minecartEmpty.itemID, 45);
		addItemToList(Item.doorSteel.itemID, 54);
		addItemToList(Item.redstone.itemID, 1);
		addItemToList(Item.boat.itemID, 5);
		addItemToList(Item.bucketMilk.itemID, 28);
		addItemToList(Item.brick.itemID, 1);
		addItemToList(Item.clay.itemID, 1);
		addItemToList(Item.reed.itemID, 1);
		addItemToList(Item.paper.itemID, 1);
		addItemToList(Item.book.itemID, 3);
		addItemToList(Item.minecartCrate.itemID, 53);
		addItemToList(Item.minecartPowered.itemID, 53);
		addItemToList(Item.compass.itemID, 37);
		addItemToList(Item.pocketSundial.itemID, 49);
		addItemToList(Item.lightStoneDust.itemID, 1);
		addItemToList(Item.dyePowder.itemID, 1);
		addItemToList(Item.sugar.itemID, 1);
		addItemToList(Item.cake.itemID, 89);
		addItemToList(Item.map.itemID, 45);
		addItemToList(Item.shears.itemID, 18);
		addItemToList(Item.enderPearl.itemID, 64);
		addItemToList(Item.netherStalkSeeds.itemID, 4);
		addItemToBanList(Item.potion.itemID);
		addItemToList(Item.brewingStand.itemID, 2);
		addItemToList(Item.emerald.itemID, 16);
		addItemToList(Item.netherStar.itemID, 1024);
		addItemToBanList(Item.enchantedBook.itemID);
		addItemToList(Item.field_94584_bZ.itemID, 1);
		// This mod items
		addItemToList(GlobalChests.globalChest.blockID, -64, 1);
		addItemToList(GlobalChests.globalLink.itemID, -16, 1);
		addItemToList(GlobalChests.voidStone.itemID, -128, 2);
		
		// Cheat/creative only stuff
		addCheatToList(new ItemStack(GlobalChests.multiItem.itemID, 1, MultiItemReference.VALUE_CHEATSTORAGE));
	}

	public int getItemPrice(ItemStack par1ItemStack) {
		if (par1ItemStack != null) {
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

	public boolean isItemBanned(ItemStack par1ItemStack) {
		return banList.contains(par1ItemStack.getItem().itemID);
	}
	
	public boolean isItemStackLimited(ItemStack par1ItemStack) {
		if (stackList.contains(par1ItemStack.getItem().itemID)) {
			int index = stackList.indexOf(par1ItemStack.getItem().itemID);
			return stackLimit.get(index) > 0 ? true : false;
		} else {
			return false;
		}
	}

	public int getStackLimit(ItemStack par1ItemStack) {
		if (stackList.contains(par1ItemStack.getItem().itemID)) {
			int index = stackList.indexOf(par1ItemStack.getItem().itemID);
			return stackLimit.get(index);
		} else {
			return 0;
		}
	}

	public void addItemToList(int ID, int price) {
		stackList.add(ID);
		priceList.add(price);
		stackLimit.add(0);
	}

	public void addItemToList(int ID, int price, int stackLimit) {
		stackList.add(ID);
		priceList.add(price);
		this.stackLimit.add(stackLimit);
	}

	/**
	 * Add an infinite storage item to list
	 * @param is Using itemstacks because it is ideal to be metadata sensitive.
	 */
	public void addCheatToList(ItemStack is){
		cheatItemList.add(is);
	}
	
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

	public void addItemToBanList(int ID) {
		banList.add(ID);
	}
	
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
