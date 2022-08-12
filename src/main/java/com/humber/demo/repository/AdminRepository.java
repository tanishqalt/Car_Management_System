package com.humber.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.humber.demo.model.Admin;
import com.humber.demo.model.User;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {

	@Query(value="select * from  car_management_system.admin u where u.user_name = ?1 and u.password = ?2",nativeQuery=true)
	Admin findAdmin(String username, String password);
}