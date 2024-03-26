package com.jpa.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@AttributeOverrides(value = { @AttributeOverride(name = "name", column = @Column(name = "guardianName") ),
		@AttributeOverride(name = "email", column = @Column(name = "guardianEmail") ),
		@AttributeOverride(name = "address", column = @Column(name = "guardianAddress") )})
public class Guardian {

	String name;
	String email;
	String address;
	
	@Override
	public String toString() {
		return "Guardian [name=" + name + ", email=" + email + ", address=" + address + "]";
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Guardian(String name, String email, String address) {
		super();
		this.name = name;
		this.email = email;
		this.address = address;
	}
	
	public Guardian() {}
	

}
