package com.javacodegeeks.resteasy.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Book extends Product {

	private String isbn;
	private String author;
	
	public Book()
	{
		
	}
	public Book(long productId, String productName, float price, String isbn,
			String author) {
		super(productId, productName, price);
		this.isbn = isbn;
		this.author = author;
	}

	@XmlElement
	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	@XmlElement
	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}
	
	@Override
	public boolean containQuery(String query) {
		try
		{
			int intQuery = Integer.valueOf(query);
			if(this.getProductId() == intQuery)
				return true;
		}
		catch(NumberFormatException nfe){			
		}
		if(this.getProductName().toUpperCase().contains(query.toUpperCase()) || author.toUpperCase().contains(query.toUpperCase()) || isbn.toUpperCase().contains(query.toUpperCase()))
			return true;		
		return false;
	}

}
