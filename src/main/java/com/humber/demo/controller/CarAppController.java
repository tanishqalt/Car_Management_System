package com.humber.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.humber.demo.service.BookingService;
import com.humber.demo.service.CarService;
import com.humber.demo.service.UserService;

@Controller
public class CarAppController {
	
	@Autowired
	private CarService carService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private BookingService bookingService;
	
	
	
	/**
	 * UI Pages
	 */
	
	// Login Page
	@GetMapping("/")
	public String Homepage() {
		return "index";
	}
	
	// Register Page
	@GetMapping("/register")
	public String RegisterPage() {
		return "register";
	}
	
	// All Cars Page
	@GetMapping("/cars")
	public String AllCarsPage() {
		return "all_cars";
	}
	
	// Single Car Page
	@GetMapping("/cars/{id}")
	public String SingleCarPage(@PathVariable(value = "id") long id) {
		return "single_car";
	}
	
	// All Bookings Page
	@GetMapping("/bookings")
	public String MyBookings() {
		return "all_bookings";
	}
	
	// Single Booking Page
	@GetMapping("/bookings/{id}")
	public String SingleBookingPage(@PathVariable(value = "id") long id) {
		return "single_booking";
	}
	
	
}
