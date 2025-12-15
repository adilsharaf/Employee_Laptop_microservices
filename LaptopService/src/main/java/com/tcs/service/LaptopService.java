package com.tcs.service;

import java.util.List;

import com.tcs.entity.Laptop;
import com.tcs.exceptions.LaptopIDNotFOundException;

public interface LaptopService {

	
	Laptop createLaptop(Laptop laptop);
	Laptop getLaptop(long id) throws LaptopIDNotFOundException;
	List<Laptop> getLaptops();
	Laptop updateLaptop(long id,Laptop laptop) throws LaptopIDNotFOundException;
	String deleteLaptop(long id) throws LaptopIDNotFOundException;
}
