package fuj1n.globalChestMod.common.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.InventoryEnderChest;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import fuj1n.globalChestMod.common.tileentity.TileEntityGlobalChest;

public class ContainerGlobalChest extends Container{

	protected TileEntityGlobalChest tileEntity;
	public EntityPlayer player;
	
	public InventoryGlobalChest inventory;
	
	public ContainerGlobalChest(EntityPlayer player, TileEntityGlobalChest te){
		this.player = player;
		inventory = new InventoryGlobalChest(player);
		inventory.loadInventory();
		tileEntity = te;
		te.openChest();
		createContainerSlots();
         bindPlayerInventory(player.inventory);
	}
	
	protected void createContainerSlots() {
		int slotIndex = 0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 9; j++) {
				addSlotToContainer(new SlotGlobalChest(inventory, slotIndex, 8 + j * 18, 21 + i * 18, this));
				slotIndex++;
			}
		}
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
	
    public void onInventoryUpdated(){
    	inventory.saveInventory();
    }
    
	@Override
	public boolean canInteractWith(EntityPlayer entityplayer) {
		return tileEntity.isUseableByPlayer(entityplayer);
	}
	
	@Override
	public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int par2)
    {
        ItemStack itemstack = null;
        Slot slot = (Slot)this.inventorySlots.get(par2);

        if (slot != null && slot.getHasStack())
        {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (par2 < 4 * 9)
            {
                if (!this.mergeItemStack(itemstack1, 3 * 9, this.inventorySlots.size(), true))
                {
                    return null;
                }
            }
            else if (!this.mergeItemStack(itemstack1, 0, 3 * 9, false))
            {
                return null;
            }

            if (itemstack1.stackSize == 0)
            {
                slot.putStack((ItemStack)null);
            }
            else
            {
                slot.onSlotChanged();
            }
        }

        return itemstack;
    }
	

}
