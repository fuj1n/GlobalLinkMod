package fuj1n.globalChestMod.common.items;

import fuj1n.globalChestMod.GlobalChests;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AABBPool;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class ItemPocketLink extends Item{

	public ItemPocketLink(int par1) {
		super(par1);
	}
	
	@Override
    public EnumRarity getRarity(ItemStack par1ItemStack){
        return EnumRarity.epic;
    }
	
	@Override
    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer){
		int range = GlobalChests.maxPocketLinkRange;
		boolean flag1 = isBlockInBB(AxisAlignedBB.getBoundingBox(par3EntityPlayer.posX - range, par3EntityPlayer.posY - range, par3EntityPlayer.posZ - range, par3EntityPlayer.posX + range, par3EntityPlayer.posY + range, par3EntityPlayer.posZ + range), par2World, GlobalChests.globalChest.blockID, false, 0);
        System.out.println(flag1);
		return par1ItemStack;
    }
	
	/**
	 * Checks if a specified block exists within the provided BB
	 * @param par1AxisAlignedBB The bounding box to look within
	 * @param par2World The world object
	 * @param par3 The block ID to search for
	 * @param flag1 Is the block metadata sensitive
	 * @param par4 If the block is metadata sensitive, specify the metadata to look for.
	 * @return Whether the block exists within the AABB.
	 */
    public boolean isBlockInBB(AxisAlignedBB par1AxisAlignedBB, World par2World, int par3, boolean flag1, int par4){
        int i = MathHelper.floor_double(par1AxisAlignedBB.minX);
        int j = MathHelper.floor_double(par1AxisAlignedBB.maxX + 1.0D);
        int k = MathHelper.floor_double(par1AxisAlignedBB.minY);
        int l = MathHelper.floor_double(par1AxisAlignedBB.maxY + 1.0D);
        int i1 = MathHelper.floor_double(par1AxisAlignedBB.minZ);
        int j1 = MathHelper.floor_double(par1AxisAlignedBB.maxZ + 1.0D);

        for (int k1 = i; k1 < j; ++k1)
        {
            for (int l1 = k; l1 < l; ++l1)
            {
                for (int i2 = i1; i2 < j1; ++i2)
                {
                    Block block = Block.blocksList[par2World.getBlockId(k1, l1, i2)];

                    if (block != null && block.blockID == par3 && (!flag1 || par2World.getBlockMetadata(k1, l1, i2) == par4))
                    {
                        return true;
                    }
                }
            }
        }

        return false;
    }
	
	/**
	 * Finds the nearest block to player.
	 * @param par1 The block Id to find
	 * @param par2World The world object
	 * @param par3EntityPlayer The player to search around
	 * @param par4 The range of the search
	 * @param flag1 Is the block metadata sensitive
	 * @param par5 If the block is metadata sensitive, specify the metadata to look for.
	 * @return The coordinates in the form of an int array (returns 0 if nothing is found).
	 * @deprecated Causes a temporary ANR, not completely working.
	 */
	public int[] findNearestBlock(int par1, World par2World, EntityPlayer par3EntityPlayer, int par4, boolean flag1, int par5){
		if(par2World.getBlockId((int)par3EntityPlayer.posX, (int)par3EntityPlayer.posY, (int)par3EntityPlayer.posZ) == par1 && (!flag1 || par2World.getBlockMetadata((int)par3EntityPlayer.posX, (int)par3EntityPlayer.posY, (int)par3EntityPlayer.posZ) == par5)){
			return new int[]{(int)par3EntityPlayer.posX, (int)par3EntityPlayer.posY, (int)par3EntityPlayer.posZ};
		}else{
			for(int i = 0; i <= par4; i++){
				for(int k = 0; k <= par4; k++){
					for(int j = 0; j < par4; j++){
						System.out.println("In");
						if(par3EntityPlayer.posY + j < 256){
							if(par2World.getBlockId((int)par3EntityPlayer.posX + i, (int)par3EntityPlayer.posY + j, (int)par3EntityPlayer.posZ + k) == par1 && (!flag1 || par2World.getBlockMetadata((int)par3EntityPlayer.posX + i, (int)par3EntityPlayer.posY + j, (int)par3EntityPlayer.posZ + k) == par5)){
								return new int[]{(int)par3EntityPlayer.posX + i, (int)par3EntityPlayer.posY + j, (int)par3EntityPlayer.posZ + k};
							}
						}
						if(par3EntityPlayer.posY - j >= 0){
							System.out.println("In");
							if(par2World.getBlockId((int)par3EntityPlayer.posX + i, (int)par3EntityPlayer.posY - j, (int)par3EntityPlayer.posZ + k) == par1 && (!flag1 || par2World.getBlockMetadata((int)par3EntityPlayer.posX + i, (int)par3EntityPlayer.posY + j, (int)par3EntityPlayer.posZ + k) == par5)){
								return new int[]{(int)par3EntityPlayer.posX + i, (int)par3EntityPlayer.posY - j, (int)par3EntityPlayer.posZ + k};
							}
						}
					}
				}
			}
		}
		return new int[]{0, 0, 0};
	}
	
	@Override
	public void updateIcons(IconRegister par1IconRegister){
		this.iconIndex = par1IconRegister.registerIcon("GlobalChestMod:fuj1n.GlobalChests.pocketLink");
	}

}
