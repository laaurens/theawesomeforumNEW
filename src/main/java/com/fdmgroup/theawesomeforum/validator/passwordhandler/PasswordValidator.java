package com.fdmgroup.theawesomeforum.validator.passwordhandler;

public abstract class PasswordValidator {

	protected PasswordValidator nextValidator;

	public abstract String getPasswordValidityError(String password);
	
	protected String callSuccessor(String password) {
		if (this.nextValidator == null) {
			return null;
		} else {
			return this.nextValidator.getPasswordValidityError(password);
		}
	}

}
