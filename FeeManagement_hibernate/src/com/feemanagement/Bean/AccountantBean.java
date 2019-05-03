package com.feemanagement.Bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
 
@Entity
@Table(name="fee_accountant", uniqueConstraints={@UniqueConstraint(columnNames={"id"})})
public class AccountantBean {
	public AccountantBean() {}
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", nullable=false, unique=true, length=11)
		private int id;
	@Column(name="name", nullable=false, length=30)
		private String name;
	@Column(name="email", nullable=false, length=30)
		private String email;
	@Column(name="password", nullable=false, length=30)
		private String password;
	@Column(name="address", nullable=false, length=30)
		private String address;
	@Column(name="contact", nullable=false, length=30)
		private String contact;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public AccountantBean(String name, String email, String password, String address, String contact) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.address = address;
		this.contact = contact;
	}
	public AccountantBean(int id, String name, String email, String password, String address, String contact) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.address = address;
		this.contact = contact;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}

}
