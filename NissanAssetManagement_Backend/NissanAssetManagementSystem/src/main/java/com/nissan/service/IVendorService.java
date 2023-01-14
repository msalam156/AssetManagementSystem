package com.nissan.service;

import com.nissan.common.APIResponse;
import com.nissan.entity.Vendor;

public interface IVendorService {

	APIResponse saveVendor(Vendor vendor);
	
	APIResponse getAllVendors();
}
