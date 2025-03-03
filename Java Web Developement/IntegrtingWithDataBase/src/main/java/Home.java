import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import Entity.User;
import Models.UserModel;

@WebServlet("/Home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String page = request.getParameter("page");
		switch (page) {
		case "home": {
			request.setAttribute("title", "Home Page"); // setting the title here not in the jsp file
			request.getRequestDispatcher("index.jsp").forward(request, response);
			break;
		}
		case "listUsers": {
			List<User> users = new ArrayList<User>();
			users = new UserModel().listUser();
			request.setAttribute("listUsers", users);
			request.setAttribute("title", "List users");
			request.getRequestDispatcher("listUsers.jsp").forward(request, response);
			break;
		}
		default: {
			request.setAttribute("title", "Error Page");
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

}
