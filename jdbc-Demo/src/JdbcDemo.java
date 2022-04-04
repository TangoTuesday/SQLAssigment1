import java.sql.*;


public class JdbcDemo {
	
	public static void main(String[] args) throws SQLException {
		
		Connection myConn = null;
		Statement  myStmt = null;
		ResultSet myRs = null; 
		
		String dbUrl = "jdbc:mysql://localhost:3306/demo";
		String user = "student";
		String pass = "MCDougle94$$";;
		
	try {
			// 1. Get a connection to database
			myConn = DriverManager.getConnection(dbUrl, user, pass);
			
			// 2. Create a statement
			myStmt = myConn.createStatement(); 
			
			//  Insert a new employee
			System.out.println("Inserting a new employee to database\n");
		
		// add a new person to table 
	/*		int rowsAffected = myStmt.executeUpdate(
					"insert into employees" + 
					"(last_name, first_name, email, department, salary) " +
					"values" +
					"('Wright', 'Eric', 'eric.wright@foo.com', 'HR', 33000.00)");
		*/
			//call helper method to display the employees information
		//	System.out.println("BEFORE THE UPDATE.....");
		//	displayEmployee(myConn, "John", "Does");
			
			// updates email at a specific person
		/*	int rowsAffected = myStmt.executeUpdate(
					"update employees " + 
					"set email = 'john.doe@luv2code.com' " + 
					"where last_name='Doe' and first_name='John' ");
		*/
			//delets the employee
			
			int rowsAffected = myStmt.executeUpdate(
					"delete from employees " +
					"where last_name='Brown' and first_name='Bill'");		
			
			//call helper method to display the employees information
		//	System.out.println("AFTER THE UPDATE.....");
		//	displayEmployee(myConn, "John", "Doe");
			
			// 3. Execute SQL query
			myRs = myStmt.executeQuery("select * from employees order by last_name ");
			
			// 4. Process the result set 
			while ( myRs.next()) {
				System.out.println(myRs.getString("last_name") + "," + myRs.getString("first_name"));
			}
			
		}
		
		catch (Exception exc) {
			
			exc.printStackTrace();
			
		}
		
	finally {
		
		if (myRs != null) {
			
			myRs.close();
			
		}
		
	}
	
	}

	//private static void displayEmployee(Connection myConn, String string, String string2) {
		// TODO Auto-generated method stub
		
	}

//what
