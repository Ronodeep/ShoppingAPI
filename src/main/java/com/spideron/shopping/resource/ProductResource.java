package com.spideron.shopping.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/products")
@Produces(MediaType.TEXT_PLAIN)
public class ProductResource {
	
	@GET
	public String getProduct() {
		return null;
	}
}
