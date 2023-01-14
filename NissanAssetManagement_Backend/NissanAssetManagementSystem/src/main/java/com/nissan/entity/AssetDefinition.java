package com.nissan.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "tblAssetDefinition")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AssetDefinition {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Setter(AccessLevel.NONE)
	private Integer ad_id;
	
	private String ad_name;
	
	private Integer at_id;
	
	private Integer ac_id;
	
	@ManyToOne
	@JoinColumn(name = "at_id", insertable = false, updatable = false)
	@JsonIgnore
	private AssetType assetType;
	
	@ManyToOne
	@JoinColumn(name = "ac_id", insertable = false, updatable = false)
	@JsonIgnore
	private AssetCategory assetCategory;

	// overloaded constructor
	public AssetDefinition(String ad_name, Integer at_id, Integer ac_id) {
		this.ad_name = ad_name;
		this.at_id = at_id;
		this.ac_id = ac_id;
	}
	
}
