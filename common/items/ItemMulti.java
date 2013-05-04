package fuj1n.globalChestMod.common.items;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import fuj1n.globalChestMod.common.tileentity.TileEntityLibrary;
import fuj1n.globalChestMod.lib.BookLibraryReference;
import fuj1n.globalChestMod.lib.MultiItemReference;

public class ItemMulti extends Item{
	
	public Icon[] icons = new Icon[MultiItemReference.ICON_PATHS.length];
	
	public ItemMulti(int par1) {
		super(par1);
		this.setHasSubtypes(true);
	}
	
	@Override
    public void getSubItems(int par1, CreativeTabs par2CreativeTabs, List par3List){
        for(int i = 0; i < MultiItemReference.NAMES_UNLOCALIZED.length; i++){
        	par3List.add(new ItemStack(this, 1, i));
        }
    }
	
	@Override
    public String getUnlocalizedName(ItemStack par1ItemStack){
		if(par1ItemStack.getItemDamage() < MultiItemReference.NAMES_UNLOCALIZED.length){
			return this.getUnlocalizedName() + "." + MultiItemReference.NAMES_UNLOCALIZED[par1ItemStack.getItemDamage()];
		}else{
			return this.getUnlocalizedName();
		}
    }
	
	@Override
    public Icon getIconFromDamage(int par1){
		if(par1 < MultiItemReference.ICON_PATHS.length){
			return icons[par1];
		}else{
			return this.itemIcon;
		}
    }
	
	@Override
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
		if(MultiItemReference.ITEM_INFORMATION[par1ItemStack.getItemDamage()] != null){
			par3List.add(MultiItemReference.ITEM_INFORMATION[par1ItemStack.getItemDamage()]);
		}
	}
	
	@Override
	public void registerIcons(IconRegister par1IconRegister){
		for(int i = 0; i < MultiItemReference.ICON_PATHS.length; i++){
			icons[i] = par1IconRegister.registerIcon("globalChestMod:" + MultiItemReference.ICON_PATHS[i]);
		}
	}

}
