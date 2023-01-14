package com.nissan.service;

import com.nissan.dto.LoginDTO;

public interface IEmailService {
	
	boolean sendSignUpMail(LoginDTO loginDTO);
}
