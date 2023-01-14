package com.nissan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.nissan.common.APIResponse;
import com.nissan.dao.VendorDao;
import com.nissan.dto.VendorDetailsDTO;
import com.nissan.entity.Vendor;

import java.util.ArrayList;
import java.util.List;

@Service
public class VendorServiceImpl implements IVendorService {

	@Autowired
	private VendorDao vendorDao;

	// method to save a new Vendor
	@Override
	public APIResponse saveVendor(Vendor vendor) {
		APIResponse apiResponse = new APIResponse();
		Vendor newVendor = vendorDao.save(vendor);
		apiResponse.setData("Vendor details of " + newVendor.getVd_name() + " added successfully!!!");
		return apiResponse;
	}

	// method to get all vendors
	@Override
	public APIResponse getAllVendors() {
		APIResponse apiResponse = new APIResponse();
		List<Vendor> vendorList = vendorDao.findAll();

		if (vendorList.isEmpty()) {
			apiResponse.setStatus(HttpStatus.NOT_FOUND.value());
			apiResponse.setError("There is no vendor in the database!!! Please add a vendor first!!!");
		} else {
			List<VendorDetailsDTO> vendorDetailsDTOList = new ArrayList<>();
			for (Vendor vendor : vendorList) {
				vendorDetailsDTOList.add(new VendorDetailsDTO(vendor.getVd_id(), vendor.getVd_name(), vendor.getAssetType().getAt_name(), vendor.getVd_from(), vendor.getVd_to(), vendor.getVd_address(), vendor.getLogin().getUsername()));
			}
			apiResponse.setData(vendorDetailsDTOList);
		}
		return apiResponse;
	}

}
