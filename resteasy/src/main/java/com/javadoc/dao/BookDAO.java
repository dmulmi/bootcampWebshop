package com.javadoc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.javacodegeeks.resteasy.model.Book;

public abstract class BookDAO {
	private static final String url = "jdbc:mysql://soerendonk.iwa.nu/bootCampWebshop";
	private static final String usr = "bootCampWebshop";
	private static final String pw = "1Z0-804";
	private static final String driver = "com.mysql.jdbc.Driver";
	private static Connection conn;

	static {
		try {
			System.setProperty("jdbc.drivers", driver);
			Class.forName(driver).newInstance();
			conn = DriverManager.getConnection(url, usr, pw);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void addBook(Book book) {
		Long bookId = book.getProductId();
		String bookName = book.getProductName();
		Float bookPrice = book.getPrice();
		String bookIsbn = book.getIsbn();
		String bookAuthor = book.getAuthor();
		try {
			Statement stmt = conn.createStatement();
			String query = "Insert into book(id, name, price, isbn, author) values "
					+ "("
					+ bookId
					+ ", '"
					+ bookName
					+ "', "
					+ bookPrice
					+ ", '"
					+ bookIsbn
					+ "', '"
					+ bookAuthor
					+ "')";
			System.out.println(query);
			stmt.execute(query);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
