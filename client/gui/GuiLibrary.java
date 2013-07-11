package fuj1n.globalLinkMod.client.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import fuj1n.globalLinkMod.common.inventory.ContainerBookLibrary;
import fuj1n.globalLinkMod.common.tileentity.TileEntityLibrary;

public class GuiLibrary extends GuiContainer {

	public TileEntityLibrary te;
	public int type;
	
	//Used for the fancy 3D item renderer
	EntityItem renderItem;
	int renderItemTickLimit = 0;

	public GuiArrowButton upArrow;
	public GuiArrowButton downArrow;
	
	int shiftX = 60;

	public int downScrollFactor = 0;

	ResourceLocation background = new ResourceLocation("globalChestMod:textures/gui/library.png");
	
	public GuiLibrary(EntityPlayer player, TileEntityLibrary library, int par3Type) {
		super(new ContainerBookLibrary(player, library));
		te = library;
		type = par3Type;
		renderItem = new EntityItem(Minecraft.getMinecraft().theWorld, 0F, 0F, 0F, new ItemStack(Item.enchantedBook));
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int par1, int par2) {
		fontRenderer.drawString(type == 0 ? "Library" : type == 1 ? "Ender Library" : type == 2 ? "Global Library" : "Unknown Library", 8, 5, 4210752);
		fontRenderer.drawString("Decorations: ", 185, 22, 4210752);
		// fontRenderer.drawString(StatCollector.translateToLocal("container.inventory"),
		// 8, ySize - 96 + 3, 4210752);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int i, int j) {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		mc.renderEngine.func_110577_a(background);
		int x = (width - xSize) / 2 - shiftX;
		int y = (height - ySize) / 2;
		this.drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
		this.drawTexturedModalRect(x + 176, y + 19, 0, 168, 175, 57);
		drawGuiSlots();
		if(mc.gameSettings.fancyGraphics){
			drawItemOnGui(mc, this.width / 2 - 72 - shiftX, this.height / 2 + 32, 24, 1.0F, renderItem);
		}else{
			drawItemStack(new ItemStack(Item.enchantedBook), this.width / 2 - 80 - shiftX, this.height / 2 - 20);
		}
	}

	private void drawGuiSlots() {
		int numOfSlots = te.getSizeInventory();
		for (int i = 0; i < numOfSlots; i++) {
			int calculatedWidth = this.width / 2 + 42 - 60;
			int calculatedHeight = this.height / 2 - 70 + (i * 19) + downScrollFactor;
			if (calculatedHeight >= this.height / 2 - 70 - 10 && calculatedHeight <= this.height / 2 + 5) {
				new GuiDisplaySlot(calculatedWidth, calculatedHeight).draw(mc, calculatedWidth, calculatedHeight);
			}
		}
		//mc.renderEngine.bindTexture("/gui/library.png");
		//this.drawTexturedModalRect(this.width / 2 + 41 - shiftX, this.height / 2 - 83, 129, 0, 37, 9);
		//this.drawTexturedModalRect(this.width / 2 + 41 - shiftX, this.height / 2 - 2, 129, 81, 37, 86);
	}

	@Override
	public void initGui() {
		super.initGui();
		this.guiLeft = this.guiLeft - shiftX;
		upArrow = new GuiArrowButton(0, this.width / 2 + 62 - shiftX, this.height / 2 - 60, 0);
		downArrow = new GuiArrowButton(1, this.width / 2 + 62 - shiftX, this.height / 2 - 60 + 22, 1);
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

	/**
	 * @Undeprecated - The 3D item renderer does not work without fancy graphics enabled
	 */
	private void drawItemStack(ItemStack par1ItemStack, int par2, int par3) {
		GL11.glTranslatef(0.0F, 0.0F, 32.0F);
		zLevel = 200.0F;
		itemRenderer.zLevel = 200.0F;
		itemRenderer.renderItemAndEffectIntoGUI(fontRenderer, mc.renderEngine, par1ItemStack, par2, par3);
		zLevel = 0.0F;
		itemRenderer.zLevel = 0.0F;
	}
	
    public void drawItemOnGui(Minecraft par0Minecraft, int par1, int par2, int par3, float par4, Entity par5Entity){
        GL11.glEnable(GL11.GL_COLOR_MATERIAL);
        GL11.glPushMatrix();
        GL11.glTranslatef((float)par1, (float)par2, 50.0F);
        GL11.glScalef((float)(-par3), (float)par3, (float)par3);
        GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
        GL11.glRotatef(135.0F, 0.0F, 1.0F, 0.0F);
        RenderHelper.enableStandardItemLighting();
        GL11.glRotatef(-135.0F, 0.0F, 1.0F, 0.0F);
        GL11.glRotatef(-((float)Math.atan((double)(par4 / 40.0F))) * 20.0F, 1.0F, 0.0F, 0.0F);
        GL11.glTranslatef(0.0F, par0Minecraft.thePlayer.yOffset, 0.0F);
        RenderManager.instance.renderEntityWithPosYaw(par5Entity, 0.0D, 0.0D, 0.0D, 0.0F, 1.0F);
        if(renderItemTickLimit >= 2){
        	par5Entity.onUpdate();
        	renderItemTickLimit = 0;
        }else{
        	renderItemTickLimit++;
        }
        GL11.glPopMatrix();
        RenderHelper.disableStandardItemLighting();
        GL11.glDisable(GL12.GL_RESCALE_NORMAL);
        OpenGlHelper.setActiveTexture(OpenGlHelper.lightmapTexUnit);
        GL11.glDisable(GL11.GL_TEXTURE_2D);
        OpenGlHelper.setActiveTexture(OpenGlHelper.defaultTexUnit);
    }

}
