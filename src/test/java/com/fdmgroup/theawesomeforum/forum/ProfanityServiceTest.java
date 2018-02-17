package com.fdmgroup.theawesomeforum.forum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import com.fdmgroup.theawesomeforum.forum.profanity.Profanity;
import com.fdmgroup.theawesomeforum.forum.profanity.ProfanityJPACRUD;
import com.fdmgroup.theawesomeforum.forum.profanity.ProfanityService;
import com.fdmgroup.theawesomeforum.user.User;

@RunWith(MockitoJUnitRunner.class)
public class ProfanityServiceTest {

	@Mock
	ProfanityJPACRUD profanityJPACRUD;
	Profanity profanity;
	User user;
	
	ProfanityService profanityService;

	@Before
	public void setUpBeforeClass() {
		MockitoAnnotations.initMocks(this);
		profanityService = new ProfanityService(profanityJPACRUD);
		profanity = new Profanity();
		user = new User();
	}

	@Test
	public void test_addProfanity() {
		profanityService.create(profanity);
		Mockito.verify(profanityJPACRUD).create(profanity);
	}

	@Test
	public void test_removeProfanity() {
		profanityService.delete(profanity.getId());
		Mockito.verify(profanityJPACRUD).delete(profanity.getId());
	}

	@Test
	public void test_updateProfanity() {
		profanityService.update(profanity);
		Mockito.verify(profanityJPACRUD).update(profanity);
	}

	@Test
	public void test_findAllCategories() {
		profanityService.readAll();
		Mockito.verify(profanityJPACRUD).readAll();
	}

	@Test
	public void test_findProfanityById() {
		profanityService.readById(1);
		Mockito.verify(profanityJPACRUD).readOneById(1);
	}
	
	@Test
	public void test_countCategories() {
		profanityService.count();
		Mockito.verify(profanityJPACRUD).count();
	}
	
	@Test
	public void test_findProfanityByString() {
		profanityService.findByString("TestString");
		Mockito.verify(profanityJPACRUD).findByString("TestString");
	}
	
}
