package com.fdmgroup.theawesomeforum.user;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import com.fdmgroup.theawesomeforum.user.User;
import com.fdmgroup.theawesomeforum.user.UserJPACRUD;
import com.fdmgroup.theawesomeforum.user.UserService;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

	@Mock
	UserJPACRUD userJPACRUD;
	User user;

	UserService userService;

	@Before
	public void setUpBeforeClass() {
		MockitoAnnotations.initMocks(this);
		userService = new UserService(userJPACRUD);
		user = new User();
	}

	@Test
	public void test_addUser() {
		userService.create(user);
		Mockito.verify(userJPACRUD).create(user);
	}

	@Test
	public void test_removeUser() {
		userService.delete(user.getId());
		Mockito.verify(userJPACRUD).delete(user.getId());
	}

	@Test
	public void test_updateUser() {
		userService.update(user);
		Mockito.verify(userJPACRUD).update(user);
	}

	@Test
	public void test_findAllCategories() {
		userService.readAll();
		Mockito.verify(userJPACRUD).readAll();
	} 

	@Test
	public void test_findUserById() {
		userService.readById(1);
		Mockito.verify(userJPACRUD).readOneById(1);
	}
	
	@Test
	public void test_countUsers() {
		userService.count();
		Mockito.verify(userJPACRUD).count();
	}
	
	
	
}
