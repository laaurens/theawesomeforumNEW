package com.fdmgroup.theawesomeforum.servlets.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fdmgroup.theawesomeforum.forum.profanity.ProfanityService;

/**
 * Servlet implementation class deleteProfanity
 */
@WebServlet("/deleteProfanity")
public class DeleteProfanity extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProfanityService profanityService;
       
    public DeleteProfanity() {
    	profanityService= new ProfanityService();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String profanityContent =request.getParameter("profanity");
		
		profanityService.delete(profanityService.findByString(profanityContent).get(0).getId());;
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/admin");
		requestDispatcher.forward(request, response);
	}

}
