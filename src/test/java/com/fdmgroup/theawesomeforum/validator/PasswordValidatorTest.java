package com.fdmgroup.theawesomeforum.validator;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.fdmgroup.theawesomeforum.validator.passwordhandler.PasswordValidator;
import com.fdmgroup.theawesomeforum.validator.passwordhandler.ValidatePasswordCase;
import com.fdmgroup.theawesomeforum.validator.passwordhandler.ValidatePasswordLength;
import com.fdmgroup.theawesomeforum.validator.passwordhandler.ValidatePasswordNumber;
import com.fdmgroup.theawesomeforum.validator.passwordhandler.ValidatePasswordSymbol;

public class PasswordValidatorTest {
	PasswordValidator symbolValidator, caseValidator, numberValidator, lengthValidator;
	String validPassword, passwordWithoutSymbol, passwordWithoutUppercase, passwordWithoutLowercase, passwordWithoutNumber, tooShortPassword, tooLongPassword;
	String result;
	String incorrectLength = "Password should be between 7 and 14 characters long!";
	String incorrectLetters = "Password should have at least one upper and one lowercase letter!";
	String incorrectNumber = "Password should have at least one number!";
	String incorrectSymbol = "Password should have at least one symbol!";

	@Before
	public void setUp() throws Exception {
		symbolValidator = new ValidatePasswordSymbol(null);
		caseValidator = new ValidatePasswordCase(null);
		numberValidator = new ValidatePasswordNumber(null);
		lengthValidator = new ValidatePasswordLength(null);
		validPassword = "AsDf123%";
		passwordWithoutSymbol = "AsDf1234";
		passwordWithoutUppercase = "asdf123%";
		passwordWithoutLowercase = "ASDF123%";
		passwordWithoutNumber = "AsDfGhJ%";
		tooShortPassword = "As1%";
		tooLongPassword = "AsDfGhJkL123456%&!^([";
	}

	@Test
	public void test_isPasswordCorrectLength_ReturnsNullSuccessorWhenPasswordIsWithinCorrectLength() {
		result = lengthValidator.getPasswordValidityError(validPassword);
		assertEquals(null, result);
	}

	@Test
	public void test_isPasswordTooShort_ReturnsIncorrectLengthWhenPasswordIsTooShort() {
		result = lengthValidator.getPasswordValidityError(tooShortPassword);
		assertEquals(incorrectLength, result);
	}

	@Test
	public void test_isPasswordTooLong_ReturnsIncorrectLengthWhenPasswordIsTooLong() {
		result = lengthValidator.getPasswordValidityError(tooLongPassword);
		assertEquals(incorrectLength, result);
	}

	@Test
	public void test_doesPasswordContainUpperAndLowerCaseLetters_ReturnsNullSuccessorWhenPasswordHasUpperAndLowerCaseLetters() {
		result = caseValidator.getPasswordValidityError(validPassword);
		assertEquals(null, result);
	}

	@Test
	public void test_doesPasswordContainUpperAndLowerCaseLetters_ReturnsIncorrectLettersWhenPasswordDoesNotContainUpperCaseLetters() {
		result = caseValidator.getPasswordValidityError(passwordWithoutUppercase);
		assertEquals(incorrectLetters, result);
	}

	@Test
	public void test_doesPasswordContainUpperAndLowerCaseLetters_ReturnsIncorrectLettersWhenPasswordDoesNotContainLowerCaseLetters() {
		result = caseValidator.getPasswordValidityError(passwordWithoutLowercase);
		assertEquals(incorrectLetters, result);
	}

	@Test
	public void test_doesPasswordContainNumbers_ReturnsNullSuccessorWhenPasswordHasNumbers() {
		result = numberValidator.getPasswordValidityError(validPassword);
		assertEquals(null, result);
	}

	@Test
	public void test_doesPasswordContainNumbers_ReturnsIncorrectLettersWhenPasswordDoesNotContainUpperCaseLetters() {
		result = numberValidator.getPasswordValidityError(passwordWithoutNumber);
		assertEquals(incorrectNumber, result);
	}

	@Test
	public void test_doesPasswordContainSymbols_ReturnsNullSuccessorWhenPasswordHasSymbols() {
		result = symbolValidator.getPasswordValidityError(validPassword);
		assertEquals(null, result);
	}

	@Test
	public void test_doesPasswordContainSymbols_ReturnsIncorrectLettersWhenPasswordDoesNotContainSymbols() {
		result = symbolValidator.getPasswordValidityError(passwordWithoutSymbol);
		assertEquals(incorrectSymbol, result);
	}

}
