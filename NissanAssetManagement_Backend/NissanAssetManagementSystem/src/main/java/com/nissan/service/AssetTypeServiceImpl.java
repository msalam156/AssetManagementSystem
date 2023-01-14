package com.nissan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nissan.common.APIResponse;
import com.nissan.dao.AssetTypeDao;
import com.nissan.entity.AssetType;
import com.nissan.exception.AssetTypeCustomException;

import static com.nissan.util.AssetTypeValidationUtil.*;

@Service
@Transactional
public class AssetTypeServiceImpl implements IAssetTypeService {

	@Autowired
	private AssetTypeDao assetTypeDao;
	
	// method to add asset type
	@Override
	public APIResponse addAssetType(AssetType assetType) {
		APIResponse apiResponse = new APIResponse();
		
		// creating an object of AssetType
		AssetType type = new AssetType(assetType.getAt_name());
		// Saving the AssetType
		assetTypeDao.save(type);
		
		apiResponse.setData("Asset Type " + type.getAt_name() + " saved successfully!!!");
		return apiResponse;
	}

	@Override
	public APIResponse findAllAssetType() {
		APIResponse apiResponse = new APIResponse();
		List<AssetType> assetTypeList = assetTypeDao.findAll();
		
		if(assetTypeList.isEmpty()) {
			apiResponse.setStatus(HttpStatus.NOT_FOUND.value());
			apiResponse.setError("Asset Type is empty. Add values in database!!!");
		} else {
			apiResponse.setData(assetTypeList);
		}
		return apiResponse;
	}

	// method to find asset type by id
	@Override
	public APIResponse findAssetById(Integer id) {
		APIResponse apiResponse = new APIResponse();
		
		// find the asset type in the database
		AssetType findAssetType = assetTypeDao.findById(id).orElse(null);
		
		// if not found
		if(findAssetType == null) {
			apiResponse.setStatus(HttpStatus.NOT_FOUND.value());
			apiResponse.setError("Asset Type of given ID is not found in the database!!! Check the ID again!!!");
		} else {
			apiResponse.setData(findAssetType);
		}
		return apiResponse;
	}

	// method to delete an AssetType by id
	@Override
	public APIResponse deleteAssetTypeById(Integer id) {
		APIResponse apiResponse = new APIResponse();
		// find if the asset type of given id exits in the database
		AssetType deleteAssetType = assetTypeDao.findById(id).orElse(null);
		
		// if not found
		if(deleteAssetType == null) {
			apiResponse.setStatus(HttpStatus.NOT_FOUND.value());
			apiResponse.setError("Asset Type pd ID " + id + " is not found in the database!!!");
		} else {
			assetTypeDao.delete(deleteAssetType);
			apiResponse.setData("Asset Type " + deleteAssetType.getAt_name() + " deleted successfully!!!");
		}
		return apiResponse;
	}

	// method to update an asset type by id 
	@Override
	public APIResponse updateAssetTypeById(AssetType assetName, Integer id) {
		APIResponse apiResponse = new APIResponse();
		try {
			validateAssetType(assetName.getAt_name());
			AssetType updateAssetType = assetTypeDao.findById(id).orElse(null);
			
			// if asset type isn't found 
			if(updateAssetType == null) {
				apiResponse.setError(HttpStatus.NOT_FOUND.value());
				apiResponse.setError("AssetType with ID is not found in the database!!!");
			} else {
				// save the asset type
				updateAssetType.setAt_name(assetName.getAt_name());
				assetTypeDao.save(updateAssetType);
				apiResponse.setData("AssetType with ID " + updateAssetType.getAt_id() + " has been successfully updated to " + updateAssetType.getAt_name());
			}
		} catch (AssetTypeCustomException e) {
			apiResponse.setError(HttpStatus.CONFLICT.value());
			apiResponse.setError(e.getMessage());
		}
		return apiResponse;
	}

}
