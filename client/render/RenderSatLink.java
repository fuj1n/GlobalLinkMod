package fuj1n.globalChestMod.client.render;

import org.lwjgl.opengl.GL11;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.world.IBlockAccess;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import fuj1n.globalChestMod.client.ClientProxyGlobalChests;

public class RenderSatLink implements ISimpleBlockRenderingHandler{

	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelID, RenderBlocks renderer) {
		Tessellator tessellator = Tessellator.instance;
		GL11.glPushMatrix();
		GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
		tessellator.startDrawingQuads();
		tessellator.setNormal(-1F, 0F, 0F);
		renderer.setRenderBounds(0.5D, 0.0D, 0.5D, 0.7D, 1.0D, 0.7D);
		renderer.renderFaceXNeg(block, 0.0D, 0.0D, 0.0D, block.getIcon(metadata, 1));
		tessellator.draw();
		tessellator.startDrawingQuads();
		tessellator.setNormal(1F, 0F, 0F);
		renderer.setRenderBounds(0.5D, 0.0D, 0.5D, 0.7D, 1.0D, 0.7D);
		renderer.renderFaceXPos(block, 0.0D, 0.0D, 0.0D, block.getIcon(metadata, 1));
		tessellator.draw();
		tessellator.startDrawingQuads();
		tessellator.setNormal(0F, 0F, -1F);
		renderer.setRenderBounds(0.5D, 0.0D, 0.5D, 0.7D, 1.0D, 0.7D);
		renderer.renderFaceZNeg(block, 0.0D, 0.0D, 0.0D, block.getIcon(metadata, 1));
		tessellator.draw();
		tessellator.startDrawingQuads();
		tessellator.setNormal(0F, 0F, 1F);
		renderer.setRenderBounds(0.5D, 0.0D, 0.5D, 0.7D, 1.0D, 0.7D);
		renderer.renderFaceZPos(block, 0.0D, 0.0D, 0.0D, block.getIcon(metadata, 1));
		tessellator.draw();
		tessellator.startDrawingQuads();
		tessellator.setNormal(0F, 1F, 0F);
		renderer.setRenderBounds(0.5D, 1D, 0.5D, 0.7D, 1D, 0.7D);
		renderer.renderFaceYPos(block, 0.0D, 0.0D, 0.0D, block.getIcon(metadata, 1));
		tessellator.draw();
		tessellator.startDrawingQuads();
		tessellator.setNormal(0F, -1F, 0F);
		renderer.setRenderBounds(0.5D, 0D, 0.5D, 0.7D, 0D, 0.7D);
		renderer.renderFaceYNeg(block, 0.0D, 0.0D, 0.0D, block.getIcon(metadata, 1));
		tessellator.draw();
		GL11.glPopMatrix();
	}

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
		if(world.getBlockMetadata(x, y, z) == 0){
			renderer.setRenderBounds(0.4D, 0.0D, 0.4D, 0.6D, 1.0D, 0.6D);
			renderer.renderStandardBlock(block, x, y, z);
			return true;
		}
		return false;
	}

	@Override
	public boolean shouldRender3DInInventory() {
		return true;
	}

	@Override
	public int getRenderId() {
		return ClientProxyGlobalChests.SatLinkRenderId;
	}

}
