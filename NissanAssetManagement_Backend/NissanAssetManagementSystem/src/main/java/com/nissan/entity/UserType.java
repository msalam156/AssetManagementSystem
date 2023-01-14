package com.nissan.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tblUserType")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserType {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Setter(AccessLevel.NONE)
	private Integer ut_id;
	
	// Admin, Purchase Manager, Vendor
	private String ut_name;

	// overloaded constructor
	public UserType(String ut_name) {
		this.ut_name = ut_name;
	}
	
}
