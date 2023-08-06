package co.edureka.boot.security.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BankRestController {
	@GetMapping("/home")
	public String homePage() {
		return "Welcome to State Bank of India";
	}
	
	@GetMapping("/care")
	public String customerCare() {
		return "Contact Customer Care @ 1800-125-1477";
	}
	
	@GetMapping("/loan")
	public String getLoanDetails() {
		return "This Page shows the Loan Details";
	}
	
	@GetMapping("/statement")
	public String getAccountStatement() {
		return "This Page shows Account Transactions";
	}
	
	@GetMapping("/balance")
	public String getAccountBalance() {
		return "Your A/C Balance is : xxxxxx";
	}
}
