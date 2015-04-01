package com.javadoc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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

	public static Catalog getCatalog() {
		List<Product> result = new ArrayList<Product>();
		try {
			Statement stmt = conn.createStatement();
			String query = "SELECT * FROM dvd";
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				Product p = new DVD(rs.getInt("id"), rs.getString("name"),
						rs.getFloat("price"), rs.getString("genre"));
				result.add(p);
			}
			query = "SELECT * FROM book";
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				Product p = new Book(rs.getInt("id"), rs.getString("name"),
						rs.getFloat("price"), rs.getString("isbn"),
						rs.getString("author"));
				result.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new Catalog(result);
	}

	public static Product searchProduct(String name) {
		try {
			String query = "SELECT * FROM dvd WHERE `name` = ?";
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setString(1, name);
			ResultSet rs = stmt.executeQuery();
			//ResultSet rs = stmt.executeQuery(query);
			if(rs.next()){
				return new DVD(rs.getInt("id"), rs.getString("name"),
						rs.getFloat("price"), rs.getString("genre"));
			}
			else
			{
				query = "SELECT * FROM book WHERE `name` = ?";
				stmt = conn.prepareStatement(query);
				stmt.setString(1, name);
				System.out.println(stmt);
				rs = stmt.executeQuery();
				if(rs.next())
					return new Book(rs.getInt("id"), rs.getString("name"),
							rs.getFloat("price"), rs.getString("isbn"),
							rs.getString("author"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return null;
	}
	
	public static void addProduct(Product p){
		try {
		if(p.getClass().getName()=="com.javacodegeeks.resteasy.model.Book"){
			Book b = (Book) p;
			String sql = "INSERT INTO book VALUES(?,?,?,?,?)";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setLong(1, CatalogDAO.getLastUsedID()+1);
			stmt.setString(2, b.getProductName());
			stmt.setFloat(3, b.getPrice());
			stmt.setString(4, b.getIsbn());
			stmt.setString(5, b.getAuthor());
			stmt.execute();
		}
		else{
			DVD d = (DVD) p;
			String sql = "INSERT INTO dvd VALUES(?,?,?,?)";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setLong(1, CatalogDAO.getLastUsedID()+1);
			stmt.setString(2, d.getProductName());
			stmt.setFloat(3, d.getPrice());
			stmt.setString(4, d.getGenre());
			stmt.execute();			
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static long getLastUsedID(){
		try{
			String sql = "SELECT MAX(`id`) FROM book";
			String sql2 = "SELECT MAX(`id`) FROM dvd";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			rs.next();
			long result = rs.getLong(1);
			rs = stmt.executeQuery(sql2);
			rs.next();
			if(result > rs.getLong(1))
				return result;
			else
				return
					rs.getLong(1);
		}
		catch(SQLException e){
			return 0;
		}
	}
}
