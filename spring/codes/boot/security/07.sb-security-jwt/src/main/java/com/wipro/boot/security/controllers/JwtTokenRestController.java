package com.wipro.boot.security.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.boot.security.models.LoginRequest;
import com.wipro.boot.security.utils.JwtUtil;

@RestController
public class JwtTokenRestController {
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	AuthenticationManager authManager;
	
	@PostMapping("/authenticate")	
	 public String generateToken(@RequestBody LoginRequest loginRequest) throws Exception {
		   try {
		    authManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
		   } catch (Exception ex) {
		      throw new Exception("invalid username/password");  
		   }

		  return jwtUtil.generateToken(loginRequest.getUsername());
		 }	
}
