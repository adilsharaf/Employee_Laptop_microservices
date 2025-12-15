package com.tcs.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Version;

@Entity
@Table(name = "employee-service")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;

    @Column(name = "laptop_id")
    private Long laptopId;
    
   
    
    

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Employee( String name, String email, Long laptopId) {
		super();
		this.name = name;
		this.email = email;
		this.laptopId = laptopId;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public Long getLaptopId() {
		return laptopId;
	}



	public void setLaptopId(Long laptopId) {
		this.laptopId = laptopId;
	}
	
	
    
    
}
