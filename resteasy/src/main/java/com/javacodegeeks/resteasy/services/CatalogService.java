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
	}

	@GET
	@Path("/json/products")
	@Produces("application/json")
	public Catalog getProductsJSON() {
		return CatalogDAO.getCatalog();
	}

	@GET
	@Path("/product/{productId}")
	@Produces("application/xml")
	public Product getProduct(@PathParam("productId") long productId) {
		Product product = CatalogDAO.getProduct(productId);
		if (product == null) {
			// By throwing this exception an 404 is send back
			throw new NotFoundException("Product doesnt exist");
		}
		return product;
	}
	
	@GET
	@Path("/json/product/{productId}")
	@Produces("application/json")
	public Product getProductJson(@PathParam("productName") long productId) {
		Product product = CatalogDAO.getProduct(productId);
		if (product == null) {
			// By throwing this exception an 404 is send back
			throw new NotFoundException("Product doesnt exist");
		}
		return product;
	}

	@GET
	@Path("/search/{query}")
	@Produces("application/xml")
	public Catalog searchProduct(@PathParam("query") String query) {
		Catalog catalog = CatalogDAO.getCatalog().searchCatalog(query);
		if (catalog == null) {
			// By throwing this exception an 404 is send back
			throw new NotFoundException("Product doesnt exist");
		}
		return catalog;
	}
	
	@GET
	@Path("/json/search/{query}")
	@Produces("application/json")
	public Catalog searchProductJson(@PathParam("query") String query) {
		Catalog catalog = CatalogDAO.getCatalog().searchCatalog(query);
		if (catalog == null) {
			// By throwing this exception an 404 is send back
			throw new NotFoundException("Product doesnt exist");
		}
		return catalog;
	}
}
