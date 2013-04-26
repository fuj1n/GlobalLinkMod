package fuj1n.globalChestMod.common.inventory;

import fuj1n.globalChestMod.GlobalChests;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotGlobalChest extends Slot{

	ContainerGlobalChest container;
	
	public SlotGlobalChest(IInventory par1IInventory, int par2, int par3, int par4, ContainerGlobalChest par5Container) {
		super(par1IInventory, par2, par3, par4);
		container = par5Container;
	}
	
	@Override
    public boolean isItemValid(ItemStack par1ItemStack)
    {
		int itemStackPrice = GlobalChests.globalChestManager.getItemPrice(par1ItemStack);
		int stackLimit = GlobalChests.globalChestManager.getStackLimit(par1ItemStack);
		int numOfStack = GlobalChests.globalChestManager.getNumOfItemStackInInventory(container.inventory, par1ItemStack);
		
		if(GlobalChests.globalChestManager.isItemBanned(par1ItemStack)){
			return false;
		}else if(numOfStack + par1ItemStack.stackSize > stackLimit && stackLimit > 0){
			return false;
		}else if(container.totalPrice + itemStackPrice <= GlobalChests.globalChestManager.maxWeight){
			return true;
		}else{
			return false;
		}
    }
	
	public boolean isItemValidToLeave(ItemStack par1ItemStack){
		return true;
	}
	
	@Override
    public void onSlotChanged(){
        super.onSlotChanged();
        container.onInventoryUpdated();
    }

}
