package com.tcs.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class LaptopDTO {
    
    private Long id;
    private String brand;
    private String model;

    // Default constructor
    public LaptopDTO() {}

    // Parameterized constructor for easy initialization
    public LaptopDTO(Long id, String brand, String model) {
        this.id = id;
        this.brand = brand;
        this.model = model;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

	@Override
	public String toString() {
		return "LaptopDTO [id=" + id + ", brand=" + brand + ", model=" + model + "]";
	}
    
}

