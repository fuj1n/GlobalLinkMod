package fuj1n.globalLinkMod.client.event;

import java.util.logging.Level;

import net.minecraftforge.client.event.sound.SoundLoadEvent;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.world.WorldEvent;
import fuj1n.globalLinkMod.GlobalChests;

public class EventHandler {

	@ForgeSubscribe
	public void onWorldSave(WorldEvent.Save event) {
		GlobalChests.chestNBT[0].saveNBTData(GlobalChests.globalChestCreative);
		GlobalChests.chestNBT[1].saveNBTData(GlobalChests.globalChestSurvival);
		GlobalChests.chestNBT[2].saveNBTData(GlobalChests.globalChestAdventure);
		GlobalChests.chestNBT[3].saveNBTData(GlobalChests.globalChestMisc);
	}

	@ForgeSubscribe
	public void onWorldLoad(WorldEvent.Load event) {
		GlobalChests.globalChestCreative = GlobalChests.chestNBT[0].getNBTTagCompound();
		GlobalChests.globalChestSurvival = GlobalChests.chestNBT[1].getNBTTagCompound();
		GlobalChests.globalChestAdventure = GlobalChests.chestNBT[2].getNBTTagCompound();
		GlobalChests.globalChestMisc = GlobalChests.chestNBT[3].getNBTTagCompound();
	}

	@ForgeSubscribe
	public void onSound(SoundLoadEvent event) {
		try {
			 event.manager.soundPoolSounds.addSound("globalchestmod:globalopen.wav");
			 event.manager.soundPoolSounds.addSound("globalchestmod:globalclose.wav");
		} catch (Exception e) {
			GlobalChests.log("Failed to register one or more sounds.", Level.WARNING);
		}
	}

}
