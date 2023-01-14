package com.nissan.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tblVendor")
public class Vendor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Setter(AccessLevel.NONE)
	private Integer vd_id;

	private String vd_name;

	private Integer at_id;

	private LocalDate vd_from;

	private LocalDate vd_to;

	private String vd_address;

	private Integer l_id;

	@ManyToOne
	@JoinColumn(name = "at_id", insertable = false, updatable = false)
	private AssetType assetType;

	@OneToOne
	@JoinColumn(name = "l_id", updatable = false, insertable = false)
	private Login login;

	// overloaded constructor
	public Vendor(String vd_name, Integer at_id, LocalDate vd_from, LocalDate vd_to, String vd_address, Integer l_id) {
		this.vd_name = vd_name;
		this.at_id = at_id;
		this.vd_from = vd_from;
		this.vd_to = vd_to;
		this.vd_address = vd_address;
		this.l_id = l_id;
	}

}
