package Repositiry;

import java.sql.PreparedStatement;

import Configuration.MySqlConnection;
import Model.TestModel;

public class TestRepository {
	
	private MySqlConnection mySqlConnection;

	public MySqlConnection getMySqlConnection() {
		return mySqlConnection;
	}

	public void setMySqlConnection(MySqlConnection mySqlConnection) {
		this.mySqlConnection = mySqlConnection;
	}
	
	public TestRepository(MySqlConnection mySqlConnection) {
		super();
		this.mySqlConnection = mySqlConnection;
	}
	
	public int insertTest(TestModel t) {
		int i = 0;
		try {
			String insertQuery = "insert into test values(?,?)";
			
			PreparedStatement ps = mySqlConnection.getConnection().prepareStatement(insertQuery);
			ps.setInt(1, t.getTestid());
			ps.setString(2,	t.getTestname());
			
			i = ps.executeUpdate();
			
			
		} catch (Exception e) {
			System.out.println(e);
			// TODO: handle exception
		}
		return i;
	}

}
