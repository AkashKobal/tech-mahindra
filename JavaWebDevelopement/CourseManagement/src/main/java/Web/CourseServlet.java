package Web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import Dao.CourseDao;
import Model.Course;

@WebServlet("/CourseServlet")
public class CourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private CourseDao dao;
  
    public CourseServlet() {
        super();
        try {
			dao = new CourseDao();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		Course course = new Course();
		course.setCoursename(request.getParameter("coursename"));
		course.setDuration(Integer.parseInt(request.getParameter("duration")));
		course.setFees(Integer.parseInt(request.getParameter("fees")));	
		course.setCategory(request.getParameter("category"));
		
		String courseid = request.getParameter("courseid");
		if (courseid == null || courseid.isEmpty()) {
			dao.addCourse(course);
			
		}
		else {
			course.setCourseid(Integer.parseInt(courseid));
//			dao.updateCourse(course);
		}
	
	}

}
