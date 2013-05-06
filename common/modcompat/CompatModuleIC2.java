package fuj1n.globalChestMod.common.modcompat;

import fuj1n.globalChestMod.GlobalChests;
import fuj1n.globalChestMod.lib.ManagerGlobalChest;

public class CompatModuleIC2 extends CompatModule{

	public CompatModuleIC2() {
		super("IC2", "Unknown");
	}

	@Override
	public void executeModCompat() {
		addAllGlobalChestWeights();
	}
	
	public void addAllGlobalChestWeights(){
		ManagerGlobalChest me = GlobalChests.globalChestManager;
	}

}
