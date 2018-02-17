package com.fdmgroup.theawesomeforum.servlets.search;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/distributionServlet")
public class DistributionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String searchString = request.getParameter("searchText");
		searchString = searchString.toLowerCase();
		searchString = searchString.trim();
		searchString = "%" + searchString + "%";
		
		String searchType = request.getParameter("searchType");
		String searchText =  request.getParameter("searchText");
		request.setAttribute("searchType", request.getParameter("searchType"));
		request.setAttribute("searchText", searchText);
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(searchType);
		requestDispatcher.forward(request, response);
	}
	
}
