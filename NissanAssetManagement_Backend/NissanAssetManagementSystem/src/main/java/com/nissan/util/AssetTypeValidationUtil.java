package com.nissan.util;

import com.nissan.exception.AssetTypeCustomException;

public class AssetTypeValidationUtil {

	// method to validate AssetType
	public static void validateAssetType(String assetName) throws AssetTypeCustomException {
		validateAssetTypeName(assetName);
	}
	
	// method to validate AssetType name
	private static void validateAssetTypeName(String assetTypeName) throws AssetTypeCustomException {
		if(assetTypeName.isBlank() || assetTypeName.isEmpty()) {
			throw new AssetTypeCustomException("Asset Type name can't be left blank!!!");
		}
	}
}
