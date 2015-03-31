package com.javacodegeeks.resteasy.model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Catalog {
	private List<Product> productList;

	public Catalog(List<Product> productList) {
		this.productList = productList;
	}

	@XmlElement(name = "product")
	@XmlElementWrapper(name = "products")
	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}
}
