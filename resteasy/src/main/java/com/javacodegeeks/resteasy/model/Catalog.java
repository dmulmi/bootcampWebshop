package com.javacodegeeks.resteasy.model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Catalog {
	
	private List<Product> productList;

	public Catalog() {

	}

	public Catalog(List<Product> productList) {
		this.productList = productList;
	}
	@XmlElement(name = "product")
	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}
}
