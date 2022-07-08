package com.cognizant.api.example2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.api.example2.model.Employee;
import com.cognizant.api.example2.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;
	
	@RequestMapping(method =RequestMethod.POST, value ="addemployee")
	public Employee addEmployee(@RequestBody Employee employee) {
		return service.saveEmployee(employee);

	}
	@RequestMapping(method =RequestMethod.POST, value ="addemployees")
		public List<Employee> addEmployees(@RequestBody List<Employee> employees) {
			return service.saveAllEmployees(employees);
	}
	@RequestMapping(method =RequestMethod.GET, value ="getemployee")
	public List<Employee>getAllEmployees(){
		return service.getEmployees();
	}
	
	@RequestMapping(method =RequestMethod.GET, value ="getemployeebyid/{id}")
	public Employee getEmployeesbyId(@PathVariable int id){
		return service.getEmployeeById(id);
	}
	
	@RequestMapping(method =RequestMethod.GET, value ="getemployeebyname/{name}")
	public Employee getEmployeesbyname(@PathVariable String name){
		return service.getEmployeeByname(name);
	}
	
	
	@RequestMapping(method =RequestMethod.PUT, value ="updateemployee")
	public Employee updateEmployee(@RequestBody Employee employee) {
		return service.updateEmployee(employee);

	}
	@RequestMapping(method =RequestMethod.DELETE, value ="deleteemployee/{id}")
	public String deleteEmployee(@PathVariable int id) {
		return service.deleteEmployee(id);
	}
}
