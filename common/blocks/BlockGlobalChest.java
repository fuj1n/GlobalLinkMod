package fuj1n.globalChestMod.common.blocks;

import java.util.Random;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLiving;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import fuj1n.globalChestMod.client.ClientProxyGlobalChests;
import fuj1n.globalChestMod.common.tileentity.TileEntityGlobalChest;

public class BlockGlobalChest extends BlockContainer{
	
	public BlockGlobalChest(int par1){
		super(par1, Material.iron);
		this.setBlockBounds(0.0625F, 0.0F, 0.0625F, 0.9375F, 0.875F, 0.9375F);
	}
	
	@Override
	public boolean isOpaqueCube(){
		return false;
	}
	
	@Override
	public boolean renderAsNormalBlock(){
		return false;
	}
	
	@Override
    public int getRenderType(){
        return ClientProxyGlobalChests.GlobalChestRenderId;
    }

	@Override
    public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLiving par5EntityLiving, ItemStack par6ItemStack)
    {
        byte b0 = 0;
        int l = MathHelper.floor_double((double)(par5EntityLiving.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

        if (l == 0)
        {
            b0 = 2;
        }

        if (l == 1)
        {
            b0 = 5;
        }

        if (l == 2)
        {
            b0 = 3;
        }

        if (l == 3)
        {
            b0 = 4;
        }

        par1World.setBlockMetadataWithNotify(par2, par3, par4, b0, 2);
    }
	
    public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random par5Random)
    {
    	if(par5Random.nextInt(2) == 0){
			for (int l = 0; l < 3; ++l) {
				double d0 = (double) ((float) par2 + par5Random.nextFloat());
				double d1 = (double) ((float) par3 + par5Random.nextFloat());
				d0 = (double) ((float) par4 + par5Random.nextFloat());
				double d2 = 0.0D;
				double d3 = 0.0D;
				double d4 = 0.0D;
				int i1 = par5Random.nextInt(2) * 2 - 1;
				int j1 = par5Random.nextInt(2) * 2 - 1;
				d2 = ((double) par5Random.nextFloat() - 0.5D) * 0.125D;
				d3 = ((double) par5Random.nextFloat() - 0.5D) * 0.125D;
				d4 = ((double) par5Random.nextFloat() - 0.5D) * 0.125D;
				double d5 = (double) par4 + 0.5D + 0.25D * (double) j1;
				d4 = (double) (par5Random.nextFloat() * 1.0F * (float) j1);
				double d6 = (double) par2 + 0.5D + 0.25D * (double) i1;
				d2 = (double) (par5Random.nextFloat() * 1.0F * (float) i1);
				par1World.spawnParticle("enchantmenttable", d6, d1, d5, d2, d3,
						d4);
			}
    	}
    }
	
	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityGlobalChest();
	}

}
