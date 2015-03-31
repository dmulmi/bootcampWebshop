package com.javacodegeeks.resteasy.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Cartline {
	
	private int quantity;
	private Product product;
	
	public Cartline(int quantity, Product product) {
		this.quantity = quantity;
		this.product = product;
	}
@XmlElement
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@XmlElement
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}
