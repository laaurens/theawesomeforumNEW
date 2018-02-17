package com.fdmgroup.theawesomeforum.forum.discussion;

import java.util.List;

import com.fdmgroup.theawesomeforum.forum.entry.Entry;
import com.fdmgroup.theawesomeforum.forum.entry.EntryJPACRUD;
import com.fdmgroup.theawesomeforum.user.User;
import com.fdmgroup.theawesomeforum.utility.ForumServiceInterface;

public class DiscussionService implements ForumServiceInterface<Discussion> {

	private DiscussionJPACRUD discussionJPACRUD;	
	
	public DiscussionService() {
		discussionJPACRUD = new DiscussionJPACRUD();
	}

	public DiscussionService(DiscussionJPACRUD discussionJPACRUD) {
		this.discussionJPACRUD = discussionJPACRUD;
	}

	public void create(Discussion discussion) {
		discussionJPACRUD.create(discussion);
	}

	public void delete(long id) {
		discussionJPACRUD.delete(id);
	}

	public void update(Discussion discussion) {
		discussionJPACRUD.update(discussion);
	}

	public List<Discussion> readAll() {
		return discussionJPACRUD.readAll();
	}

	public Discussion readById(long id) {
		return discussionJPACRUD.readOneById(id);
	}

	public long count() {
		return discussionJPACRUD.count();

	}
	

	public long countDiscussionsForOneUser(User user) {
		return discussionJPACRUD.readAllFromOneUser(user).size();
	}
	
	public List<Discussion> findByString(String string){
		 return this.discussionJPACRUD.findByString(string);
	}
	
//	public Discussion findByEntryId(long entryId) {
//		return discussionJPACRUD.findByEntryId(entryId);
//	}

}