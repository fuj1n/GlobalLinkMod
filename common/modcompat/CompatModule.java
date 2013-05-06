package fuj1n.globalChestMod.common.modcompat;

public abstract class CompatModule {

	public final String MODNAME;
	public final String MINMODVER;
	
	public CompatModule(String modname, String minmodver){
		this.MODNAME = modname;
		this.MINMODVER = minmodver;
	}
	
	public abstract void executeModCompat();
	
}
