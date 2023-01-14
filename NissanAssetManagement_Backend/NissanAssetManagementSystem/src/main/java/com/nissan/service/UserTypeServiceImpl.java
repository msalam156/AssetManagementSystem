package com.nissan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.nissan.common.APIResponse;
import com.nissan.dao.UserTypeDao;
import com.nissan.entity.UserType;

@Service
public class UserTypeServiceImpl implements IUserTypeService {

	@Autowired
	private UserTypeDao userTypeDao;
	
	// method to add a new user type
	@Override
	public APIResponse addNewUserType(UserType userType) {
		APIResponse apiResponse = new APIResponse();
		UserType type = userTypeDao.save(userType);
		
		apiResponse.setData("User type " + type.getUt_name() + " saved in the database successfully!!!");
		return apiResponse;
	}

	// method to get all user type
	@Override
	public APIResponse getAllUserType() {
		APIResponse apiResponse = new APIResponse();
		List<UserType> userTypeList = userTypeDao.findAll();
		
		// If the list is empty
		if(userTypeList.isEmpty()) {
			apiResponse.setStatus(HttpStatus.NOT_FOUND.value());
			apiResponse.setError("Database in empty!!! Please add user type first!!!");
		} else {
			apiResponse.setData(userTypeList);
		}
		return apiResponse;
	}

}
