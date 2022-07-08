package com.cognizant.DemoRestApi;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class EmployeeRepository {
	
	
	Connection con =null;
	public EmployeeRepository() {
		
		String url ="jdbc:mysql://localhost:3306/restdb";
		String username="root";
		String password ="Athira@11";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url,username,password);
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public List<Employee> getAllEmployee(){
	List<Employee>emp = new ArrayList<>();
	String sql = "select * from employee";
	
	try {
		
		Statement st = con.createStatement();
	ResultSet rs = 	st.executeQuery(sql);
	while(rs.next()) {
		
		Employee e1 = new Employee();
		e1.setId(rs.getInt(1));
		e1.setName(rs.getString(2));
		
		emp.add(e1);
	}
	}
	catch(Exception e) {
		
		System.out.println(e);
	}
	
	return emp;
	}
	
	public Employee getEmployeeOnId(int id) {
		
		String sql = "select * from employee where id ="+id;
		Employee e1 = new Employee();
		try {
			
			Statement st = con.createStatement();
		ResultSet rs = 	st.executeQuery(sql);
		if(rs.next()) {
			
			
			e1.setId(rs.getInt(1));
			e1.setName(rs.getString(2));
			
			
		}
		}
		catch(Exception e) {
			
			System.out.println(e);
		}
		
  return e1;
	}
	
	
	
	public void create(Employee e1) {
		
		
		String sql = "insert into employee values(?,?)";
		
		try {
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1,e1.getId());
			st.setString(2, e1.getName());
		st.executeUpdate();
		
		}
		
		catch(Exception e) {
			
			System.out.println(e);
		}
		
}
	
	
	
	
public void update(Employee e1) {
		
		
		String sql = "update employee set name =? where id =?";
		
		try {
			
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setString(1, e1.getName());
			st.setInt(2,e1.getId());
		st.executeUpdate();
		
		}
		
		catch(Exception e) {
			
			System.out.println(e);
		}
		
}


public void DeleteEmployee(int id) {
	
	
	String sql = "delete from employee  where id =?";
	
	try {
		
		PreparedStatement st = con.prepareStatement(sql);
		
		
		st.setInt(1,id);
	st.executeUpdate();
	
	}
	
	catch(Exception e) {
		
		System.out.println(e);
	}
	
}
}
