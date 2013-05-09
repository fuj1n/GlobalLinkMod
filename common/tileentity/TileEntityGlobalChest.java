package fuj1n.globalLinkMod.common.tileentity;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;

public class TileEntityGlobalChest extends TileEntity {
	/** The current angle of the chest lid (between 0 and 1) */
	public float lidAngle;

	/** The angle of the chest lid last tick */
	public float prevLidAngle;

	/** The number of players currently using this ender chest. */
	public int numUsingPlayers;

	/** Server sync counter (once per 20 ticks) */
	private int ticksSinceSync;

	/**
	 * Allows the entity to update its state. Overridden in most subclasses,
	 * e.g. the mob spawner uses this to count ticks and creates a new spawn
	 * inside its implementation.
	 */
	@Override
	public void updateEntity() {
		super.updateEntity();

		if (++ticksSinceSync % 20 * 4 == 0) {
			worldObj.addBlockEvent(xCoord, yCoord, zCoord, Block.enderChest.blockID, 1, numUsingPlayers);
		}

		prevLidAngle = lidAngle;
		float f = 0.1F;
		if (numUsingPlayers == 0 && lidAngle > 0.0F || numUsingPlayers > 0 && lidAngle < 1.0F) {
			if (numUsingPlayers > 0) {
				lidAngle += f;
			} else {
				lidAngle -= f;
			}

			if (lidAngle > 1.0F) {
				lidAngle = 1.0F;
			}

			if (lidAngle < 0.0F) {
				lidAngle = 0.0F;
			}
		}
	}

	/**
	 * Called when a client event is received with the event number and
	 * argument, see World.sendClientEvent
	 */
	@Override
	public boolean receiveClientEvent(int par1, int par2) {
		if (par1 == 1) {
			numUsingPlayers = par2;
			return true;
		} else {
			return super.receiveClientEvent(par1, par2);
		}
	}

	/**
	 * invalidates a tile entity
	 */
	@Override
	public void invalidate() {
		this.updateContainingBlockInfo();
		super.invalidate();
	}

	public void openChest() {
		++numUsingPlayers;
		worldObj.addBlockEvent(xCoord, yCoord, zCoord, Block.enderChest.blockID, 1, numUsingPlayers);
		double d1 = xCoord + 0.5D;
		double d0 = zCoord + 0.5D;
		worldObj.playSoundEffect(d1, yCoord + 0.5D, d0, "random.chestopen", 0.5F, worldObj.rand.nextFloat() * 0.1F + 0.9F);
	}

	public void closeChest() {
		--numUsingPlayers;
		worldObj.addBlockEvent(xCoord, yCoord, zCoord, Block.enderChest.blockID, 1, numUsingPlayers);
		double d0 = xCoord + 0.5D;
		double d2 = zCoord + 0.5D;
		worldObj.playSoundEffect(d0, yCoord + 0.5D, d2, "random.chestclosed", 0.5F, worldObj.rand.nextFloat() * 0.1F + 0.9F);
	}

	public boolean isUseableByPlayer(EntityPlayer par1EntityPlayer) {
		return worldObj.getBlockTileEntity(xCoord, yCoord, zCoord) != this ? false : par1EntityPlayer.getDistanceSq(xCoord + 0.5D, yCoord + 0.5D, zCoord + 0.5D) <= 64.0D;
	}
}
