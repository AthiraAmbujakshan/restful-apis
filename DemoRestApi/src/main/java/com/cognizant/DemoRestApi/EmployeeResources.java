package com.cognizant.DemoRestApi;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("employee")
public class EmployeeResources {

	EmployeeRepository repo = new EmployeeRepository();
	
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	
	public List<Employee>getAllEmployee(){
		return repo.getAllEmployee();
	}
	
	
	@POST
    @Path("newemployee")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Employee CreateEmployee(Employee e1)
	{
		 repo.create(e1);
		 System.out.println(e1);
	return e1;
	}
	
	@GET
	@Path("newemployee/101")

	 @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})

	
	public Employee getEmployeeById() {
		return repo.getEmployeeOnId(101);
	}
	
	@GET
	@Path("newemployee/{id}")

	 @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})

	
	public Employee getEachEmployeeById(@PathParam("id") int id) {
		return repo.getEmployeeOnId(id);
	}
	
	
	
	@PUT
	@Path("newemployee")

	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})

	
	public Employee UpdateEmployee(Employee e1) {
		System.out.println(e1);
		
		
		// check if id exists, if not, create new resources, else update employee
		
		if(repo.getEmployeeOnId(e1.getId()).getId()==0)
		{
			repo.create(e1);
		}
		else {
			repo.update(e1);	
		}
	
	return e1;
	}
	
	
	
	@DELETE
	@Path("newemployee/{id}")

	
	public Employee DeleteEmployee(@PathParam("id") int id) {
		Employee e1 = repo.getEmployeeOnId(id);
		if(e1.getId()!= 0) {
			repo.DeleteEmployee(id);
		}
		
	
	return e1;
	}
	
	
}
