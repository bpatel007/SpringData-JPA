/** 
 * SAANVI
 * This source file is part of demo project 
 * Developer : Bharatkumar Patel (bharat_4u81@yahoo.co.in)
 * Date : 4 Nov 2014  : 13:10:25
 **/
package com.saanvi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saanvi.entity.User;

/**
 * @author Bharatkumar Patel
 *
 */
public interface UserRepository extends JpaRepository<User, Long> {
	
	public List<User> findByFirstName(String firstName);
	
	public List<User> findByLastName(String lastName);
	
	public User findByFirstNameOrLastName(String firstName, String lastName);
	
	

}
