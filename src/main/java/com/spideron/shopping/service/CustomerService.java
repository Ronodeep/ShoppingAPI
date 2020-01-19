package com.spideron.shopping.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.spideron.shopping.database.DatabaseOps;
import com.spideron.shopping.model.Customer;

public class CustomerService {
	private DatabaseOps dbOPS = new DatabaseOps();

	public List<Customer> getAllCustomers() throws SQLException {
		// TODO: exception handling
		final String customeSelectQuery = "select * from customers";
		Connection connection = dbOPS.getConnection();

		List<Customer> customerList = null;
		try {
			if (connection != null) {

				PreparedStatement ptSelectQuery = connection.prepareStatement(customeSelectQuery);
				ResultSet customerSet = ptSelectQuery.executeQuery();
				customerList = new ArrayList<Customer>();

				while (customerSet.next()) {
					Customer customer = new Customer(customerSet.getString(1), customerSet.getString(2),
							customerSet.getString(3), customerSet.getString(4));
					customerList.add(customer);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbOPS.closeDBConnection(connection);
		}
		return customerList;
	}

	public Customer getCustomer(String custID) throws SQLException {
		// TODO: exception handling
		final String customeSelectQuery = "select * from customers where customerid=?";
		Connection connection = dbOPS.getConnection();
		Customer customer = null;
		try {
			if (connection != null) {

				PreparedStatement ptSelectQuery = connection.prepareStatement(customeSelectQuery);
				ptSelectQuery.setString(1, custID);

				ResultSet customerSet = ptSelectQuery.executeQuery();

				while (customerSet.next()) {
					customer = new Customer(customerSet.getString(1), customerSet.getString(2),
							customerSet.getString(3), customerSet.getString(4));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbOPS.closeDBConnection(connection);
		}
		return customer;
	}
}
