package fuj1n.globalChestMod.common.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import fuj1n.globalChestMod.common.tileentity.TileEntityLibrary;

public class ContainerBookLibrary extends Container{

	/* TODO */ public InventoryGlobalChest inventoryGlobal;
	
	public TileEntityLibrary tileEntity;
	
	public ContainerBookLibrary(EntityPlayer par1EntityPlayer, TileEntityLibrary par2Library){
		tileEntity = par2Library;
		bindPlayerInventory(par1EntityPlayer.inventory);
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer entityplayer) {
		return tileEntity.isUseableByPlayer(entityplayer);
	}

	protected void bindPlayerInventory(InventoryPlayer inventoryPlayer) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 9; j++) {
				addSlotToContainer(new Slot(inventoryPlayer, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
			}
		}

		for (int i = 0; i < 9; i++) {
			addSlotToContainer(new Slot(inventoryPlayer, i, 8 + i * 18, 142));
		}
	}
	
	
	
}
