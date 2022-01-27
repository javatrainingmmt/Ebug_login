package com.ebugtracker.login.controller;

import static org.hamcrest.CoreMatchers.any;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.ebugtracker.login.entity.UserEntity;
import com.ebugtracker.login.entity.UserRequest;
import com.ebugtracker.login.repository.UserRepository;

@SpringBootTest
public class AuthenticationControllerTest {

	@Autowired
	private AuthenticationController authc;
	
	@Autowired
	private UserRepository userrepo;
	
	@Autowired
	private UserEntity user;
	
	/*@Test
	public void register(){
		UserEntity user = new UserEntity(1,"admin","password","ADMIN");
		//when(userrepo.save(user)).thenReturn(user);
		//Long id = (long) 1;
		//String username="staff2";
		//String password ="staff2";
		//String role="STAFF";
		//user.setId(id);user.setUsername(username);user.setPassword(password);user.setRole(role);
		//assertEquals(1,userrepo.save(user));
		userrepo.save(user);
		UserEntity user1= userrepo.findByUsername("admin");
		assertNotNull(user);
		assertEquals(user.getUsername(),user1.getUsername());
		
		
	}*/
	
	
}
