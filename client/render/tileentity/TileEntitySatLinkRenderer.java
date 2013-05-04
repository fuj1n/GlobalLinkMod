package fuj1n.globalChestMod.client.render.tileentity;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import fuj1n.globalChestMod.client.render.model.ModelSatLink;
import fuj1n.globalChestMod.common.tileentity.TileEntitySatLink;

public class TileEntitySatLinkRenderer extends TileEntitySpecialRenderer{

	ModelSatLink model = new ModelSatLink();
	
	@Override
	public void renderTileEntityAt(TileEntity tileentity, double d0, double d1, double d2, float f) {
		if(tileentity.getBlockMetadata() == 1){
			model.render((TileEntitySatLink)tileentity, d0, d1, d2);
		}
	}
}
