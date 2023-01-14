package com.nissan.service;

import com.nissan.common.APIResponse;
import com.nissan.entity.UserType;

public interface IUserTypeService {

	APIResponse addNewUserType(UserType userType);
	
	APIResponse getAllUserType();
}
