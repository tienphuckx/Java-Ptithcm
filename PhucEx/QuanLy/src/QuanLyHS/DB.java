/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package QuanLyHS;
import java.sql.*;

public class DB {
    public static void main(String[] args) {
        DB db = new DB();
        db.addHOCSINH(123, "NGUYENPHUC", "HATINH");
    }
    
    // CONNECT ----------------------------------------------------------------------------------------------
    public Connection getConnection()
    {
        String url = "jdbc:sqlserver://localhost:1433;databaseName=QuanLy";
        String user = "sa";
        String pass = "123456";       
        try {
            return DriverManager.getConnection(url, user, pass);           
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }
    
    // ADD -------------------------------------------------------------------------------------------------------
    public void addHOCSINH(int maHOCSINH, String tenHOCSINH, String dcHOCSINH){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            String sql = "INSERT INTO HocSinhInfo(maHOCSINH,tenHOCSINH,dcHOCSINH) VALUES (?,?,?)";
            connection = getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, maHOCSINH);
            preparedStatement.setString(2, tenHOCSINH);
            preparedStatement.setString(3, dcHOCSINH);
            preparedStatement.executeUpdate();
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
        } finally {
            try {
                if(connection != null){
                    connection.close();
                }
                if(preparedStatement != null){
                    preparedStatement.close();
                }
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
        }     
    }
 

    
}
