package fuj1n.globalChestMod.common.modcompat;

import buildcraft.BuildCraftBuilders;
import buildcraft.BuildCraftCore;
import buildcraft.BuildCraftEnergy;
import buildcraft.BuildCraftTransport;
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
			//CORE
		me.addItemToBanList(BuildCraftCore.springBlock.blockID);
			//ENERGY
		me.addItemToList(BuildCraftEnergy.engineBlock.blockID, 36);
			//BUILDERS
		me.addItemToList(BuildCraftBuilders.markerBlock.blockID, 2);
		me.addItemToList(BuildCraftBuilders.pathMarkerBlock.blockID, 2);
		me.addItemToList(BuildCraftBuilders.fillerBlock.blockID, 46);
		me.addItemToList(BuildCraftBuilders.builderBlock.blockID, 728);
		me.addItemToList(BuildCraftBuilders.architectBlock.blockID, 729);
		me.addItemToList(BuildCraftBuilders.libraryBlock.blockID, 73);
			//TRANSPORT
		//Items
			//CORE
		me.addItemToList(BuildCraftCore.woodenGearItem.itemID, 2);
		me.addItemToList(BuildCraftCore.stoneGearItem.itemID, 6);
		me.addItemToList(BuildCraftCore.ironGearItem.itemID, 42);
		me.addItemToList(BuildCraftCore.goldGearItem.itemID, 90);
		me.addItemToList(BuildCraftCore.diamondGearItem.itemID, 346);
		me.addItemToList(BuildCraftCore.wrenchItem.itemID, 33);
			//ENERGY
		me.addItemToBanList(BuildCraftEnergy.bucketOil.itemID);
		me.addItemToBanList(BuildCraftEnergy.fuelLiquid.itemID);
			//BUILDERS
		me.addItemToList(BuildCraftBuilders.templateItem.itemID, 9);
		me.addItemToList(BuildCraftBuilders.blueprintItem.itemID, 9);
			//TRANSPORT
		me.addItemToList(BuildCraftTransport.pipeWaterproof.itemID, 1);
		me.addItemToList(BuildCraftTransport.pipeGate.itemID, 24);
		me.addItemToList(BuildCraftTransport.pipeGateAutarchic.itemID, 62);
		me.addItemToList(BuildCraftTransport.redPipeWire.itemID, 11);
		me.addItemToList(BuildCraftTransport.bluePipeWire.itemID, 11);
		me.addItemToList(BuildCraftTransport.greenPipeWire.itemID, 11);
		me.addItemToList(BuildCraftTransport.yellowPipeWire.itemID, 11);
		me.addItemToList(BuildCraftTransport.pipeItemsWood.itemID, 3);
		me.addItemToList(BuildCraftTransport.pipeItemsEmerald.itemID, 33);
		me.addItemToList(BuildCraftTransport.pipeItemsStone.itemID, 3);
		me.addItemToList(BuildCraftTransport.pipeItemsCobblestone.itemID, 3);
		me.addItemToList(BuildCraftTransport.pipeItemsIron.itemID, 19);
		me.addItemToList(BuildCraftTransport.pipeItemsGold.itemID, 25);
		me.addItemToList(BuildCraftTransport.pipeItemsDiamond.itemID, 129);
		me.addItemToList(BuildCraftTransport.pipeItemsObsidian.itemID, 3);
		me.addItemToList(BuildCraftTransport.pipeItemsVoid.itemID, 3);
		me.addItemToList(BuildCraftTransport.pipeItemsSandstone.itemID, 9);
		me.addItemToList(BuildCraftTransport.pipeLiquidsWood.itemID, 4);
		me.addItemToList(BuildCraftTransport.pipeLiquidsCobblestone.itemID, 4);
		me.addItemToList(BuildCraftTransport.pipeLiquidsStone.itemID, 4);
		me.addItemToList(BuildCraftTransport.pipeLiquidsIron.itemID, 20);
		me.addItemToList(BuildCraftTransport.pipeLiquidsGold.itemID, 26);
		me.addItemToList(BuildCraftTransport.pipeLiquidsVoid.itemID, 4);
		me.addItemToList(BuildCraftTransport.pipeLiquidsSandstone.itemID, 10);
		me.addItemToList(BuildCraftTransport.pipeLiquidsEmerald.itemID, 34);
		me.addItemToList(BuildCraftTransport.pipePowerWood.itemID, 4);
		me.addItemToList(BuildCraftTransport.pipePowerStone.itemID, 4);
		me.addItemToList(BuildCraftTransport.pipePowerGold.itemID, 26);
		me.addItemToList(BuildCraftTransport.facadeItem.itemID, 7);
		me.addItemToList(BuildCraftTransport.pipeStructureCobblestone.itemID, 4);
	}
	
}
