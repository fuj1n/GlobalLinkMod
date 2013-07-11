package fuj1n.globalLinkMod.client.render.tileentity;

import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import fuj1n.globalLinkMod.client.render.model.ModelGlobalChest;
import fuj1n.globalLinkMod.common.tileentity.TileEntityGlobalChest;

public class TileEntityGlobalChestRenderer extends TileEntitySpecialRenderer {

	private ModelGlobalChest globalChestModel = new ModelGlobalChest();

	ResourceLocation texture = new ResourceLocation("globalChestMod:textures/entity/chest/globalchest.png");
	
	@Override
	public void renderTileEntityAt(TileEntity tileentity, double d0, double d1, double d2, float f) {
		tileEntityRenderer = TileEntityRenderer.instance;
		renderGlobalChest((TileEntityGlobalChest) tileentity, d0, d1, d2, f);
	}

	public void renderGlobalChest(TileEntityGlobalChest par1TileEntityGlobalChest, double par2, double par4, double par6, float par8) {
		int i = 0;

		i = par1TileEntityGlobalChest.getBlockMetadata();

		this.func_110628_a(texture);
		GL11.glPushMatrix();
		GL11.glEnable(GL12.GL_RESCALE_NORMAL);
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		GL11.glTranslatef((float) par2, (float) par4 + 1.0F, (float) par6 + 1.0F);
		GL11.glScalef(1.0F, -1.0F, -1.0F);
		GL11.glTranslatef(0.5F, 0.5F, 0.5F);
		short short1 = 0;

		if (i == 2) {
			short1 = 180;
		}

		if (i == 3) {
			short1 = 0;
		}

		if (i == 4) {
			short1 = 90;
		}

		if (i == 5) {
			short1 = -90;
		}

		GL11.glRotatef(short1, 0.0F, 1.0F, 0.0F);
		GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
		float f1 = par1TileEntityGlobalChest.prevLidAngle + (par1TileEntityGlobalChest.lidAngle - par1TileEntityGlobalChest.prevLidAngle) * par8;
		f1 = 1.0F - f1;
		f1 = 1.0F - f1 * f1 * f1;
		globalChestModel.chestLid.rotateAngleX = -(f1 * (float) Math.PI / 2.0F);
		globalChestModel.renderAll();
		GL11.glDisable(GL12.GL_RESCALE_NORMAL);
		GL11.glPopMatrix();
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	}

}
