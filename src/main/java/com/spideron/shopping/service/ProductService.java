package com.spideron.shopping.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.spideron.shopping.database.DatabaseOps;
import com.spideron.shopping.model.Product;

public class ProductService {
	private DatabaseOps dbOPS = new DatabaseOps();
	
	public Product getProduct(String productID) throws SQLException {
		// TODO: exception handling
		final String productSelectQuery = "select * from products where productid=?";
		Connection connection = dbOPS.getConnection();
		Product product = null;
		
		try {
			if (connection != null) {

				PreparedStatement ptSelectQuery = connection.prepareStatement(productSelectQuery);
				ptSelectQuery.setString(1, productID);
				ResultSet productSet = ptSelectQuery.executeQuery();

				while (productSet.next()) {
					product = new Product(productSet.getString(1), productSet.getString(2),
							productSet.getString(3), productSet.getFloat(4),productSet.getFloat(5));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbOPS.closeDBConnection(connection);
		}
		return product;
	}
	
	public List<Product> getMatchedProducts(String productPartialName) throws SQLException {
		// TODO: exception handling
		final String productSelectQuery = "select * from products where productname like ?";
		Connection connection = dbOPS.getConnection();
		Product product = null;
		List<Product> productList=null;
		try {
			if (connection != null) {

				PreparedStatement ptSelectQuery = connection.prepareStatement(productSelectQuery);
				ptSelectQuery.setString(1, "%"+productPartialName+"%");
				System.out.println("ptSelectQuery:"+ptSelectQuery);
				ResultSet productSet = ptSelectQuery.executeQuery();
				productList=new ArrayList<Product>();
				
				while (productSet.next()) {
					product = new Product(productSet.getString(1), productSet.getString(2),
							productSet.getString(3), productSet.getFloat(4),productSet.getFloat(5));
					productList.add(product);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbOPS.closeDBConnection(connection);
		}
		return productList;
	}
}
