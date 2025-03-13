package Web;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import Dao.CourseDao;
import Model.Course;

@WebServlet("/viewCourses")
public class viewCourses extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private CourseDao courseDAO;

    @Override
    public void init() throws ServletException {
        try {
            courseDAO = new CourseDao(); // Initialize DAO in init()
        } catch (ClassNotFoundException | SQLException e) {
            throw new ServletException(e); // Log error
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Course> listCourse = courseDAO.getAllCourses(); // Fetch courses
        request.setAttribute("listCourse", listCourse); // Set courses in request scope
        RequestDispatcher dispatcher = request.getRequestDispatcher("view.jsp"); // Forward to JSP
        dispatcher.forward(request, response);
    }
}
