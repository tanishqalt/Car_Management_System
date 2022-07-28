package com.humber.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.humber.demo.model.Booking;

/** The Booking Repository that helps us perform CRUD operations on Booking table in the database **/

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

}
