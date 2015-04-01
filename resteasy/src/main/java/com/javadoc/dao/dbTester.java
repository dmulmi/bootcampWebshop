package com.javadoc.dao;

import com.javacodegeeks.resteasy.mockups.BookMockup;
import com.javacodegeeks.resteasy.model.Book;
import com.javacodegeeks.resteasy.model.Catalog;

public class dbTester {

	public static void main(String[] args) {
		//Catalog c = CatalogDAO.getCatalog();
		BookDAO.addBook(BookMockup.getBook());
		
	}

}
