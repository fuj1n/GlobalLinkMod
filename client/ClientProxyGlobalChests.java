package fuj1n.globalLinkMod.client;

import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.client.registry.RenderingRegistry;
import fuj1n.globalLinkMod.client.event.EventHandler;
import fuj1n.globalLinkMod.client.render.RenderGlobalChest;
import fuj1n.globalLinkMod.client.render.RenderSatLink;
import fuj1n.globalLinkMod.client.render.tileentity.TileEntityGlobalChestRenderer;
import fuj1n.globalLinkMod.client.render.tileentity.TileEntitySatLinkRenderer;
import fuj1n.globalLinkMod.common.CommonProxyGlobalChests;
import fuj1n.globalLinkMod.common.tileentity.TileEntityGlobalChest;
import fuj1n.globalLinkMod.common.tileentity.TileEntitySatLink;

public class ClientProxyGlobalChests extends CommonProxyGlobalChests {

	public static int GlobalChestRenderId;
	public static int SatLinkRenderId;

	@Override
	public void PreInit() {
		GlobalChestRenderId = RenderingRegistry.getNextAvailableRenderId();
		SatLinkRenderId = RenderingRegistry.getNextAvailableRenderId();
		RenderingRegistry.registerBlockHandler(new RenderGlobalChest());
		RenderingRegistry.registerBlockHandler(new RenderSatLink());
		TileEntityRenderer.instance.specialRendererMap.put(TileEntityGlobalChest.class, new TileEntityGlobalChestRenderer());
		TileEntityRenderer.instance.specialRendererMap.put(TileEntitySatLink.class, new TileEntitySatLinkRenderer());
		MinecraftForge.EVENT_BUS.register(new EventHandler());
	}

	@Override
	public void Init() {
	}

	@Override
	public void PostInit() {
	}

}
