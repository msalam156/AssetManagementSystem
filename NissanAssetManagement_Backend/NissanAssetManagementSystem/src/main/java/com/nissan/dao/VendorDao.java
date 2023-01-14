package com.nissan.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nissan.entity.Vendor;

@Repository
public interface VendorDao extends JpaRepository<Vendor, Integer> {

}
