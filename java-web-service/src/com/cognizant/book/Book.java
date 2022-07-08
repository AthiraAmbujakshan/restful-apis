package com.cognizant.book;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * 
 * 
 * to consume restful apis usimg java project by adding 
 * @author 845269
 *
 */
@Path("/book")
public class Book {
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public String HelloWorldXml() {
		String response ="<? xml version= '1.0'?>"+"<hello>HelloWorld</hello>";
		return response;
		
	}

}
