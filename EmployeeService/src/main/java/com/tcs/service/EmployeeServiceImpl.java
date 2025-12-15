package com.tcs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.Exceptions.EmployeeIDNotFoundException;
import com.tcs.Exceptions.LaptopIDNotFOundException;
import com.tcs.client.EmployeeClient;
import com.tcs.dto.EmployeeWithLaptopDTO;
import com.tcs.dto.LaptopDTO;
import com.tcs.entity.Employee;
import com.tcs.repository.EmployeeRepository;

import jakarta.transaction.Transactional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    EmployeeClient employeeClient;

    @Override
    @Transactional
    public Employee createEmployee(Employee employee) {
        employee.setLaptopId(null); 
        return employeeRepository.save(employee);
    }

    @Override
    @Transactional
    public Employee assignLaptop(long empId, long laptopId) throws EmployeeIDNotFoundException, LaptopIDNotFOundException {
        Employee emp = employeeRepository.findById(empId).orElseThrow(
                () -> new EmployeeIDNotFoundException("Employee not found with ID: " + empId));

       
        LaptopDTO laptop = employeeClient.getLaptopById(laptopId);  
        if (laptop == null) {
            throw new LaptopIDNotFOundException("Laptop not found with ID: " + laptopId);
        }

    
        emp.setLaptopId(laptop.getId());

      
        return employeeRepository.save(emp);
    }

   
    @Override
    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    
    @Override
    @Transactional
    public EmployeeWithLaptopDTO getEmployeeWithLaptop(Long id) throws EmployeeIDNotFoundException {
        Employee emp = employeeRepository.findById(id).orElseThrow(
                () -> new EmployeeIDNotFoundException("Employee not found with ID: " + id));

        System.out.println("Employee: " + emp);
        
        LaptopDTO laptop = null;
        if (emp.getLaptopId() != null) {
            laptop = employeeClient.getLaptopById(emp.getLaptopId());
            System.out.println("Laptop: " + laptop);
        }

        

        
        return new EmployeeWithLaptopDTO(emp, laptop);
    }

    @Override
    @Transactional
    public Employee updateEmployeeDetails(long empId, Employee employee) throws EmployeeIDNotFoundException {
        Employee emp = employeeRepository.findById(empId).orElseThrow(
                () -> new EmployeeIDNotFoundException("Employee not found with ID: " + empId));

        emp.setName(employee.getName());
        emp.setEmail(employee.getEmail());
//        emp.setLaptopId(employee.getLaptopId());

        return employeeRepository.save(emp);
    }

    @Override
    @Transactional
    public String deleteEmployee(long empId) throws EmployeeIDNotFoundException {
        Employee emp = employeeRepository.findById(empId).orElseThrow(
                () -> new EmployeeIDNotFoundException("Employee not found with ID: " + empId));

        employeeRepository.delete(emp);

        return "Employee with ID " + empId + " is deleted";
    }
}
