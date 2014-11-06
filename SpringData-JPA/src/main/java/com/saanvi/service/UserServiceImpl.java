/** 
 * SAANVI
 * This source file is part of demo project 
 * Developer : Bharatkumar Patel (bharat_4u81@yahoo.co.in)
 * Date : 4 Nov 2014  : 14:14:19
 **/
package com.saanvi.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.saanvi.entity.User;
import com.saanvi.exception.UserNotFoundException;
import com.saanvi.repository.UserRepository;

/**
 * @author Bharatkumar Patel
 *
 */
@Service
public class UserServiceImpl implements UserService {
	
	
	private static final Logger log = Logger.getLogger(UserServiceImpl.class);

	@Resource
	UserRepository userRepository;
	
	@Transactional
	@Override
	public User create(User user) {
		userRepository.save(user);
		return user;
	}

	@Transactional(rollbackFor=UserNotFoundException.class)
	@Override
	public User delete(Long id) throws UserNotFoundException {

		User user = userRepository.findOne(id);
		
		if(user == null){
			throw new UserNotFoundException();
		}
		
		userRepository.delete(user);
		return user;
		
	}

	
	@Transactional(readOnly=true)
	@Override
	public List<User> findAll() {
	return userRepository.findAll();
	}

	@Transactional(readOnly=true)
	@Override
	public User findById(Long id) {
		return userRepository.findOne(id);
	}

	
	@Override
	public User update(User user) throws UserNotFoundException {
		
		User userToUpdate = userRepository.findOne(user.getId());
		
		if(userToUpdate == null){
			throw new UserNotFoundException();
		}
		
		userRepository.save(user);
	
		return user;
	}
	
	
	public void setUserRepository(UserRepository userRepository){
		this.userRepository = userRepository;
	}
	
	

}
