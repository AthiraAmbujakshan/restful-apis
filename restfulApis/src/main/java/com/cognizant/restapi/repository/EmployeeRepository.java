package com.cognizant.restapi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.restapi.model.Employee;


@Repository
public interface EmployeeRepository  extends JpaRepository<Employee, Integer>{

	

	//List<Employee> saveAll(List<Employee> employees);

	//Employee findById(int id);

	//Employee findByName(String name);

}


