package com.fdmgroup.theawesomeforum.user;

import java.util.List;

import com.fdmgroup.theawesomeforum.forum.entry.Entry;
import com.fdmgroup.theawesomeforum.utility.ForumServiceInterface;

public class UserService implements ForumServiceInterface<User> {

	private UserJPACRUD userJPACRUD;

	public UserService() {
		userJPACRUD = new UserJPACRUD();
	}

	public UserService(UserJPACRUD userJPACRUD) {
		this.userJPACRUD = userJPACRUD;
	}

	public void create(User user) {
		userJPACRUD.create(user);
	}

	public void delete(long id) {
		userJPACRUD.delete(id);
	}

	public void update(User user) {
		userJPACRUD.update(user);
	}

	public List<User> readAll() {
		return userJPACRUD.readAll();
	}

	public User readById(long id) {
		return userJPACRUD.readOneById(id);
	}

	public User readByName(String userName) {
		return userJPACRUD.readOneByName(userName);
	}

	@Override
	public long count() {
		return userJPACRUD.count();
	}

	public List<User> findByName(String string) {
		return userJPACRUD.findByString(string);
	}

	public List<Entry> findAllEntriesForOneUserSortedByDate(User user) {
		List<Entry> entries = userJPACRUD.findAllEntriesFromOneUserSortedByDate(user);
		return entries;
	}

	public List<User> readByEmail(String string) {
		return userJPACRUD.readByEmail(string);
	}

	public List<User> readByBirthday(String string) {
		return userJPACRUD.readByBirthday(string);

	}

}
