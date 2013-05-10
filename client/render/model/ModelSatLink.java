package fuj1n.globalLinkMod.client.render.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.Tessellator;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.client.FMLClientHandler;
import fuj1n.globalLinkMod.common.tileentity.TileEntitySatLink;

public class ModelSatLink extends ModelBase {

	private IModelCustom modelSatlink;

	public ModelSatLink() {
		modelSatlink = AdvancedModelLoader.loadModel("/mods/globalChestMod/models/satlink.obj");
	}

	public void render(TileEntitySatLink te, double x, double y, double z) {
		GL11.glPushMatrix();
		GL11.glDisable(GL11.GL_LIGHTING);
		GL11.glTranslatef((float) x + 0.5f, (float) y, (float) z + 0.5f);
		GL11.glScalef(0.5f, 0.5f, 0.5f);
		FMLClientHandler.instance().getClient().renderEngine.bindTexture("/mods/globalChestMod/textures/models/satLink.png");
		te.topBitRotationAngle++;
		this.render(te);
		GL11.glPopMatrix();
	}

	private void render(TileEntitySatLink te) {
		Tessellator tessellator = Tessellator.instance;
		modelSatlink.renderPart("default");
		tessellator.setTextureUV(5, 0);
		modelSatlink.renderPart("pCube1");
		tessellator.setTextureUV(0, 0);
		modelSatlink.renderPart("pCube2");
		tessellator.setTextureUV(5, 16);
		GL11.glRotatef(te.topBitRotationAngle, 0F, 1F, 0F);
		modelSatlink.renderPart("pCube3");
		tessellator.setTextureUV(11, 16);
		modelSatlink.renderPart("pPlane1");
		modelSatlink.renderPart("pastedpPlane1group");
		modelSatlink.renderPart("pastedpPlane1group1");
		modelSatlink.renderPart("pastedpPlane1group2");
	}
}
