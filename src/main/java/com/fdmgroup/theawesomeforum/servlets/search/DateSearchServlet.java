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

@WebServlet("/searchDates")
public class DateSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String searchDateString = request.getParameter("searchText");

		List<Entry> entries = EntrySearchLogic.searchEntriesByDate(searchDateString);
		if (entries != null) {
			request.setAttribute("entries", entries);
		} else {
			String errorString = "Please enter a valid date in DD/MM/YYYY format";
			request.setAttribute("errorString", errorString);
		}
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/search/searchEntries.jsp");
		requestDispatcher.forward(request, response);
		
	}

}
