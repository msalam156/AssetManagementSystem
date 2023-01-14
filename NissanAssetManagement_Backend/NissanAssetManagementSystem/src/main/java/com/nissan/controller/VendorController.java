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
import com.nissan.entity.Vendor;
import com.nissan.service.IVendorService;

@CrossOrigin
@RestController
@RequestMapping("/api/vendor")
public class VendorController {

	@Autowired
	IVendorService vendorService;
	
	// API to add vendor details
	@PostMapping
	public ResponseEntity<APIResponse> addVendorDetails(@RequestBody Vendor vendor) {
		APIResponse apiResponse = vendorService.saveVendor(vendor);
		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}
	
	// API to get all vendors
	@GetMapping
	public ResponseEntity<APIResponse> getAllVendors() {
		APIResponse apiResponse = vendorService.getAllVendors();
		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}
	
}
