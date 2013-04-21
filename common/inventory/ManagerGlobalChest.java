package fuj1n.globalChestMod.common.inventory;

import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

public class ManagerGlobalChest {

	public ArrayList stackList = new ArrayList();
	public ArrayList<Integer> priceList = new ArrayList();
	public ArrayList banList = new ArrayList();
	
	public int maxPrice = 4096;
	
	public ManagerGlobalChest(int par1){
		maxPrice = par1;
		populatePriceList();
	}
	
	public void populatePriceList(){
		stackList.add(Block.brick.blockID);
		int index = stackList.indexOf(Block.brick.blockID);
		priceList.add(16);
	}
	
	public int getItemPrice(ItemStack par1ItemStack){
		System.out.println(par1ItemStack.getItem().itemID);
		if(stackList.contains(par1ItemStack.getItem().itemID)){
			System.out.println("State 1");
			int index = stackList.indexOf(par1ItemStack.getItem().itemID);
			return priceList.get(index) * par1ItemStack.stackSize;
		}else if(!banList.contains(par1ItemStack.getItem().itemID)){
			return 0;
		}else{
			return maxPrice + 1;
		}
	}
	
}
