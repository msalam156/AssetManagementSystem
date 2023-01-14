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
import com.nissan.entity.UserType;
import com.nissan.service.IUserTypeService;

@CrossOrigin
@RestController
@RequestMapping("/api/userType")
public class UserTypeController {

	@Autowired
	private IUserTypeService userTypeService;
	
	// API to add a new user type
	@PostMapping
	public ResponseEntity<APIResponse> addUserType(@RequestBody UserType userType) {
		APIResponse apiResponse = userTypeService.addNewUserType(userType);
		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}
	
	// API to get all user type
	@GetMapping
	public ResponseEntity<APIResponse> getAllUserType() {
		APIResponse apiResponse = userTypeService.getAllUserType();
		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	} 
}
