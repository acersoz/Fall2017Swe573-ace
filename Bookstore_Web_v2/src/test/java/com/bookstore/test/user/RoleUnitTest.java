package com.bookstore.test.user;

import java.util.Iterator;

import javax.transaction.Transactional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.bookstore.datalayer.config.RepositorySpringConfiguration;
import com.bookstore.datalayer.entity.Role;
import com.bookstore.datalayer.repository.RoleRepository;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RepositorySpringConfiguration.class)
public class RoleUnitTest {

	@Autowired
	private RoleRepository roleRepository;

	@Test
	@Transactional
	public void selectRoleList() {
		
		Iterator<Role> roles = roleRepository.findAll().iterator();
		
		boolean hasRecord = false;
		while(roles.hasNext()) {
			Role role = roles.next();
			System.out.println(role.getName());
			hasRecord = true;
		}
		
		Assert.assertTrue(hasRecord);
	}
}
