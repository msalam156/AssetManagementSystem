package com.nissan.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nissan.common.APIResponse;
import com.nissan.dao.LoginDao;
import com.nissan.dto.LoginDTO;
import com.nissan.entity.Login;
import com.nissan.exception.LoginClassCustomException;

import static com.nissan.util.LoginValidationUtil.*;

@Service
@Transactional
public class LoginServiceImpl implements ILoginService {

	@Autowired
	private LoginDao loginDao;
	
	@Autowired
	private IEmailService emailService;

	// method to find user by email and password
	@Override
	public APIResponse findByUserNameAndPassword(LoginDTO loginDTO) {
		APIResponse apiResponse = new APIResponse();

		// verify user exists with given email and password
		Login userLogin = loginDao.findOneByUsernameAndPassword(loginDTO.getUsername(), loginDTO.getPassword());

		// response
		if (userLogin == null) {
			apiResponse.setStatus(HttpStatus.NOT_FOUND.value());
			apiResponse.setData("User login failed!!!");
		} else {
			// Storing more details
			Map<String, Object> data = new HashMap<>();
			data.put("role", userLogin.getUt_id());
			data.put("emailId", userLogin.getUsername());
			apiResponse.setData(data);
		}
		return apiResponse;

	}

	// method to add more credentials
	@Override
	public APIResponse addLoginUser(Login login) {
		APIResponse apiResponse = new APIResponse();
		try {
			// validate the login credentials
			validateLoginDetails(login);
			checkForDuplicateUsername(login.getUsername());
			// save if succeeded
			loginDao.save(login);
			apiResponse.setData("New login credentials with ID " + login.getUsername() + " and Role ID "
					+ login.getUt_id() + " has been created successfully!!! \n");
			
			// calling email service
			boolean mailSent = emailService.sendSignUpMail(new LoginDTO(login.getUsername(), login.getPassword()));
			
			// If sending mail fails
			if(mailSent) {
				apiResponse.setError("Mail has been sent successfully!!!");
			} else {
				apiResponse.setStatus(HttpStatus.NOT_FOUND.value());
				apiResponse.setError("Mail does not exist!!!");
			}

		} catch (LoginClassCustomException e) {
			apiResponse.setStatus(HttpStatus.CONFLICT.value());
			apiResponse.setError(e.getMessage());
		}
		return apiResponse;
	}

	// method to check duplicate username
	private void checkForDuplicateUsername(String username) throws LoginClassCustomException {
		Login findDuplicateLogin = loginDao.findByUsername(username);

		// if found
		if (findDuplicateLogin != null) {
			throw new LoginClassCustomException("Username already exists!!! Use another username!!!");
		}
	}

	// method to get all login users
	@Override
	public APIResponse getAllLoginUsers() {
		APIResponse apiResponse = new APIResponse();
		List<Login> loginList = loginDao.findAll();
		
		// If the list is empty
		if(loginList.isEmpty()) {
			apiResponse.setStatus(HttpStatus.NOT_FOUND.value());
			apiResponse.setError("Databae is empty!!! Please add login users first!!!");
		} else {
			apiResponse.setData(loginList);
		}
		
		return apiResponse;
	}

}
