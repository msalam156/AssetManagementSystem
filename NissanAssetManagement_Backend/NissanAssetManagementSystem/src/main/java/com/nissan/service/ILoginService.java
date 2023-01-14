package com.nissan.service;

import com.nissan.common.APIResponse;
import com.nissan.dto.LoginDTO;
import com.nissan.entity.Login;

public interface ILoginService {

	APIResponse findByUserNameAndPassword(LoginDTO loginDTO);
	
	APIResponse addLoginUser(Login login);
	
	APIResponse getAllLoginUsers();
	
}
