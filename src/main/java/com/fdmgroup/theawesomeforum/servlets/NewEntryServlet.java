package com.fdmgroup.theawesomeforum.servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.fdmgroup.theawesomeforum.forum.discussion.Discussion;
import com.fdmgroup.theawesomeforum.forum.discussion.DiscussionService;
import com.fdmgroup.theawesomeforum.forum.entry.Entry;
import com.fdmgroup.theawesomeforum.forum.profanity.ProfanityFilterLogic;
import com.fdmgroup.theawesomeforum.forum.profanity.ProfanityService;
import com.fdmgroup.theawesomeforum.user.User;
import com.fdmgroup.theawesomeforum.user.UserService;
import com.fdmgroup.theawesomeforum.utility.ForumServiceInterface;

@WebServlet("/newentry") 
public class NewEntryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ForumServiceInterface<Discussion> discussionService;
	private UserService userService;
	private User loggedInUser;

	private List<Entry> listOfEntries;
	private Map<Long, User> userToIdMap = new HashMap<>();
    /**
     * @see HttpServlet#HttpServlet()
     */

	private ProfanityService profanityService;
    public NewEntryServlet() {
    	discussionService = new DiscussionService();
    	profanityService = new ProfanityService();
    	userService = new UserService();
    	loggedInUser = new User();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String entryContent = request.getParameter("entry");
		String discussionId = request.getParameter("discussionId");	
		loggedInUser = userService.readByName((String) session.getAttribute("username"));
		entryContent = ProfanityFilterLogic.filterProfanities(entryContent, profanityService.readAll());	
		
		Discussion discussion = generateEntry(entryContent, discussionId);
		
		listOfEntries = discussion.getEntries();
		for (Entry entryHolder : listOfEntries) {
			userToIdMap.put(entryHolder.getUserId(), userService.readById(entryHolder.getUserId()));
		}
		request.setAttribute("userToIdMap", userToIdMap);
		request.setAttribute("discussion", discussion);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/discussion.jsp");
		requestDispatcher.forward(request, response);
	}

	private Discussion generateEntry(String entryContent, String discussionId) {
		Entry entry = new Entry(entryContent, loggedInUser);
		long id = Long.parseLong(discussionId);
		Discussion discussion = discussionService.readById(id);
		discussion.getEntries().add(entry);
		discussionService.update(discussion);
		return discussion;
	}

}
