package com.javadoc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.javacodegeeks.resteasy.model.Book;
import com.javacodegeeks.resteasy.model.Catalog;
import com.javacodegeeks.resteasy.model.DVD;
import com.javacodegeeks.resteasy.model.Product;


public abstract class CatalogDAO {
	private static final String url = "jdbc:mysql://soerendonk.iwa.nu/bootCampWebshop";
	private static final String usr = "bootCampWebshop";
	private static final String pw = "1Z0-804";
	private static Connection conn;
	
	static{
		try {
			conn = DriverManager.getConnection(url, usr, pw);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static Catalog getCatalog(){
		List<Product> result = new ArrayList<Product>();
		try {
			Statement stmt = conn.createStatement();
			String query = "SELECT * FROM dvd";
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()){
				Product p = new DVD(rs.getInt("id"),rs.getString("name"),rs.getFloat("price"), rs.getString("genre"));
				result.add(p);
			}
			query = "SELECT * FROM book";
			rs = stmt.executeQuery(query);
			while(rs.next()){
				Product p = new Book(rs.getInt("id"), rs.getString("name"),rs.getFloat("price"), rs.getString("isbn"), rs.getString("author"));
				result.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new Catalog(result);
	}
	
	//public static Product searchProduct()
}
