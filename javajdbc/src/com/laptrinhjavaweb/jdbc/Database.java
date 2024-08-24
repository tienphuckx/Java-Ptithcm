package com.laptrinhjavaweb.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Database {
	private static String DB_URL = "jdbc:mysql://localhost:3306/javasql";
	private static String USER = "root";
	private static String PASS = "";
//	NguyenPhuc@97
	private static Connection conn = null;
	private static Statement stmt = null;

	private static final String INSERT_USER = "INSERT INTO users(name,sdt,address) VALUES(?,?,?)";
	private static final String GET_ALL_USER = "SELECT * FROM users";
	private static final String GET_USER_BY_ID = "SELECT name,sdt,address FROM users WHERE id=?";
	private static final String DELETE_USER_BY_ID = "DELETE FROM users WHERE id=?";
	private static final String UPDATE_USER_BY_ID = "UPDATE users SET name=?,sdt=?,address=? WHERE id=?";

	/*
	 * try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);) {
	 * System.out.println("Connected database successfully..."); } catch
	 * (SQLException e) { e.printStackTrace(); }
	 */

	
	// GET CONNECTION
	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		System.out.println("Getting connection to database...");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	
	// INSERT USER
	public void insertUser(User user) throws ClassNotFoundException, SQLException {
		conn = getConnection();
		if (conn != null) {
			PreparedStatement stmt = conn.prepareStatement(INSERT_USER);
			
			stmt.setString(1, user.getName());
			stmt.setString(2, user.getSdt());
			stmt.setString(3, user.getAddress());
			stmt.execute();
		}else {
			System.out.println("Connection is null...");
		}
		conn.close();
		
		System.out.println("Insert user successfully !");
	}

	
	// GET USER BY ID
	public User getUserById(int id) throws ClassNotFoundException, SQLException {
		User user = null;	
		conn = getConnection();
		if(conn != null) {
			PreparedStatement stmt = conn.prepareStatement(GET_USER_BY_ID);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				String name = rs.getString("name");
				String sdt = rs.getString("sdt");
				String address = rs.getString("address");
				user = new User(name, sdt, address);
			}
			
			
		}		
		conn.close();
		
		return user;
	}

	
	// GET ALL USERS
	public List<User> getAllUsers()
	{
		List<User> userList = new ArrayList<User>();
		try {
			Connection conn = getConnection();
			if(conn != null) {
				PreparedStatement stmt = conn.prepareStatement(GET_ALL_USER);
				ResultSet rs = stmt.executeQuery();
				while(rs.next()) {
					String name = rs.getString("name");
					String sdt = rs.getString("sdt");
					String address = rs.getString("address");
					userList.add(new User(name, sdt, address));
				}
			}else {
				System.out.println("Connection is null ...");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return userList;
	}
	
	
	// UPDATE USER BY ID
	// DELETE USER BY ID
	
}
