package DataSource;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySqlDBConnection {
	private Connection connection;
	public MySqlDBConnection() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver loaded");
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3308/techm","root","Akash@123");
		System.out.println("Connection established");
	}
	public Connection getConnection() {
		return connection;
	}
	public void setConnection(Connection connection) {
		this.connection = connection;
	}
	

}
