package com.spideron.shopping.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.spideron.shopping.database.DatabaseOps;
import com.spideron.shopping.model.Order;

public class OrderService {
	private DatabaseOps dbOPS = new DatabaseOps();

	public List<Order> getOrderListForCustomer(String custID) throws SQLException {

		// TODO: exception handling
		final String orderSelectQuery = "select * from Orders where customername=(select name from customers where customerid=?)";
		Connection connection = dbOPS.getConnection();

		List<Order> orderList = null;
		try {
			if (connection != null) {

				PreparedStatement ptSelectQuery = connection.prepareStatement(orderSelectQuery);
				ptSelectQuery.setString(1, custID);
				ResultSet customerSet = ptSelectQuery.executeQuery();
				orderList = new ArrayList<Order>();

				while (customerSet.next()) {
					Order order = new Order(customerSet.getString(1), customerSet.getDate(2), customerSet.getString(3),
							customerSet.getString(4));
					orderList.add(order);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbOPS.closeDBConnection(connection);
		}
		return orderList;
	}

	public Order getOrderForCustomer(String custID, String orderId) throws SQLException {
		// TODO: exception handling
		final String orderSelectQuery = "select * from Orders where ordernumber=? and customername=(select name from customers where customerid=?)";
		Connection connection = dbOPS.getConnection();

		Order order=null;
		try {
			if (connection != null) {
				PreparedStatement ptSelectQuery = connection.prepareStatement(orderSelectQuery);
				
				ptSelectQuery.setString(1, orderId);
				ptSelectQuery.setString(2, custID);
				
				
				ResultSet customerSet = ptSelectQuery.executeQuery();
				while (customerSet.next()) {
					order = new Order(customerSet.getString(1), customerSet.getDate(2), customerSet.getString(3),
							customerSet.getString(4));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbOPS.closeDBConnection(connection);
		}
		return  order;
	}
}
