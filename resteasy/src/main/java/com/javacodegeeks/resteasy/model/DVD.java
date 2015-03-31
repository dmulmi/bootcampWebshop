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
	
	

}
