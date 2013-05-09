package fuj1n.globalLinkMod.client.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;
import fuj1n.globalLinkMod.common.inventory.ContainerBookLibrary;
import fuj1n.globalLinkMod.common.inventory.ContainerGlobalChest;
import fuj1n.globalLinkMod.common.inventory.ContainerVoidStone;
import fuj1n.globalLinkMod.common.tileentity.TileEntityGlobalChest;
import fuj1n.globalLinkMod.common.tileentity.TileEntityLibrary;
import fuj1n.globalLinkMod.lib.GuiAssistant;

public class GuiHandler implements IGuiHandler {

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		switch (ID) {
		case GuiAssistant.ID_GLOBALCHEST:
			return new ContainerGlobalChest(player, (TileEntityGlobalChest) world.getBlockTileEntity(x, y, z), false);
		case GuiAssistant.ID_GLOBALCHESTPOCKET:
			return new ContainerGlobalChest(player, (TileEntityGlobalChest) world.getBlockTileEntity(x, y, z), true);
		case GuiAssistant.ID_VOIDSTONE:
			return new ContainerVoidStone(player.inventory);
		case GuiAssistant.ID_LIBRARY:
			return new ContainerBookLibrary(player, (TileEntityLibrary) world.getBlockTileEntity(x, y, z));
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		switch (ID) {
		case GuiAssistant.ID_GLOBALCHEST:
			return new GuiGlobalChest(player, (TileEntityGlobalChest) world.getBlockTileEntity(x, y, z), false);
		case GuiAssistant.ID_GLOBALCHESTPOCKET:
			return new GuiGlobalChest(player, (TileEntityGlobalChest) world.getBlockTileEntity(x, y, z), true);
		case GuiAssistant.ID_VOIDSTONE:
			return new GuiVoidStone(player.inventory);
		case GuiAssistant.ID_LIBRARY:
			return new GuiLibrary(player, (TileEntityLibrary) world.getBlockTileEntity(x, y, z), world.getBlockMetadata(x, y, z));
		}
		return null;
	}

}
