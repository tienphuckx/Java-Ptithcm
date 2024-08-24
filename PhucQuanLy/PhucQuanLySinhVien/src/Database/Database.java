/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author NguyenPhuc
 */

/*

create table Lop
(
	ID_Lop int primary key not null,
	Ten_Lop nvarchar not null,
	Nien_Khoa int not null
);

create table  Sinh_Vien
(
	ID_SinhVien varchar(100) primary key not null ,
	Ho_Ten varchar(100) not null,
	Khoa int not null,
	Dia_Chi varchar(100),
	ID_Lop int not null foreign key references Lop (ID_Lop)

);

create table MonHoc 
(
	ID_MonHoc varchar(100) primary key not null,
	Ten_MonHoc varchar(100) ,
	SoTinChi int 
);

create table BangDiem
(
	ID_SinhVien varchar(100) not null foreign key references Sinh_Vien (ID_SinhVien),
	ID_MonHoc varchar(100) not null foreign key references MonHoc (ID_MonHoc),
	Diem float
);


*/
public class Database {
    
    public static Connection conn;
    // ------- CONNECTION ----------------------------------------------------------
    public Connection getConnection()
    {
        String url = "jdbc:sqlserver://localhost:1433;databaseName=PhucQuanLySinhVien";
        String username = "sa";
        String password = "123456";      
        if (conn == null)
        {            
            try {
                conn = DriverManager.getConnection(url, username, password);
            } catch (SQLException ex) {
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            }
        }                   
        return conn;
    }
    // ------- END -- CONNECTION ------------------------------------------------------
    
       
}
