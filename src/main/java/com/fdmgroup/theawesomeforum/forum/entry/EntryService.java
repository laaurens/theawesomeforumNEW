package com.fdmgroup.theawesomeforum.forum.entry;

import java.time.LocalDateTime;
import java.util.List;

import com.fdmgroup.theawesomeforum.user.User;
import com.fdmgroup.theawesomeforum.utility.ForumServiceInterface;

public class EntryService implements ForumServiceInterface<Entry>{

	private EntryJPACRUD entryJPACRUD;

	public EntryService() {
		entryJPACRUD = new EntryJPACRUD();
	}

	public EntryService(EntryJPACRUD entryJPACRUD) {
		this.entryJPACRUD = entryJPACRUD;
	}

	public void create(Entry entry) {
		entryJPACRUD.create(entry);
	}

	public void delete(long id) {
		entryJPACRUD.delete(id);
	}

	public void update(Entry entry) {
		entryJPACRUD.update(entry);
	}

	public List<Entry> readAll() {
		return entryJPACRUD.readAll();
	} 

	public Entry readById(long id) {
		return entryJPACRUD.readOneById(id);
	}

	public long count() {
		return entryJPACRUD.count();		
	}
	
	public long countForOneUser(User user) {
		return entryJPACRUD.readAllFromOneUser(user).size();		
	}
	
	public List<Entry> findByString(String searchString){
		return entryJPACRUD.findByString(searchString);
	}
	
	public List<Entry> findByDate(LocalDateTime dateOfEntry){
		List<Entry> entries = entryJPACRUD.findByDate(dateOfEntry);
		 return entries;
	}
	
}
