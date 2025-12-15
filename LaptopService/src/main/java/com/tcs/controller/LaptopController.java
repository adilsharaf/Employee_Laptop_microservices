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

import com.tcs.entity.Laptop;
import com.tcs.exceptions.LaptopIDNotFOundException;
import com.tcs.service.LaptopService;

@RestController
@RequestMapping("/laptops")
public class LaptopController {
	
	@Autowired
	LaptopService laptopService;

	 	@PostMapping
	    public Laptop create(@RequestBody Laptop laptop) {
	        return laptopService.createLaptop(laptop);
	    }

	    @GetMapping("/{id}")
	    public Laptop getById(@PathVariable Long id) throws LaptopIDNotFOundException {
	        return laptopService.getLaptop(id);
	    }

	    @GetMapping
	    public List<Laptop> getAll() {
	        return laptopService.getLaptops();
	    }

	    @PutMapping("/{id}")
	    public Laptop update(@PathVariable Long id,
	                         @RequestBody Laptop laptop) throws LaptopIDNotFOundException {
	        
	        return laptopService.updateLaptop(id,laptop);
	    }

	    @DeleteMapping("/{id}")
	    public String delete(@PathVariable Long id) throws LaptopIDNotFOundException{
	        return laptopService.deleteLaptop(id);
	    }
}
