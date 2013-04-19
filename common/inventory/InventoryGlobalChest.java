package fuj1n.globalChestMod.common.inventory;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;
import fuj1n.globalChestMod.GlobalChests;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.inventory.InventoryEnderChest;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.EnumGameType;

public class InventoryGlobalChest extends InventoryBasic{

	public EntityPlayer thePlayer;
	public NBTTagCompound nbt;
	public EnumGameType gamemode;
	
	
	public InventoryGlobalChest(EntityPlayer par1EntityPlayer) {
		super("fuj1n.GlobalChests.container.globalChest", false, 27);
		thePlayer = par1EntityPlayer;
		gamemode = getPlayerGameMode();
	}
	
	public void loadInventory() {
		switch (gamemode) {
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
		if (nbt == null) {
			nbt = new NBTTagCompound();
		}

		NBTTagList tagList = nbt.getTagList("inventory");
		int i;

		for (i = 0; i < this.getSizeInventory(); ++i) {
			this.setInventorySlotContents(i, (ItemStack) null);
		}

		for (i = 0; i < tagList.tagCount(); ++i) {
			NBTTagCompound nbttagcompound = (NBTTagCompound) tagList.tagAt(i);
			int j = nbttagcompound.getByte("Slot") & 255;

			if (j >= 0 && j < this.getSizeInventory()) {
				this.setInventorySlotContents(j,
						ItemStack.loadItemStackFromNBT(nbttagcompound));
			}
		}
	}
	
	public void saveInventory(){
		if (nbt != null) {
			NBTTagList nbttaglist = new NBTTagList();

			for (int i = 0; i < this.getSizeInventory(); ++i) {
				ItemStack itemstack = this.getStackInSlot(i);

				if (itemstack != null) {
					NBTTagCompound nbttagcompound = new NBTTagCompound();
					nbttagcompound.setByte("Slot", (byte) i);
					itemstack.writeToNBT(nbttagcompound);
					nbttaglist.appendTag(nbttagcompound);
				}
			}
			nbt.setTag("inventory", nbttaglist);
			switch (gamemode) {
			case SURVIVAL:
				GlobalChests.chestNBTSurvival.saveNBTData(nbt);
				break;
			case ADVENTURE:
				GlobalChests.chestNBTAdventure.saveNBTData(nbt);
				break;
			case CREATIVE:
				GlobalChests.chestNBTCreative.saveNBTData(nbt);
				break;
			default:
				GlobalChests.chestNBTSurvival.saveNBTData(nbt);
				break;
			}
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
