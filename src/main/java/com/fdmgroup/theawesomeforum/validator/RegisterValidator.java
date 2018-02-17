package com.fdmgroup.theawesomeforum.validator;

import com.fdmgroup.theawesomeforum.user.UserJPACRUD;

public class RegisterValidator {

	private UserJPACRUD userJPACRUD; 
	
	public RegisterValidator() {
		userJPACRUD = new UserJPACRUD();
	}
	
	public RegisterValidator(UserJPACRUD userJPACRUD) {
		this.userJPACRUD = userJPACRUD;
	}
	
	public boolean validateEmail(String email) {
		return (userJPACRUD.readByEmail(email) != null);
	}
	
}
