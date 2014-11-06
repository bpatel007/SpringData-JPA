/** 
 * SAANVI
 * This source file is part of demo project 
 * Developer : Bharatkumar Patel (bharat_4u81@yahoo.co.in)
 * Date : 6 Nov 2014  : 12:31:05
 **/
package test.saanvi.repository;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.saanvi.config.JPAConfig;
import com.saanvi.entity.User;
import com.saanvi.repository.UserRepository;

/**
 * @author Bharatkumar Patel
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {JPAConfig.class})
public class UserRepositoryTest {
	
	@Autowired
	private UserRepository userRepository;
	
	@Test
	public void saveUser(){
		User user = new User();
		user.setFirstName("Nishant");
		user.setLastName("Patel");
		user.setCreationDate(new Date());
		userRepository.save(user);
		Assert.assertNotNull(user.getId());
	}
	
	@Test
	public void testfindUser(){
		Assert.assertNotNull(userRepository.findOne(1L));
	}
	
	
	
	

}
