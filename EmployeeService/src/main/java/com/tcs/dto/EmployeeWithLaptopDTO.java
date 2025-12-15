package com.tcs.dto;

import com.tcs.entity.Employee;

public class EmployeeWithLaptopDTO {

    private Long id;
    private String name;
    private String email;
    private LaptopDTO laptop;

    
    public EmployeeWithLaptopDTO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public EmployeeWithLaptopDTO(Employee emp, LaptopDTO laptop) {
        this.id = emp.getId();
        this.name = emp.getName();
        this.email = emp.getEmail();
        this.laptop = laptop;
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


	public LaptopDTO getLaptop() {
		return laptop;
	}


	public void setLaptop(LaptopDTO laptop) {
		this.laptop = laptop;
	}


	@Override
	public String toString() {
		return "EmployeeWithLaptopDTO [id=" + id + ", name=" + name + ", email=" + email + ", laptop=" + laptop + "]";
	}
	
	
}

