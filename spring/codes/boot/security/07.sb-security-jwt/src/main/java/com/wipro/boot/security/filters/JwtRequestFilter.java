package com.wipro.boot.security.filters;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.wipro.boot.security.services.CustomUserDetailsService;
import com.wipro.boot.security.utils.JwtUtil;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {
 @Autowired
 private JwtUtil jwtUtil;
	
 @Autowired
 private CustomUserDetailsService service;
	
 @Override
 protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
  String authorizationHeaderValue = request.getHeader("Authorization");
  System.out.println(authorizationHeaderValue);
		
  String token = null;
  String username = null;
		
  if(authorizationHeaderValue != null && authorizationHeaderValue.startsWith("Bearer ")) {
	token = authorizationHeaderValue.substring(7);
	username = jwtUtil.extractUsername(token);
  }
		
  if(username != null && SecurityContextHolder.getContext().getAuthentication()==null) {
	UserDetails userDetails = service.loadUserByUsername(username);
			
	if(jwtUtil.validateToken(token, userDetails)) {
  	  UsernamePasswordAuthenticationToken upToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
	upToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				
	SecurityContextHolder.getContext().setAuthentication(upToken);
      }
  }
		
  filterChain.doFilter(request, response);
 }
}