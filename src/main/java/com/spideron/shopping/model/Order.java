package com.spideron.shopping.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Order {
	private String ordernumber;
    private Date orderdate;
    private String customername;
    private String productsOrdered;
    
    
	public Order() {
		super();
	}
	public Order(String ordernumber, Date orderdate, String customername, String productsOrdered) {
		super();
		this.ordernumber = ordernumber;
		this.orderdate = orderdate;
		this.customername = customername;
		this.productsOrdered = productsOrdered;
	}
	public String getOrdernumber() {
		return ordernumber;
	}
	public void setOrdernumber(String ordernumber) {
		this.ordernumber = ordernumber;
	}
	public Date getOrderdate() {
		return orderdate;
	}
	public void setOrderdate(Date orderdate) {
		this.orderdate = orderdate;
	}
	public String getCustomername() {
		return customername;
	}
	public void setCustomername(String customername) {
		this.customername = customername;
	}
	public String getProductsOrdered() {
		return productsOrdered;
	}
	public void setProductsOrdered(String productsOrdered) {
		this.productsOrdered = productsOrdered;
	}
    
    
}
