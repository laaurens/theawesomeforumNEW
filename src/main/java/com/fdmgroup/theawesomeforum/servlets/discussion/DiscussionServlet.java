package com.fdmgroup.theawesomeforum.servlets.discussion;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/discussion")
public class DiscussionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String discussionId = request.getParameter("discussionId");
		
		DiscussionLogic.fetchDiscussionsFromService(request, discussionId);
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/discussion.jsp");
		requestDispatcher.forward(request, response);

	}

	

}
