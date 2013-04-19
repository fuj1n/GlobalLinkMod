package fuj1n.globalChestMod.common.inventory;

import fuj1n.globalChestMod.GlobalChests;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.world.EnumGameType;

public class InventoryGlobalChest extends InventoryBasic{

	public EntityPlayer thePlayer;
	public NBTTagCompound nbt;
	
	
	public InventoryGlobalChest(EntityPlayer par1EntityPlayer) {
		super("fuj1n.GlobalChests.container.globalChest", false, 27);
		thePlayer = par1EntityPlayer;
	}
	
	public void loadInventory(){
		NBTTagCompound nbt;
		EnumGameType gamemode = getPlayerGameMode();
		
		switch(gamemode){
		case SURVIVAL:
			nbt = GlobalChests.chestNBTSurvival.getNBTTagCompound();
			break;
		case ADVENTURE:
			nbt = GlobalChests.chestNBTAdventure.getNBTTagCompound();
			break;
		case CREATIVE:
			nbt = GlobalChests.chestNBTCreative.getNBTTagCompound();
			break;
		default:
			nbt = GlobalChests.chestNBTSurvival.getNBTTagCompound();
			break;
		}
		
		if(nbt != null){
			this.nbt = nbt;
			NBTTagList tagList = nbt.getTagList("inventory");
	        int i;

	        for (i = 0; i < this.getSizeInventory(); ++i)
	        {
	            this.setInventorySlotContents(i, (ItemStack)null);
	        }

	        for (i = 0; i < tagList.tagCount(); ++i)
	        {
	            NBTTagCompound nbttagcompound = (NBTTagCompound)tagList.tagAt(i);
	            int j = nbttagcompound.getByte("Slot") & 255;

	            if (j >= 0 && j < this.getSizeInventory())
	            {
	                this.setInventorySlotContents(j, ItemStack.loadItemStackFromNBT(nbttagcompound));
	            }
	        }
		}
		
	}
	
	public void saveInventory(){
		if(nbt != null){
	        NBTTagList nbttaglist = new NBTTagList();

	        for (int i = 0; i < this.getSizeInventory(); ++i)
	        {
	            ItemStack itemstack = this.getStackInSlot(i);

	            if (itemstack != null)
	            {
	                NBTTagCompound nbttagcompound = new NBTTagCompound();
	                nbttagcompound.setByte("Slot", (byte)i);
	                itemstack.writeToNBT(nbttagcompound);
	                nbttaglist.appendTag(nbttagcompound);
	            }
	        }
	        nbt.setTag("inventory", nbttaglist);
		}
	}
	
	public EnumGameType getPlayerGameMode(){
		
		if(thePlayer.capabilities.isCreativeMode){
			return EnumGameType.CREATIVE;
		}else if(!thePlayer.capabilities.allowEdit){
			return EnumGameType.ADVENTURE;
		}else{
			return EnumGameType.SURVIVAL;
		}
	}

}
