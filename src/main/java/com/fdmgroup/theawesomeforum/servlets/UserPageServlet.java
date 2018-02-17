package com.fdmgroup.theawesomeforum.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fdmgroup.theawesomeforum.forum.entry.Entry;
import com.fdmgroup.theawesomeforum.forum.profanity.Profanity;
import com.fdmgroup.theawesomeforum.user.User;
import com.fdmgroup.theawesomeforum.user.UserService;
import com.fdmgroup.theawesomeforum.utility.ForumServiceInterface;

@WebServlet("/userpage")
public class UserPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService;
	private User user;

	public UserPageServlet() {
		userService = new UserService();
		user = new User();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session.getAttribute("username") != null) {
			prepareUserPageContent(request);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/userpage.jsp");
			requestDispatcher.forward(request, response);
		} else {
			response.sendRedirect("forum");

		}

	}

	private void prepareUserPageContent(HttpServletRequest request) {
		String userName = request.getParameter("linkUserName");

		User user = userService.readByName(userName);
		List<Entry> entriesForOneUser = userService.findAllEntriesForOneUserSortedByDate(user);
		if (entriesForOneUser.size() > 5) {
			List<Entry> restrictedListOfEntries = entriesForOneUser.subList(0, 5);
			setUserAttributes(request, user, restrictedListOfEntries);
		} else {
			setUserAttributes(request, user, entriesForOneUser);
		}

	}

	private void setUserAttributes(HttpServletRequest request, User user, List<Entry> listOfEntries) {
		request.setAttribute("user", user);
		request.setAttribute("restrictedListOfEntries", listOfEntries);
	}

}
