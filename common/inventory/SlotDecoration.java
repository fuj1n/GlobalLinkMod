package fuj1n.globalLinkMod.common.inventory;

import fuj1n.globalLinkMod.GlobalChests;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotDecoration extends Slot{

	public SlotDecoration(IInventory par1iInventory, int par2, int par3, int par4) {
		super(par1iInventory, par2, par3, par4);
	}
	
	@Override
	public boolean isItemValid(ItemStack par1ItemStack){
		return par1ItemStack.itemID == GlobalChests.decoBook.itemID;
	}

}
