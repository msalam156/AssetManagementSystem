package com.nissan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nissan.common.APIResponse;
import com.nissan.dao.PurchaseOrderDao;
import com.nissan.dto.PurchaseOrderDTO;
import com.nissan.entity.PurchaseOrder;
import com.nissan.entity.PurchaseOrderStatus;
import com.nissan.service.IPurchaseOrderService;
import com.nissan.service.IPurchaseOrderStatusService;

@CrossOrigin
@RestController
@RequestMapping("/api/purchaseOrder")
public class PurchaseOrderController {

	@Autowired
	PurchaseOrderDao purchaseOrderDao;

	@Autowired
	private IPurchaseOrderStatusService purchaseOrderStatusService;
	
	@Autowired
	private IPurchaseOrderService purchaseOrderService;

	@PutMapping("{id}")
	public ResponseEntity<PurchaseOrder> updateCustomer(@PathVariable Integer id,
			@RequestBody PurchaseOrder purchaseOrder) {

		return purchaseOrderService.updatePurchaseOrder(id, purchaseOrder);
	}

	@PostMapping("/insertPurchaseOrder")
	public void createUser(@RequestBody PurchaseOrder purchaseOrder) {
		purchaseOrderDao.save(purchaseOrder);
	}

	@GetMapping("/allPurchaseOrder")
	public List<PurchaseOrderDTO> getAllPurchaseOrders() {
//		APIResponse apiResponse = new APIResponse();
		List<PurchaseOrderDTO> orderDTOList = purchaseOrderService.getAllPurchaseOrders();
		
//		if(orderDTOList.isEmpty()) {
//			apiResponse.setStatus(HttpStatus.NOT_FOUND.value());
//			apiResponse.setError("Database is empty!!! Please add purchase order first!!!");
//		} else {
//			apiResponse.setData(orderDTOList);
//		}
		return orderDTOList;
//		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}

	@PostMapping("/addingPurchaseOrder")
	public PurchaseOrder createPurchaseOrder(@RequestBody PurchaseOrder purchaseOrder) {
		return purchaseOrderService.savePurchaseOrder(purchaseOrder);
	}


	// API to find all the status
	@GetMapping("/status")
	public ResponseEntity<APIResponse> getAllPurchaseStatus() {
		APIResponse apiResponse = purchaseOrderStatusService.getAllStatus();
		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}
	
	// API to add new Purchase Status
	@PostMapping("/status")
	public ResponseEntity<APIResponse> addNewPurchaseStatus(@RequestBody PurchaseOrderStatus orderStatus) {
		APIResponse apiResponse = purchaseOrderStatusService.addNewStatus(orderStatus);

		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}

}
