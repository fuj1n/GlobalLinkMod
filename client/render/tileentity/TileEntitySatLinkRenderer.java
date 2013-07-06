package fuj1n.globalLinkMod.client.render.tileentity;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import fuj1n.globalLinkMod.client.render.model.ModelSatLink;
import fuj1n.globalLinkMod.common.tileentity.TileEntitySatLink;

public class TileEntitySatLinkRenderer extends TileEntitySpecialRenderer {

	ModelSatLink model = new ModelSatLink();

	@Override
	public void renderTileEntityAt(TileEntity tileentity, double d0, double d1, double d2, float f) {
		if (tileentity.getBlockMetadata() == 1) {
			//TODO model.render((TileEntitySatLink) tileentity, d0, d1, d2);
		}
	}
}
