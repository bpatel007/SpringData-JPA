/** 
 * SAANVI
 * This source file is part of demo project 
 * Developer : Bharatkumar Patel (bharat_4u81@yahoo.co.in)
 * Date : 6 Nov 2014  : 12:31:05
 **/
package test.saanvi.repository;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
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
	
	
	private static final Logger log = Logger.getLogger(UserRepositoryTest.class);
	
	@Autowired
	private UserRepository userRepository;
	
	//@Test
	public void saveUser(){
		User user = new User();
		user.setFirstName("Ramesh");
		user.setLastName("Soni");
		user.setCreationDate(new Date());
		userRepository.save(user);
		Assert.assertNotNull(user.getId());
	}
	
	@Test
	public void testfindUser(){
		Assert.assertNotNull(userRepository.findOne(1L));
		
	}
	
	
	@Test
	public void testFindByFirstName(){
		List<User> userList = userRepository.findByFirstName("Nishant");
		if(userList.size() > 0){
			log.debug("RESULT by FirstName := "+userList.get(0).getFirstName() + " - "+ userList.get(0).getLastName());
		}
		
		Assert.assertNotNull(userList);
		
	}
	
	@Test
	public void testFindByLastName(){
		List<User> userList = userRepository.findByLastName("Soni");
		if(userList.size() > 0){
			log.debug("RESULT by LastName := "+userList.get(0).getFirstName() + " - "+ userList.get(0).getLastName());
		}
		
		Assert.assertNotNull(userList);
		
	}
	
	
	
	
	

}
