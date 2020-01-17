package com.spideron.shopping.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.spideron.shopping.database.DatabaseOps;

@Path("/consumers")
@Produces(MediaType.TEXT_PLAIN)
public class ConsumerResource {
	private DatabaseOps dbOPS= new DatabaseOps();
	
	@GET
	public String getConsumer() {
		//Connection connection = dbOPS.getConnection();
		return "String";
	}

}
