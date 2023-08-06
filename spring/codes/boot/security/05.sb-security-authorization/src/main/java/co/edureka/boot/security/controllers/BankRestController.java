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
	
	@GetMapping("/admin")
	public String getAdminDashBoard() {
		return "This Page shows the Admin Dashboard which can accessed only by ADMIN Role";
	}
	
	@GetMapping("/manager")
	public String getManagerDashBoard() {
		return "This Page shows Manager Dashboard which can be accessed by ADMIN & MANAGER roles";
	}
	
	@GetMapping("/customer")
	public String getCustomerPage() {
		return "This Page shows Customer Page, which can be accessed by any user";
	}	
}
