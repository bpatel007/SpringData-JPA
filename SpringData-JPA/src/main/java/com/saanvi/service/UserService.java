/** 
 * SAANVI
 * This source file is part of demo project 
 * Developer : Bharatkumar Patel (bharat_4u81@yahoo.co.in)
 * Date : 4 Nov 2014  : 13:29:40
 **/
package com.saanvi.service;

import java.util.List;

import com.saanvi.entity.User;
import com.saanvi.exception.UserNotFoundException;

/**
 * @author Bharatkumar Patel
 *
 */
public interface UserService {
	
	public User create(User user);
	
	public User delete(Long id)throws  UserNotFoundException;
	
	public List<User> findAll();
	
	public User findById(Long id);
	
	public User update(User user)throws UserNotFoundException;

}
