package co.edureka.boot.rest.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cibil")
public class CibilRestController {
	@GetMapping("/score")
	public ResponseEntity<?> getCibilScore(@RequestParam("name") String customerName, @RequestParam("pan") String pan){
		String response = "";
		HttpStatus status;
		if(pan.length() == 10) {
			//logic to get CIBIL score from DB
			response = String.format("Hi %s, your CIBIL Score for PAN: %s is 803", customerName, pan);
			status = HttpStatus.OK;
		}else {
			response = String.format("Hi %s, please submit a valid PAN Number", customerName);
			status = HttpStatus.BAD_REQUEST;
		}
			
		return new ResponseEntity<String>(response, status);	
	}
}
