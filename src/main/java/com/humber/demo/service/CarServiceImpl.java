package com.humber.demo.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.humber.demo.model.Car;
import com.humber.demo.repository.CarRepository;

@Service
public class CarServiceImpl implements CarService {
	
	@Autowired
	private CarRepository carRepository;

	// returns all the cars
	@Override
	public List<Car> getAllCars() {
		return carRepository.findAll();
	}

}
