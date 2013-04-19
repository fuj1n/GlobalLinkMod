package fuj1n.globalChestMod.client.nbt;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import net.minecraft.client.Minecraft;
import net.minecraft.nbt.CompressedStreamTools;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.MinecraftException;
import cpw.mods.fml.common.FMLLog;

public class GlobalChestNBT {

	private final FMLLog logger = new FMLLog();
	
	private final File NBTLocation;
	private final File NBTFile;
	
	private final long milliTime = System.currentTimeMillis();
	
	public GlobalChestNBT(String postfix){
		if(MinecraftServer.getServer() != null && MinecraftServer.getServer().isDedicatedServer()){
			NBTLocation = new File("null");
			NBTFile = new File("null");
		}else{
			NBTLocation = new File(Minecraft.getMinecraftDir(), "saves/");
			NBTFile = new File(Minecraft.getMinecraftDir(), "saves/globalChestData" + postfix + ".dat");
			NBTLocation.mkdirs();
			try {
				if(!NBTFile.exists()){
					NBTFile.createNewFile();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			setSessionLock();
		}
	}
	
	private void setSessionLock() {
		try {
			File file = new File(NBTLocation, "sessionlockGlobalChest.lock");
			DataOutputStream dataoutputstream = new DataOutputStream(new FileOutputStream(file));

			try {
				dataoutputstream.writeLong(milliTime);
			}
			finally {
				dataoutputstream.close();
			}
		}
		catch (IOException ioexception) {
			ioexception.printStackTrace();
			throw new RuntimeException("Failed to check session lock, aborting");
		}
	}
	
	public void checkSessionLock() throws MinecraftException {
		try {
			File file = new File(NBTLocation, "sessionlockGlobalChest.lock");
			DataInputStream datainputstream = new DataInputStream(new FileInputStream(file));
			try {
				if (datainputstream.readLong() != milliTime) {
					throw new MinecraftException("The save is being accessed from another location, aborting");
				}
			}
			finally {
				datainputstream.close();
			}
		}
		catch (IOException ioexception) {
			throw new MinecraftException("Failed to check session lock, aborting");
		}
	}
	
	public void clearSessionLock(){
		File file = new File(NBTLocation, "sessionlockGlobalChest.lock");
		if(file.exists()){
			file.delete();
		}
	}
	
	public NBTTagCompound getNBTTagCompound(){
		File file = NBTFile;
		if (file.exists())
		{
			try
			{
				NBTTagCompound nbttagcompound = CompressedStreamTools.readCompressed(new FileInputStream(file));
				return nbttagcompound;
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		return new NBTTagCompound();
	}
	
	public void saveNBTData(NBTTagCompound NBTData)
	{
		try
		{
			if(NBTData != null){
				File file = NBTFile;
				
				if (file.exists())
				{
					file.delete();
					file.createNewFile();
				}else{
					file.createNewFile();
				}
				
				CompressedStreamTools.writeCompressed(NBTData, new FileOutputStream(file));
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
}
