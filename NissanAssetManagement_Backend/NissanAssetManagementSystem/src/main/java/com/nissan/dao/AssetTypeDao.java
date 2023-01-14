package com.nissan.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nissan.entity.AssetType;

@Repository
public interface AssetTypeDao extends JpaRepository<AssetType, Integer>{

}
