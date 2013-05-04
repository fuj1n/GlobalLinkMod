package fuj1n.globalChestMod.common.blocks;

import java.util.Random;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;

public abstract class BlockMultiBlock extends BlockContainer {

	public final int[] DIMENSIONS;
	public final boolean ISHOLLOW;
	
	/**
	 * The standard block constructor
	 * @param par1 The ID of the block
	 * @param par2Material The material of the block
	 * @param size The size of the block(used if isMultiBlockCustomShaped() returns false)
	 * @param isHollow Is the multiblock required to be hollow(used if isMultiBlockCustomShaped() returns false)
	 */
	public BlockMultiBlock(int par1, Material par2Material, int[] size, boolean isHollow) {
		super(par1, par2Material);
		this.setTickRandomly(true);
		DIMENSIONS = size;
		ISHOLLOW = isHollow;
	}
	
	@Override
    public int tickRate(World par1World){
        return 30;
    }
	
	@Override
    public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random) {
		System.out.println("Tick");
    	boolean flag1 = isMultiBlockCustomShaped() ? canFormMultiBlock(par1World, par2, par3, par4) : canFormMultiBlock_default(par1World, par2, par3, par4);
    	if(flag1){
    		System.out.println("Building multiblock");
    		formMultiBlock(par1World, par2, par3, par4);
    	}else{
    		if(isBlockValidMultiBlockController(par1World, par2, par3, par4)){
    			System.out.println("Removing multiblock");
    			breakMultiBlock(par1World, par2, par3, par4);
    		}
    	}
    	par1World.scheduleBlockUpdate(par2, par3, par4, this.blockID, this.tickRate(par1World));
    }
    
	public abstract boolean isBlockValidMultiBlockController(World par1World, int par2, int par3, int par4);
	
	/**
	 * Insert your check for multiblock formation here
	 * @return if the multiblock can be formed in the current setup.
	 */
	public abstract boolean canFormMultiBlock(World par1World, int par2, int par3, int par4);
	
	/**
	 * Insert your instructions for multiblock formation here.
	 */
	public abstract void formMultiBlock(World par1World, int par2, int par3, int par4);

	/**
	 * Insert your instructions for multiblock disformation here.
	 */
	public abstract void breakMultiBlock(World par1World, int par2, int par3, int par4);
	
	/**
	 * Overwrite and return true if you want to use the canFormMultiBlock method
	 */
	public boolean isMultiBlockCustomShaped(){
		return false;
	}
	
	public final boolean canFormMultiBlock_default(World par1World, int par2, int par3, int par4){
		//TODO
		return false;
	}
	
	@Override
    public void onBlockAdded(World par1World, int par2, int par3, int par4) {
		par1World.scheduleBlockUpdate(par2, par3, par4, this.blockID, this.tickRate(par1World));
	}
	
}
