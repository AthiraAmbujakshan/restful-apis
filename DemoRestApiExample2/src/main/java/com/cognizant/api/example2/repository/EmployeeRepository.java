package com.cognizant.api.example2.repository;




import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.api.example2.model.Employee;







public interface EmployeeRepository  extends JpaRepository<Employee, Integer>{

	Employee findById(int id);

	Employee findByName(String name);

	

	

}
