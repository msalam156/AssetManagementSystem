package com.nissan.service;

import com.nissan.common.APIResponse;
import com.nissan.entity.AssetType;

public interface IAssetTypeService {

	APIResponse addAssetType(AssetType assetType);
	
	APIResponse findAllAssetType();
	
	APIResponse findAssetById(Integer id);
	
	APIResponse deleteAssetTypeById(Integer id);
	
	APIResponse updateAssetTypeById(AssetType assetName, Integer id);
	
}
