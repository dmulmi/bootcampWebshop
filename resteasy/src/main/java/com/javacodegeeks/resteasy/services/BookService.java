package com.javacodegeeks.resteasy.services;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.javacodegeeks.resteasy.mockups.BookMockup;
import com.javacodegeeks.resteasy.model.Book;
import com.javadoc.dao.BookDAO;

@Path("/book")
public class BookService {
	@POST
	//@Consumes("application/xml")
	@Produces("application/text_html")
	public Response addBook(Book book) {
		book = BookMockup.getBook();
		BookDAO.addBook(book);
		return Response.status(201).build();
	}

/*	@POST
	@Path("/json")
	@Consumes("application/json")
	@Produces("application/text")
	public Response addBookJson(Book book) {
		Long id = BookDAO.addBook(book);
		return Response.status(201).build();
	}

	@POST
	@Path("/list")
	@Consumes("application/xml")
	@Produces("application/text")
	public Response addBookList(List<Book> bookList) {
		Long id = BookDAO.addBookList(bookList);
		return Response.status(201).build();
	}

	@POST
	@Path("/json/list")
	@Consumes("application/json")
	@Produces("application/text")
	public Response addBookListJson(List<Book> bookList) {
		Long id = BookDAO.addBookList(bookList);
		return Response.status(201).build();
	}*/

}
