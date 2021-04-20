package com;

//For REST Service
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import model.Product;

@Path("/Product")
public class ProductService {

	Product productObj = new Product();
	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readItems()
	{
	return "Hello";
	}
}
