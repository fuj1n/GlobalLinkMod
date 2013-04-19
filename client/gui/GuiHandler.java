package fuj1n.globalChestMod.client.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;
import fuj1n.globalChestMod.common.inventory.ContainerGlobalChest;
import fuj1n.globalChestMod.common.tileentity.TileEntityGlobalChest;

public class GuiHandler implements IGuiHandler{

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		switch(ID){
		case 0:
			return new ContainerGlobalChest(player, (TileEntityGlobalChest)world.getBlockTileEntity(x, y, z));
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		switch(ID){
		case 0:
			return new GuiGlobalChest(player, (TileEntityGlobalChest)world.getBlockTileEntity(x, y, z));
		}
		return null;
	}

}
