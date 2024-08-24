package com.phuccode.connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.mysql.cj.jdbc.Driver;

public class MySqlService 
{
	protected Connection connection;
	protected static String DB_URL = "jdbc:mysql://localhost:3306/java_quanlysach";
	protected static String USER = "root";
	protected static String PASS = "";
	
	public MySqlService() 
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
	
	
	/*
	 * 
	 * try
		{
			String url = "jdbc:mysql://localhost:3306/java_quanlysach?useUnicode=true&characterEncoding=utf-8";
			Properties properties = new Properties();
			properties.put("user", "root");
			properties.put("password", "");
			Driver driver = new Driver();
			connection = driver.connect(url, properties);
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
		}
	 */
}
