package bankmanagementsystem;

import java.sql.*;



public class Connection {
	// register driver
	java.sql.Connection c; 
	Statement s;
	public Connection() {
		try {
			
			// create connection
			c=DriverManager.getConnection("jdbc:mysql:///bankmanagement","root","Mva@1234" );
			s= c.createStatement();
		}catch (Exception e) {
		System.out.println(e);
		}
	}
}
