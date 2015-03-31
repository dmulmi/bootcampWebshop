package com.javacodegeeks.resteasy.mockups;

import java.util.ArrayList;
import java.util.List;

import com.javacodegeeks.resteasy.model.Book;
import com.javacodegeeks.resteasy.model.DVD;
import com.javacodegeeks.resteasy.model.Product;

public class CatalogMockup {
	
	public static List<Product> getProducts()
	{	
		Product prdt1 = new Book(1,"java",21.5f,"NLW12AQWe234","Harry");
		Product prdt2 = new DVD(2,"java",23.5f,"study");
		List<Product> products = new ArrayList<Product>();
		products.add(prdt1);
		products.add(prdt2);
		return products;
	}
	
	public static Product searchProduct(String productName)
	{	
		List<Product> products = getProducts();
		Product prdt = null;
		for(Product available: products)
		{
			if(available.getProductName().equals(productName))
			{
				prdt = available;
			}
		}
		return prdt;
	}
	
}
