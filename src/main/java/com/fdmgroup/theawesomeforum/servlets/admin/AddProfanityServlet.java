package com.fdmgroup.theawesomeforum.servlets.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fdmgroup.theawesomeforum.forum.profanity.Profanity;
import com.fdmgroup.theawesomeforum.forum.profanity.ProfanityService;

@WebServlet("/addProfanity")
public class AddProfanityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProfanityService profanityService;   

    public AddProfanityServlet() {
    	profanityService= new ProfanityService();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   String profanityContent = request.getParameter("newProfanity");
			Profanity profanity=new Profanity(profanityContent);
			profanityService.create(profanity);
			System.out.println("TEST - " + profanity);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/admin");
			requestDispatcher.forward(request, response);
	}

}
