package com.fdmgroup.theawesomeforum.servlets.search;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fdmgroup.theawesomeforum.forum.discussion.Discussion;
import com.fdmgroup.theawesomeforum.forum.discussion.DiscussionService;

@WebServlet("/searchDiscussions")
public class DiscussionSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String searchString ="%" + request.getParameter("searchText") + "%";
		DiscussionService discussionService = new DiscussionService();
		List<Discussion> discussions = discussionService.findByString(searchString);
		request.setAttribute("discussions", discussions);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/search/searchDiscussions.jsp");
		requestDispatcher.forward(request, response);
	}
}
