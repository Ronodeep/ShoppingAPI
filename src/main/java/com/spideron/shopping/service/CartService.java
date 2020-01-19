package com.spideron.shopping.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.spideron.shopping.database.DatabaseOps;
import com.spideron.shopping.model.Cart;

public class CartService {
	private DatabaseOps dbOPS = new DatabaseOps();
	
	public List<Cart> getCartsForCustomer(String custId) throws SQLException{
		// TODO: exception handling
		final String orderSelectQuery = "select * from carts where customerid=?";
		Connection connection = dbOPS.getConnection();

		List<Cart> cartList = null;
		try {
			if (connection != null) {

				PreparedStatement ptSelectQuery = connection.prepareStatement(orderSelectQuery);
				ptSelectQuery.setString(1, custId);

				ResultSet cartSet = ptSelectQuery.executeQuery();
				cartList = new ArrayList<Cart>();

				while (cartSet.next()) {
					Cart cart=new Cart(cartSet.getString(1), cartSet.getString(2), cartSet.getString(3));
					cartList.add(cart);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbOPS.closeDBConnection(connection);
		}
		return cartList;
	}
}
