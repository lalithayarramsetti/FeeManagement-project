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

@Table(name="fee_student", uniqueConstraints={@UniqueConstraint(columnNames={"rollno"})})
public class StudentBean {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="rollno", nullable=false, unique=true, length=11)
	private int rollno;
	@Column(name="name", nullable=false, length=30)
	private String name;
	@Column(name="email", nullable=false, length=30)
	private String email;
	@Column(name="sex", nullable=false, length=30)
	private String sex;
	@Column(name="course", nullable=false, length=30)
	private String course;
	@Column(name="fee", nullable=false, length=30)
	private int fee;
	@Column(name="paid", nullable=false, length=30)
	private int paid;
	@Column(name="due", nullable=false, length=30)
	private int due;
	@Column(name="address", nullable=false, length=30)
	private String address;
	@Column(name="contact", nullable=false, length=30)
	private String contact;
	
	public StudentBean(int rollno, String name, String email, String sex, String course, int fee, int paid, int due,
			String address, String contact) {
		super();
		this.rollno = rollno;
		this.name = name;
		this.email = email;
		this.sex = sex;
		this.course = course;
		this.fee = fee;
		this.paid = paid;
		this.due = due;
		this.address = address;
		this.contact = contact;
	}
	public StudentBean(String name, String email, String sex, String course, int fee, int paid, int due, String address,
			String contact) {
		super();
		this.name = name;
		this.email = email;
		this.sex = sex;
		this.course = course;
		this.fee = fee;
		this.paid = paid;
		this.due = due;
		this.address = address;
		this.contact = contact;
	}
	public StudentBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getRollno() {
		return rollno;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
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
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public int getFee() {
		return fee;
	}
	public void setFee(int fee) {
		this.fee = fee;
	}
	public int getPaid() {
		return paid;
	}
	public void setPaid(int paid) {
		this.paid = paid;
	}
	public int getDue() {
		return due;
	}
	public void setDue(int due) {
		this.due = due;
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
