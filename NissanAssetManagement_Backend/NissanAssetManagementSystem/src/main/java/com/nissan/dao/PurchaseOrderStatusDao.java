package com.nissan.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nissan.entity.PurchaseOrderStatus;

@Repository
public interface PurchaseOrderStatusDao extends JpaRepository<PurchaseOrderStatus, Integer> {

}
