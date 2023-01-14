package com.nissan.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.nissan.entity.PurchaseOrder;

@Repository
public interface PurchaseOrderDao extends JpaRepository<PurchaseOrder, Integer>{

}
