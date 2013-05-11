package fuj1n.globalLinkMod.client.render;

import org.lwjgl.opengl.GL11;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.world.IBlockAccess;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import fuj1n.globalLinkMod.GlobalChests;
import fuj1n.globalLinkMod.client.ClientProxyGlobalChests;
import fuj1n.globalLinkMod.common.inventory.InventoryLibraryDecoration;
import fuj1n.globalLinkMod.common.tileentity.TileEntityLibrary;
import fuj1n.globalLinkMod.lib.DecoBookReference;

public class RenderLibrary implements ISimpleBlockRenderingHandler {

	public int[][] bookCoords;
	
	public RenderLibrary(){
		getBookCoords();
	}
	
	public void getBookCoords(){
		bookCoords = new int[DecoBookReference.NAMES.length][2];
		for(int j = 0; j < DecoBookReference.NAMES.length / 7; j++){
			for(int i = 0; i < DecoBookReference.NAMES.length / (DecoBookReference.NAMES.length / 7); i++){
				bookCoords[i * (j + 1)] = new int[] { i * 2 , j * 6 };
				System.out.println(bookCoords[i * (j + 1)][0] + " " + bookCoords[i * (j + 1)][1]);
			}
		}
	}
	
	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelID, RenderBlocks renderer) {
		if(modelID == this.getRenderId()){
			GL11.glPushMatrix();
			block.setBlockBoundsForItemRender();
			GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
			Tessellator tessellator = Tessellator.instance;
			tessellator.startDrawingQuads();
			tessellator.setNormal(0.0F, 1.0F, 0.0F);
			renderer.renderFaceYPos(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSide(block, 1));
			tessellator.draw();
			tessellator.startDrawingQuads();
			tessellator.setNormal(0.0F, -1.0F, 0.0F);
			renderer.renderFaceYNeg(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSide(block, 0));
			tessellator.draw();
			tessellator.startDrawingQuads();
			tessellator.setNormal(1.0F, 0.0F, 0.0F);
			renderer.renderFaceXPos(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSide(block, 3));
			tessellator.draw();
			tessellator.startDrawingQuads();
			tessellator.setNormal(-1.0F, 0.0F, 0.0F);
			renderer.renderFaceXNeg(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSide(block, 2));
			tessellator.draw();
			tessellator.startDrawingQuads();
			tessellator.setNormal(0.0F, 0.0F, 1.0F);
			renderer.renderFaceZPos(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSide(block, 4));
			tessellator.draw();
			tessellator.startDrawingQuads();
			tessellator.setNormal(0.0F, 0.0F, -1.0F);
			renderer.renderFaceZNeg(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSide(block, 5));
			tessellator.draw();
			GL11.glPopMatrix();
		}
	}

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
		block.setBlockBoundsBasedOnState(world, x, y, z);
		renderer.renderStandardBlock(block, x, y, z);
		renderBooks(world, x, y, z, block, modelId, renderer);
		return true;
	}

	public void renderBooks(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer){
		TileEntityLibrary te = (TileEntityLibrary)world.getBlockTileEntity(x, y, z);
		InventoryLibraryDecoration inv = te.decoInventory;
		Tessellator tessellator = Tessellator.instance;
	}
	
	@Override
	public boolean shouldRender3DInInventory() {
		return true;
	}

	@Override
	public int getRenderId() {
		return ClientProxyGlobalChests.LibraryRenderId;
	}

}
