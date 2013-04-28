package fuj1n.globalChestMod.common.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemGlobalLink extends Item {

	public ItemGlobalLink(int par1) {
		super(par1);
	}

	@Override
	public boolean hasEffect(ItemStack par1ItemStack) {
		return true;
	}

	@Override
	public EnumRarity getRarity(ItemStack par1ItemStack) {
		return EnumRarity.epic;
	}

	@Override
	public void updateIcons(IconRegister par1IconRegister) {
		iconIndex = par1IconRegister.registerIcon("GlobalChestMod:fuj1n.GlobalChests.globalLink");
	}

}
