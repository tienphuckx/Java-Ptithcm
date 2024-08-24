package com.laptrinhjavaweb.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC {

	public static void main(String[] args)   
	{
		User user = new User();
		Database database = new Database();
		
		try {
			user = database.getUserById(5);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("USERNAME:  "+ user.getName());
		System.out.println("SDT     :  "+ user.getSdt());
		System.out.println("ADDRESS :  "+ user.getAddress());
	}
}
		

