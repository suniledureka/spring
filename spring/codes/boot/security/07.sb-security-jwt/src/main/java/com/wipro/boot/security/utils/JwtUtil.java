package com.wipro.boot.security.utils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JwtUtil {
	//@Value("${jwt.secret}")
	private String SECRET_KEY = "my_secret_key";
	
	/*--- retrieve username from JWT Token ---*/
    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    /*--- retrieve expiration date & time from JWT Token ---*/
    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }
    
    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }
    
    /*--- for retrieving any information from token, we need to provide the secret key  ---*/
    private Claims extractAllClaims(String token) {
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
    }
    
    /*--- to check whether the token is expired ---*/    
    private Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    /*--- generate token for the user ---*/
    public String generateToken(String userName) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("firstName", "Sanjay");
        claims.put("lastName", "Kumar");
        claims.put("email", "sanjay@gmail.com");
        
        return createToken(claims, userName);
    }

    private String createToken(Map<String, Object> claims, String subject) {  
    	
        return Jwts.builder().setHeaderParam("typ","JWT")
        		//.setClaims(claims) 
        		.setIssuer("Wipro Limited")        					
        		.setSubject(subject)        					
        		.setIssuedAt(new Date(System.currentTimeMillis()))
        		.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 30)) //30 mins
        		.addClaims(claims)        					
        		.signWith(SignatureAlgorithm.HS256, SECRET_KEY)
        		.compact();        					
    }
    
    //-- to validate the token
    public Boolean validateToken(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }
}
