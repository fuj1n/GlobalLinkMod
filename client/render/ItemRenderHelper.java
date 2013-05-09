package fuj1n.globalLinkMod.client.render;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.tileentity.TileEntity;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ItemRenderHelper {
	public static ItemRenderHelper instance = new ItemRenderHelper();

	public void render(Block par1Block, TileEntity par2TileEntity) {
		TileEntityRenderer.instance.renderTileEntityAt(par2TileEntity, 0.0D, 0.0D, 0.0D, 0.0F);
	}
}
