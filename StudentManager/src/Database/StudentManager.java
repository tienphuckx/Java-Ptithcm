package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class StudentManager {

    public StudentManager() {
    }

 
    // TAO KET NOI TOI CSDL -----------------------------------------------------------------------------------
    private Connection connection;
    public Connection getConn() {
	return connection;
    }
    public void setConn(Connection conn) {
	this.connection = conn;
    }   
    public Connection getConnect() throws ClassNotFoundException, SQLException {
	Class.forName(DatabaseInfo.driverName);
	connection = DriverManager.getConnection(DatabaseInfo.dbURL, DatabaseInfo.dbUser, DatabaseInfo.dbPass);
	System.out.println("CONNECTTED!");
	return connection;
    }

    // KIEM TRA SINH VIEN CO TRONG CSDL HAY CHUA ? ----------------------------------------------------------------------------------
    public boolean checkStudent(String StudentId) throws SQLException, ClassNotFoundException {
	// Káº¿t ná»‘i database
	connection = getConnect();

	// Kiá»ƒm tra sinh viÃªn cÃ³ trong database hay chÆ°a
	String sql = "Select * from Students where StudentId = '" + StudentId + "'";
	Statement stm1 = connection.createStatement();
	ResultSet rs = stm1.executeQuery(sql);

	// Tráº£ vá»� káº¿t quáº£
	if (!rs.next()) {
	    connection.close();
	    return false;
	}
	connection.close();
	return true;
    }
    
    
// XUAT RA BANG SINH VIEN --- SU DUNG VECTOR ----------------------------------------------------------------------------------
    public Vector<Vector<String>> getAll() throws ClassNotFoundException, SQLException {
	Vector<Vector<String>> data = new Vector<>();

	// Káº¿t ná»‘i database
	connection = getConnect();

	// Táº¡o cÃ¢u lá»‡nh SQL (CÃ¡ch 1: dÃ¹ng Statement)
	Statement stmt = connection.createStatement();
	ResultSet rs = stmt.executeQuery("Select * from Students");
	while (rs.next()) {

	    // Láº¥y dá»¯ liá»‡u tá»« ResultSet
	    String Sno = rs.getString(1);
	    String Sname = rs.getString(2);
	    String Sgender = rs.getString(3);
	    String Sclass = rs.getString(4);
	    String Saddress = rs.getString(5);
	    String Semail = rs.getString(6);

	    // Ghi vÃ o vector
	    Vector<String> temp = new Vector<>();
	    temp.add(Sno);
	    temp.add(Sname);
	    temp.add(Sgender);
	    temp.add(Sclass);
	    temp.add(Saddress);
	    temp.add(Semail);

	    // ThÃªm dá»¯ liá»‡u vÃ o data vector chÃ­nh
	    data.add(temp);
	}
	return data;
    }

// UPDATE NEW SINH VIEN ------------------------------------------------------------------------------------------------------    
    public int update(String Sno, String Sname, String Sgender, String Sclass, String Sadress, String Semail)
                    throws ClassNotFoundException, SQLException {
	int updateStatus = 0;
	// Káº¿t ná»‘i database
	Connection conn = getConnect();

	// Táº¡o cÃ¢u lá»‡nh SQL
	String sql = "UPDATE Students set StudentName='" + Sname + "',StudentGender'" + Sgender + "',StudentClass='" + Sclass + "',Semail ='"
	                + Semail + "',StudentAdress='" + Sadress + "' WHERE StudentId='" + Sno + "'";
	Statement stm1 = conn.createStatement();
	updateStatus = stm1.executeUpdate(sql);
	conn.close();
	return updateStatus;
    }

    public void addNew(String StudentId, String StudentName, String StudentGender, String StudentClass, String StudentAdress, String StudentEmail)
                    throws ClassNotFoundException, SQLException {
	// Káº¿t ná»‘i database
	connection = getConnect();

	// Táº¡o cÃ¢u lá»‡nh SQL (CÃ¡ch 2: sá»­ dá»¥ng PreparedStatement)
	String sql = "INSERT INTO Students(StudentId,StudentName,StudentGender,StudentClass,StudentAdress,StudentEmail) VALUES(?,?,?,?,?,?)";
	PreparedStatement stmt = connection.prepareStatement(sql);
	stmt.setString(1, StudentId);
	stmt.setString(2, StudentName);
	stmt.setString(3, StudentGender);
	stmt.setString(4, StudentClass);
	stmt.setString(5, StudentAdress);
	stmt.setString(6, StudentEmail);

	// Thá»±c hiá»‡n lá»‡nh SQL
	stmt.executeUpdate();

	// Ä�Ã³ng káº¿t ná»‘i
	connection.close();
    }
    
// XOA SINH VIEN THEO AD --------------------------------------------------------------------------------------------------------
    public int delete(String Sno) throws SQLException, ClassNotFoundException {
	int deleteStatus = 0;

	// Káº¿t ná»‘i database
	connection = getConnect();

	// XÃ³a sinh viÃªn
	String sql = "DELETE FROM STUDENTS WHERE StudentId='" + Sno + "'";
	Statement stm1 = connection.createStatement();
	deleteStatus = stm1.executeUpdate(sql);

	// Tráº£ vá»� káº¿t quáº£ int (cÃ³ xÃ³a thÃ nh cÃ´ng hay khÃ´ng)
	connection.close();
	return deleteStatus;
    }
}
