package com.fdmgroup.theawesomeforum.validator;

import com.fdmgroup.theawesomeforum.user.User;
import com.fdmgroup.theawesomeforum.user.UserJPACRUD;

public class UserRightsValidator { 
	
	private UserJPACRUD userJPACRUD;
	
	public UserRightsValidator(UserJPACRUD userJPACRUD){
		this.userJPACRUD = userJPACRUD;
	}
	
	public boolean isAdmin(String userName){
		User user = userJPACRUD.readOneByName(userName);
		return (boolean) user.isAdmin();
	}

}
