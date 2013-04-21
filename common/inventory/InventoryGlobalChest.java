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
			nbt = GlobalChests.globalChestSurvival;
			break;
		case ADVENTURE:
			nbt = GlobalChests.globalChestAdventure;
			break;
		case CREATIVE:
			nbt = GlobalChests.globalChestCreative;
			break;
		default:
			nbt = GlobalChests.globalChestMisc;
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
				GlobalChests.globalChestSurvival = nbt;
				break;
			case ADVENTURE:
				GlobalChests.globalChestAdventure = nbt;
				break;
			case CREATIVE:
				GlobalChests.globalChestCreative = nbt;
				break;
			default:
				GlobalChests.globalChestMisc = nbt;
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
