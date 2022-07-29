package com.humber.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.humber.demo.model.User;

/** The User Repository that helps us perform CRUD operations on User table in the database **/

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	@Query(value="select * from  car_management_system.users u where u.email = ?1",nativeQuery=true)
	User findByEmail(String email);
	
}
