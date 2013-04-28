package fuj1n.globalChestMod.common.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerVoidStone extends Container {

	private int rows = 3;
	private int cols = 3;

	private int firstSlotX = 15;
	private int firstSlotY = 21;

	public int middleSlotX = firstSlotX;
	public int middleSlotY = firstSlotY;

	private InventoryBasic voidInventory = new InventoryBasic("void", false, rows * cols);

	public ContainerVoidStone(InventoryPlayer par1InventoryPlayer) {
		firstSlotX = 62;
		addContainerSlots();
		bindPlayerInventory(par1InventoryPlayer);
	}

	protected void addContainerSlots() {
		int currentSlot = 0;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (currentSlot == Math.ceil(rows * cols / 2)) {
					middleSlotX = firstSlotX + j * 18;
					middleSlotY = firstSlotY + i * 18;
					currentSlot++;
				} else {
					this.addSlotToContainer(new Slot(voidInventory, currentSlot, firstSlotX + j * 18, firstSlotY + i * 18));
					currentSlot++;
				}
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

	@Override
	public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int par2) {
		ItemStack itemstack = null;
		Slot slot = (Slot) inventorySlots.get(par2);

		if (slot != null && slot.getHasStack()) {
			ItemStack itemstack1 = slot.getStack();
			itemstack = itemstack1.copy();

			if (par2 < 4 * 9) {
				if (!this.mergeItemStack(itemstack1, rows * cols, inventorySlots.size(), true)) {
					return null;
				}
			} else if (!this.mergeItemStack(itemstack1, 0, rows * cols, false)) {
				return null;
			}

			if (itemstack1.stackSize == 0) {
				slot.putStack((ItemStack) null);
			} else {
				slot.onSlotChanged();
			}
		}

		return itemstack;
	}

	@Override
	public boolean canInteractWith(EntityPlayer entityplayer) {
		return true;
	}

}
