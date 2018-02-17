package com.fdmgroup.theawesomeforum.servlets.search.logic;

import java.io.IOException;
import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.ServletException;

import com.fdmgroup.theawesomeforum.forum.entry.Entry;
import com.fdmgroup.theawesomeforum.forum.entry.EntryService;
import com.fdmgroup.theawesomeforum.user.User;
import com.fdmgroup.theawesomeforum.user.UserService;

public class EntrySearchLogic {
 
	public static List<Entry> searchEntriesByDate(String searchString) throws ServletException, IOException {
		LocalDateTime searchDate;
		List<Entry> entries = null;
		try {
			searchDate = parseDate(searchString);
			entries = retrieveEntries(searchDate);
			attachUserToEntries(entries);
		} catch (DateTimeException | NumberFormatException | StringIndexOutOfBoundsException e) {
//			String errorString = "Please enter a valid date in DD/MM/YYYY format";
		}
		return entries;
	}
	
	public static List<Entry> searchEntries(String searchString)
			throws ServletException, IOException {
		EntryService entryService = new EntryService();
		List<Entry> entries = entryService.findByString(searchString);
		attachUserToEntries(entries);
		return entries;
	}
	
	private static void attachUserToEntries(List<Entry> entries) {
		UserService userService = new UserService();
		for (Entry entry : entries) {
			entry = getEntrysUserFromDatabase(entry, userService);
		}
	}

	private static List<Entry> retrieveEntries(LocalDateTime searchDate) {
		List<Entry> entries;
		EntryService entryService = new EntryService();
		entries = entryService.findByDate(searchDate);
		return entries;
	}

	private static LocalDateTime parseDate(String searchDateString) {
		LocalDateTime searchDate;
		int day = Integer.parseInt(searchDateString.substring(0, 2));
		int month = Integer.parseInt(searchDateString.substring(3, 5));
		int year = Integer.parseInt(searchDateString.substring(6, 10));
		searchDate = LocalDateTime.of(year, month, day,0,0,0);
		return searchDate;
	}
	
	private static Entry getEntrysUserFromDatabase(Entry entry, UserService userService) {
		long userId = entry.getUserId();
		User user = userService.readById(userId);
		entry.setUser(user);
		return entry;
	}
}
