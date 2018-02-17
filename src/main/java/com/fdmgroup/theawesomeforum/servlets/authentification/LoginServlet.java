package com.fdmgroup.theawesomeforum.servlets.authentification;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fdmgroup.theawesomeforum.user.User;
import com.fdmgroup.theawesomeforum.user.UserJPACRUD;
import com.fdmgroup.theawesomeforum.user.UserService;
import com.fdmgroup.theawesomeforum.validator.LoginValidator;
import com.fdmgroup.theawesomeforum.validator.UserRightsValidator;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LoginValidator loginValidator;
	private UserRightsValidator userRightsValidator;
	private UserJPACRUD userJPACRUD;
	private UserService userService;
	private List<User> usersWithBirthday;

	public LoginServlet() {
		this.userJPACRUD = new UserJPACRUD();
		this.loginValidator = new LoginValidator(userJPACRUD);
		this.userRightsValidator = new UserRightsValidator(userJPACRUD);
		this.userService = new UserService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/login.jsp");
		requestDispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		HttpSession session = request.getSession();

		validateLoginData(request, response, username, password, session);
		checkIfUserIsAdmin(username, session);
		usersWithBirthday = userService.readByBirthday(" ");
		session.setAttribute("usersWithBirthday", usersWithBirthday);
	}

	private void checkIfUserIsAdmin(String username, HttpSession session) {
		if (userRightsValidator.isAdmin(username)) {
			session.setAttribute("isAdmin", "isAdmin");
		}
	}

	private void validateLoginData(HttpServletRequest request, HttpServletResponse response, String username,
			String password, HttpSession session) throws IOException, ServletException {
		if (loginValidator.validateLogin(username, password)) {
			session.setAttribute("username", username);
			response.sendRedirect("forum");

		} else {
			request.setAttribute("error", "Invalid Username or Password");
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/login.jsp");
			rd.include(request, response);
		}
	}

}
