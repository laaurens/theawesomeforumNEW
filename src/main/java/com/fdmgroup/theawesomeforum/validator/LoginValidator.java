package com.fdmgroup.theawesomeforum.validator;

import com.fdmgroup.theawesomeforum.user.User;
import com.fdmgroup.theawesomeforum.user.UserJPACRUD;

public class LoginValidator {

	private UserJPACRUD userJPACRUD; 
	private User loginUser;
	
	public LoginValidator() {
		userJPACRUD = new UserJPACRUD();
	}
	
	public LoginValidator(UserJPACRUD userJPACRUD) {
		this.userJPACRUD = userJPACRUD;
	}
	
	public boolean validateLogin(String username, String password){
		return (validateUsername(username) && validatePassword(username, password));
	}
	
	public boolean validateUsername(String username) {
		loginUser = userJPACRUD.readOneByName(username);
		return (loginUser != null);
	}

	public boolean validatePassword(String username, String password) {
		return (loginUser.getPassWord().equals(password));
	}
	
}
