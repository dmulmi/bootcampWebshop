package com.javadoc.dao;

import com.javacodegeeks.resteasy.model.Catalog;

public class dbTester {

	public static void main(String[] args) {
		Catalog c = CatalogDAO.getCatalog();
		System.out.println(c.getProductList().get(0).getProductName());

	}

}
