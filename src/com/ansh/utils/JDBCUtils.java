package com.ansh.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtils {
	private static String jdbcURL = "jdbc:mysql://localhost:3301/test?useSSL=false";
	private static String jdbcUsername = "root";
	private static String jdbcPassword = "root";

	public static Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	public static void printSqlException(SQLException ex) {
		for(Throwable e: ex) {
			if(e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQL state: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while(t!= null) {
					System.out.println("Cause:" + t);
					t = t.getCause();
				}
				
				
			}
		}
	}
}
