package fuj1n.globalLinkMod.client.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.resources.ResourceLocation;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiDisplaySlot extends Gui {
	/** Button width in pixels */
	protected int width;

	/** Button height in pixels */
	protected int height;

	/** The x position of this control. */
	public int xPosition;

	/** The y position of this control. */
	public int yPosition;

	/** Hides the button completely if false. */
	public boolean draw;
	protected boolean field_82253_i;

	ResourceLocation background = new ResourceLocation("globalChestMod:textures/gui/library.png");
	
	public GuiDisplaySlot(int par1, int par2) {
		this(par1, par2, 18, 18);
	}

	public GuiDisplaySlot(int par1, int par2, int par3, int par4) {
		this.width = 18;
		this.height = 18;
		this.draw = true;
		this.xPosition = par1;
		this.yPosition = par2;
		this.width = par3;
		this.height = par4;
	}

	public void draw(Minecraft par1Minecraft, int par2, int par3) {
		if (this.draw) {
			FontRenderer fontrenderer = par1Minecraft.fontRenderer;
			par1Minecraft.renderEngine.func_110577_a(background);
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			this.field_82253_i = par2 >= this.xPosition && par3 >= this.yPosition && par2 < this.xPosition + this.width && par3 < this.yPosition + this.height;
			this.drawTexturedModalRect(this.xPosition, this.yPosition, 238, 0, this.width, this.height);
			this.mouseDragged(par1Minecraft, par2, par3);
		}
	}

	/**
	 * Fired when the mouse button is dragged. Equivalent of
	 * MouseListener.mouseDragged(MouseEvent e).
	 */
	protected void mouseDragged(Minecraft par1Minecraft, int par2, int par3) {
	}

	/**
	 * Fired when the mouse button is released. Equivalent of
	 * MouseListener.mouseReleased(MouseEvent e).
	 */
	public void mouseReleased(int par1, int par2) {
	}

	/**
	 * Returns true if the mouse has been pressed on this control. Equivalent of
	 * MouseListener.mousePressed(MouseEvent e).
	 */
	public boolean mousePressed(Minecraft par1Minecraft, int par2, int par3) {
		return this.draw && par2 >= this.xPosition && par3 >= this.yPosition && par2 < this.xPosition + this.width && par3 < this.yPosition + this.height;
	}

	public boolean func_82252_a() {
		return this.field_82253_i;
	}

	public void func_82251_b(int par1, int par2) {
	}
}
