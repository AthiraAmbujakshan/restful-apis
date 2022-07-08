package com.cognizant.test.DemoRestApiSpringboot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeResources {

	@Autowired
	EmployeeRepository repo;
	
	
	
	@RequestMapping(method =RequestMethod.GET, value ="employee")
	public List<Employee>getEmployee(){
		 List<Employee>employess = repo.findAll();
		 return employess;
}
	
	@RequestMapping(method =RequestMethod.POST, value ="addemployee")
	@ResponseBody
	public Employee AddEmployee(@RequestBody Employee employee){
		
		 return repo.save(employee);
}
	
	@RequestMapping(method =RequestMethod.PUT, value ="updateemployee")
	@ResponseBody
	public Employee UpdateEmployee(@RequestBody Employee employee){
		
		 return repo.save(employee);
	
}
	
	@RequestMapping(method =RequestMethod.DELETE, value ="deleteemployee/{id}")
	
	public String  DeleteEmployee(@PathVariable int id ){
		
		 repo.delete(id);
		 return "employee deleted" +id;
	
}
	
}
