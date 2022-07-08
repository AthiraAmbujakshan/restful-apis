package com.cognizant.api.example2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.api.example2.model.Employee;
import com.cognizant.api.example2.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository repo;
	
	
	public Employee saveEmployee(Employee employee) {
		return repo.save(employee);
	}
	

	public List<Employee> saveAllEmployees(List<Employee> employees) {
		return repo.save(employees);
	}
	
	public List<Employee> getEmployees() {
		return repo.findAll();
	}
	
	public Employee getEmployeeById(int id) {
		return repo.findById(id);
	}
	
	public Employee getEmployeeByname(String name) {
		return repo.findByName(name);
	}
	
	public String deleteEmployee(int id) {
		
		repo.delete(id);
		return "employee deleted " + id;
	}
	
	public Employee updateEmployee(Employee employee) {
		
		Employee existingemployee = repo.findById(employee.getId());
		existingemployee.setName(employee.getName());
		return repo.save(existingemployee);
	}
}
