package com.spideron.shopping.resource;

import java.net.URI;
import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.spideron.shopping.model.Product;
import com.spideron.shopping.service.ProductService;

@Path("/products")
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })

public class ProductResource {
	private ProductService prdServ = new ProductService();

	@GET
	@Path("/{productId}")
	public Product getProduct(@PathParam("productId") String productID) throws SQLException {
		return prdServ.getProduct(productID);
	}

	@GET
	public List<Product> getMatchProducts(@QueryParam("prdPartialName") String prdPartialName) throws SQLException {
		return prdServ.getMatchedProducts(prdPartialName);
	}

	@POST
	public Response addNewProduct(Product product, @Context UriInfo uriInfo) throws SQLException {

		Product newProduct = prdServ.addNewProduct(product);
		newProduct.addLink(generateProductURL(uriInfo, newProduct.getProductid()), "self");

		// Adding STATUS CODE and Resource Location URL in Header
		URI resourcePath = uriInfo.getAbsolutePathBuilder().path(newProduct.getProductid()).build();
		return Response.created(resourcePath).entity(newProduct).build();

	}

	/**
	 * Generate HATEOAS LINK for product that is newly created
	 * 
	 * @param uriInfo
	 * @param profileID
	 * @return
	 */
	private String generateProductURL(UriInfo uriInfo, String profileID) {
		return uriInfo.getAbsolutePathBuilder().path(profileID).build().toString();
	}
}
