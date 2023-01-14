package com.nissan.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "tblLogin")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Login {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Setter(AccessLevel.NONE)
	private Integer l_id;
	
	@Column(unique = true)
	private String username;
	
	private String password;
	
	private Integer ut_id;
	
	@ManyToOne
	@JoinColumn(name = "ut_id", insertable = false, updatable = false)
	private UserType userType;
	
	@OneToOne(mappedBy = "login")
	@JsonIgnore
	private UserRegistration userRegistration;

	// overloaded constructor
	public Login(String username, String password, Integer ut_id) {
		this.username = username;
		this.password = password;
		this.ut_id = ut_id;
	}
	
}
