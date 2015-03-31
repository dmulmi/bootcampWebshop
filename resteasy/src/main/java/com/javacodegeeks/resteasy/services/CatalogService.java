package com.javacodegeeks.resteasy.services;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.jboss.resteasy.spi.NotFoundException;

import com.javacodegeeks.resteasy.mockups.CatalogMockup;
import com.javacodegeeks.resteasy.model.Catalog;
import com.javacodegeeks.resteasy.model.Product;
import com.javadoc.dao.CatalogDAO;

@Path("/catalog")
public class CatalogService {
	@GET
	@Path("/products")
	@Produces("application/xml")
	public Catalog getProducts() {
		return CatalogDAO.getCatalog();
		//return CatalogMockup.getProducts();
	}

	@GET
	@Path("/json/products")
	@Produces("application/json")
	public List<Product> getProductsJSON() {
		List<Product> products = CatalogMockup.getProducts().getProductList();
		return products;
	}

	@GET
	@Path("/product/{productName}")
	@Produces("application/xml")
	public Product searchProduct(@PathParam("productName") String productName) {
//		Product product = CatalogMockup.searchProduct(productName);
		Product product = CatalogDAO.searchProduct(productName);
		if (product == null) {
			// By throwing this exception an 404 is send back
			throw new NotFoundException("Product doesnt exist");
		}
		return product;
	}
	
	@GET
	@Path("/json/product/{productName}")
	@Produces("application/json")
	public Product searchProductJson(@PathParam("productName") String productName) {
		Product product = CatalogMockup.searchProduct(productName);
		if (product == null) {
			// By throwing this exception an 404 is send back
			throw new NotFoundException("Product doesnt exist");
		}
		return product;
	}
}
