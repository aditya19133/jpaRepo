package com.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "Student_table" , uniqueConstraints = @UniqueConstraint(name =  "emailId", columnNames = "email_id") )
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long rollNo;
	
	@Column(name = "fullname")
	private String name;
	
	@Column(name = "email_id" , nullable = false)
	private String emailId;
	
	@Embedded
	Guardian guardian;
	
	public Student() {}
	

	public Student(Long rollNo, String name, String emailId) {
		super();
		this.rollNo = rollNo;
		this.name = name;
		this.emailId = emailId;
	}
	
	public Student(Long rollNo, String name, String emailId, Guardian guardian) {
		super();
		this.rollNo = rollNo;
		this.name = name;
		this.emailId = emailId;
		this.guardian = guardian;
	}
	
	public Long getRollNo() {
		return rollNo;
	}
	
	public void setRollNo(Long rollNo) {
		this.rollNo = rollNo;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmailId() {
		return emailId;
	}
	
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	@Override
	public String toString() {
		return "Student [rollNo=" + rollNo + ", name=" + name + ", emailId=" + emailId + ", guardian=" + guardian + "]";
	}
	

}
