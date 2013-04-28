package fuj1n.globalChestMod.common.items.recipe;

import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.World;
import fuj1n.globalChestMod.GlobalChests;

public class RecipeVoidStone implements IRecipe
{
    private ItemStack output;

    /**
     * Used to check if a recipe matches current crafting inventory
     */
    @Override
	public boolean matches(InventoryCrafting par1InventoryCrafting, World par2World)
    {
        this.output = null;
        boolean flag1 = false;
        int points = 0;
        if(isProperRecipe(par1InventoryCrafting)){
        	return true;
        }
        
        for (int i = 0; i < par1InventoryCrafting.getSizeInventory(); ++i){
			if (par1InventoryCrafting.getStackInSlot(i) != null) {
				ItemStack itemstack = par1InventoryCrafting.getStackInSlot(i).copy();
				if (flag1 && itemstack.getItem() == GlobalChests.voidStone) {
					//System.out.println("Void stone adding points");
					points++;
				} else if (itemstack.getItem() == GlobalChests.voidStone) {
					//System.out.println("Void stone detected");
					itemstack.stackSize = 1;
					this.output = itemstack;
					flag1 = true;
				} else {
					//System.out.println("Junk item adding points");
					points++;
				}
			}
		}
        //System.out.println("The crafting request returned: " + (flag1 && points > 0) + " as flag1 is: " + flag1 + " and the recipe has: " + points + " points");
        return flag1 && points > 0;
    }

    public boolean isProperRecipe(InventoryCrafting par1InventoryCrafting){
    	return false;
    }
    
    /**
     * Returns an Item that is the result of this recipe
     */
    @Override
	public ItemStack getCraftingResult(InventoryCrafting par1InventoryCrafting)
    {
        return this.output.copy();
    }

    /**
     * Returns the size of the recipe area
     */
    @Override
	public int getRecipeSize()
    {
        return 10;
    }

    @Override
	public ItemStack getRecipeOutput()
    {
        return this.output;
    }
}
