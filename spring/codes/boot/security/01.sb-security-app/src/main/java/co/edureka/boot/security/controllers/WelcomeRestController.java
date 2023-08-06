package co.edureka.boot.security.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeRestController {
	@GetMapping("/welcome")
	public String sendWelcomeMessage() {
		return "Welcome to Spring Boot Security";
	}
}
