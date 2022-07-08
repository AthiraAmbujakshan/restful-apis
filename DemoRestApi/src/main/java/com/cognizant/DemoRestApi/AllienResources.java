      package com.cognizant.DemoRestApi;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("aliens")
public class AllienResources {

	// to return a single allien resources----//
	
/*	@GET
	 @Produces(MediaType.APPLICATION_XML)
	
	public  Allien getAlien() {
		Allien a1 = new Allien();
		a1.setName("Athira");
		a1.setPoints(60);
		
		return a1;
		
	} */
	
	
		//  to return multiple resources--------//
	
	
/*	@GET
	 @Produces(MediaType.APPLICATION_XML)
		
		public List<Allien> getMultipleAlien() {
			Allien a1 = new Allien();
			a1.setName("Athira");
			a1.setPoints(60);
			
			
		Allien a2 = new Allien();
		a1.setName("Ambu");
		a1.setPoints(70);
		
		List<Allien> alliens = Arrays.asList(a1, a2);
		return alliens;
		
		
	}*/
	
	
	// to get data from AllienRepository -----------------//
	
	
	

	AllienRepository repo = new AllienRepository();
	
	@GET
	 @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	
	public List<Allien> getAlien(){
		
		return repo.getAlliens();
		
	}
	
	
	
	//to create data or add data to database----
	

	@POST
	@Path("alien")
	
	 public Allien createAllien(Allien a1) {
		
	repo.create(a1);
	System.out.println(a1);
	return a1;
		
	}
	
	
	//to get particular allien based on id----
	@GET
	@Path("alien/101")

	 @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})

	
	public Allien getAllien() {
		return repo.getAlliensonid(101);
	}

// giving 101 is not good if we want to fetch other ids 
	
	@GET
	@Path("alien/{id}")

	 @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})

	
	public Allien getAlliens(@PathParam("id") int id) {
		return repo.getAlliensonid(id);
	}
	
}
