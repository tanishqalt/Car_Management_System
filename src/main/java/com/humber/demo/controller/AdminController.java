package com.humber.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.humber.demo.model.Admin;
import com.humber.demo.model.User;
import com.humber.demo.service.AdminService;
import com.humber.demo.service.BookingService;
import com.humber.demo.service.CarService;
import com.humber.demo.service.UserService;

@Controller
public class AdminController {
	
	long userid;
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CarService carService;
	
	@Autowired
	private BookingService bookingService;
	
	@GetMapping("/admin")
	public String Homepage(Model model) {
		return "admin";
	}

	@GetMapping("/adminLogin")
	public String loginAdmin(ModelMap model, @RequestParam String username, @RequestParam String password, RedirectAttributes redirectAttrs) {
		
		if(username=="" || password=="") {
			return "admin";
		}
		
		// get user by email
		Admin admin = adminService.getAdmin(username, password);
		
		if(admin.equals(null)) {
			return "admin";
		}
		
		System.out.println("Retrieved Password: "+admin.getPassword().toString());
		System.out.println("Entered Password: "+password.toString());
		
		// check the password
		if(admin.getPassword().equals(password)) {
			// login successful
			System.out.println("Login successful");
			return "redirect:/users";
			// if the password match, redirect to all cars page
		} else {
			// if the passwords don't match, redirect to same page
			System.out.println("Login failed");
		}
		return "index";
	}
	
	// All Cars Page
		@GetMapping("/users")
		public String AllUsersPage(Model model) {
			
			model.addAttribute("listOfUsers", adminService.getAllUsers());
			
			return "users";
		}
		
		// All Bookings Page
		@GetMapping("/selectedUserBookings/{id}")
		public String SelectedUserBookings(Model model, @PathVariable(value = "id") long id) {
			userid = id;
			// Fetch the user
			User user = userService.getUserbyID(id);
			
			// change this to get all bookings by userID
			model.addAttribute("listOfBookings", bookingService.getSelectedUserBookings(id));
			model.addAttribute("user", user);
			return "selected_user_booking";
		}
		
		@GetMapping("/bookCar/{id}")
		public String BookCar(@PathVariable (value = "id") long id) {
			
			bookingService.bookCarById(id);
			return "redirect:/selectedUserBookings/" + userid;
		}
		
		@GetMapping("/declineCar/{id}")
		public String DeclineCar(@PathVariable (value = "id") long id) {
			
			bookingService.declineCarById(id);
			return "redirect:/selectedUserBookings/" + userid;
		}
		
}
