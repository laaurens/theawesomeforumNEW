package com.fdmgroup.theawesomeforum.forum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import com.fdmgroup.theawesomeforum.forum.discussion.Discussion;
import com.fdmgroup.theawesomeforum.forum.discussion.DiscussionJPACRUD;
import com.fdmgroup.theawesomeforum.forum.discussion.DiscussionService;
import com.fdmgroup.theawesomeforum.user.User;

@RunWith(MockitoJUnitRunner.class)
public class DiscussionServiceTest {

	@Mock
	DiscussionJPACRUD discussionJPACRUD;
	Discussion discussion;
	User user;
	
	DiscussionService discussionService;

	@Before
	public void setUpBeforeClass() {
		MockitoAnnotations.initMocks(this);
		discussionService = new DiscussionService(discussionJPACRUD);
		discussion = new Discussion();
		user = new User();
	}

	@Test
	public void test_addDiscussion() {
		discussionService.create(discussion);
		Mockito.verify(discussionJPACRUD).create(discussion);
	}

	@Test 
	public void test_removeDiscussion() {
		discussionService.delete(discussion.getId());
		Mockito.verify(discussionJPACRUD).delete(discussion.getId());
	}

	@Test
	public void test_updateDiscussion() {
		discussionService.update(discussion);
		Mockito.verify(discussionJPACRUD).update(discussion);
	}

	@Test
	public void test_findAllDiscussions() {
		discussionService.readAll();
		Mockito.verify(discussionJPACRUD).readAll();
	} 

	@Test
	public void test_findDiscussionById() {
		discussionService.readById(1);
		Mockito.verify(discussionJPACRUD).readOneById(1);
	}
	
	@Test
	public void test_countDiscussions() {
		discussionService.count();
		Mockito.verify(discussionJPACRUD).count();
	}
	
	@Test
	public void test_countDiscussionsForOneUser() {
		discussionService.countDiscussionsForOneUser(user);
		Mockito.verify(discussionJPACRUD).readAllFromOneUser(user);
	}
	
	
}
