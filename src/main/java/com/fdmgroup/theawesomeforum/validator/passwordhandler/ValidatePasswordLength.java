package com.fdmgroup.theawesomeforum.validator.passwordhandler;

public class ValidatePasswordLength extends PasswordValidator{

	private String message = "Password should be between 7 and 14 characters long!";
	
	public ValidatePasswordLength(PasswordValidator successor) {
		this.nextValidator = successor;
	}
	
	@Override
	public String getPasswordValidityError(String password) {
		return validatePasswordLength(password);
	}

	private String validatePasswordLength(String password) {
		if (validatePasswordLengthIsNotTooLong(password) && validatePasswordLengthIsNotTooShort(password)) {
			return callSuccessor(password);
		} else {
			return message;
		}
	}
	
	private boolean validatePasswordLengthIsNotTooLong(String password) {
		return (password.length() <= 14);
	}

	private boolean validatePasswordLengthIsNotTooShort(String password) {
		return (password.length() >= 7);
	}


}
