package com.fdmgroup.theawesomeforum.servlets.authentification;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.fdmgroup.theawesomeforum.forum.profanity.Profanity;
import com.fdmgroup.theawesomeforum.forum.profanity.ProfanityFilterLogic;
import com.fdmgroup.theawesomeforum.forum.profanity.ProfanityService;
import com.fdmgroup.theawesomeforum.user.User;
import com.fdmgroup.theawesomeforum.validator.LoginValidator;
import com.fdmgroup.theawesomeforum.validator.RegisterValidator;
import com.fdmgroup.theawesomeforum.validator.passwordhandler.PasswordValidatorHandler;

public class RegisterLogic {
	
	private List<Profanity> profanities;
	private String firstName;
	private String lastName;
	private String userName;
	private String password;
	private String email;
	private LocalDate birthday;
	private String bio;
	private String homepage;
	private String location;
	private RegisterValidator registerValidator;
	private PasswordValidatorHandler passwordValidatorHandler;
	private LoginValidator loginValidator;
	private User user;
	ProfanityService profanityService;
	
	public RegisterLogic() {
		profanityService = new ProfanityService();
		registerValidator = new RegisterValidator();
		loginValidator = new LoginValidator();
		passwordValidatorHandler = new PasswordValidatorHandler();
	}
	
	public User registerUser(HttpServletRequest request) {
		getParameters(request);
		profanities = profanityService.readAll();
		filterRegisterData(firstName, lastName, userName, password, email, bio, homepage, location);
		if (!validateEmail(request)) {
			return null;
		}
		if (validateUsername(request) ) {
			validatePassword(request);
		}
		return user;
	}
	
	private void getParameters(HttpServletRequest request) {
		firstName = request.getParameter("firstname");
		lastName = request.getParameter("lastname");
		userName = request.getParameter("username");
		password = request.getParameter("password");
		email = request.getParameter("Email");
		birthday = getDateFromParameters(request);
		bio = request.getParameter("bio");
		homepage = request.getParameter("homepage");
		location = request.getParameter("location");
	}
	
	private boolean validateEmail(HttpServletRequest request) {
		if (registerValidator.validateEmail(email) || email.length() == 0) {
			request.setAttribute("emailError", "Try another email.");
			return false;
		}
		return true;
	}
	
	private void createUser() {
		user = new User(userName, false, password, firstName, lastName, location, bio, homepage, birthday, email);
	}

	private void filterRegisterData(String firstName, String lastName, String userName, String password, String email, String bio, String homepage, String location) {
		this.firstName = ProfanityFilterLogic.filterProfanities(firstName, profanities);
		this.lastName = ProfanityFilterLogic.filterProfanities(lastName, profanities);
		this.userName = ProfanityFilterLogic.filterProfanities(userName, profanities);
		this.password = ProfanityFilterLogic.filterProfanities(password, profanities);
		this.email = ProfanityFilterLogic.filterProfanities(email, profanities);
		this.bio = ProfanityFilterLogic.filterProfanities(bio, profanities);
		this.homepage = ProfanityFilterLogic.filterProfanities(homepage, profanities);
		this.location = ProfanityFilterLogic.filterProfanities(location, profanities);
	}

	private LocalDate getDateFromParameters(HttpServletRequest request) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate date = LocalDate.parse(request.getParameter("birthday"), formatter);
		return date;
	}

	private void validatePassword(HttpServletRequest request) {
		String passwordMessage = passwordValidatorHandler.validatePassword(password);
		if (passwordMessage == null) {
			createUser();
		} else {
			request.setAttribute("passwordError", passwordMessage);
		}
	}

	private boolean validateUsername(HttpServletRequest request) {
		if (loginValidator.validateUsername(userName) || userName.length() == 0) {
			request.setAttribute("usernameError", "Try another username.");
			return false;
		}
		return true;
	}

}
