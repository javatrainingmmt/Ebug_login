package com.ebugtracker.login.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.ebugtracker.login.Exception.UserNotFoundException;
import com.ebugtracker.login.entity.UserEntity;
import com.ebugtracker.login.repository.UserRepository;

@SpringBootTest
class CustomUserDetailsServiceTest {

	@Autowired
	private CustomUserDetailsService custserv;
	
	@Autowired
	private UserRepository userrepo;
	
	
	@Test
	public void getUserByUserName() {
		String name="Customer1";		
		UserEntity user= userrepo.findByUsername(name);
		//UserEntity obj = new UserEntity();
		assertEquals(name,user.getUsername());
		//fail("Not yet implemented");
	}
	
	@Test
	public void register(){
		UserEntity user = new UserEntity(1,"admin","password","ADMIN");
		userrepo.save(user);
		UserEntity user1= userrepo.findByUsername("admin");
		assertNotNull(user);
		assertEquals(user.getUsername(),user1.getUsername());
		
		
	}
	
	

}
