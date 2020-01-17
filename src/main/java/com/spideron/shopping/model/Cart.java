package com.spideron.shopping.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Cart {
	private String cartid;
	private String customerid;
	private String productList;
	
	
	public Cart() {
		super();
	}
	public Cart(String cartid, String customerid, String productList) {
		super();
		this.cartid = cartid;
		this.customerid = customerid;
		this.productList = productList;
	}
	public String getCartid() {
		return cartid;
	}
	public void setCartid(String cartid) {
		this.cartid = cartid;
	}
	public String getCustomerid() {
		return customerid;
	}
	public void setCustomerid(String customerid) {
		this.customerid = customerid;
	}
	public String getProductList() {
		return productList;
	}
	public void setProductList(String productList) {
		this.productList = productList;
	}
	
	
}
