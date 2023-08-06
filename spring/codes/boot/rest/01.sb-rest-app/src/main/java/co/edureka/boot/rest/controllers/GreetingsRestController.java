package co.edureka.boot.rest.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/edureka")
public class GreetingsRestController {
	@GetMapping("/greet")
	public String sendGreetingByGet() {
		return "Greetings from edureka - GET";
	}
	
	@PostMapping("/greet")
	public String sendGreetingByPost() {
		return "Greetings from edureka - POST";
	}	
	
	@PutMapping("/greet")
	public String sendGreetingByPut() {
		return "Greetings from edureka - PUT";
	}
	
	@DeleteMapping("/greet")
	public String sendGreetingByDelete() {
		return "Greetings from edureka - DELETE";
	}
}
