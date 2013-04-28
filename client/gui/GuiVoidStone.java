package fuj1n.globalChestMod.client.gui;

import org.lwjgl.opengl.GL11;

import fuj1n.globalChestMod.GlobalChests;
import fuj1n.globalChestMod.common.inventory.ContainerVoidStone;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;

public class GuiVoidStone extends GuiContainer{

	private static ContainerVoidStone container;
	
	public GuiVoidStone(InventoryPlayer par1InventoryPlayer) {
		super(container = new ContainerVoidStone(par1InventoryPlayer));
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int par1, int par2){
        fontRenderer.drawString("Void Stone", 8, 5, 4210752);
        fontRenderer.drawString(StatCollector.translateToLocal("container.inventory"), 8, ySize - 96 + 3, 4210752);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int i, int j) {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.renderEngine.bindTexture("/gui/voidStone.png");
        int x = (width - xSize) / 2;
        int y = (height - ySize) / 2;
        this.drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
        drawItemStack(new ItemStack(GlobalChests.voidStone, 1), this.guiLeft + GuiVoidStone.container.middleSlotX, this.guiTop + GuiVoidStone.container.middleSlotY);
        
	}
	
    private void drawItemStack(ItemStack par1ItemStack, int par2, int par3)
    {
        GL11.glTranslatef(0.0F, 0.0F, 32.0F);
        this.zLevel = 200.0F;
        itemRenderer.zLevel = 200.0F;
        itemRenderer.renderItemAndEffectIntoGUI(this.fontRenderer, this.mc.renderEngine, par1ItemStack, par2, par3);
        this.zLevel = 0.0F;
        itemRenderer.zLevel = 0.0F;
    }

}
