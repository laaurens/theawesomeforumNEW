package com.fdmgroup.theawesomeforum.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fdmgroup.theawesomeforum.forum.subcategory.Subcategory;
import com.fdmgroup.theawesomeforum.forum.subcategory.SubcategoryService;
import com.fdmgroup.theawesomeforum.utility.ForumServiceInterface;


@WebServlet("/category")
public class SubcategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ForumServiceInterface<Subcategory> subcategoryService;
	
	public SubcategoryServlet() {
		subcategoryService = new SubcategoryService();
	} 

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String subcategoryId = request.getParameter("subcategoryId");
		long id = Long.parseLong(subcategoryId); 		
		Subcategory subcategory = subcategoryService.readById(id);
		
		request.setAttribute("subcategory", subcategory);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/subcategory.jsp");
		requestDispatcher.forward(request, response);

	}

}
