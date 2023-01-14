package com.nissan.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.nissan.dto.PurchaseOrderDTO;
import com.nissan.entity.PurchaseOrder;

public interface IPurchaseOrderService {

	ResponseEntity<PurchaseOrder> updatePurchaseOrder(Integer id, PurchaseOrder purchaseOrder);

	List<PurchaseOrderDTO> getAllPurchaseOrders();

	PurchaseOrder savePurchaseOrder(PurchaseOrder purchaseOrder);

}
