package fuj1n.globalLinkMod.common.modcompat;

import fuj1n.globalLinkMod.GlobalChests;
import fuj1n.globalLinkMod.lib.ManagerGlobalChest;

public class CompatModuleIC2 extends CompatModule {

	public CompatModuleIC2() {
		super("IC2", "Unknown");
	}

	@Override
	public void executeModCompat() {
		addAllGlobalChestWeights();
	}

	public void addAllGlobalChestWeights() {
		ManagerGlobalChest me = GlobalChests.globalChestManager;
	}

}
