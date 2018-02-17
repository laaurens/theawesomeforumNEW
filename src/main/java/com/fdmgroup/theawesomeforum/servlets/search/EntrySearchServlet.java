package com.fdmgroup.theawesomeforum.servlets.search;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fdmgroup.theawesomeforum.forum.entry.Entry;
import com.fdmgroup.theawesomeforum.servlets.search.logic.EntrySearchLogic;

@WebServlet("/searchEntries")
public class EntrySearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String searchString = "%" + request.getParameter("searchText") + "%";
		List<Entry> entries = EntrySearchLogic.searchEntries(searchString);
		
		request.setAttribute("entries", entries);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/search/searchEntries.jsp");
		requestDispatcher.forward(request, response);
	}

}
