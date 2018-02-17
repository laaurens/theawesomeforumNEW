package com.fdmgroup.theawesomeforum.validator;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.fdmgroup.theawesomeforum.user.User;
import com.fdmgroup.theawesomeforum.user.UserJPACRUD;
import com.fdmgroup.theawesomeforum.validator.UserRightsValidator;

public class UserRightsValidatorTest {

	UserRightsValidator userRightsValidator;
	@Mock
	UserJPACRUD userJPACRUD;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		userRightsValidator = new UserRightsValidator(userJPACRUD);
	}

	@Test
	public void test_isadmin_returnsTrue_whenUserIsAdmin() {
		User user = new User("Marvin", true, "password");
		Mockito.when(userJPACRUD.readOneByName("Marvin")).thenReturn(user);
		boolean expectedResult = userRightsValidator.isAdmin("Marvin");
		assertTrue(expectedResult);
	}
	
	@Test
	public void test_isadmin_returnsFalse_whenUserIsNotAnAdmin() {
		User user = new User("Marvin", false, "password");
		Mockito.when(userJPACRUD.readOneByName("Marvin")).thenReturn(user);
		boolean expectedResult = userRightsValidator.isAdmin("Marvin");
		assertFalse(expectedResult);
	}

}
