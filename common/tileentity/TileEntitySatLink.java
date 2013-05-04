package fuj1n.globalChestMod.common.tileentity;

import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;

public class TileEntitySatLink extends TileEntity{

	public boolean isMultiblockFormed = false;
	public float topBitRotationAngle = 0F;
	
	@Override
    public AxisAlignedBB getRenderBoundingBox()
    {
		AxisAlignedBB bb = AxisAlignedBB.getAABBPool().getAABB(xCoord, yCoord, zCoord, xCoord + 1, yCoord + 2, zCoord + 1);
        return bb;
    }
	
	@Override
    public boolean isInvalid(){
        return !isMultiblockFormed;
    }
}
