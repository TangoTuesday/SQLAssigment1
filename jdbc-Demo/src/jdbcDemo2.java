import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbcDemo2 {

	public static void main(String[] args) throws SQLException {
		
		Connection myConn = null;
		PreparedStatement  myStmt = null;
		ResultSet myRs = null; 
		
		String dbUrl = "jdbc:mysql://localhost:3306/demo";
		String user = "student";
		String pass = "MCDougle94$$";;
		
	try {
			// 1. Get a connection to database
			myConn = DriverManager.getConnection(dbUrl, user, pass);
			
			// 2. Create a prepare statement
			myStmt = myConn.prepareStatement("select * from employees where salar > ? and department=?"); 
			
			// 3. Set the parameters 
			myStmt.setDouble(1, 80000);
			myStmt.setString(2, "Legal");
			
			
			// 4. Execute SQL query
			myRs = myStmt.executeQuery();
			
			// 5. Process the result set 
			display(myRs); 
			}
			
		
		
		catch (Exception exc) {
			
			exc.printStackTrace();
			
		}
		
	finally {
		
		if (myRs != null) {
			
			myRs.close();
			
		}
		
	}
	
	
 static void display(mRs) {
	
	
}

	//private static void displayEmployee(Connection myConn, String string, String string2) {
		// TODO Auto-generated method stub
		
	}
}
