package Configuration;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySqlConnection {
	private Connection connection;
	
	public MySqlConnection() throws Exception {
	    Class.forName("com.mysql.cj.jdbc.Driver");
	    System.out.println("Driver loaded");
//	    connection = DriverManager.getConnection("jdbc:mysql://192.168.209.186:3308/test1","admin","admin@123");
	    connection = DriverManager.getConnection("jdbc:mysql://localhost:3308/test1","root","Akash@123");
	    System.out.println("Connection established");
	}
	

	public MySqlConnection(Connection connection) {
		super();
		this.connection = connection;
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

}
