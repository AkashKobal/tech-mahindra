package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Configuration.MySQLConnection;
import Model.Course;

public class CourseDao {

	Connection connection = null;

	public CourseDao() throws ClassNotFoundException, SQLException {
		connection = MySQLConnection.getConnection();
	}

	public void addCourse(Course course) {
		try {
			PreparedStatement ps = connection
					.prepareStatement("INSERT INTO course(coursename,fees,category,duration) VALUES(?,?,?,?)");
			ps.setString(1, course.getCoursename());
			ps.setInt(2, course.getFees());
			ps.setString(3, course.getCategory());
			ps.setInt(4, course.getDuration());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Course Added Successfully!");

	}

	public List<Course> getAllCourses() {
		List<Course> courses = new ArrayList<Course>();
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM course");
//			Statement ps = connection.createStatement();
			ResultSet rs = ps.executeQuery("SELECT * FROM course");

			while (rs.next()) {
				Course course = new Course();
				course.setCourseid(rs.getInt("courseid"));
				course.setCoursename(rs.getString("coursename"));
				course.setFees(rs.getInt("fees"));
				course.setCategory(rs.getString("category"));
				course.setDuration(rs.getInt("duration"));

				courses.add(course);

			}
			System.out.println("Courses Fetched Successfully");
			System.out.println(courses);

		} catch (Exception e) {
			// TODO: handle exception
		}

		return courses;

	}
	
		

	public static void main(String[] args) {
		try {
			CourseDao dao = new CourseDao();
			List<Course> courses = dao.getAllCourses();
			System.out.println(courses);
		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	public void deleteCourse(int course) {
		try {
			PreparedStatement ps = connection.prepareStatement("DELETE FROM course WHERE courseid = ?");
			ps.setInt(1, course);
			ps.executeUpdate();
			System.out.println("Course Deleted Successfully");
			
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}

}
