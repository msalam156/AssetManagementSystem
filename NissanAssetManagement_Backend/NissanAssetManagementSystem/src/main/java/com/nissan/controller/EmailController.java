package com.nissan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nissan.dto.LoginDTO;
import com.nissan.entity.Login;
import com.nissan.service.IEmailService;

@CrossOrigin
@RestController
@RequestMapping("/api/email")
public class EmailController {

	@Autowired
	private IEmailService emailService;
	
	@PostMapping
	public ResponseEntity<?> sendSignupMail(@RequestBody Login login) {
		boolean mailSent = emailService.sendSignUpMail(new LoginDTO(login.getUsername(), login.getPassword()));
		
		if(mailSent) {
			return ResponseEntity.status(HttpStatus.OK).body("Mail sent successfully!!!");
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Mail sent unsuccessful!!!");
		}
	}
}
