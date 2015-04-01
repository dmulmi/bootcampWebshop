package com.javacodegeeks.resteasy.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class DVD extends Product {
	
	private String Genre;

	public DVD()
	{
		
	}
	public DVD(long productId, String productName, float price, String genre) {
		super(productId, productName, price);
		Genre = genre;
	}
	
	@XmlElement
	public String getGenre() {
		return Genre;
	}

	public void setGenre(String genre) {
		Genre = genre;
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
		if(this.getProductName().toUpperCase().contains(query.toUpperCase()) || Genre.toUpperCase().contains(query.toUpperCase()))
			return true;		
		return false;
	}


}
