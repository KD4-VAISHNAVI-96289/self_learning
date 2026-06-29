package com.casestudyutils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtils {
	static String URL="jdbc:mysql://localhost:3306/productDb";
	static String user="root";
	static String password="Pass@123";
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL,user,password);
	}
}
