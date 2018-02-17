package com.fdmgroup.theawesomeforum.validator.passwordhandler;

public class PasswordValidatorHandler implements PasswordValidatorHandlerInterface{

	public PasswordValidatorHandler() { }

	@Override
	public String validatePassword(String password) {
		
		PasswordValidator symbolValidator = new ValidatePasswordSymbol(null);
		PasswordValidator caseValidator = new ValidatePasswordCase(symbolValidator);
		PasswordValidator numberValidator = new ValidatePasswordNumber(caseValidator);
		PasswordValidator lengthValidator = new ValidatePasswordLength(numberValidator);

		return lengthValidator.getPasswordValidityError(password);
	}

}
