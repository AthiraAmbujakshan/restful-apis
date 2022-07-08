package com.cognizant.restapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RestController;

import com.cognizant.restapi.model.Employee;
import com.cognizant.restapi.service.EmployeeService;

@RestController
public class EmployeeController {
	
	
	@Autowired
  private EmployeeService  employeeservice;
	
	@RequestMapping("/getallemployee")
	
	public List <Employee> getAllEmployee(){
	return	employeeservice.getEmployee();
		
	}
	
	
	@RequestMapping(method =RequestMethod.POST, value ="/addemployee")
	public void addEmployee(@RequestBody Employee employee) {
		
	  employeeservice.addEmployee(employee);
	}
	
	@RequestMapping(method =RequestMethod.PUT, value ="/updateemployee/{id}")
	public void updateEmployee(@PathVariable int id, @RequestBody Employee employee) {
		
	  employeeservice.updateEmployee(id,employee);
	}
	
	@RequestMapping(method =RequestMethod.DELETE, value ="/deleteemployee/{id}" )
	public void deleteEmployee(@PathVariable int id) {
		
		 employeeservice.deleteEmployee(id);
	}
	
}
	
