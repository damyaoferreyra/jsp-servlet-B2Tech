package com.ferreira.employeediretory.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionUtil {

	private static String URL = "jdbc:mysql://localhost:3306/employeedirectory";;
	private static String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static String USERNAME = "root";
	private static String PASSWORD = "root";
	private static Connection connection;
	
	public static Connection openConnection() throws SQLException, ClassNotFoundException {
		
		if(connection != null) return connection;
		else {
			Class.forName(DRIVER);
			
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		}
		
		return connection;
	}
}
