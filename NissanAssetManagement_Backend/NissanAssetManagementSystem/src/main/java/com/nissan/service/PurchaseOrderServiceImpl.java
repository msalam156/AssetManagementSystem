package com.nissan.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.nissan.dao.PurchaseOrderDao;
import com.nissan.dto.PurchaseOrderDTO;
import com.nissan.entity.PurchaseOrder;

@Service
public class PurchaseOrderServiceImpl implements IPurchaseOrderService {

	@Autowired
	PurchaseOrderDao purchaseOrderDao;

	@Override
	public ResponseEntity<PurchaseOrder> updatePurchaseOrder(Integer id, PurchaseOrder purchaseOrder) {
		try {
			PurchaseOrder updatePurchaseOrder = purchaseOrderDao.findById(id).orElseThrow();
			if (updatePurchaseOrder.getPd_id() == id) {
				updatePurchaseOrder.setPd_order_no(purchaseOrder.getPd_order_no());
				updatePurchaseOrder.setAd_id(purchaseOrder.getAd_id());
				updatePurchaseOrder.setAt_id(purchaseOrder.getAt_id());
				updatePurchaseOrder.setPd_qty(purchaseOrder.getPd_qty());
				updatePurchaseOrder.setPd_date(purchaseOrder.getPd_date());
				updatePurchaseOrder.setPd_ddate(purchaseOrder.getPd_ddate());
				updatePurchaseOrder.setPo_status_id(purchaseOrder.getPo_status_id());
				updatePurchaseOrder.setVd_id(purchaseOrder.getVd_id());
			}
			return new ResponseEntity<PurchaseOrder>(purchaseOrderDao.save(updatePurchaseOrder), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public List<PurchaseOrderDTO> getAllPurchaseOrders() {
		List<PurchaseOrder> orderList = purchaseOrderDao.findAll(); 
		if(orderList.isEmpty()) {
			return null;
		} else {
			List<PurchaseOrderDTO> orderDTOList = new ArrayList<>();
			for (PurchaseOrder order : orderList) {
				orderDTOList.add(new PurchaseOrderDTO(order.getPd_id(), order.getPd_order_no(),
						order.getAssetDefination().getAd_name(), order.getAssetType().getAt_name(), order.getPd_qty(),
						order.getPd_date(), order.getPd_ddate(), order.getPurchaseOrderStatus().getPo_status(),
						order.getVendor().getVd_name()));
			}
			return orderDTOList;
		}
	}

	@Override
	public PurchaseOrder savePurchaseOrder(PurchaseOrder purchaseOrder) {
		// TODO Auto-generated method stub
		return purchaseOrderDao.save(purchaseOrder);
	}

}
