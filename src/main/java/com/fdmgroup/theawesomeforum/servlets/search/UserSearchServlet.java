package com.fdmgroup.theawesomeforum.servlets.search;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fdmgroup.theawesomeforum.user.User;
import com.fdmgroup.theawesomeforum.user.UserService;

@WebServlet("/searchUsers")
public class UserSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String searchString = request.getParameter("searchText");
		UserService userService = new UserService();
		List<User> users = userService.findByName(searchString);
		
		request.setAttribute("users", users);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/search/searchUsers.jsp");
		requestDispatcher.forward(request, response);
	}

}
