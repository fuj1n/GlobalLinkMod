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
		int itemStackPrice = GlobalChests.globalChestManager.getItemPrice(new ItemStack(par1ItemStack.getItem(), par1ItemStack.stackSize));
		System.out.println(itemStackPrice);
		if(container.totalPrice + itemStackPrice <= GlobalChests.globalChestManager.maxPrice){
			return true;
		}else{
			return false;
		}
    }
	
	@Override
    public void onSlotChanged(){
        super.onSlotChanged();
        container.onInventoryUpdated();
    }

}
