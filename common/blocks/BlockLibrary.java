package fuj1n.globalLinkMod.common.blocks;

import java.util.HashMap;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import fuj1n.globalLinkMod.GlobalChests;
import fuj1n.globalLinkMod.client.ClientProxyGlobalChests;
import fuj1n.globalLinkMod.common.tileentity.TileEntityLibrary;
import fuj1n.globalLinkMod.lib.DecoBookReference;
import fuj1n.globalLinkMod.lib.GuiAssistant;

public class BlockLibrary extends BlockContainer {
	
	public HashMap<String, Icon> bookIcons;
	private Icon[] blockIcons;
	
	public BlockLibrary(int par1) {
		super(par1, Material.wood);
		blockIcons = new Icon[3];
	}

	@Override
	public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9) {
		par5EntityPlayer.openGui(GlobalChests.instance, GuiAssistant.ID_LIBRARY, par1World, par2, par3, par4);
		return true;
	}
	
	@Override
	public Icon getIcon(int par1, int par2){
		switch(par1){
		case 0:
			return Block.planks.getIcon(par1, 0);
		case 1:
			return Block.planks.getIcon(par1, 0);
		default:
			return this.blockIcons[par2 < blockIcons.length ? par2 : 0];
		}
	}
	
	@Override
	public void registerIcons(IconRegister par1IconRegister){
		this.blockIcons[0] = par1IconRegister.registerIcon("globalChestMod:fuj1n.GlobalChests.bookLibrary");
		this.blockIcons[1] = par1IconRegister.registerIcon("globalChestMod:fuj1n.GlobalChests.bookLibrary_ender");
		this.blockIcons[2] = par1IconRegister.registerIcon("globalChestMod:fuj1n.GlobalChests.bookLibrary_global");
		
		bookIcons = new HashMap<String, Icon>();
		
		DecoBookReference.registerBookIcons(par1IconRegister, bookIcons);
	}

	@Override
	public int getRenderType(){
		return ClientProxyGlobalChests.LibraryRenderId;
	}
	
	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityLibrary();
	}

}
