package com.nissan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nissan.common.APIResponse;
import com.nissan.dto.UserDetailsDTO;
import com.nissan.service.IUserService;

@CrossOrigin
@RestController
@RequestMapping("/api/users")
public class UserController {
	

	@Autowired
	private IUserService userService;
	
	private APIResponse apiResponse;
	
	// get all users (Purchase Manager)
	@GetMapping
	public ResponseEntity<APIResponse> getAllUsers() {
		apiResponse = userService.getAllUsers();
		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}
	
	// get user(Purchase Manager) by ID 
	@GetMapping("{id}")
	public ResponseEntity<APIResponse> getUserById(@PathVariable Integer id) {
		apiResponse = userService.findUserById(id);
		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}
	
	// post details using login id of the user(Purchase Manager)
	@PostMapping("{id}")
	public ResponseEntity<APIResponse> addUserDetails(@RequestBody UserDetailsDTO userDetailsDTO, @PathVariable Integer id) {
		apiResponse = userService.addUserDetails(userDetailsDTO, id);
		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}
	
	// delete user using user(Purchase Manager) id 
	@DeleteMapping("{id}")
	public ResponseEntity<APIResponse> deleteUser(@PathVariable Integer id) {
		apiResponse = userService.deleteUserbyId(id);
		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}
	
	// update details of a user(Purchase Manager)
	@PutMapping("{id}")
	public ResponseEntity<APIResponse> updateUserDetails(@RequestBody UserDetailsDTO userDetailsDTO, @PathVariable Integer id) {
		apiResponse = userService.updateUserDetailsById(userDetailsDTO, id);
		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}

}
