package com.humber.demo.service;

import java.util.List;

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

}
