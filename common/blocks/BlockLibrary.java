package fuj1n.globalLinkMod.common.blocks;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import fuj1n.globalLinkMod.GlobalChests;
import fuj1n.globalLinkMod.common.tileentity.TileEntityLibrary;
import fuj1n.globalLinkMod.lib.GuiAssistant;

public class BlockLibrary extends BlockContainer {

	public BlockLibrary(int par1) {
		super(par1, Material.wood);
	}

	@Override
	public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9) {
		par5EntityPlayer.openGui(GlobalChests.instance, GuiAssistant.ID_LIBRARY, par1World, par2, par3, par4);
		return true;
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityLibrary();
	}

}
