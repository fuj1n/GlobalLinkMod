package fuj1n.globalLinkMod.lib;

import java.util.ArrayList;

import net.minecraft.item.Item;

public class BookLibraryReference {

	public static BookLibraryReference instance = new BookLibraryReference();
	public static ArrayList<Object> books = new ArrayList();

	public void populateBooksList() {
		books.add(Item.book);
		books.add(Item.writableBook);
		books.add(Item.writtenBook);
		books.add(Item.enchantedBook);
	}

	public void addBookToList(Object BookItem) {
		books.add(BookItem);
	}
}
