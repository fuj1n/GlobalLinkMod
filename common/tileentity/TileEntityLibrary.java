package fuj1n.globalLinkMod.common.tileentity;

import java.util.ArrayList;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet132TileEntityData;
import net.minecraft.tileentity.TileEntity;
import fuj1n.globalLinkMod.common.inventory.InventoryLibraryDecoration;
import fuj1n.globalLinkMod.lib.BookLibraryReference;

public class TileEntityLibrary extends TileEntity implements IInventory {

	public InventoryLibraryDecoration decoInventory;
	private ArrayList<ItemStack> inventory;
	
	public TileEntityLibrary() {
		inventory = new ArrayList();
		decoInventory = new InventoryLibraryDecoration();
	}

	@Override
	public void readFromNBT(NBTTagCompound par1NBTTagCompound) {
		super.readFromNBT(par1NBTTagCompound);
		decoInventory.readFromNBT(par1NBTTagCompound);
	}

	@Override
	public void writeToNBT(NBTTagCompound par1NBTTagCompound) {
		super.writeToNBT(par1NBTTagCompound);
		decoInventory.writeToNBT(par1NBTTagCompound);
	}

	@Override
    public Packet getDescriptionPacket(){
		NBTTagCompound var1NBTTagCompound = new NBTTagCompound();
		writeToNBT(var1NBTTagCompound);
        return new Packet132TileEntityData(xCoord, yCoord, zCoord, 0, var1NBTTagCompound);
    }
	
	@Override
	public void onDataPacket(INetworkManager net, Packet132TileEntityData pkt){
		readFromNBT(pkt.customParam1);
		
		worldObj.markBlockForRenderUpdate(xCoord, yCoord, zCoord);
	}
	
	@Override
	public int getSizeInventory() {
		return inventory.size();
	}

	@Override
	public ItemStack getStackInSlot(int i) {
		return inventory.get(i);
	}

	@Override
	public ItemStack decrStackSize(int par1, int par2) {
		if (inventory.get(par1) != null) {
			ItemStack itemstack;

			if (inventory.get(par1).stackSize <= par2) {
				itemstack = inventory.get(par1);
				inventory.set(par1, null);
				this.onInventoryChanged();
				return itemstack;
			} else {
				itemstack = inventory.set(par1, inventory.get(par1).splitStack(par2));

				if (inventory.get(par1).stackSize == 0) {
					inventory.set(par1, null);
				}

				this.onInventoryChanged();
				return itemstack;
			}
		} else {
			return null;
		}
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int i) {
		if (inventory.get(i) != null) {
			ItemStack itemstack = inventory.get(i);
			inventory.set(i, null);
			return itemstack;
		} else {
			return null;
		}
	}

	@Override
	public void setInventorySlotContents(int par1, ItemStack par2ItemStack) {
		inventory.set(par1, par2ItemStack);

		if (par2ItemStack != null && par2ItemStack.stackSize > this.getInventoryStackLimit()) {
			par2ItemStack.stackSize = this.getInventoryStackLimit();
		}

		this.onInventoryChanged();

	}

	@Override
	public String getInvName() {
		return "fuj1n.globalChests.inventoryLibrary";
	}

	@Override
	public boolean isInvNameLocalized() {
		return false;
	}

	@Override
	public int getInventoryStackLimit() {
		return 64;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer par1EntityPlayer) {
		return worldObj.getBlockTileEntity(xCoord, yCoord, zCoord) != this ? false : par1EntityPlayer.getDistanceSq(xCoord + 0.5D, yCoord + 0.5D, zCoord + 0.5D) <= 64.0D;
	}

	@Override
	public void openChest() {
	}

	@Override
	public void closeChest() {
	}

	@Override
	public boolean isItemValidForSlot(int i, ItemStack itemstack) {
		int meta = worldObj.getBlockMetadata(xCoord, yCoord, zCoord);
		return meta == 0 && BookLibraryReference.books.contains(itemstack.getItem());
	}

}
