package com.bookstore.test.user;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.bookstore.datalayer.config.RepositorySpringConfiguration;
import com.bookstore.datalayer.entity.Role;
import com.bookstore.datalayer.entity.User;
import com.bookstore.datalayer.entity.UserRole;
import com.bookstore.datalayer.repository.UserRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RepositorySpringConfiguration.class)
public class UserUnitTest {

	@Autowired
	private UserRepository userRepository;
	
	@Test
	@Transactional
	@Rollback(false)
	public void insertUser() throws JsonProcessingException {
		
		User user = new User();
		user.setEmail("ahmetcanersoz@gmail.com");
		user.setEnabled(true);
		user.setLastName("Ersöz");
		user.setName("Ahmet Can");
		user.setPassword("123");
		user.setPhone("5067508696");
		user.setUserName("acersoz");
		
		
		Role role1 = new Role();
		role1.setName("ADMIN");
		
		UserRole userRole1 = new UserRole();
		userRole1.setUser(user);
		userRole1.setRole(role1);
		
		///////////////////////////////////////////////
		
		Role role2 = new Role();
		role2.setName("STANDARD");
		
		UserRole userRole2 = new UserRole();
		userRole2.setUser(user);
		userRole2.setRole(role2);
		
		List<UserRole> userRoles = new ArrayList<UserRole>();
		userRoles.add(userRole1);
		userRoles.add(userRole2);
		
		user.setUserRoles(userRoles);
		
		userRepository.save(user);
		
		ObjectMapper mapper = new ObjectMapper();

		String json = mapper.writeValueAsString(user);
		
		System.out.println(json);
		
		Assert.assertNotNull(user.getUserId());
	}
	
	@Test
	@Transactional
	public void selectUser() {
		
		User user = userRepository.findByUserNameAndPassword("acersoz", "123");
		
		Assert.assertTrue(user.getUserRoles().size() > 0);
	}
	
}
