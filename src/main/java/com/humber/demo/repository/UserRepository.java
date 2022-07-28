package com.humber.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.humber.demo.model.User;

/** The User Repository that helps us perform CRUD operations on User table in the database **/

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
