package com.ebugtracker.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ebugtracker.login.entity.UserEntity;
import com.ebugtracker.login.repository.UserRepository;

@RestController
public class CheckByName {

	@Autowired
	private UserRepository userrepo;
	
	@PostMapping("/username")
	public UserEntity getUserByName(@RequestBody UserEntity user) {
		UserEntity name = userrepo.findByUsername(user.getUsername());
		return name;
	}
}
