package fuj1n.globalLinkMod.lib;

import java.util.HashMap;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;

public class DecoBookReference {

	public static final String[] NAMES = { "Red Decoration Book", "Red Decoration Book", "Green Decoration Book", "Green Decoration Book", "Cyan Decoration Book", "Cyan Decoration Book", "Blue Decoration Book", "Brown Decoration Book", "Brown Decoration Book", "Blue Decoration Book", "Blue Decoration Book", "Yellow Decoration Book", "Yellow Decoration Book", "Green Decoration Book" };
	public static final String[] NAMES_UNLOCALIZED = { "decoBookRedStrip", "decoBookRed", "decoBookGreenStrip", "decoBookGreen", "decoBookCyanStrip", "decoBookCyan", "decoBookBlue", "decoBookBrownTallStrip", "decoBookBrownTall", "decoBookBlueTallStrip", "decoBookBlueTall", "decoBookYellowStrip", "decoBookYellow", "decoBookGreenTilt" };
	public static final String[] ITEM_INFORMATION = { "Strip", null, "Strip", null, "Strip", null, null, "Strip;Tall", "Tall", "Strip;Tall", "Tall", "Strip", null, "Tilted" };
	public static final String[] ICON_PATHS = { "fuj1n.GlobalChests.decoBooks.example" };

	public static void registerBookIcons(IconRegister par1IconRegister, HashMap<String, Icon> books){
		books.put("Red Decoration Book Strip", par1IconRegister.registerIcon("globalChestMod:books/book_redstrip"));
		books.put("Red Decoration Book", par1IconRegister.registerIcon("globalChestMod:books/book_red"));
		books.put("Green Decoration Book Strip", par1IconRegister.registerIcon("globalChestMod:books/book_greenstrip"));
		books.put("Green Decoration Book", par1IconRegister.registerIcon("globalChestMod:books/book_green"));
		books.put("Cyan Decoration Book Strip", par1IconRegister.registerIcon("globalChestMod:books/book_cyanstrip"));
		books.put("Cyan Decoration Book", par1IconRegister.registerIcon("globalChestMod:books/book_cyan"));
		books.put("Blue Decoration Book Strip", par1IconRegister.registerIcon("globalChestMod:books/book_bluestrip"));
		books.put("Brown Decoration Book Strip;Tall", par1IconRegister.registerIcon("globalChestMod:books/book_brownstriptall"));
		books.put("Brown Decoration Book Tall", par1IconRegister.registerIcon("globalChestMod:books/book_browntall"));
		books.put("Blue Decoration Book Strip;Tall", par1IconRegister.registerIcon("globalChestMod:books/book_bluestriptall"));
		books.put("Blue Decoration Book Tall", par1IconRegister.registerIcon("globalChestMod:books/book_bluetall"));
		books.put("Yellow Decoration Book Strip", par1IconRegister.registerIcon("globalChestMod:books/book_yellowstrip"));
		books.put("Yellow Decoration Book", par1IconRegister.registerIcon("globalChestMod:books/book_yellow"));
		books.put("Green Decoration Book Tilted", par1IconRegister.registerIcon("globalChestMod:books/book_greentilted"));
	}
	
}
