package com.fdmgroup.theawesomeforum.servlets.discussion;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.fdmgroup.theawesomeforum.forum.discussion.Discussion;
import com.fdmgroup.theawesomeforum.forum.discussion.DiscussionService;
import com.fdmgroup.theawesomeforum.forum.entry.Entry;
import com.fdmgroup.theawesomeforum.user.User;
import com.fdmgroup.theawesomeforum.user.UserService;
import com.fdmgroup.theawesomeforum.utility.ForumServiceInterface;

public class DiscussionLogic {

	private static ForumServiceInterface<Discussion> discussionService;
	private static UserService userService;
	private static List<Entry> listOfEntries;
	private static Map<Long, User> userToIdMap;
	
	public static void fetchDiscussionsFromService(HttpServletRequest request, String discussionId) {
		HttpSession session = request.getSession();
		Discussion discussion = prepareDiscussionData(discussionId);
		restrictViewIfNotLoggedIn(request, session, discussion);
		prepareListOfEntries(request, discussion);
	}

	private static void prepareListOfEntries(HttpServletRequest request, Discussion discussion) {
		listOfEntries = discussion.getEntries();
		for (Entry entryHolder : listOfEntries) {
			userToIdMap.put(entryHolder.getUserId(), userService.readById(entryHolder.getUserId()));
		}
		request.setAttribute("userToIdMap", userToIdMap);
	}

	private static Discussion prepareDiscussionData(String discussionId) {
		userToIdMap = new HashMap<>();
		discussionService = new DiscussionService();
		userService = new UserService();
		long id = Long.parseLong(discussionId);
		Discussion discussion = discussionService.readById(id);
		return discussion;
	}

	private static void restrictViewIfNotLoggedIn(HttpServletRequest request, HttpSession session,
			Discussion discussion) {
		Discussion restrictedDiscussion = new Discussion();
		if (session.getAttribute("username") == null && discussion.getEntries().size() > 10) {
			restrictedDiscussion.setEntries(discussion.getEntries().subList(0, 10));
			request.setAttribute("discussion", restrictedDiscussion);
		} else {
			request.setAttribute("discussion", discussion);

		}
	}
}
