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
import lombok.ToString;


@Entity
@Table(name = "tblAssetCategory")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AssetCategory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Setter(AccessLevel.NONE)
	private Integer ac_id;
	
	private String ac_name;

	// overloaded constructor
	public AssetCategory(String ac_name) {
		this.ac_name = ac_name;
	}
	
}
