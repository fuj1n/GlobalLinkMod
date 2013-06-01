package fuj1n.globalLinkMod.common.blocks;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class BlockEnderChest extends net.minecraft.block.BlockEnderChest{

	public BlockEnderChest(int par1) {
		super(par1);
	}
	
	@Override
    public ArrayList<ItemStack> getBlockDropped(World world, int x, int y, int z, int metadata, int fortune){
        ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
        ret.add(new ItemStack(Block.obsidian, 7));
        ret.add(new ItemStack(Block.chest, 1));
        return ret;
    }
	
	
}
