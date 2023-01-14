package com.nissan.service;

import com.nissan.common.APIResponse;
import com.nissan.dto.UserDetailsDTO;

public interface IUserService {
	
	APIResponse getAllUsers();
	
	APIResponse findUserById(Integer id);
	
	APIResponse addUserDetails(UserDetailsDTO userDetailsDTO, Integer l_id);
	
	APIResponse deleteUserbyId(Integer id);
	
	APIResponse updateUserDetailsById(UserDetailsDTO userDetailsDTO, Integer id);
	
}
