package com.fdmgroup.theawesomeforum.servlets.discussion;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fdmgroup.theawesomeforum.forum.discussion.Discussion;
import com.fdmgroup.theawesomeforum.forum.entry.Entry;
import com.fdmgroup.theawesomeforum.forum.profanity.Profanity;
import com.fdmgroup.theawesomeforum.forum.profanity.ProfanityFilterLogic;
import com.fdmgroup.theawesomeforum.forum.profanity.ProfanityService;
import com.fdmgroup.theawesomeforum.forum.subcategory.Subcategory;
import com.fdmgroup.theawesomeforum.forum.subcategory.SubcategoryService;
import com.fdmgroup.theawesomeforum.user.User;
import com.fdmgroup.theawesomeforum.user.UserService;

@WebServlet("/newdiscussion")
public class NewDiscissionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SubcategoryService subcategoryService = new SubcategoryService();
	private UserService userService;
	ProfanityService profanityService;
	List<Profanity> profanities;
	private User loggedInUser;
	private String discussionContent;
	private String title;
	private String subcategoryId;

	public NewDiscissionServlet() {
		subcategoryService = new SubcategoryService();
		profanityService = new ProfanityService();
		userService = new UserService();
		loggedInUser = new User();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();		
		subcategoryId = request.getParameter("subcategoryId");
		
		filterData(request);
		Subcategory subcategory = generateDiscussion(session);
		
		request.setAttribute("subcategory", subcategory);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/subcategory.jsp");
		requestDispatcher.forward(request, response);
	}

	private Subcategory generateDiscussion(HttpSession session) {
		loggedInUser = userService.readByName((String) session.getAttribute("username"));
		Entry entry = new Entry(discussionContent, loggedInUser);
		Subcategory subcategory = generateDiscussion(subcategoryId, title, entry);
		return subcategory;
	}

	private void filterData(HttpServletRequest request) {
		profanities = profanityService.readAll();
		discussionContent = filterDiscussionContent(request, profanities);
		title = filterTitle(request, profanities);
	}

	private String filterTitle(HttpServletRequest request, List<Profanity> profanities) {
		String title = request.getParameter("title");
		title = ProfanityFilterLogic.filterProfanities(title, profanities);
		return title;
	}

	private String filterDiscussionContent(HttpServletRequest request, List<Profanity> profanities) {
		String discussionContent = request.getParameter("discussion");
		discussionContent = ProfanityFilterLogic.filterProfanities(discussionContent, profanities);
		return discussionContent;
	}

	private Subcategory generateDiscussion(String subcategoryId, String title, Entry entry) {
		List<Entry> firstEntry = new ArrayList<Entry>();
		firstEntry.add(entry);
		Discussion discussion = new Discussion(title, firstEntry);
		long id = Long.parseLong(subcategoryId);
		Subcategory subcategory = subcategoryService.readById(id);
		subcategory.getDiscussions().add(discussion);
		subcategoryService.update(subcategory);
		return subcategory;
	}
}