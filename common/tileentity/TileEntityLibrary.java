package fuj1n.globalChestMod.common.tileentity;

import java.util.ArrayList;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileEntityLibrary extends TileEntity implements IInventory{

	private ArrayList<ItemStack> inventory;
	
	public TileEntityLibrary(){
		inventory = new ArrayList();
	}
	
	@Override
	public void readFromNBT(NBTTagCompound par1NBTTagCompound){
		super.readFromNBT(par1NBTTagCompound);
	}
	
	@Override
	public void writeToNBT(NBTTagCompound par1NBTTagCompound){
		super.writeToNBT(par1NBTTagCompound);
	}
	
	@Override
	public int getSizeInventory() {
		return 0;
	}

	@Override
	public ItemStack getStackInSlot(int i) {
		return inventory.get(i);
	}

	@Override
	public ItemStack decrStackSize(int par1, int par2) {
        if (this.inventory.get(par1) != null)
        {
            ItemStack itemstack;

            if (this.inventory.get(par1).stackSize <= par2)
            {
                itemstack = this.inventory.get(par1);
                this.inventory.set(par1, null);
                this.onInventoryChanged();
                return itemstack;
            }
            else
            {
                itemstack = this.inventory.set(par1, this.inventory.get(par1).splitStack(par2));

                if (this.inventory.get(par1).stackSize == 0)
                {
                	this.inventory.set(par1, null);
                }

                this.onInventoryChanged();
                return itemstack;
            }
        }
        else
        {
            return null;
        }
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int i) {
        if (this.inventory.get(i) != null)
        {
            ItemStack itemstack = this.inventory.get(i);
            this.inventory.set(i, null);
            return itemstack;
        }
        else
        {
            return null;
        }
	}

	@Override
	public void setInventorySlotContents(int par1, ItemStack par2ItemStack) {
		this.inventory.set(par1, par2ItemStack);

        if (par2ItemStack != null && par2ItemStack.stackSize > this.getInventoryStackLimit())
        {
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
		return this.worldObj.getBlockTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? false : par1EntityPlayer.getDistanceSq((double)this.xCoord + 0.5D, (double)this.yCoord + 0.5D, (double)this.zCoord + 0.5D) <= 64.0D;
	}

	@Override
	public void openChest() {}

	@Override
	public void closeChest() {}

	@Override
	public boolean isStackValidForSlot(int i, ItemStack itemstack) {
		int meta = worldObj.getBlockMetadata(this.xCoord, this.yCoord, this.zCoord);
		return meta == 0;
	}

}
