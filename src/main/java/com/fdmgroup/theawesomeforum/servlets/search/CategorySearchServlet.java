package com.fdmgroup.theawesomeforum.servlets.search;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fdmgroup.theawesomeforum.forum.category.Category;
import com.fdmgroup.theawesomeforum.forum.category.CategoryService;

@WebServlet("/searchCategories")
public class CategorySearchServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String searchString = request.getParameter("searchText");
		CategoryService categoryService = new CategoryService();
		List<Category> categories = categoryService.findByString(searchString);

		request.setAttribute("categories", categories);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/search/searchCategories.jsp");
		requestDispatcher.forward(request, response); 
	}
}
