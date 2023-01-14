package com.nissan.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.nissan.dto.UserDetailsDTO;
import com.nissan.exception.UserCustomException;

// class for writing validation codes for UserRegistration
public class UserValidationUtils {
	
	// method to validate user input details
	public static void validateuserDetails(UserDetailsDTO userDetailsDTO) throws UserCustomException {
		validateName(userDetailsDTO.getFirstName(), userDetailsDTO.getLastName());
		validateAge(userDetailsDTO.getAge());
		validateGender(userDetailsDTO.getGender());
		validatePhoneNumber(userDetailsDTO.getPhoneNumber());
	}

	// method to validate Name
	private static void validateName(String firstName, String lastName) throws UserCustomException {
		// pattern matching using regex - Name must be in alphabets
		Pattern pattern = Pattern.compile("[A-Za-z]");
		Matcher matcherFirstName = pattern.matcher(firstName);
		Matcher matcherLastName = pattern.matcher(lastName);
		
		boolean matchFirstNameFound = matcherFirstName.find();
		boolean matchLastNameFound = matcherLastName.find();
		
		if(!matchFirstNameFound || !matchLastNameFound) {
			throw new UserCustomException("Name must be in alphabet characters!!!");
		}
	}
	
	// method to validate Age
	private static void validateAge(Integer age) throws UserCustomException {
		// user must be above 18 years
		if(age < 18) {
			throw new UserCustomException("Age must be over 18!!!");
		}
	}
	
	// method to validate gender
	private static void validateGender(String gender) throws UserCustomException {
		// user must be either Male or Female
		if(!gender.equalsIgnoreCase("Male") && !gender.equalsIgnoreCase("Female")) {
			throw new UserCustomException("Gender must be either MALE or FEMALE!!!");
		}
	}
	
	// method to validate phone number
	private static void validatePhoneNumber(Long phoneNumber) throws UserCustomException {
		// phone number must be a 10-digit no. 
		if(phoneNumber < 7000000000l && phoneNumber > 9999999999l) {
			throw new UserCustomException("Put a valid phone number");
		}
	}
	
}
