package com.nissan.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nissan.entity.UserType;

@Repository
public interface UserTypeDao extends JpaRepository<UserType, Integer> {

}
