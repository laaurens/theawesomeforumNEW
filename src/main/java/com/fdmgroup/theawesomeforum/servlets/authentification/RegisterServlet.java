package com.fdmgroup.theawesomeforum.servlets.authentification;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fdmgroup.theawesomeforum.user.User;
import com.fdmgroup.theawesomeforum.user.UserService;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private RegisterLogic registerLogic;
	private User user;
	private UserService userService;

	public RegisterServlet() {
		registerLogic = new RegisterLogic();
		userService = new UserService();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/register.jsp");
		requestDispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		user = registerLogic.registerUser(request);		
		if(user != null) {
			userService.create(user);
		}
		
		RequestDispatcher requestdispatcher = request.getRequestDispatcher("WEB-INF/register.jsp");
		requestdispatcher.forward(request, response);
	}
}
