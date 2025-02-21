package Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.sql.*;
import DataSource.MySqlDBConnection;
import Model.Course;
import Model.Course;

// Datasource   --  Configuration
// JDBC calls 

// this violates SOLID principle
public class CourseRepository {
	// get the datasourse object
	//Injecting/wiring an object 
	// @autowire
	private MySqlDBConnection connection;
	//alt shift s

	public CourseRepository(MySqlDBConnection connection) {
		super();
		this.connection = connection;
	}

	public MySqlDBConnection getConnection() {
		return connection;
	}
	public void setConnection(MySqlDBConnection connection) {
		this.connection = connection;
	}
	public int insertCourse(Course c) {
		int r=0;
		try {
		String sql="insert into course values(?,?,?,?)";
		
		PreparedStatement ps=connection.getConnection().prepareStatement(sql);
		ps.setString(1, c.getCourseid());
		ps.setString(2, c.getCoursename());
		ps.setInt(3,c.getCredit());
		ps.setString(4, c.getCtype());
		 r=ps.executeUpdate();
		
		}catch(Exception e) {}
		return r;
	}
	public List<Course> fetchAllCourses() {
		List<Course> list=new ArrayList<Course>();
		Course c;
		try {
		String sql="select * from course";	
		Statement st=connection.getConnection().createStatement();
		ResultSet set=st.executeQuery(sql);
		while(set.next()) {
			String courseid=set.getString(1);
			String coursename=set.getString(2);
			int credit=set.getInt(3);
			String ctype=set.getString(4);
			c = new Course(courseid,coursename,credit,ctype); 
			list.add(c);
		}
		}catch(Exception e) {}
		return list;
	}
	public int updateCourse(Course c, String id) {
		int r=0;
		try {
		String sql="update Course set coursename=?, coursetype=? where courseid=?";	
		PreparedStatement ps=connection.getConnection().prepareStatement(sql);
		ps.setString(1, c.getCoursename());
		ps.setString(2, c.getCtype());
		ps.setString(3, id);
		r=ps.executeUpdate();
		}catch(Exception e) {}
		return r;
	}
	public int deleteCourse(String id) {
		int r=0;
		try {
			String sql="delete from Course where sid=?";	
			PreparedStatement ps=connection.getConnection().prepareStatement(sql);
			ps.setString(1,id);
			r=ps.executeUpdate();
		}catch(Exception e) {}
		return r;
	}

}