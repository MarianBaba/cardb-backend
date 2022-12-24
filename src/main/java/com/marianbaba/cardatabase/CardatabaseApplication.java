package com.marianbaba.cardatabase;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.marianbaba.cardatabase.domain.CarRepository;
import com.marianbaba.cardatabase.domain.Car;
import com.marianbaba.cardatabase.domain.OwnerRepository;
import com.marianbaba.cardatabase.domain.User;
import com.marianbaba.cardatabase.domain.UserRepository;
import com.marianbaba.cardatabase.domain.Owner;

@SpringBootApplication
public class CardatabaseApplication implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(CardatabaseApplication.class);
	
	@Autowired
	private CarRepository repository;
	
	@Autowired
	private OwnerRepository orepository;
	
	@Autowired
	private UserRepository urepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CardatabaseApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		// we create owners first
		Owner owner1 = new Owner("John", "Johnson");
		Owner owner2 = new Owner("Mary", "Robinson");
		orepository.saveAll(Arrays.asList(owner1, owner2));
		
		// then the cars
		Car car1 = new Car("Ford", "Mustang", "Red", "ADS-213", 2021, 59000, owner1);
		Car car2 = new Car("Nissan", "Leaf", "Green", "AQR-873", 2020, 54000, owner2);
		Car car3 = new Car("Toyota", "Supra", "Red", "AKG-065", 2022, 9000, owner2);
		repository.saveAll(Arrays.asList(car1, car2, car3));
		
		for (Car car : repository.findAll()) {
			logger.info(car.getBrand() + " " + car.getModel());
		}
		
		urepository.save(new User("user", 
				"$2a$10$NVM0n8ElaRgg7zWO1CxUdei7vWoPg91Lz2aYavh9.f9q0e4bRadue","USER"));
		urepository.save(new User("admin", 
				"$2a$10$8cjz47bjbR4Mn8GMg9IZx.vyjhLXR/SKKMSZ9.mP9vpMu0ssKi8GW", "ADMIN"));
	}

}
