package com.javacodegeeks.resteasy.mockups;

import java.util.ArrayList;
import java.util.List;

import com.javacodegeeks.resteasy.model.Book;
import com.javacodegeeks.resteasy.model.Catalog;
import com.javacodegeeks.resteasy.model.DVD;
import com.javacodegeeks.resteasy.model.Product;
import com.javadoc.dao.CatalogDAO;

public class CatalogMockup {

	public static Catalog getProducts() {
		Book prdt1 = new Book(1, "java", 21.5f, "NLW12AQWe234", "Harry");
		Book prdt2 = new Book(2, "java", 23.5f, "NLW12AQWe234WE", "Potter");
		List<Product> products = new ArrayList<Product>();
		products.add(prdt1);
		products.add(prdt2);
		return new Catalog(products);
		//return CatalogDAO.getCatalog();
	}

	public static Product searchProduct(long productName) {
//		Catalog cat = getProducts();
//		List<Product> products = cat.getProductList();
//		Product prdt = null;
//		for (Product available : products) {
//			if (available.getProductName().equals(productName)) {
//				prdt = available;
//			}
//		}
//		if (prdt.getClass().getName().equals("Book"))
//			prdt = (Book) prdt;
//		else
//			prdt = (DVD) prdt;
//		return prdt;
		return CatalogDAO.getProduct(productName);
	}

}
