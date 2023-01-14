package com.nissan.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "tblAssetType")
@Setter
@Getter
@NoArgsConstructor
@ToString
public class AssetType {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Setter(AccessLevel.NONE)
	private Integer at_id;
	
	private String at_name;

	// overloaded constructor
	public AssetType(String at_name) {
		this.at_name = at_name;
	}
	
}
