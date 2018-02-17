package com.fdmgroup.theawesomeforum.validator.passwordhandler;

public class ValidatePasswordCase extends PasswordValidator{

	private String message = "Password should have at least one upper and one lowercase letter!";
	private boolean capitalFlag, lowercaseFlag;
	
	public ValidatePasswordCase(PasswordValidator nextValidator) {
		this.nextValidator = nextValidator;
	}
	
	@Override
	public String getPasswordValidityError(String password) {
		for(int letter = 0; letter < password.length(); letter++) {
			char currentChar = password.charAt(letter);
			capitalFlag = validatePasswordContainsUppercaseLetters(capitalFlag, currentChar);
			lowercaseFlag = validatePasswordContainsLowercaseLetters(lowercaseFlag, currentChar);
		}
		return checkBothValidatorsPassed(password, capitalFlag, lowercaseFlag);
	}
	
	private boolean validatePasswordContainsUppercaseLetters(boolean capitalFlag, char currentChar) {
		if(Character.isUpperCase(currentChar)) {
			capitalFlag = true;
		}
		return capitalFlag;
	}

	private boolean validatePasswordContainsLowercaseLetters(boolean lowercaseFlag, char currentChar) {
		if(Character.isLowerCase(currentChar)) {
			lowercaseFlag = true;
		}
		return lowercaseFlag;
	}
	

	private String checkBothValidatorsPassed(String password, boolean capitalFlag, boolean lowercaseFlag) {
		if(capitalFlag && lowercaseFlag) {
			return callSuccessor(password);
		} else {
			return message;
		}
	}
}
