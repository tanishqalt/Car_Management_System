package com.humber.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.humber.demo.model.Car;
import com.humber.demo.model.User;
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
	public String Homepage(Model model) {
		return "index";
	}
	
	// Register Page
	@GetMapping("/register")
	public String RegisterPage(Model model) {
		
		// creating a model to bind data to.
		User user = new User();
		model.addAttribute(user);
		return "register";
	}
	
	// All Cars Page
	@GetMapping("/cars")
	public String AllCarsPage(Model model) {
		model.addAttribute("listOfCars", carService.getAllCars());
		return "all_cars";
	}
	
	// Single Car Page
	@GetMapping("/cars/{id}")
	public String SingleCarPage(@PathVariable(value = "id") long id, Model model) {
		
		// retrive the single car from the database
		Car car = carService.getCarbyID(id);
		model.addAttribute("car", car);
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
	
	
	
	// API routes
	@PostMapping("/newUser")
    public String newUser(@ModelAttribute("user") User user) {
        // save user to database
        userService.newUser(user);
        return "redirect:/";
    }
	
	@GetMapping("/loginUser")
	public String loginUser(ModelMap model, @RequestParam String email, @RequestParam String password) {
		
		// get user by email
		User user = userService.getUserbyEmail(email);
		
		// check the password
		if(user.getPassword() == password) {
			// login successful
			System.out.print("Login successful");
			model.addAttribute("user", user);
			// if the password match, redirect to all cars page
		} else {
			// if the passwords don't match, redirect to same page
			System.out.print("Login failed");
		}
		return "index";
	}
	
}
