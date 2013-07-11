package fuj1n.globalLinkMod.common.inventory;

import fuj1n.globalLinkMod.GlobalChests;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

public class InventoryLibraryDecoration extends InventoryBasic{
	
	public ItemStack[] inventoryContents = new ItemStack[this.getSizeInventory()];
	
	public InventoryLibraryDecoration() {
		super("fuj1n.GlobalChests.container.library", false, 27*2);
	}
	
	@Override
    public int getInventoryStackLimit(){
        return GlobalChests.allowDecoStorage ? 64 : 1;
    }
	
	public void readFromNBT(NBTTagCompound par1NBTTagCompound){
		NBTTagList nbttaglist = par1NBTTagCompound.getTagList("Deco");
		this.inventoryContents = new ItemStack[this.getSizeInventory()];

		for (int i = 0; i < nbttaglist.tagCount(); ++i) {
			NBTTagCompound nbttagcompound1 = (NBTTagCompound) nbttaglist.tagAt(i);
			byte b0 = nbttagcompound1.getByte("Slot");

			if (b0 >= 0 && b0 < this.inventoryContents.length) {
				this.inventoryContents[b0] = ItemStack.loadItemStackFromNBT(nbttagcompound1);
			}
		}
	}
	
	public void writeToNBT(NBTTagCompound par1NBTTagCompound){
		NBTTagList nbttaglist = new NBTTagList();

		for (int i = 0; i < this.inventoryContents.length; ++i) {
			if (this.inventoryContents[i] != null) {
				NBTTagCompound nbttagcompound1 = new NBTTagCompound();
				nbttagcompound1.setByte("Slot", (byte) i);
				this.inventoryContents[i].writeToNBT(nbttagcompound1);
				nbttaglist.appendTag(nbttagcompound1);
			}
		}

		par1NBTTagCompound.setTag("Deco", nbttaglist);
	}

}
