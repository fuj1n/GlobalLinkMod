package fuj1n.globalChestMod.client;

import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.client.registry.RenderingRegistry;
import fuj1n.globalChestMod.client.event.EventSound;
import fuj1n.globalChestMod.client.render.RenderGlobalChest;
import fuj1n.globalChestMod.client.render.tileentity.TileEntityGlobalChestRenderer;
import fuj1n.globalChestMod.common.CommonProxyGlobalChests;
import fuj1n.globalChestMod.common.tileentity.TileEntityGlobalChest;

public class ClientProxyGlobalChests extends CommonProxyGlobalChests{
	
	public static int GlobalChestRenderId;
	
	@Override
	public void PreInit(){
		GlobalChestRenderId = RenderingRegistry.getNextAvailableRenderId();
		RenderingRegistry.registerBlockHandler(new RenderGlobalChest());
		TileEntityRenderer.instance.specialRendererMap.put(TileEntityGlobalChest.class, new TileEntityGlobalChestRenderer());
		MinecraftForge.EVENT_BUS.register(new EventSound());
	}
	@Override
	public void Init(){}
	@Override
	public void PostInit(){}

}
