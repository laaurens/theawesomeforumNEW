package com.fdmgroup.theawesomeforum.user;

import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import com.fdmgroup.theawesomeforum.validator.RegisterValidator;

@RunWith(MockitoJUnitRunner.class)
public class RegisterValidatorTest {
	
	@Mock
	UserJPACRUD userJPACRUD;
	RegisterValidator registerValidator;
	String validEmail;
	String invalidEmail;

	@Before
	public void setUpBeforeClass() {
		MockitoAnnotations.initMocks(this);
		registerValidator = new RegisterValidator(userJPACRUD);
		validEmail = "test@test.de";
		validEmail = "test@test.de";
	}
	
	@Test
	public void test_validateEmail_returnsTrueIfEmailIsValid() {
		registerValidator.validateEmail(validEmail);
		Mockito.verify(userJPACRUD).readByEmail(validEmail);
	}
	
	@Test
	public void test_validateEmail_returnsTrueIfEmailIsInvalid() {
		Mockito.when(userJPACRUD.readByEmail(invalidEmail)).thenReturn(null);
		boolean actualResult = registerValidator.validateEmail(invalidEmail);
		assertFalse(actualResult);
	}
}
