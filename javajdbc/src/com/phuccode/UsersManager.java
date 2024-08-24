package com.phuccode;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.xdevapi.PreparableStatement;

public class UsersManager {

	public static void main(String[] args) {
		String jdbcURL = "jdbc:mysql://localhost:3306/java_crud_jdbc";
		String username = "root";
		String password = "";
		
		String username_1 = "huyentran";
		String email_1 = "huyentran@gmail.com";
		String fullname_1 = "Nguyen Ngoc HuyenTran";
		String password_1 = "12345678";
		
		String new_fullname = "Huyen Tran Cong Chua";
		String new_password = "7777777";
		String new_email = "huyen@gmail.com";
		String huyentran = "huyentran";
		
		
		try {
			Connection conn = DriverManager.getConnection(jdbcURL, username, password);
			
			
			/*
			String sql = "INSERT INTO users (username, email, fullname, password) VALUES (?,?,?,?)";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, username_1);
			stmt.setString(2, email_1);
			stmt.setString(3, fullname_1);
			stmt.setString(4, password_1);		
			int rows = stmt.executeUpdate();
			if(rows > 0) {
				System.out.println("INSERTED!");
			}else {
				System.out.println("FALSED TO INSERT!");
			}
			*/
			
			
			
			/*
			String sql = "SELECT * FROM users";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				System.out.println("--------------------");
				System.out.println("Name      :" + rs.getString("fullname"));
				System.out.println("Email     :" + rs.getString("email"));
				System.out.println("Username  :" + rs.getString("username"));
				System.out.println("Password  :" + rs.getString("password"));				
			}
			*/
			
			
			
			/*
			String sql = "UPDATE users SET fullname=?, password=?, email=? WHERE username=?";			
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, new_fullname);
			stmt.setString(2, new_password);
			stmt.setString(3, new_email);
			stmt.setString(4, huyentran);
			int rows = stmt.executeUpdate();
			if(rows > 0) {
				System.out.println("UPDATE SUCCESSFULLY!");
			}else {
				System.out.println("FAIL TO UPDATE!");
			}
			*/
			
			
			
			/*
			String sql = "DELETE FROM users WHERE username=?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, huyentran);
			int rows = stmt.executeUpdate();
			if(rows > 0) {
				System.out.println("DELETE SUCCESSFULLY!");
			}else {
				System.out.println("FAIL TO DELETE!");
			}
			
			*/
			
			
			
			
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
