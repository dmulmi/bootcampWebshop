package com.javadoc.dao;

import com.javacodegeeks.resteasy.mockups.BookMockup;
import com.javacodegeeks.resteasy.model.Book;
import com.javacodegeeks.resteasy.model.Catalog;
import com.javacodegeeks.resteasy.model.DVD;

public class dbTester {

	public static void main(String[] args) {
		//Catalog c = CatalogDAO.getCatalog();
		//CatalogDAO.addProduct(new Book(5,"Raising steam", 15.45F, "123452", "Terry Pratchett"));
		//CatalogDAO.addProduct(new DVD(6,"Interstellar", 34.95F, "Sci-Fi"));
		System.out.println(CatalogDAO.getLastUsedID());
	}

}
