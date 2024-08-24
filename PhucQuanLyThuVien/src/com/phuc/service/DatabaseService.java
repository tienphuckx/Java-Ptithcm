package com.phuc.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseService 
{
	protected Connection connection;
	protected static String DB_URL = "jdbc:mysql://localhost:3306/java_quanlysach";
	protected static String USER = "root";
	protected static String PASS = "";
	
	public DatabaseService() 
	{
		try {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			connection = DriverManager.getConnection(DB_URL, USER, PASS);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
