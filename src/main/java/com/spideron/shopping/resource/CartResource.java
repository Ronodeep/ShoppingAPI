package com.spideron.shopping.resource;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.spideron.shopping.model.Cart;
import com.spideron.shopping.service.CartService;

@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
public class CartResource {
	private CartService cartServ=new CartService();
	
	@GET
	public List<Cart> getCartsForCustomer(@PathParam("customerID")String custId) throws SQLException {
		return cartServ.getCartsForCustomer(custId);
	}

}
