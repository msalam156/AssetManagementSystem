package com.nissan.util;

import com.nissan.exception.AssetTypeCustomException;

// class for writing validation for AssetClass
public class AssetClassUtil {

	public static void validateAssetClassName(String className) throws AssetTypeCustomException {
		if(className.isBlank() || className.isEmpty()) {
			throw new AssetTypeCustomException("Asset Class name can't be left blank!!!");
		}
	}
}
