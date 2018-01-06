package com.bookstore.servicelayer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.datalayer.entity.Role;
import com.bookstore.datalayer.entity.User;
import com.bookstore.datalayer.entity.UserRole;
import com.bookstore.datalayer.repository.UserRepository;
import com.bookstore.weblayer.model.Registration;
import com.bookstore.weblayer.model.UserAuthentication;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleService roleService;
	
	@Transactional
	public List<User> getUserList() {
		
		Iterator<User> users = userRepository.findAll().iterator();
		
		List<User> userList = new ArrayList<User>(); 
		
		while(users.hasNext()) {
			User user = users.next();
			userList.add(user);
		}
		
		return userList;
	}
	
	@Transactional
	public User findUser(Integer userId) {
		
		return userRepository.findByUserId(userId);
	}
	
	@Transactional
	public Boolean insertUser(Registration registration) {
		
		User user = new User();
		user.setEmail(registration.getEmail());
		user.setName(registration.getFirstName());
		user.setLastName(registration.getLastName());
		user.setPassword(registration.getPassword());
		user.setUserName(registration.getUserName());
		user.setPhone(registration.getPhone());
		
		Role role = roleService.findRole(registration.getUserRoleId());
		
		if(role == null) {
			
			role = new Role();
			role.setName("STANDARD");
			//role.setName("ADMIN");
			role = roleService.insertRole(role);
		}
		
		UserRole userRole = new UserRole();
		userRole.setRole(role);
		userRole.setUser(user);
		
		List<UserRole> userRoles = new ArrayList<UserRole>();
		userRoles.add(userRole);
		
		user.setUserRoles(userRoles);
		
		userRepository.save(user);
		return true;
		
	}
	
	@Transactional
	public User login(UserAuthentication userAuthentication) {
		
		User user = userRepository.findByUserNameAndPassword(userAuthentication.getUserName(), userAuthentication.getPassWord());
	
		if(user == null) {
			return null;
		}
		
		return user;
	}
	
	@Transactional
	public Boolean deleteUser(Integer userId) {
		
		userRepository.delete(userId);
		return true;
	}
	
	@Transactional
	public List<String> getRoleNames() {
		
		List<Role> roles = roleService.getAllRoles();
		
		List<String> roleNameList = new ArrayList<String>();
		
		for(Role role : roles) {
			roleNameList.add(role.getName());
		}
		
		return roleNameList;
	}
	
}
