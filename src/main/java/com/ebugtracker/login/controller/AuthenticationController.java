package com.ebugtracker.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ebugtracker.login.config.JwtUtility;
import com.ebugtracker.login.entity.AuthenticationRequest;
import com.ebugtracker.login.entity.AuthenticationResponse;
import com.ebugtracker.login.entity.Response;
import com.ebugtracker.login.entity.UserEntity;
import com.ebugtracker.login.entity.UserRequest;
import com.ebugtracker.login.service.CustomUserDetailsService;

@RestController
@CrossOrigin
public class AuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private CustomUserDetailsService userDetailsService;

	@Autowired
	private JwtUtility jwtUtil;

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest)
			throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
					authenticationRequest.getUsername(), authenticationRequest.getPassword()));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		}
		catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
		
		UserDetails userdetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
		String token = jwtUtil.generateToken(userdetails);
		return ResponseEntity.ok(new AuthenticationResponse(token));
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public Response saveUser(@RequestBody UserRequest user) throws Exception {
		if(user.getRole().equalsIgnoreCase("customer")) {
			userDetailsService.save(user);
			return new Response("Customer Added Successfully!!");
		}
		return new Response("Only Customer can register"); 
		//return ResponseEntity.ok(userDetailsService.save(user));
	}
	
	/*@PostMapping("/register-cust")
	public UserEntity registerCustomer(@RequestBody UserRequest user) {
		return userDetailsService.save(user);
	}*/
}
