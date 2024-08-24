/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socketanddb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author NguyenPhuc ----------------- BY VU 
 */
public class DB {
    // MAIN ----------------------------------------------------------------------------------------
    public static void main(String[] args) {
        DB db = new DB();
        db.addNhanVien(777777777, "PHUCPHUC", 244);
        System.out.println("Thanh cong");
    }
    // CONNECT ------------------------------------------------------------------------------------
    public Connection getConnection(){
        String user = "sa";
        String pass = "123456";
        String url = "jdbc:sqlserver://localhost:1433;databaseName=QLNV";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            return DriverManager.getConnection(url,user,pass);
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    
    // INSERT --------------------------------------------------------------------------------------
    public void addNhanVien(int manhanvien,String hoten,int tuoi){
        
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        
        try {
            String sql = "INSERT INTO nhanvien(manhanvien,hoten,tuoi) values (?,?,?)";          
            connection = getConnection();          
            statement = connection.prepareStatement(sql);            
            statement.setInt(1, manhanvien);
            statement.setString(2, hoten);
            statement.setInt(3, tuoi);
            statement.executeUpdate();        
        } catch (SQLException e) {
            System.out.println(e.getMessage());          
        }finally{
            try {
                if(connection != null){
                    connection.close();
                }
                if(statement != null){
                    statement.close();
                }            
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    
}
