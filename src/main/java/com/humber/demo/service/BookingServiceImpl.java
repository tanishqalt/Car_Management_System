package com.humber.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.humber.demo.model.Booking;
import com.humber.demo.repository.BookingRepository;

@Service
public class BookingServiceImpl implements BookingService {
	
	@Autowired
	private BookingRepository bookingRepository;

	@Override
	public List<Booking> getAllBookings() {
		return this.bookingRepository.findAll();
	}

	@Override
	public void newBooking(Booking booking) {
		this.bookingRepository.save(booking);
		
	}

	@Override
	public void deleteBookingByID(long id) {
		this.bookingRepository.deleteById(id);
	}

	@Override
	public Booking getBookingbyID(long id) {
		Optional < Booking > optional = bookingRepository.findById(id);
		Booking booking = null;
		
		if(optional.isPresent()) {
			booking = optional.get();
		} else {
			throw new RuntimeException(" Booking not found for id: " + id);
		}
		
		return booking;
	}

}
