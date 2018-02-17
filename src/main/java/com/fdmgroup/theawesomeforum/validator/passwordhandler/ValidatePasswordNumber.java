package com.fdmgroup.theawesomeforum.validator.passwordhandler;

public class ValidatePasswordNumber extends PasswordValidator {
	
	private String message = "Password should have at least one number!";
	private boolean numberFlag;

	public ValidatePasswordNumber(PasswordValidator successor) {
		this.nextValidator = successor;
	}

	@Override
	public String getPasswordValidityError(String password) {
		for (int letter = 0; letter < password.length(); letter++) {
			char currentChar = password.charAt(letter);
			numberFlag = validatePasswordContainsNumber(numberFlag, currentChar);
		}

		return validateCharacterCheck(password, numberFlag);
	}

	private boolean validatePasswordContainsNumber(boolean numberFlag, char currentChar) {
		if (Character.isDigit(currentChar)) {
			numberFlag = true;
		}
		return numberFlag;
	}
	
	private String validateCharacterCheck(String password, boolean numberFlag) {
		if (numberFlag) {
			return callSuccessor(password);
		} else {
			return message;
		}
	}

}
