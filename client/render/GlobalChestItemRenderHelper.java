package fuj1n.globalChestMod.client.render;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fuj1n.globalChestMod.GlobalChests;
import fuj1n.globalChestMod.common.tileentity.TileEntityGlobalChest;

@SideOnly(Side.CLIENT)
public class GlobalChestItemRenderHelper
{
    /** The static instance of ChestItemRenderHelper. */
    public static GlobalChestItemRenderHelper instance = new GlobalChestItemRenderHelper();

    /** Instance of Chest's Tile Entity. */
    private TileEntityGlobalChest globalChest = new TileEntityGlobalChest();

    /**
     * Renders a chest at 0,0,0 - used for item rendering
     */
    public void renderChest(Block par1Block, int par2, float par3)
    {
        if (par1Block.blockID == GlobalChests.globalChest.blockID){
        	globalChest.blockMetadata = par2;
            TileEntityRenderer.instance.renderTileEntityAt(this.globalChest, 0.0D, 0.0D, 0.0D, 0.0F);
        }
    }
}
