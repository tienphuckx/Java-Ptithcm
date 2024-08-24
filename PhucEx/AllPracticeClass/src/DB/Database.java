/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import java.sql.*;

/**
 *
 * @author NguyenPhuc
 */
public class Database {
    // CONNECT CLASS --------------------------------------
    Connection getConnection(){
        
        String url = "jdbc:sqlserver://localhost:1433;databaseName=QuanLyHocSinh";
        String username = "sa";
        String password = "123456";
        
        try {
            return DriverManager.getConnection(url, username, password);
        } catch (Exception e){
            System.out.println(e.getMessage());
        } 
        
        return null;    
    }
    
    // ADD HOC SINH CLASS ------------------------------- INSERT
    public static void InsertStudent(int MaHocSinh, String tenHocSinh, String dcHocSinh){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "INSERT INTO StudentInfo (MaHocSinh,tenHocSinh,dcHocSinh) VALUES (?,?,?)";
        
       try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, MaHocSinh);
            preparedStatement.setString(2, tenHocSinh);
            preparedStatement.setString(3, dcHocSinh);
            preparedStatement.executeUpdate();
       } catch (Exception e){
           System.out.println(e.getMessage());
       } finally {
           try {
               if(connection != null)
                {
                    connection.close();
                }
                if(preparedStatement != null)
                {
                    preparedStatement.close();
                }
           } catch (Exception e){
               System.out.println(e.getMessage());
           }
       }
    }
    
    // DELETE HOC SINH CLASS ------------------------------- DALATE
    // UPDATE HOC SINH CLASS ------------------------------- UPDATE
    // 
}
