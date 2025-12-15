package com.tcs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.Exceptions.EmployeeIDNotFoundException;
import com.tcs.Exceptions.LaptopIDNotFOundException;
import com.tcs.dto.EmployeeWithLaptopDTO;
import com.tcs.entity.Employee;
import com.tcs.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	EmployeeService service;

	@PostMapping
	public Employee create(@RequestBody Employee emp) {
		return service.createEmployee(emp);
	}

	@PutMapping("/{id}/assign-laptop/{laptopId}")
	public Employee assignLaptop(@PathVariable Long id, @PathVariable Long laptopId)
			throws EmployeeIDNotFoundException,LaptopIDNotFOundException {
		return service.assignLaptop(id, laptopId);
	}

	@GetMapping
	public List<Employee> getEmployees() {
		return service.getEmployees();
	}

	@PutMapping("/{id}")
	public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee)
			throws EmployeeIDNotFoundException {
		return service.updateEmployeeDetails(id, employee);
	}

	@GetMapping("/details/{id}")
	public EmployeeWithLaptopDTO getEmployeeWithLaptop(@PathVariable Long id) throws EmployeeIDNotFoundException {
		return service.getEmployeeWithLaptop(id);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) throws EmployeeIDNotFoundException {
		service.deleteEmployee(id);
	}
}
