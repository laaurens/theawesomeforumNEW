package com.fdmgroup.theawesomeforum.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import com.fdmgroup.theawesomeforum.user.User;
import com.fdmgroup.theawesomeforum.user.UserJPACRUD;
import com.fdmgroup.theawesomeforum.validator.LoginValidator;

@RunWith(MockitoJUnitRunner.class)
public class LoginValidatorTest {

	@Mock
	UserJPACRUD userJPACRUD;
	
	LoginValidator loginValidator;
	boolean result;
	User validUser;
	User invalidUser; 
	
	@Before
	public void setUpBeforeClass() {
		MockitoAnnotations.initMocks(this); 
		loginValidator = new LoginValidator(userJPACRUD);
		validUser = new User("validUser", false, "password");
		invalidUser = new User("invalidUser", false, "password123");
		
	}

	@Test
	public void test_isUserRegistered_ReturnTrueWhenUserIsRegistered() {
		Mockito.when(userJPACRUD.readOneByName("validUser")).thenReturn(validUser);
		result = loginValidator.validateUsername("validUser");
		assertTrue(result);
	}
	
	@Test
	public void test_isUserRegistered_ReturnFalseWhenUserIsNotRegistered() {
		Mockito.when(userJPACRUD.readOneByName("invalidUser")).thenReturn(null);
		result = loginValidator.validateUsername("invalidUser");
		assertFalse(result);
	}

	@Test
	public void test_isPasswordCorrect_ReturnTrueIfPasswordIsValid() {
		Mockito.when(userJPACRUD.readOneByName("validUser")).thenReturn(validUser);
		loginValidator.validateUsername("validUser");
		result = loginValidator.validatePassword("validUser", "password");
		assertTrue(result);
	}
	
	@Test
	public void test_isPasswordCorrect_ReturnFalseIfPasswordIsInvalid() {
		Mockito.when(userJPACRUD.readOneByName("invalidUser")).thenReturn(invalidUser);
		loginValidator.validateUsername("invalidUser");
		result = loginValidator.validatePassword("invalidUser", "password");
		assertFalse(result);
	}
	
	@Test
	public void test_validateLogin_ReturnFalseIfUsernameIsInvalid() {
		Mockito.when(userJPACRUD.readOneByName("invalidUser")).thenReturn(invalidUser);
		result = loginValidator.validateLogin("invalidUser", "password");
		assertFalse(result);
	}
	
	@Test
	public void test_validateLogin_ReturnFalseIfUsernameIsValid() {
		Mockito.when(userJPACRUD.readOneByName("validUser")).thenReturn(validUser);
		result = loginValidator.validateLogin("validUser", "password");
		assertTrue(result);
	}
	
}
