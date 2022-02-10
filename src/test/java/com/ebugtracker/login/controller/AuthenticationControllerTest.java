package com.ebugtracker.login.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ebugtracker.login.entity.UserEntity;
import com.ebugtracker.login.repository.UserRepository;

class AuthenticationControllerTest {

	@Autowired
	private AuthenticationController authc;
	
	@Autowired
	private UserRepository userrepo;
	
	@Autowired
	private UserEntity user;
	
	@Test
	public void register(){
		UserEntity user = new UserEntity(1,"admin","password","ADMIN");
		userrepo.save(user);
		UserEntity user1= userrepo.findByUsername("admin");
		assertNotNull(user);
		assertEquals(user.getUsername(),user1.getUsername());
		
		
	}

}
