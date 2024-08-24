
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class MyConnection {
    
    public static String URL = "jdbc:mysql://localhost:3306/java_contacts_application";
    public static String USERNAME = "root";
    public static String PASSWORD = "";
    
    
    public static Connection getConnection()
    {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_contacts_application", "root", "");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return conn;
    }
    
    public static void checkConn(Connection conn)
    {
        if(conn == null)
        {
            JOptionPane.showMessageDialog(null, "Connection is null");
        }
    }
}
