package com.spideron.shopping.resource;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.spideron.shopping.model.Order;
import com.spideron.shopping.service.OrderService;

@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
public class OrderResource {
	private OrderService ordeServ = new OrderService();

	@GET
	public List<Order> getCustomersOrders(@PathParam("customerID") String custID,
			@QueryParam("startDate") Date startDate, @QueryParam("endDate")Date endDate) throws SQLException {
		
		return ordeServ.getOrderListForCustomer(custID,startDate,endDate);
	}

	@GET
	@Path("/{orderId}")
	public Order getCustomersOrders(@PathParam("customerID") String custID, @PathParam("orderId") String orderId)
			throws SQLException {
		return ordeServ.getOrderForCustomer(custID, orderId);
	}
}
