package fuj1n.globalChestMod.common.enchantment;

import fuj1n.globalChestMod.GlobalChests;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.util.StatCollector;

public class EnchantmentRange extends Enchantment{

	public EnchantmentRange(int par1, int par2, boolean flag1) {
		super(par1, par2, GlobalChests.pocketLinkEnchantment);
		if(flag1){
			this.addToBookList(this);
		}
	}
	
    public String getTranslatedName(int par1)
    {
        String s = "Pocket Link Range";
        return s + " " + StatCollector.translateToLocal("enchantment.level." + par1);
    }

	
    public int getMaxLevel(){
        return 5;
    }

}
