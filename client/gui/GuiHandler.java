package fuj1n.globalChestMod.client.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;
import fuj1n.globalChestMod.common.inventory.ContainerBookLibrary;
import fuj1n.globalChestMod.common.inventory.ContainerGlobalChest;
import fuj1n.globalChestMod.common.inventory.ContainerVoidStone;
import fuj1n.globalChestMod.common.tileentity.TileEntityGlobalChest;
import fuj1n.globalChestMod.common.tileentity.TileEntityLibrary;
import fuj1n.globalChestMod.lib.GuiAssistant;

public class GuiHandler implements IGuiHandler {

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		switch (ID) {
		case GuiAssistant.ID_GLOBALCHEST:
			return new ContainerGlobalChest(player, (TileEntityGlobalChest) world.getBlockTileEntity(x, y, z));
		case GuiAssistant.ID_VOIDSTONE:
			return new ContainerVoidStone(player.inventory);
		case GuiAssistant.ID_LIBRARY:
			return new ContainerBookLibrary(player, (TileEntityLibrary)world.getBlockTileEntity(x, y, z));
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		switch (ID) {
		case GuiAssistant.ID_GLOBALCHEST:
			return new GuiGlobalChest(player, (TileEntityGlobalChest) world.getBlockTileEntity(x, y, z));
		case GuiAssistant.ID_VOIDSTONE:
			return new GuiVoidStone(player.inventory);
		case GuiAssistant.ID_LIBRARY:
			return new GuiLibrary(player, (TileEntityLibrary)world.getBlockTileEntity(x, y, z), world.getBlockMetadata(x, y, z));
		}
		return null;
	}

}
