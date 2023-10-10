package DB;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionPro {
	
	
	public static Connection createconnection() throws Exception 
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost/hotelbooking","root","");
		return con;
	}

}
