package com.aca.broodnbarley.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MariaDbUtil {
	
	private static String connectionUrl =
			"jdbc:mariadb://localhost:3306/broodnbarley?user=root&password=Baseball10";
	
	public static Connection getConnection() {
		Connection connection = null;
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			connection = DriverManager.getConnection(connectionUrl);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		return connection;
	}
	
	
	public static void main(String[] args) {
		Connection connection = MariaDbUtil.getConnection();
		if(null != connection) {
			System.out.println("A real connection");
		}else {
			System.out.println("Help. Connection is null");
		}
		
		

	}

}
