package com.nissan.service;

import com.nissan.common.APIResponse;
import com.nissan.entity.PurchaseOrder;
import com.nissan.entity.PurchaseOrderStatus;

public interface IPurchaseOrderStatusService {

	APIResponse getAllStatus();
	
	APIResponse addNewStatus(PurchaseOrderStatus status);

	

	
}
