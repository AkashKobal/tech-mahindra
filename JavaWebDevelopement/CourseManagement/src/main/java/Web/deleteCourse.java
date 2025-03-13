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

@WebServlet("/deleteCourse")
public class deleteCourse extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CourseDao courseDAO;
    public deleteCourse() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    public void init() throws ServletException {
        try {
            courseDAO = new CourseDao(); // Initialize DAO in init()
        } catch (ClassNotFoundException | SQLException e) {
            throw new ServletException(e); // Log error
        }
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Course course = new Course();
		course.setCourseid(Integer.parseInt(request.getParameter("courseid")));
		
		String courseid = request.getParameter("courseid");
		if (courseid == null || courseid.isEmpty()) {
			courseDAO.deleteCourse(course);
		} else {
			course.setCourseid(Integer.parseInt(courseid));
		}
	}

}
