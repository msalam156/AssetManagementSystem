package com.nissan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nissan.common.APIResponse;
import com.nissan.dao.AssetClassDao;
import com.nissan.entity.AssetCategory;
import com.nissan.exception.AssetTypeCustomException;

import static com.nissan.util.AssetClassUtil.*;

import java.util.List;

@Service
@Transactional
public class AssetClassServiceImpl implements IAssetClassService {

	@Autowired
	private AssetClassDao assetClassDao;

	// method to add a new asset class
	@Override
	public APIResponse addNewAssetClass(AssetCategory assetClass) {
		APIResponse apiResponse = new APIResponse();
		try {
			// validate asset class name
			validateAssetClassName(assetClass.getAc_name());

			// save the assetClass if valid after converting it to uppercase
			assetClass.setAc_name(assetClass.getAc_name().toUpperCase());
			assetClassDao.save(assetClass);
			apiResponse.setData("Asset class " + assetClass.getAc_name() + " added to the database successfully!!!");
		} catch (AssetTypeCustomException e) {
			apiResponse.setStatus(HttpStatus.CONFLICT.value());
			apiResponse.setError(e.getMessage());
		}
		return apiResponse;
	}

	// method to find asset class by id
	@Override
	public APIResponse getAssetClassById(Integer ac_id) {
		APIResponse apiResponse = new APIResponse();

		// find the assetclass by id
		AssetCategory findAssetClass = assetClassDao.findById(ac_id).orElse(null);

		// if not found
		if (findAssetClass == null) {
			apiResponse.setStatus(HttpStatus.NOT_FOUND.value());
			apiResponse.setError("Asset Class of given ID doesn't exist in the database!!!");
		} else {
			apiResponse.setData(findAssetClass);
		}
		return apiResponse;
	}

	// method to get all asset classes
	@Override
	public APIResponse getAllAssetClasses() {
		APIResponse apiResponse = new APIResponse();

		// get list of asset class
		List<AssetCategory> assetClassList = assetClassDao.findAll();

		// if not found
		if (assetClassList.isEmpty()) {
			apiResponse.setStatus(HttpStatus.NOT_FOUND.value());
			apiResponse.setError("No Asset class found un the database!!!");
		} else {
			apiResponse.setData(assetClassList);
		}
		return apiResponse;
	}

	// method to update an asset class by id
	@Override
	public APIResponse updateAssetClassById(Integer id, AssetCategory assetClass) {
		APIResponse apiResponse = new APIResponse();

		try {
			// validate asset class name
			validateAssetClassName(assetClass.getAc_name());

			// find the assetclass by id
			AssetCategory updateAssetClass = assetClassDao.findById(id).orElse(null);

			// if not found
			if (updateAssetClass == null) {
				apiResponse.setStatus(HttpStatus.NOT_FOUND.value());
				apiResponse.setError("Asset Class of given ID doesn't exist in the database!!!");
			} else {

				// if Asset Class name is valid
				updateAssetClass.setAc_name(assetClass.getAc_name().toUpperCase());
				assetClassDao.save(updateAssetClass);
				apiResponse.setData("Asset Class name of Asset Class ID " + updateAssetClass.getAc_id()
						+ " has been successfully update to " + updateAssetClass.getAc_name() + "!!!");
			}
		} catch (AssetTypeCustomException e) {
			apiResponse.setError(e.getMessage());
		}

		return apiResponse;
	}

	// method to delete asset class
	@Override
	public APIResponse deleteAssetClassById(Integer id) {
		APIResponse apiResponse = new APIResponse();
		
		// find the asset class to be deleted
		AssetCategory deleteAssetClass = assetClassDao.findById(id).orElse(null);
		
		// if asset class is not found
		if(deleteAssetClass == null) {
			apiResponse.setStatus(HttpStatus.NOT_FOUND.value());
			apiResponse.setError("Asset Class of id " + id + " is not found in the database!!!");
		} else {
			assetClassDao.delete(deleteAssetClass);
			apiResponse.setData("Asset class " + deleteAssetClass.getAc_name() + " has been deleted from the database successfully!!!");
		}
		return apiResponse;
	}

}
