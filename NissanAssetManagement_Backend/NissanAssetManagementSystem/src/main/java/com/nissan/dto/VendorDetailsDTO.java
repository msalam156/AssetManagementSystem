package com.nissan.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class VendorDetailsDTO {
	
	private Integer vd_id;

	private String vd_name;

	private String at_type;

	private LocalDate vd_from;

	private LocalDate vd_to;

	private String vd_address;

	private String vd_email;

	public VendorDetailsDTO(Integer vd_id, String vd_name, String at_type, LocalDate vd_from, LocalDate vd_to,
			String vd_address, String vd_email) {
		this.vd_id = vd_id;
		this.vd_name = vd_name;
		this.at_type = at_type;
		this.vd_from = vd_from;
		this.vd_to = vd_to;
		this.vd_address = vd_address;
		this.vd_email = vd_email;
	}
	
}
