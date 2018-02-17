package com.fdmgroup.theawesomeforum.validator.passwordhandler;

public class ValidatePasswordSymbol extends PasswordValidator {

	private String message = "Password should have at least one symbol!";

	public ValidatePasswordSymbol(PasswordValidator successor) {
		this.nextValidator = successor;
	}

	@Override
	public String getPasswordValidityError(String password) {

		String symbols = "!£$%^&*=+-<>?@~#\"\'(){}[]_|\\";
		boolean symbolFlag = false;

		symbolFlag = isSymbolInPassword(password, symbols, symbolFlag);

		if (symbolFlag) {
			return callSuccessor(password);
		} else {
			return message;
		}

	}

	private boolean isSymbolInPassword(String password, String symbols, boolean symbolFlag) {
		for (int i = 0; i < password.length(); i++) {
			char pc = password.charAt(i);
			for (int j = 0; j < symbols.length(); j++) {
				char sc = symbols.charAt(j);
				if (pc == sc) {
					symbolFlag = true;
				}
			}
		}
		return symbolFlag;
	}

}
