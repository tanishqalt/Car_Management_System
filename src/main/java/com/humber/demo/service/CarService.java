package com.humber.demo.service;
import java.util.List;
import com.humber.demo.model.Car;


public interface CarService {
	
	// Method 3 – Get All Cars
	List<Car> getAllCars();
	
	// Method 7 – Get Single Car	
	Car getCarbyID(long id);
}
