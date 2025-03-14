package Client;

import Controller.CourseController;
import DataSource.MySqlDBConnection;
import Model.Course;
import Repository.CourseRepository;
import Service.CourseServiceIMPL;

public class CourseTest {
	public static void main(String[] args) {
        try {
        	MySqlDBConnection dbConnection = new MySqlDBConnection();
            CourseRepository courseRepository = new CourseRepository(dbConnection);
            CourseServiceIMPL courseService = new CourseServiceIMPL(courseRepository);
            CourseController courseController = new CourseController(courseService);
            
     
            Course course = new Course("CSE5678", "Web Developement",3, "Elective");
            int result = courseController.insertCourse(course);

            if (result > 0) {
                System.out.println("Course inserted successfully!");
            } else {
                System.out.println("Failed to insert Course.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
