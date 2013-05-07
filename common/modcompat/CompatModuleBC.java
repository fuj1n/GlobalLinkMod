package fuj1n.globalChestMod.common.modcompat;

import buildcraft.BuildCraftBuilders;
import buildcraft.BuildCraftCore;
import buildcraft.BuildCraftEnergy;
import cpw.mods.fml.common.Loader;
import fuj1n.globalChestMod.GlobalChests;
import fuj1n.globalChestMod.lib.ManagerGlobalChest;

public class CompatModuleBC extends CompatModule{

	/**
	 * Whether this module can except all parts of BC to be installed(as now they come shipped together)
	 */
	public boolean exceptAllInstalled = true;
	public boolean coreInstalled = false;
	public boolean energyInstalled = false;
	public boolean buildersInstalled = false;
	public boolean transportInstalled = false;
	public boolean factoryInstalled = false;
	public boolean siliconInstalled = false;
	
	public CompatModuleBC() {
		super("Buildcraft", "3.5.1");
	}

	@Override
	public void executeModCompat() {
		execCoreCompat();
		if(Loader.isModLoaded("BuildCraft|Energy") || exceptAllInstalled){
			execEnergyCompat();
		}
		if(Loader.isModLoaded("BuildCraft|Builders") || exceptAllInstalled){
			execBuildersCompat();
		}
		if(Loader.isModLoaded("BuildCraft|Transport") || exceptAllInstalled){
			execTransportCompat();
		}
		if(Loader.isModLoaded("BuildCraft|Factory") || exceptAllInstalled){
			execFactoryCompat();
		}
		if(Loader.isModLoaded("BuildCraft|Silicon") || exceptAllInstalled){
			execSiliconCompat();
		}
	}

	public void execCoreCompat(){
		coreInstalled = true;
		addAllGlobalChestWeights();
	}
	
	public void execEnergyCompat(){
		energyInstalled = true;
	}
	
	public void execBuildersCompat(){
		buildersInstalled = true;
	}
	
	public void execTransportCompat(){
		transportInstalled = true;
	}
	
	public void execFactoryCompat(){
		factoryInstalled = true;
	}
	
	public void execSiliconCompat(){
		siliconInstalled = true;
	}
	
	public void addAllGlobalChestWeights(){
		ManagerGlobalChest me = GlobalChests.globalChestManager;
		//Blocks
		me.addItemToBanList(BuildCraftCore.springBlock.blockID);
		me.addItemToList(BuildCraftEnergy.engineBlock.blockID, 36);
		me.addItemToList(BuildCraftBuilders.markerBlock.blockID, 2);
		me.addItemToList(BuildCraftBuilders.pathMarkerBlock.blockID, 2);
		me.addItemToList(BuildCraftBuilders.fillerBlock.blockID, 46);
		me.addItemToList(BuildCraftBuilders.builderBlock.blockID, 728);
		me.addItemToList(BuildCraftBuilders.architectBlock.blockID, 729);
		me.addItemToList(BuildCraftBuilders.libraryBlock.blockID, 73);
		//Items
		me.addItemToList(BuildCraftCore.woodenGearItem.itemID, 2);
		me.addItemToList(BuildCraftCore.stoneGearItem.itemID, 6);
		me.addItemToList(BuildCraftCore.ironGearItem.itemID, 42);
		me.addItemToList(BuildCraftCore.goldGearItem.itemID, 90);
		me.addItemToList(BuildCraftCore.diamondGearItem.itemID, 346);
		me.addItemToList(BuildCraftCore.wrenchItem.itemID, 33);
		me.addItemToBanList(BuildCraftEnergy.bucketOil.itemID);
		me.addItemToBanList(BuildCraftEnergy.fuelLiquid.itemID);
		me.addItemToList(BuildCraftBuilders.templateItem.itemID, 9);
		me.addItemToList(BuildCraftBuilders.blueprintItem.itemID, 9);
	}
	
}
