package fuj1n.globalChestMod.common.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fuj1n.globalChestMod.GlobalChests;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemVoidStone extends Item{

	public ItemVoidStone(int par1) {
		super(par1);
	}
	
    @Override
    public boolean hasEffect(ItemStack par1ItemStack){
        return true;
    }
    
    @Override
    public EnumRarity getRarity(ItemStack par1ItemStack){
        return EnumRarity.uncommon;
    }
	
    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer){
    	par3EntityPlayer.openGui(GlobalChests.instance, 1, par2World, (int)par3EntityPlayer.posX, (int)par3EntityPlayer.posY, (int)par3EntityPlayer.posZ);
        return par1ItemStack;
    }
    
	@Override
	public void updateIcons(IconRegister par1IconRegister){
		this.iconIndex = par1IconRegister.registerIcon("GlobalChestMod:fuj1n.GlobalChests.voidStone");
	}

}
