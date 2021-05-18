package com.vti.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Entity
@Table(name = "`Admin`", catalog = "heroku_b127bd7a389e7b4")
public class Admin implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "Email", nullable = false, unique = true, length = 100)
	@Email
	private String email;
	
	@Column(name = "`Password`", nullable = false, length = 255)
	@Size(min=8 , max=255)
	private String password;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Admin() {
		
	}

	public Admin(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	@Override
	public String toString() {
		return "Admin [email=" + email + ", password=" + password + "]";
	}


}
