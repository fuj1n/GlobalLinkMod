package fuj1n.globalChestMod.common.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import fuj1n.globalChestMod.GlobalChests;

public class SlotGlobalChest extends Slot {

	ContainerGlobalChest container;

	public SlotGlobalChest(IInventory par1IInventory, int par2, int par3, int par4, ContainerGlobalChest par5Container) {
		super(par1IInventory, par2, par3, par4);
		container = par5Container;
	}

	@Override
	public boolean isItemValid(ItemStack par1ItemStack) {
		int itemStackPrice = GlobalChests.globalChestManager.getItemPrice(par1ItemStack);
		int stackLimit = GlobalChests.globalChestManager.getStackLimit(par1ItemStack);
		int numOfStack = GlobalChests.globalChestManager.getNumOfItemStackInInventory(container.inventory, par1ItemStack);

		if(GlobalChests.globalChestManager.isItemCheatItem(par1ItemStack)){
			return true;
		}
		
		if(GlobalChests.globalChestManager.cheatItemExists(container.inventory)){
			return true;
		}
		
		if (GlobalChests.globalChestManager.isItemBanned(par1ItemStack)) {
			return false;
		} else if (numOfStack + par1ItemStack.stackSize > stackLimit && stackLimit > 0) {
			return false;
		} else if (container.totalPrice + itemStackPrice <= GlobalChests.globalChestManager.maxWeight) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean canTakeStack(EntityPlayer par1EntityPlayer) {
		ItemStack itemstack = inventory.getStackInSlot(slotNumber);
		int itemStackPrice = GlobalChests.globalChestManager.getItemPrice(itemstack);
		
		if(GlobalChests.globalChestManager.isItemCheatItem(itemstack)){
			if(GlobalChests.globalChestManager.maxWeight < container.totalPrice){
				return false;
			}
		}
		
		if(GlobalChests.globalChestManager.cheatItemExists(container.inventory)){
			return true;
		}
		
		if (itemStackPrice < 0) {
			if (container.totalPrice - itemStackPrice > GlobalChests.globalChestManager.maxWeight) {
				return false;
			} else {
				return true;
			}
		} else {
			return true;
		}
	}

	@Override
	public void onSlotChanged() {
		super.onSlotChanged();
		container.onInventoryUpdated();
	}

}
