package fuj1n.globalChestMod.client;

import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fuj1n.globalChestMod.GlobalChests;

public final class CreativeTabGlobalChestMod extends CreativeTabs
{
    public CreativeTabGlobalChestMod(String label)
    {
        super(label);
    }
    
    CreativeTabGlobalChestMod(int par1, String par2Str)
    {
        super(par1, par2Str);
    }

    @Override
	@SideOnly(Side.CLIENT)

    /**
     * the itemID for the item to be displayed on the tab
     */
    public int getTabIconItemIndex(){
        return GlobalChests.globalChest.blockID;
    }
}
