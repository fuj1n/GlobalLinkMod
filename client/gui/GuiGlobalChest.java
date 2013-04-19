/**
 * 
 */
package fuj1n.globalChestMod.client.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

import fuj1n.globalChestMod.common.inventory.ContainerGlobalChest;
import fuj1n.globalChestMod.common.tileentity.TileEntityGlobalChest;

/**
 * @author fuj1n
 */

class GuiGlobalChest extends GuiContainer{

	private static ContainerGlobalChest container;
	private TileEntityGlobalChest tileEntity;
	
	public GuiGlobalChest(EntityPlayer player, TileEntityGlobalChest tileEnity) {
		super(container = new ContainerGlobalChest(player, tileEnity));
		this.tileEntity = tileEnity;
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int par1, int par2){
        fontRenderer.drawString("Global Chest", 8, 5, 4210752);
        fontRenderer.drawString(StatCollector.translateToLocal("container.inventory"), 8, ySize - 96 + 3, 4210752);
	}
	
	@Override
    public void onGuiClosed(){
        super.onGuiClosed();
        tileEntity.closeChest();
    }
	
	@Override
    public void updateScreen() {
		this.container.inventory.saveInventory();
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int i, int j) {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.renderEngine.bindTexture("/gui/globalChest.png");
        int x = (width - xSize) / 2;
        int y = (height - ySize) / 2;
        this.drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
	}

}
