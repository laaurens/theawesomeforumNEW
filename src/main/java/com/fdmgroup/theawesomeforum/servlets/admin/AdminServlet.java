package com.fdmgroup.theawesomeforum.servlets.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fdmgroup.theawesomeforum.forum.profanity.Profanity;
import com.fdmgroup.theawesomeforum.forum.profanity.ProfanityService;
import com.fdmgroup.theawesomeforum.user.User;
import com.fdmgroup.theawesomeforum.user.UserService;
import com.fdmgroup.theawesomeforum.utility.ForumServiceInterface;

@WebServlet("/admin")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ForumServiceInterface<User> userService;
	private ForumServiceInterface<Profanity> profanityService;

	public AdminServlet() {
		userService = new UserService();
		profanityService = new ProfanityService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session.getAttribute("username") != null && session.getAttribute("isAdmin") != null) {
			prepareAdminContent(request);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/admin.jsp");
			requestDispatcher.forward(request, response);
		} else {
			response.sendRedirect("forum");

		}

	}

	private void prepareAdminContent(HttpServletRequest request) {
		List<User> users = userService.readAll();
		List<Profanity> profanities = profanityService.readAll();
		setAdminAttributes(request, users, profanities);
	}

	private void setAdminAttributes(HttpServletRequest request, List<User> users, List<Profanity> profanities) {
		request.setAttribute("users", users);
		request.setAttribute("profanities", profanities);
		long numberOfUsers = userService.count();
		request.setAttribute("numberOfUsers", numberOfUsers);
	}

}
