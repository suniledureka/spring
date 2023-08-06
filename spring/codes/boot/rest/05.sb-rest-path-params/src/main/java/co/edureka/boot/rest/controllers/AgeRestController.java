package co.edureka.boot.rest.controllers;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/personal")
public class AgeRestController {
	@GetMapping("/age/{name}/{yob}")
	public ResponseEntity<String> checkEligibilityForInsurance(@PathVariable("name") String name, @PathVariable Integer yob) {		
		String msg = "";
		ResponseEntity<String> entity = null;
		
		if(isValidYearOfBirth(yob)) {
			int age = calculateAge(yob);
			msg = String.format("Hi %s, you are %d years of age , and are eligible for Insurance", name, age);
			entity = new ResponseEntity<String>(msg, HttpStatus.OK);
		}else {
			msg = String.format("Hi %s, your submitted Year of Birth (%d) is not Valid", name, yob);
			entity = new ResponseEntity<String>(msg, HttpStatus.BAD_REQUEST);
		}
		
		return entity;
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
