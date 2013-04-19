package fuj1n.globalChestMod.client;

import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraftforge.client.MinecraftForgeClient;
import cpw.mods.fml.client.registry.RenderingRegistry;
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
	}
	@Override
	public void Init(){}
	@Override
	public void PostInit(){}

}
