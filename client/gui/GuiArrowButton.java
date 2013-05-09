package fuj1n.globalLinkMod.client.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiArrowButton extends GuiButton {
	/** Button width in pixels */
	protected int width;

	/** Button height in pixels */
	protected int height;

	/** The x position of this control. */
	public int xPosition;

	/** The y position of this control. */
	public int yPosition;

	public int buttonIcon;

	/** ID for this control. */
	public int id;

	/** True if this control is enabled, false to disable. */
	public boolean enabled;

	/** Hides the button completely if false. */
	public boolean drawButton;
	protected boolean field_82253_i;

	public GuiArrowButton(int par1, int par2, int par3, int par4) {
		this(par1, par2, par3, 16, 20, par4);
	}

	public GuiArrowButton(int par1, int par2, int par3, int par4, int par5, int par6) {
		super(par1, par2, par3, par4, par5, "");
		this.width = 16;
		this.height = 20;
		this.enabled = true;
		this.drawButton = true;
		this.id = par1;
		this.xPosition = par2;
		this.yPosition = par3;
		this.width = par4;
		this.height = par5;
		this.buttonIcon = par6;
	}

	/**
	 * Returns 0 if the button is disabled, 1 if the mouse is NOT hovering over
	 * this button and 2 if it IS hovering over this button.
	 */
	@Override
	protected int getHoverState(boolean par1) {
		byte b0 = 1;

		if (!this.enabled) {
			b0 = 0;
		} else if (par1) {
			b0 = 2;
		}

		return b0;
	}

	/**
	 * Draws this button to the screen.
	 */
	@Override
	public void drawButton(Minecraft par1Minecraft, int par2, int par3) {
		if (this.drawButton) {
			FontRenderer fontrenderer = par1Minecraft.fontRenderer;
			par1Minecraft.renderEngine.bindTexture("/gui/library.png");
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			this.field_82253_i = par2 >= this.xPosition && par3 >= this.yPosition && par2 < this.xPosition + this.width && par3 < this.yPosition + this.height;
			int k = this.getHoverState(this.field_82253_i);
			this.drawTexturedModalRect(this.xPosition, this.yPosition, 240, (buttonIcon == 0 ? 18 : 78) + k * 20, this.width, this.height);
			// this.drawTexturedModalRect(this.xPosition + this.width / 2,
			// this.yPosition, 200 - this.width / 2, 18 + k * 20, this.width /
			// 2, this.height);
			this.mouseDragged(par1Minecraft, par2, par3);
		}
	}

	/**
	 * Fired when the mouse button is dragged. Equivalent of
	 * MouseListener.mouseDragged(MouseEvent e).
	 */
	@Override
	protected void mouseDragged(Minecraft par1Minecraft, int par2, int par3) {
	}

	/**
	 * Fired when the mouse button is released. Equivalent of
	 * MouseListener.mouseReleased(MouseEvent e).
	 */
	@Override
	public void mouseReleased(int par1, int par2) {
	}

	/**
	 * Returns true if the mouse has been pressed on this control. Equivalent of
	 * MouseListener.mousePressed(MouseEvent e).
	 */
	@Override
	public boolean mousePressed(Minecraft par1Minecraft, int par2, int par3) {
		return this.enabled && this.drawButton && par2 >= this.xPosition && par3 >= this.yPosition && par2 < this.xPosition + this.width && par3 < this.yPosition + this.height;
	}

	@Override
	public boolean func_82252_a() {
		return this.field_82253_i;
	}

	@Override
	public void func_82251_b(int par1, int par2) {
	}
}
