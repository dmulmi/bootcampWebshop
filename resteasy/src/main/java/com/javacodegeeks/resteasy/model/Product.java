package com.javacodegeeks.resteasy.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Product {
	private long productId;
	private String productName;
	private float price;
	
	public Product()
	{
		
	}

	public Product(long productId, String productName, float price) {
		this.productId = productId;
		this.productName = productName;
		this.price = price;
	}
	
	@XmlElement
	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	
	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}
	
	@XmlElement
	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

}
