package com.cognizant.DemoRestApi;

import java.util.ArrayList;
import java.util.List;

public class AllienRepository {

	
	List<Allien>alliens;
	
	
	public AllienRepository() {
		
		alliens = new ArrayList<>();
		
		
		Allien a1 = new Allien();
		a1.setName("Athira");
		a1.setPoints(60);
		a1.setId(101);
		
	Allien a2 = new Allien();
	a2.setName("Ambu");
	a2.setPoints(70);
	a2.setId(102);
	
	alliens.add(a1);
	alliens.add(a2);
	}
	
	public List<Allien> getAlliens(){
		return alliens;
	}
	
	public Allien getAlliensonid(int id) {
		
		
		for(Allien a: alliens) {
			
			if(a.getId()==id) {
				return a;
			}
		}
		return new Allien();
	}

	

	public void create(Allien a1) {
		alliens.add(a1);
		
	}
}
