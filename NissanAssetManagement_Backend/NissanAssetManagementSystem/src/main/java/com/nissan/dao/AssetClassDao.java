package com.nissan.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nissan.entity.AssetCategory;

@Repository
public interface AssetClassDao extends JpaRepository<AssetCategory, Integer> {

}
