package com.spideron.shopping.resource;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.spideron.shopping.model.Product;
import com.spideron.shopping.service.ProductService;

@Path("/products")
@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
public class ProductResource {
	private ProductService prdServ= new ProductService();
	@GET
	@Path("/{productId}")
	public Product getProduct(@PathParam("productId")String productID) throws SQLException {
		return prdServ.getProduct(productID);
	}
	
	@GET
	public List<Product> getMatchProducts(@QueryParam("prdPartialName")String prdPartialName) throws SQLException {
		return prdServ.getMatchedProducts("Core");
	}
}
