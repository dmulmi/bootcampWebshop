package com.javacodegeeks.resteasy.mockups;

import com.javacodegeeks.resteasy.model.Book;

public class BookMockup {

	public static Book getBook() {
		Book book = new Book(3, "java", 21.5f, "NLW1AWe234", "Harry");
		return book;
	}
}
