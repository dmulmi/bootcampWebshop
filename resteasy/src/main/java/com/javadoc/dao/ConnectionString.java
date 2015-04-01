package com.javadoc.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionString {
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

}
