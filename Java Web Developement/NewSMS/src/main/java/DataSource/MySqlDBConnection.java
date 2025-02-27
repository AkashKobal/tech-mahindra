package DataSource;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySqlDBConnection {
	private Connection connection;
	public MySqlDBConnection() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("Driver Loaded");
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3308/techm","root","Akash@123");
		System.out.println("Connection Established");
	}
	public Connection getConnection() {
		return connection;
	}
	public void setConnection(Connection connection) {
		this.connection = connection;
	}
	

}
