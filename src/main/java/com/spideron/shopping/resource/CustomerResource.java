package com.spideron.shopping.resource;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.spideron.shopping.model.Customer;
import com.spideron.shopping.service.CustomerService;

@Path("/customers")
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class CustomerResource {
	private CustomerService customerServ=new CustomerService();
	
	@GET
	public List<Customer> getCustomers() throws SQLException {
		// FIXME: exception handling
		return customerServ.getAllCustomers();
	}
	
	@GET
	@Path("/{customerID}")
	public Customer getCustomer(@PathParam("customerID")String custID) throws SQLException {
		// FIXME: exception handling
		return customerServ.getCustomer(custID);
	}
	
	@Path("/{customerID}/orders")
	public OrderResource getOrderResource() throws SQLException {
		// FIXME: exception handling
		return new OrderResource();
	}

	@Path("/{customerID}/carts") 
	public CartResource getCartResource() throws SQLException { 
		// FIXME: exception handling 
		return new CartResource(); 
	}
	 
}
