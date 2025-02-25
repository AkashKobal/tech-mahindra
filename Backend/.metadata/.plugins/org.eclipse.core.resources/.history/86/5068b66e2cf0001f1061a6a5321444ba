package DataSource;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySqlDBConnection {
	private Connection connection;
	
	public MySqlDBConnection(Connection connection) {
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3308/techm","root","Akash@123");
			
			
		} catch (Exception e) {
			
			System.out.println(e);
			
		}
		
    }

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

}
