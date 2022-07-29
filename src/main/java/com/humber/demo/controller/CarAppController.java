package com.humber.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.humber.demo.model.Booking;
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
	public String AllCarsPage(Model model,  @RequestParam long userID) {
		// Fetch the user
		User user = userService.getUserbyID(userID);
		
		model.addAttribute("listOfCars", carService.getAllCars());
		model.addAttribute("user", user);
		return "all_cars";
	}
	
	// Single Car Page
	@GetMapping("/cars/{id}")
	public String SingleCarPage(@PathVariable(value = "id") long id, Model model, @RequestParam long userID) {
		// Fetch the user
		User user = userService.getUserbyID(userID);
		
		// retrive the single car from the database
		Car car = carService.getCarbyID(id);
		
		
		// creating a model to bind data to
		Booking booking = new Booking();
		
		model.addAttribute("car", car);
		model.addAttribute("user", user);
		model.addAttribute("booking", booking);
		return "single_car";
	}
	
	// All Bookings Page
	@GetMapping("/bookings")
	public String MyBookings(Model model, @RequestParam long userID) {
		
		// Fetch the user
		User user = userService.getUserbyID(userID);
		
		// change this to get all bookings by userID
		model.addAttribute("listOfBookings", bookingService.getAllBookings());
		model.addAttribute("user", user);
		return "all_bookings";
	}
	
	// Single Booking Page
	@GetMapping("/bookings/{id}")
	public String SingleBookingPage(@PathVariable(value = "id") long id, Model model, @RequestParam long userID) {

		// Fetch the user
		User user = userService.getUserbyID(userID);
	
		// retrive the single booking from the database
		Booking booking = bookingService.getBookingbyID(id);
		model.addAttribute("booking", booking);
		model.addAttribute("user", user);
		return "single_booking";
	}	
	
	
	
	// API routes
	
	// API route to register a new user and redirect them to homepage
	@PostMapping("/newUser")
    public String newUser(@ModelAttribute("user") User user) {
        // save user to database
        userService.newUser(user);
        return "redirect:/";
    }
	
	
	// API route to login the user. 
	@GetMapping("/loginUser")
	public String loginUser(ModelMap model, @RequestParam String email, @RequestParam String password, RedirectAttributes redirectAttrs) {
		
		if(email=="" || password=="") {
			return "index";
		}
		
		// get user by email
		User user = userService.getUserbyEmail(email);
		
		if(user.equals(null)) {
			return "index";
		}
		
		System.out.println("Retrieved Password: "+user.getPassword().toString());
		System.out.println("Entered Password: "+password.toString());
		
		// check the password
		if(user.getPassword().equals(password)) {
			// login successful
			System.out.println("Login successful");
			return "redirect:/cars?userID="+user.getId();
			// if the password match, redirect to all cars page
		} else {
			// if the passwords don't match, redirect to same page
			System.out.println("Login failed");
		}
		return "index";
	}
	
	// API route to add a new booking and redirect to mybookings page
	@PostMapping("/newBooking")
    public String newBooking(@ModelAttribute("booking") Booking booking, RedirectAttributes redirectAttrs) {
        // save user to database
		System.out.println("User ID: "+booking.getUser().getId());
		System.out.println("Car ID: "+booking.getCar().getCarID());
		System.out.println("Start Date: "+booking.getStartDate());
		System.out.println("End Date: "+booking.getEndDate());
		System.out.println("Cost: "+booking.getCost());
		
        bookingService.newBooking(booking);
        redirectAttrs.addFlashAttribute("user", booking.getUser());
        long userID=booking.getUser().getId();
        return "redirect:/bookings?userID="+userID;
    }
	
	
	// API route to add a new booking and redirect to mybookings page
		@PostMapping("/cancelBooking")
	    public String cancelBooking(@ModelAttribute("booking") Booking booking, RedirectAttributes redirectAttrs) {
	        // save user to database
			System.out.println("User ID: "+booking.getUser().getId());
			System.out.println("Car ID: "+booking.getCar().getCarID());
			System.out.println("Start Date: "+booking.getStartDate());
			System.out.println("End Date: "+booking.getEndDate());
			System.out.println("Cost: "+booking.getCost());
			
	        bookingService.newBooking(booking);
	        redirectAttrs.addFlashAttribute("user", booking.getUser());
	        long userID=booking.getUser().getId();
	        return "redirect:/bookings?userID="+userID;
	    }
	
	
	
	// API route to delete the booking and redirect to mybookings page
	@GetMapping("/deleteBooking/{id}")
	public String deleteEmployee(@PathVariable(value = "id") long id, @RequestParam long userID) {

        // call delete employee method 
        this.bookingService.deleteBookingByID(id);
        return "redirect:/bookings?userID="+userID;
    }
	
	
}
