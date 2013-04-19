package fuj1n.globalChestMod.client.event;

import java.util.logging.Level;

import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.sound.SoundLoadEvent;
import net.minecraftforge.event.ForgeSubscribe;
import fuj1n.globalChestMod.GlobalChests;

public class EventSound {

	@ForgeSubscribe
	public void onSound(SoundLoadEvent event){
		try{
		}catch(Exception e){
			GlobalChests.log("Failed to register one or more sounds.", Level.WARNING);
		}
	}
	
}
