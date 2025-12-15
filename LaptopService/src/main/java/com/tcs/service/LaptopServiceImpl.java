package com.tcs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.tcs.entity.Laptop;
import com.tcs.exceptions.LaptopIDNotFOundException;
import com.tcs.repository.LaptopRepository;

import jakarta.transaction.Transactional;

@Service
public class LaptopServiceImpl implements LaptopService {
	
	@Autowired
	LaptopRepository laptopRepository;
	

	@Override
	@Transactional
	public Laptop createLaptop(Laptop laptop) {
		
		return laptopRepository.save(laptop);
	}

	@Override
	@Transactional
	public Laptop getLaptop(long id) throws LaptopIDNotFOundException{
		Laptop laptop=laptopRepository.findById(id).orElseThrow(
				()->new LaptopIDNotFOundException("Id not found"));
		
		return laptop;
	}

	@Override
	@Transactional
	public List<Laptop> getLaptops() {
		
		return laptopRepository.findAll();
	}

	@Override
	@Transactional
	public Laptop updateLaptop(long id, Laptop laptop)throws LaptopIDNotFOundException {
		
		Laptop lap=laptopRepository.findById(id).orElseThrow(
				()->new LaptopIDNotFOundException("Id not found"));
		lap.setBrand(laptop.getBrand());
		lap.setModel(laptop.getModel());
		
		return laptopRepository.save(lap);
	}

	@Override
	@Transactional
	public String deleteLaptop(long id) throws LaptopIDNotFOundException{
		
		Laptop lap=laptopRepository.findById(id).orElseThrow(
				()->new LaptopIDNotFOundException("Id not found"));
		laptopRepository.delete(lap);
		return "Laptop is deleted";
	}

}
