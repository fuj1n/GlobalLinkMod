package fuj1n.globalLinkMod.common.inventory;

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
        return 1;
    }
	
	public void readFromNBT(NBTTagCompound par1NBTTagCompound){
		NBTTagList tagList = par1NBTTagCompound.getTagList("Decorations");
		inventoryContents = new ItemStack[this.getSizeInventory()];
		System.out.println("Read Got" + tagList.tagCount());
		for(int i = 0; i < tagList.tagCount(); i++){
			NBTTagCompound nbttagcompound1 = (NBTTagCompound) tagList.tagAt(i);
			
			byte b0 = nbttagcompound1.getByte("Slot");
			System.out.println("Get" + b0);
			if (b0 >= 0 && b0 < inventoryContents.length) {
				inventoryContents[b0] = ItemStack.loadItemStackFromNBT(nbttagcompound1);
			}
		}
		
	}
	
	public void writeToNBT(NBTTagCompound par1NBTTagCompound){
		NBTTagList tagList = new NBTTagList();
		System.out.println("Write Got" + inventoryContents.length);
		for (int i = 0; i < inventoryContents.length; i++) {
			if (inventoryContents[i] != null) {
				NBTTagCompound nbttagcompound1 = new NBTTagCompound();
				nbttagcompound1.setByte("Slot", (byte) i);
				System.out.println("Send" + (byte) i);
				inventoryContents[i].writeToNBT(nbttagcompound1);
				tagList.appendTag(nbttagcompound1);
			}
		}

		par1NBTTagCompound.setTag("Decorations", tagList);
	}

}
