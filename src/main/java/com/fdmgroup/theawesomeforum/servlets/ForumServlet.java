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

import com.fdmgroup.theawesomeforum.forum.category.Category;
import com.fdmgroup.theawesomeforum.forum.category.CategoryService;
import com.fdmgroup.theawesomeforum.utility.ForumServiceInterface;

@WebServlet("/forum") 
public class ForumServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ForumServiceInterface<Category> categoryService;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		request.setAttribute("session", session);
		categoryService = new CategoryService();
		List<Category> categories = categoryService.readAll();
		
		request.setAttribute("categories", categories);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/forum.jsp");
		requestDispatcher.forward(request, response);
	}

}  
