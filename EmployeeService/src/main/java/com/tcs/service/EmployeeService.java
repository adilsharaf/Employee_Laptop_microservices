package com.tcs.service;

import java.util.List;

import com.tcs.Exceptions.EmployeeIDNotFoundException;
import com.tcs.Exceptions.LaptopIDNotFOundException;
import com.tcs.dto.EmployeeWithLaptopDTO;
import com.tcs.dto.LaptopDTO;
import com.tcs.entity.Employee;

public interface EmployeeService {
//
//	Create Employee (Laptop ID initially NULL)
//	Update Employee to assign a Laptop
//	Get Employee details
//	Get Employee along with assigned Laptop details (using Feign Client)
//	Update Employee details
//	Delete Employee
	
	Employee createEmployee(Employee employee);
	Employee assignLaptop(long empId, long laptopId)throws EmployeeIDNotFoundException,LaptopIDNotFOundException;
	List<Employee> getEmployees();
	EmployeeWithLaptopDTO getEmployeeWithLaptop(Long id) throws EmployeeIDNotFoundException ;
	Employee updateEmployeeDetails(long empid,Employee employee)throws EmployeeIDNotFoundException ;
	String deleteEmployee(long empid)throws EmployeeIDNotFoundException ;
}
