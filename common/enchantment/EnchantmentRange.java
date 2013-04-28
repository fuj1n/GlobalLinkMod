package fuj1n.globalChestMod.common.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.util.StatCollector;
import fuj1n.globalChestMod.GlobalChests;

public class EnchantmentRange extends Enchantment {

	public EnchantmentRange(int par1, int par2, boolean flag1) {
		super(par1, par2, GlobalChests.pocketLinkEnchantment);
		if (flag1) {
			Enchantment.addToBookList(this);
		}
	}

	@Override
	public String getTranslatedName(int par1) {
		String s = "Pocket Link Range";
		return s + " " + StatCollector.translateToLocal("enchantment.level." + par1);
	}

	@Override
	public int getMaxLevel() {
		return 5;
	}

}
