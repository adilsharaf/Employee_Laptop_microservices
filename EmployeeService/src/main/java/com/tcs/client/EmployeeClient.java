package com.tcs.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.tcs.dto.LaptopDTO;

@FeignClient(name="laptop-service",url="http://localhost:9090")
public interface EmployeeClient {
	
	@GetMapping("laptops/{id}")
	LaptopDTO getLaptopById(@PathVariable long id);
}
