package com.nissan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.nissan.common.APIResponse;
import com.nissan.dao.PurchaseOrderStatusDao;
import com.nissan.entity.PurchaseOrderStatus;

@Service
public class PurchaseOrderStatusServiceImpl implements IPurchaseOrderStatusService {

	@Autowired
	private PurchaseOrderStatusDao statusDao;
	
	// method to get all status
	@Override
	public APIResponse getAllStatus() {
		APIResponse apiResponse = new APIResponse();
		List<PurchaseOrderStatus> statusList = statusDao.findAll();
		
		// if the list is empty
		if(statusList.isEmpty()) {
			apiResponse.setError(HttpStatus.NOT_FOUND.value());
			apiResponse.setError("Database is empty!!! Add status list first");
		} else {
			apiResponse.setData(statusList);
		}
		
		return apiResponse;
	}

	// method to add a new status
	@Override
	public APIResponse addNewStatus(PurchaseOrderStatus status) {
		APIResponse apiResponse = new APIResponse();
		
		PurchaseOrderStatus newStatus = statusDao.save(status);
		apiResponse.setData("New status " + newStatus.getPo_status() + " added to the database successfully!!!");
		
		return apiResponse;
	}

}
