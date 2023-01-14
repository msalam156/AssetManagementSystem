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
import com.nissan.entity.AssetCategory;
import com.nissan.entity.AssetType;
import com.nissan.service.IAssetClassService;
import com.nissan.service.IAssetTypeService;

@CrossOrigin
@RestController
@RequestMapping("/api/assets")
public class AssetContoller {

	@Autowired
	private IAssetTypeService assetTypeService;
	
	@Autowired
	private IAssetClassService assetClassService;
	
	// to add new asset
	@PostMapping
	public ResponseEntity<APIResponse> addAssetType(@RequestBody AssetType assetType) {
		APIResponse apiResponse = assetTypeService.addAssetType(assetType);
		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}
	
	// to get all assets
	@GetMapping
	public ResponseEntity<APIResponse> getAllAssetType() {
		APIResponse apiResponse = assetTypeService.findAllAssetType();
		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}
	
	// to get asset type by id
	@GetMapping("{id}")
	public ResponseEntity<APIResponse> getAssetTypeById(@PathVariable Integer id) {
		APIResponse apiResponse = assetTypeService.findAssetById(id);
		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}
	
	// to delete an asset type
	@DeleteMapping("{id}")
	public ResponseEntity<APIResponse> deleteAssetTypeById(@PathVariable Integer id) {
		APIResponse apiResponse = assetTypeService.deleteAssetTypeById(id);
		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}
	
	// To update Asset Type
	@PutMapping("{id}")
	public ResponseEntity<APIResponse> updateAssetType(@RequestBody AssetType assetName, @PathVariable Integer id) {
		APIResponse apiResponse = assetTypeService.updateAssetTypeById(assetName, id);
		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}
	
	// To add an asset class
	@PostMapping("/class")
	public ResponseEntity<APIResponse> addAssetClass(@RequestBody AssetCategory assetClass) {
		APIResponse apiResponse = assetClassService.addNewAssetClass(assetClass);
		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}
	
	// To get an asset by asset is
	@GetMapping("/class/{id}")
	public ResponseEntity<APIResponse> getAssetClassById(@PathVariable Integer id) {
		APIResponse apiResponse = assetClassService.getAssetClassById(id);
		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}
	
	// To get all asset classes
	@GetMapping("/class")
	public ResponseEntity<APIResponse> getAllAssetClasses() {
		APIResponse apiResponse = assetClassService.getAllAssetClasses();
		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}
	
	// To update Asset Class
	@PutMapping("/class/{id}") 
	public ResponseEntity<APIResponse> updateAssetClassById(@PathVariable Integer id, @RequestBody AssetCategory assetClass) {
		APIResponse apiResponse = assetClassService.updateAssetClassById(id, assetClass);
		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}
	
	// To delete an Asset Class
	@DeleteMapping("/class/{id}")
	public ResponseEntity<APIResponse> deleteAssetClassById(@PathVariable Integer id) {
		APIResponse apiResponse = assetClassService.deleteAssetClassById(id);
		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}
	
}
