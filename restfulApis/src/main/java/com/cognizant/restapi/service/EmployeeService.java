package com.cognizant.restapi.service;

import java.util.ArrayList;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.restapi.model.Employee;
import com.cognizant.restapi.repository.EmployeeRepository;

@Service
public class EmployeeService{
	
	@Autowired
	private EmployeeRepository repo;
	
	
	
	 public List<Employee> getEmployee() {
			List<Employee>emplist = new ArrayList<Employee>();
			repo.findAll().forEach(emplist::add);
			return emplist;
			}
	
	public void addEmployee(Employee employee) {
		
		repo.save(employee);
	}
	
	
    
    public void updateEmployee(int id ,Employee employee) {
    	   repo.save(employee);
    	  
      }

	public void deleteEmployee(int id) {
		repo.delete(id);
		
	}
}




