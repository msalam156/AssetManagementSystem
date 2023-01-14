package com.nissan.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "tblUserRegistration")
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserRegistration {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Setter(AccessLevel.NONE)
	private Integer u_id;
	
	private String firstName;
	
	private String lastName;
	
	private Integer age;
	
	private String gender;
	
	private String address;
	
	private Long phoneNumber;
	
	@Setter(AccessLevel.NONE)
	private Integer l_id;
	
	@OneToOne
	@JoinColumn(name = "l_id", insertable = false, updatable = false)
	private Login login;

	// constructor 
	public UserRegistration(String firstName, String lastName, Integer age, String gender, String address,
			Long phoneNumber, Integer l_id) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.gender = gender;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.l_id = l_id;
	}
	
}
