package com.nissan.service;

import com.nissan.common.APIResponse;
import com.nissan.entity.AssetCategory;

public interface IAssetClassService {

	APIResponse addNewAssetClass(AssetCategory assetClass);
	
	APIResponse getAssetClassById(Integer id);
	
	APIResponse getAllAssetClasses();
	
	APIResponse updateAssetClassById(Integer id, AssetCategory assetClass);
	
	APIResponse deleteAssetClassById(Integer id);
	
}
