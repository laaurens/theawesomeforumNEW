package com.fdmgroup.theawesomeforum.forum;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fdmgroup.theawesomeforum.forum.category.Category;
import com.fdmgroup.theawesomeforum.forum.category.CategoryJPACRUD;
import com.fdmgroup.theawesomeforum.forum.discussion.Discussion;
import com.fdmgroup.theawesomeforum.forum.discussion.DiscussionJPACRUD;
import com.fdmgroup.theawesomeforum.forum.entry.Entry;
import com.fdmgroup.theawesomeforum.forum.entry.EntryJPACRUD;
import com.fdmgroup.theawesomeforum.forum.profanity.Profanity;
import com.fdmgroup.theawesomeforum.forum.profanity.ProfanityJPACRUD;
import com.fdmgroup.theawesomeforum.forum.subcategory.Subcategory;
import com.fdmgroup.theawesomeforum.forum.subcategory.SubcategoryJPACRUD;
import com.fdmgroup.theawesomeforum.user.User;
import com.fdmgroup.theawesomeforum.user.UserJPACRUD;
import com.fdmgroup.theawesomeforum.utility.JPAConnectionManager;

public class DatabaseDummyData {

	CategoryJPACRUD categoryJPACRUD;
	DiscussionJPACRUD discussionJPACRUD;
	UserJPACRUD userJPACRUD;
	SubcategoryJPACRUD subcategoryJPACRUD;
	ProfanityJPACRUD profanityJPADRUD;
	EntryJPACRUD entryJPACRUD;

	public DatabaseDummyData() {
		categoryJPACRUD = new CategoryJPACRUD();
		discussionJPACRUD = new DiscussionJPACRUD();
		userJPACRUD = new UserJPACRUD();
		profanityJPADRUD = new ProfanityJPACRUD();
		entryJPACRUD = new EntryJPACRUD();
	}

	public void run() {

		User user1 = new User("Olive", false, "password", "Olliver", null, "Glasgow", null, null, null, null);
		User user2 = new User("laurens", true, "password", "Laurens", "Pollock", "Pollock Castle", null, null, null, null);
		userJPACRUD.create(user1);
		userJPACRUD.create(user2);

		User user3 = new User("Linda", false, "password");
		User user4 = new User("Xi", false, "password", "Xi", "Pudewill", "Loch Lomond", "..", null, null, "xi++@googlemail.com");
		User user5 = new User("biene1990", false, "password", "Biene", "Maya", "Glasgow", "guck mal da fliegt eine Birne", null , null, "b.12@t-online.de");

		userJPACRUD.create(user3);
		userJPACRUD.create(user4);
		userJPACRUD.create(user5);

		Entry entry1OfDiscussion1OfSubcategory1 = new Entry(
				"1 Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
				user1);
		Entry entry1OfDiscussion1OfSubcategory2 = new Entry(
				"2 Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Turpis massa tincidunt dui ut. Metus dictum at tempor commodo ullamcorper a lacus vestibulum sed. Aliquam purus sit amet luctus. Cras fermentum odio eu feugiat pretium nibh ipsum consequat.",
				user1);
		Entry entry1OfDiscussion1OfSubcategory3 = new Entry(
				"3 Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Turpis massa tincidunt dui ut. Metus dictum at tempor commodo ullamcorper a lacus vestibulum sed. Aliquam purus sit amet luctus. Cras fermentum odio eu feugiat pretium nibh ipsum consequat.(-5)",
				user2);
		Entry entry1OfDiscussion1OfSubcategory4 = new Entry(
				"4 Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Turpis massa tincidunt dui ut. Metus dictum at tempor commodo ullamcorper a lacus vestibulum sed. Aliquam purus sit amet luctus. Cras fermentum odio eu feugiat pretium nibh ipsum consequat.",
				user3);
		Entry entry1OfDiscussion1OfSubcategory5 = new Entry(
				"5 ed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Turpis massa tincidunt dui ut. Metus dictum at tempor commodo ullamcorper a lacus vestibulum sed. Aliquam purus sit amet luctus. Cras fermentum odio eu feugiat pretium nibh ipsum consequat.",
				user4);
		Entry entry1OfDiscussion1OfSubcategory6 = new Entry(
				"6 Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Turpis massa tincidunt dui ut. Metus dictum at tempor commodo ullamcorper a lacus vestibulum sed. Aliquam purus sit amet luctus. Cras fermentum odio eu feugiat pretium nibh ipsum consequat.",
				user3);
		Entry entry1OfDiscussion1OfSubcategory7 = new Entry(
				"7 consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Turpis massa tincidunt dui ut. Metus dictum at tempor commodo ullamcorper a lacus vestibulum sed. Aliquam purus sit amet luctus. Cras fermentum odio eu feugiat pretium nibh ipsum consequat.(today)",
				user2);
		Entry entry1OfDiscussion1OfSubcategory8 = new Entry(
				"8 Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Turpis massa tincidunt dui ut. Metus dictum at tempor commodo ullamcorper a lacus vestibulum sed. Aliquam purus sit amet luctus. Cras fermentum odio eu feugiat pretium nibh ipsum consequat.",
				user1);
		Entry entry1OfDiscussion1OfSubcategory9 = new Entry(
				"9 Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Turpis massa tincidunt dui ut. Metus dictum at tempor commodo ullamcorper a lacus vestibulum sed. Aliquam purus sit amet luctus. Cras fermentum odio eu feugiat pretium nibh ipsum consequat.",
				user4);
		Entry entry1OfDiscussion1OfSubcategory10 = new Entry(
				"10 Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Turpis massa tincidunt dui ut. Metus dictum at tempor commodo ullamcorper a lacus vestibulum sed. Aliquam purus sit amet luctus. Cras fermentum odio eu feugiat pretium nibh ipsum consequat.(-3)",
				user2);
		Entry entry1OfDiscussion1OfSubcategory11 = new Entry(
				"11 Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Turpis massa tincidunt dui ut. Metus dictum at tempor commodo ullamcorper a lacus vestibulum sed. Aliquam purus sit amet luctus. Cras fermentum odio eu feugiat pretium nibh ipsum consequat.",
				user3);
		Entry entry1OfDiscussion1OfSubcategory12 = new Entry(
				"11 Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Turpis massa tincidunt dui ut. Metus dictum at tempor commodo ullamcorper a lacus vestibulum sed. Aliquam purus sit amet luctus. Cras fermentum odio eu feugiat pretium nibh ipsum consequat.",
				user5);

		entry1OfDiscussion1OfSubcategory3.setDateOfEntry(LocalDateTime.now().minusDays(5));
		entry1OfDiscussion1OfSubcategory11.setDateOfEntry(LocalDateTime.now().minusDays(3));

		List<Entry> listOfEntriesOfDiscussion1OfSubcategory1 = new ArrayList<Entry>();
		listOfEntriesOfDiscussion1OfSubcategory1.add(entry1OfDiscussion1OfSubcategory1);
		listOfEntriesOfDiscussion1OfSubcategory1.add(entry1OfDiscussion1OfSubcategory2);
		listOfEntriesOfDiscussion1OfSubcategory1.add(entry1OfDiscussion1OfSubcategory3);
		listOfEntriesOfDiscussion1OfSubcategory1.add(entry1OfDiscussion1OfSubcategory4);
		listOfEntriesOfDiscussion1OfSubcategory1.add(entry1OfDiscussion1OfSubcategory5);
		listOfEntriesOfDiscussion1OfSubcategory1.add(entry1OfDiscussion1OfSubcategory6);
		listOfEntriesOfDiscussion1OfSubcategory1.add(entry1OfDiscussion1OfSubcategory7);
		listOfEntriesOfDiscussion1OfSubcategory1.add(entry1OfDiscussion1OfSubcategory8);
		listOfEntriesOfDiscussion1OfSubcategory1.add(entry1OfDiscussion1OfSubcategory9);
		listOfEntriesOfDiscussion1OfSubcategory1.add(entry1OfDiscussion1OfSubcategory10);
		listOfEntriesOfDiscussion1OfSubcategory1.add(entry1OfDiscussion1OfSubcategory11);
		listOfEntriesOfDiscussion1OfSubcategory1.add(entry1OfDiscussion1OfSubcategory12);
		List<Entry> listOfEntriesOfDiscussion2OfSubcategory1 = new ArrayList<Entry>();
		List<Entry> listOfEntriesOfDiscussion1OfSubcategory5 = new ArrayList<Entry>();

		Discussion discussion1OfSubcategory1 = new Discussion("Annotation for Bean validation",
				listOfEntriesOfDiscussion1OfSubcategory1);
		Discussion discussion2OfSubcategory1 = new Discussion("Annotation JPA",
				listOfEntriesOfDiscussion2OfSubcategory1);
		Discussion discussion1OfSubcategory5 = new Discussion("CSS button", listOfEntriesOfDiscussion1OfSubcategory5);

		List<Discussion> listOfDiscussionsOfSubcategory1 = new ArrayList<Discussion>();
		listOfDiscussionsOfSubcategory1.add(discussion1OfSubcategory1);
		listOfDiscussionsOfSubcategory1.add(discussion2OfSubcategory1);

		List<Discussion> listOfDiscussionsOfSubcategory2 = new ArrayList<Discussion>();
		List<Discussion> listOfDiscussionsOfSubcategory3 = new ArrayList<Discussion>();
		List<Discussion> listOfDiscussionsOfSubcategory4 = new ArrayList<Discussion>();
		List<Discussion> listOfDiscussionsOfSubcategory5 = new ArrayList<Discussion>();
		listOfDiscussionsOfSubcategory5.add(discussion1OfSubcategory5);
		List<Discussion> listOfDiscussionsOfSubcategory6 = new ArrayList<Discussion>();

		Subcategory javaEEsubcategory1 = new Subcategory("Annotations", "Beschreibung lalala",
				listOfDiscussionsOfSubcategory1);
		Subcategory javaEEsubcategory2 = new Subcategory("Persistence", "Beschreibung lalala",
				listOfDiscussionsOfSubcategory2);
		Subcategory javaEEsubcategory3 = new Subcategory("Servlets", "Beschreibung lalala",
				listOfDiscussionsOfSubcategory3);

		List<Subcategory> javaEESubCategoryList = new ArrayList<Subcategory>();
		javaEESubCategoryList.add(javaEEsubcategory1);
		javaEESubCategoryList.add(javaEEsubcategory2);
		javaEESubCategoryList.add(javaEEsubcategory3);

		Subcategory subcategory4 = new Subcategory("HTML", "Beschreibung lalala", listOfDiscussionsOfSubcategory4);
		Subcategory subcategory5 = new Subcategory("CSS", "Beschreibung lalala", listOfDiscussionsOfSubcategory5);
		Subcategory subcategory6 = new Subcategory("JQuery", "Beschreibung lalala", listOfDiscussionsOfSubcategory6);

		List<Subcategory> listOfSubCategories2 = new ArrayList<Subcategory>();
		listOfSubCategories2.add(subcategory4);
		listOfSubCategories2.add(subcategory5);
		listOfSubCategories2.add(subcategory6);

		Category category1 = new Category("Java EE", javaEESubCategoryList);
		Category category2 = new Category("Webdesign", listOfSubCategories2);

		categoryJPACRUD.create(category1);
		categoryJPACRUD.create(category2);

		// User user5 = new User("I4mNotLion3l", false, "password",
		// listOfDiscussionsOfSubcategory1,
		// listOfEntriesOfDiscussion1OfSubcategory1);
		// userJPACRUD.create(user5);

		Profanity profanities1 = new Profanity("Profanity");
		Profanity profanities2 = new Profanity("Bullocks");
		Profanity profanities3 = new Profanity("Brexit");

		profanityJPADRUD.create(profanities1);
		profanityJPADRUD.create(profanities2);
		profanityJPADRUD.create(profanities3);

		System.out.println(entry1OfDiscussion1OfSubcategory1.getUser().getUserName());
		// categoryJPACRUD.getJPAConnectionManager().closeEntityManagerFactory();

		List<Entry> entries = userJPACRUD.findAllEntriesFromOneUserSortedByDate(user2);
		for (Entry temp : entries) {
			System.out.println(temp);
		}
		
		JPAConnectionManager.getJPAConnectionManager("theawesomeforum").closeEntityManagerFactory();
		
	}
}
