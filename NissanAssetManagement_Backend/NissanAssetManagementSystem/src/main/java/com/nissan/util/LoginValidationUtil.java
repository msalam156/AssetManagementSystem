package com.nissan.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.nissan.entity.Login;
import com.nissan.exception.LoginClassCustomException;

// class for writing validation codes for Login
public class LoginValidationUtil {
	
	// validate the login credential details
	public static void validateLoginDetails(Login login) throws LoginClassCustomException {
		validateUsername(login.getUsername());
		validatePassword(login.getPassword());
		if(login.getUt_id() == null) {
			throw new LoginClassCustomException("Role Id can't be null!!!");
		}
		validateUserRole(login.getUt_id());
	}
	
	// method to validate email ID
	private static void validateUsername(String username) throws LoginClassCustomException {
		// email must contain @gmail.com
		Pattern pattern = Pattern.compile("[A-Za-z0-9]" + "@gmail.com");
		Matcher matcher = pattern.matcher(username);
		boolean matchFound = matcher.find();
		
		if(!matchFound) {
			throw new LoginClassCustomException("Username must contain @gmail.com!!!");
		}	
	}
	
	// method to validate password
	private static void validatePassword(String password) throws LoginClassCustomException {
		// password must be a combination of alphanumeric with special characters
		Pattern pattern = Pattern.compile("[A-Za-z]" + "[@#$]" + "[0-9]");
		Matcher matcher = pattern.matcher(password);
		boolean matchFound = matcher.find();
		
		if(!matchFound) {
			throw new LoginClassCustomException("Password must contain alphabetts, special characters(@, #, $) and numbers!!!");
		}
	}
	
	// method to validate user role
	private static void validateUserRole(Integer roleId) throws LoginClassCustomException {
		if(roleId < 1 || roleId > 3 || roleId == null) {
			throw new LoginClassCustomException("Role Id must be either 1, 2 or 3!!!");
		}
	}

}
