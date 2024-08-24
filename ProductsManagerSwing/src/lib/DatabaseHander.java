
package lib;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class DatabaseHander {
        private static String DRIVER_URL = "com.mysql.cj.jdbc.Driver";
	private static String DRIVER = "jdbc:mysql://";
	private static String HOST = "localhost:";
	private static String BACKWARD = "/";
	private static String DB_NAME = "java_products";
	private static String USER_NAME = "root";
	private static String USER_PASS = "";
	static int PORT = 3306;
        public static Connection conn = null;
	
	public static Connection getConnection() throws ClassNotFoundException
	{		           
            Class.forName(DRIVER_URL);
            try {
		conn = DriverManager.getConnection(DRIVER + HOST + PORT + BACKWARD + DB_NAME, USER_NAME, USER_PASS);
                /* JOptionPane.showMessageDialog(null, "Connected to database successfully!"); */
                return conn;
            } catch (SQLException e) {			
		e.printStackTrace();
            }
            return null;
	}
}
