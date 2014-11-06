/** 
 * SAANVI
 * This source file is part of demo project 
 * Developer : Bharatkumar Patel (bharat_4u81@yahoo.co.in)
 * Date : 4 Nov 2014  : 14:28:27
 **/
package test.saanvi.service;

import java.util.Date;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.saanvi.config.JPAConfig;
import com.saanvi.entity.User;
import com.saanvi.service.UserService;
import com.saanvi.service.UserServiceImpl;
/**
 * @author Bharatkumar Patel
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {JPAConfig.class})
public class UserServiceTest {

	@Autowired
	private UserService userService;
	 
    private static final Logger log = Logger.getLogger(UserServiceTest.class);
 
    @Before
    public void setUp() {
    log.debug("setup method called....");
    }
    
    @Test
    public void init(){
    	log.debug("init method called...");
    }
	
	//@Test
	public void save(){
		User user = new User();
		
		log.debug(userService);
		user.setFirstName("Saanvi");
		user.setLastName("Patel");
		user.setCreationDate(new Date());
		User savedUser = userService.create(user);
		log.debug("UserID := " + user.getId());
		
		Assert.assertNotNull(savedUser);

	}


}
