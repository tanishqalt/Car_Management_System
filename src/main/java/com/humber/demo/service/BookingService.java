package com.humber.demo.service;
import java.util.List;
import com.humber.demo.model.Booking;

public interface BookingService {

	// Method 4 – New Booking
	void newBooking(Booking booking);
	
	// Method 5 – Retrieve All Books
	List<Booking> getAllBookings();
	
	// Method 6 – Delete Booking
	void deleteBookingByID(long id);
}
