package com.spideron.shopping.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.spideron.shopping.hateoas.Link;

@XmlRootElement
public class Product{
	private String productid;
	private String category;
	private String productname;
	private float price;
	private float ratings;
	// Adding HATEOAS component
	private List<Link> urlLinkList=new ArrayList<Link>();
	
	public Product() {
		super();
	}
	public Product(String productid, String category, String productname, float price, float ratings) {
		super();
		this.productid = productid;
		this.category = category;
		this.productname = productname;
		this.price = price;
		this.ratings = ratings;
	}
	public String getProductid() {
		return productid;
	}
	public void setProductid(String productid) {
		this.productid = productid;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public float getRatings() {
		return ratings;
	}
	public void setRatings(float ratings) {
		this.ratings = ratings;
	}
	public List<Link> getUrlLinks() {
		return urlLinkList;
	}
	public void setUrlLinks(List<Link> urlLinks) {
		this.urlLinkList = urlLinks;
	}
	
	public void addLink(String url,String rel) {
		Link link=new Link(url, rel);
		urlLinkList.add(link);
	}
}
