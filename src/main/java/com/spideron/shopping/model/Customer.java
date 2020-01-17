package com.spideron.shopping.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Customer {
	private String customerid;
	private String name;
	private String email;
	private String city;
	
	
	public Customer() {
		super();
	}
	public Customer(String customerid, String name, String email, String city) {
		super();
		this.customerid = customerid;
		this.name = name;
		this.email = email;
		this.city = city;
	}
	public String getCustomerid() {
		return customerid;
	}
	public void setCustomerid(String customerid) {
		this.customerid = customerid;
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
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	
}
