package fuj1n.globalChestMod.common.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import fuj1n.globalChestMod.common.tileentity.TileEntityGlobalChest;

public class ContainerGlobalChest extends Container{

	protected TileEntityGlobalChest tileEntity;
	
	public ContainerGlobalChest(InventoryPlayer inventoryPlayer, TileEntityGlobalChest te){
		tileEntity = te;
         bindPlayerInventory(inventoryPlayer);
	}
	
	protected void createContainerSlots(){
		
	}
	
    protected void bindPlayerInventory(InventoryPlayer inventoryPlayer) {
        for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 9; j++) {
                        addSlotToContainer(new Slot(inventoryPlayer, j + i * 9 + 9,
                                        8 + j * 18, 84 + i * 18));
                }
        }

        for (int i = 0; i < 9; i++) {
                addSlotToContainer(new Slot(inventoryPlayer, i, 8 + i * 18, 142));
        }
    }
	
	@Override
	public boolean canInteractWith(EntityPlayer entityplayer) {
		return tileEntity.isUseableByPlayer(entityplayer);
	}

}
