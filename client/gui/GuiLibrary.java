package fuj1n.globalLinkMod.client.gui;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import org.lwjgl.opengl.GL11;

import fuj1n.globalLinkMod.common.inventory.ContainerBookLibrary;
import fuj1n.globalLinkMod.common.tileentity.TileEntityLibrary;

public class GuiLibrary extends GuiContainer {

	public TileEntityLibrary te;
	public int type;

	public GuiArrowButton upArrow;
	public GuiArrowButton downArrow;

	public int downScrollFactor = 0;

	public GuiLibrary(EntityPlayer player, TileEntityLibrary library, int par3Type) {
		super(new ContainerBookLibrary(player, library));
		te = library;
		type = par3Type;
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int par1, int par2) {
		fontRenderer.drawString(type == 0 ? "Library" : type == 1 ? "Ender Library" : type == 2 ? "Global Library" : "Unknown Library", 8, 5, 4210752);
		// fontRenderer.drawString(StatCollector.translateToLocal("container.inventory"),
		// 8, ySize - 96 + 3, 4210752);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int i, int j) {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		mc.renderEngine.bindTexture("/gui/library.png");
		int x = (width - xSize) / 2;
		int y = (height - ySize) / 2;
		this.drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
		drawGuiSlots();
		drawItemStack(new ItemStack(Item.enchantedBook), this.width / 2 - 80, this.height / 2 - 20);
	}

	private void drawGuiSlots() {
		int numOfSlots = te.getSizeInventory();
		for (int i = 0; i < numOfSlots; i++) {
			int calculatedWidth = this.width / 2 + 42;
			int calculatedHeight = this.height / 2 - 70 + (i * 19) + downScrollFactor;
			if (calculatedHeight >= this.height / 2 - 70 - 10 && calculatedHeight <= this.height / 2 + 5) {
				new GuiDisplaySlot(calculatedWidth, calculatedHeight).draw(mc, calculatedWidth, calculatedHeight);
			}
		}
		mc.renderEngine.bindTexture("/gui/library.png");
		this.drawTexturedModalRect(this.width / 2 + 41, this.height / 2 - 83, 129, 0, 37, 9);
		this.drawTexturedModalRect(this.width / 2 + 41, this.height / 2 - 2, 129, 81, 37, 86);
	}

	@Override
	public void initGui() {
		super.initGui();
		upArrow = new GuiArrowButton(0, this.width / 2 + 62, this.height / 2 - 60, 0);
		downArrow = new GuiArrowButton(1, this.width / 2 + 62, this.height / 2 - 60 + 22, 1);
		buttonList.add(upArrow);
		buttonList.add(downArrow);
	}

	@Override
	protected void actionPerformed(GuiButton par1GuiButton) {
		switch (par1GuiButton.id) {
		case 0:
			// TODO Scroll up code goes here
		case 1:
			// TODO Scroll down code goes here
		}
	}

	private void drawItemStack(ItemStack par1ItemStack, int par2, int par3) {
		GL11.glTranslatef(0.0F, 0.0F, 32.0F);
		zLevel = 200.0F;
		itemRenderer.zLevel = 200.0F;
		itemRenderer.renderItemAndEffectIntoGUI(fontRenderer, mc.renderEngine, par1ItemStack, par2, par3);
		zLevel = 0.0F;
		itemRenderer.zLevel = 0.0F;
	}

}
