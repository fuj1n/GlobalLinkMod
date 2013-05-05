package fuj1n.globalChestMod.common.blocks;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import fuj1n.globalChestMod.client.ClientProxyGlobalChests;
import fuj1n.globalChestMod.common.tileentity.TileEntitySatLink;

public class BlockSatLink extends BlockMultiBlock{

	public BlockSatLink(int par1) {
		super(par1, Material.iron, new int[]{1, 2, 1}, false);
	}

	@Override
	public boolean isOpaqueCube(){
		return false;
	}
	
	@Override
	public boolean renderAsNormalBlock(){
		return false;
	}
	
	//@Override
	//public Icon getIcon(int par1, int par2){
	//	return Block.blockIron.getIcon(par1, par2);
	//}
	
	//@Override
	//public void registerIcons(IconRegister par1IconRegister){}
	
	@Override
	public int getRenderType(){
		return ClientProxyGlobalChests.SatLinkRenderId;
	}
	
	@Override
    public AxisAlignedBB getSelectedBoundingBoxFromPool(World par1World, int par2, int par3, int par4){
		if(par1World.getBlockMetadata(par2, par3, par4) == 1){
			return AxisAlignedBB.getAABBPool().getAABB((double)par2 + this.minX, (double)par3 + this.minY, (double)par4 + this.minZ, (double)par2 + this.maxX, (double)par3 + 0.1F, (double)par4 + this.maxZ);
		}
        return AxisAlignedBB.getAABBPool().getAABB((double)par2 + this.minX, (double)par3 + this.minY, (double)par4 + this.minZ, (double)par2 + this.maxX, (double)par3 + this.maxY, (double)par4 + this.maxZ);
    }
	
	@Override
	public boolean isBlockValidMultiBlockController(World par1World, int par2, int par3, int par4) {
		return par1World.getBlockMetadata(par2, par3, par4) != 2;
	}
	
	@Override
	public boolean canFormMultiBlock(World par1World, int par2, int par3, int par4) {
		if(par1World.getBlockMetadata(par2, par3, par4) != 2){
			if(par1World.getBlockId(par2, par3 + 1, par4) == this.blockID){
				if(par1World.getBlockId(par2, par3 - 1, par4) != this.blockID){
					return true;
				}
			}
		}
		return false;
	}
	
	@Override
	public void formMultiBlock(World par1World, int par2, int par3, int par4) {
		TileEntitySatLink te = (TileEntitySatLink)par1World.getBlockTileEntity(par2, par3, par4);
		if(te == null){
			te = (TileEntitySatLink)this.createNewTileEntity(par1World);
		}
		te.isMultiblockFormed = true;
		par1World.setBlockMetadataWithNotify(par2, par3, par4, 1, 2);
		par1World.setBlockTileEntity(par2, par3, par4, te);
		par1World.setBlockMetadataWithNotify(par2, par3 + 1, par4, 2, 2);
		par1World.setBlockTileEntity(par2, par3, par4, te);
		
	}
	
	@Override
	public void breakMultiBlock(World par1World, int par2, int par3, int par4) {
		TileEntitySatLink te = (TileEntitySatLink)par1World.getBlockTileEntity(par2, par3, par4);
		if(te == null){
			te = (TileEntitySatLink)this.createNewTileEntity(par1World);
		}
		te.isMultiblockFormed = false;
		int block1 = par1World.getBlockId(par2, par3, par4);
		int block2 = par1World.getBlockId(par2, par3 + 1, par4);
		int meta1 = par1World.getBlockMetadata(par2, par3, par4);
		int meta2 = par1World.getBlockMetadata(par2, par3 + 1, par4);
		par1World.setBlockMetadataWithNotify(par2, par3, par4, 0, 2);
		par1World.setBlockMetadataWithNotify(par2, par3 + 1, par4, 0, 2);
		if(Block.blocksList[block1] != null){
			par1World.setBlockTileEntity(par2, par3, par4, te);
		}
		if(Block.blocksList[block2] != null){
			par1World.setBlockTileEntity(par2, par3 + 1, par4, Block.blocksList[block2].createTileEntity(par1World, meta2));
		}
	}
	
	@Override
    public void breakBlock(World par1World, int par2, int par3, int par4, int par5, int par6){
        if(par1World.getBlockMetadata(par2, par3, par4) == 1){
        	this.breakMultiBlock(par1World, par2, par3, par4);
        }
    }
	
    @Override
	public boolean isMultiBlockCustomShaped(){
		return true;
	}

	@Override
    public void setBlockBoundsBasedOnState(IBlockAccess par1IBlockAccess, int par2, int par3, int par4) {
		int meta = par1IBlockAccess.getBlockMetadata(par2, par3, par4);
		switch(meta){
		case 0:
			this.setBlockBounds(0.4F, 0.0F, 0.4F, 0.6F, 1.0F, 0.6F);
			break;
		case 1:
			this.setBlockBounds(0.0F, 0.0F, 0.0F, 1F, 1.0F, 1F);
			break;
		case 2:
			this.setBlockBounds(0.4F, 0.0F, 0.4F, 0.6F, 0.6F, 0.6F);
			break;
		default:
			this.setBlockBounds(0F, 0F, 0F, 1F, 1F, 1F);
		}
	}
	
	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntitySatLink();
	}
	
	@Override
    public void addCollisionBoxesToList(World par1World, int par2, int par3, int par4, AxisAlignedBB par5AxisAlignedBB, List par6List, Entity par7Entity){
        if(par1World.getBlockMetadata(par2, par3, par4) == 1){
        	this.setBlockBounds(0.4F, 0.0F, 0.4F, 0.6F, 1.0F, 0.6F);
        }else{
        	this.setBlockBoundsBasedOnState(par1World, par2, par3, par4);
        }
        super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6List, par7Entity);
        int meta = par1World.getBlockMetadata(par2, par3, par4);
        if(meta == 1){
        	this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.1F, 1.0F);
        	super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6List, par7Entity);
        }
        this.setBlockBoundsForItemRender();
    }

}
