package com.fdmgroup.theawesomeforum.validator;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.fdmgroup.theawesomeforum.validator.passwordhandler.PasswordValidatorHandler;

public class PasswordValidatorChainTest {

	PasswordValidatorHandler passwordValidatorHandler;
	String password1 = "";
	String password2 = "a";
	String password3 = "aaaaaaaaaaaaaaaaa";
	String password4 = "aaaaaaa";
	String password5 = "aaaaaaa1";
	String password6 = "AAAAAAA1";
	String password7 = "aaaaaaa1A";
	String password8 = "aaaaaaa1A!";
	
	String lengthError = "Password should be between 7 and 14 characters long!";
	String numberError = "Password should have at least one number!";
	String caseError = "Password should have at least one upper and one lowercase letter!";
	String symbolError = "Password should have at least one symbol!";
	
	@Before
	public void setUp() throws Exception {
		passwordValidatorHandler  = new PasswordValidatorHandler();
	}

	@Test
	public void test_if_length_error_is_returned_when_there_is_no_password() {
		assertEquals(lengthError, passwordValidatorHandler.validatePassword(password1));
	}
	
	@Test 
	public void test_if_length_error_is_returned_when_there_is_a_short_password() {
		assertEquals(lengthError, passwordValidatorHandler.validatePassword(password2));
	}
	
	@Test
	public void test_if_length_error_is_returned_when_there_is_a_long_password() {
		assertEquals(lengthError, passwordValidatorHandler.validatePassword(password3));
	}
	
	@Test
	public void test_if_number_error_is_returned_when_there_is_no_number() {
		assertEquals(numberError, passwordValidatorHandler.validatePassword(password4));
	}
	
	@Test
	public void test_if_case_error_is_returned_when_there_is_no_uppercase() {
		assertEquals(caseError, passwordValidatorHandler.validatePassword(password5));
	}
	
	@Test
	public void test_if_case_error_is_returned_when_there_is_no_lowercase() {
		assertEquals(caseError, passwordValidatorHandler.validatePassword(password6));
	}
	
	@Test
	public void test_if_symbol_error_is_returned_when_there_is_no_symbol() {
		assertEquals(symbolError, passwordValidatorHandler.validatePassword(password7));
	}
	
	@Test
	public void test_if_validation_returns_null_when_all_conditions_are_met() {
		assertEquals(null, passwordValidatorHandler.validatePassword(password8));
	}

}
