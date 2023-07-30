package co.edureka.web.controllers;

import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/personal")
public class AgeController {
	@GetMapping("/age/{name}/{yob}")
	public String checkEligibilityForInsurance(@PathVariable("name") String name, @PathVariable("yob") Integer yob, Model model) {		
		String msg = "";
		
		if(isValidYearOfBirth(yob)) {
			int age = calculateAge(yob);
			msg = String.format("Hi %s, you are %d years of age , and are eligible for Insurance", name, age);
		}else {
			msg = String.format("Hi %s, your submitted Year of Birth (%d) is not Valid", name, yob);
		}
		
		model.addAttribute("message", msg);
		
		return "age";
	}
	
	private int calculateAge(Integer yob) {		
		return getCurrentYear() - yob;
	}

	private boolean isValidYearOfBirth(Integer yob) {
		return yob < getCurrentYear();
	}

	private static int getCurrentYear() {
		LocalDate date = LocalDate.now();
		return date.getYear();
	}
	
}
