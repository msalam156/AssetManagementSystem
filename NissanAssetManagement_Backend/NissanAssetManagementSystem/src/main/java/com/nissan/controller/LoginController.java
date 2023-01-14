package com.nissan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nissan.common.APIResponse;
import com.nissan.dto.LoginDTO;
import com.nissan.entity.Login;
import com.nissan.service.ILoginService;

@CrossOrigin
@RestController
@RequestMapping("/api/login")
public class LoginController {

	@Autowired
	private ILoginService loginService;
	
	// for login
	@PostMapping
	public ResponseEntity<APIResponse> login(@RequestBody LoginDTO loginDTO) {
		APIResponse apiResponse = loginService.findByUserNameAndPassword(loginDTO);
		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}
	
	// for adding more credentials
	@PostMapping("/addLoginUser")
	public ResponseEntity<APIResponse> addLoginUser(@RequestBody Login login) {
		APIResponse apiResponse = loginService.addLoginUser(login);
		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}
	
	// API to get Login list
	@GetMapping
	public ResponseEntity<APIResponse> getAllLoginUsers() {
		APIResponse apiResponse = loginService.getAllLoginUsers();
		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}
}
