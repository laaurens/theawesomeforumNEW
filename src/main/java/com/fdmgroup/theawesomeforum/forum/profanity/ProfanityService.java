package com.fdmgroup.theawesomeforum.forum.profanity;

import java.util.List;

import com.fdmgroup.theawesomeforum.utility.CRUD;
import com.fdmgroup.theawesomeforum.utility.ForumServiceInterface;

public class ProfanityService implements ForumServiceInterface<Profanity> {

	private CRUD<Profanity> entryJPACRUD;

	public ProfanityService() {
		entryJPACRUD = new ProfanityJPACRUD();
	}

	public ProfanityService(ProfanityJPACRUD entryJPACRUD) {
		this.entryJPACRUD = entryJPACRUD;
	}

	public void create(Profanity entry) {
		entryJPACRUD.create(entry);
	}

	public void delete(long id) {
		entryJPACRUD.delete(id);
	}

	public void update(Profanity entry) {
		entryJPACRUD.update(entry);
	}

	public List<Profanity> readAll() {
		return entryJPACRUD.readAll();
	}

	public Profanity readById(long id) {
		return entryJPACRUD.readOneById(id);
	}

	public long count() {
		return entryJPACRUD.count();
	}

	public List<Profanity> findByString(String searchString) {
		return entryJPACRUD.findByString(searchString);
	}

}
