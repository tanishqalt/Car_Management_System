package com.humber.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.humber.demo.model.Car;

/** The Car Repository that helps us perform CRUD operations on Car table in the database **/

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

}
