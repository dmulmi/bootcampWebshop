package com.javacodegeeks.resteasy.model;

import java.util.ArrayList;
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
	
	public Catalog searchCatalog(String query){
		Catalog result = new Catalog(new ArrayList<Product>());
		for(Product p : this.productList)
			if(p.containQuery(query))
				result.getProductList().add(p);
		return result;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((productList == null) ? 0 : productList.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Catalog other = (Catalog) obj;
		if (productList == null) {
			if (other.productList != null)
				return false;
		} else if (!productList.equals(other.productList))
			return false;
		return true;
	}
	
}
