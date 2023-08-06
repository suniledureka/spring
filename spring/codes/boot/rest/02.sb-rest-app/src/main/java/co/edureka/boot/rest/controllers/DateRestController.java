package co.edureka.boot.rest.controllers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DateRestController {
	
	@GetMapping(path = {"/date", "/today"})
	public ResponseEntity<String> showTodaysDateAndTime(){
		LocalDateTime dateTimeObj = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy HH:mm:ss");
		String dateTime = formatter.format(dateTimeObj);
		
		//ResponseEntity<String> responseEntity = new ResponseEntity<String>(HttpStatus.OK); 
		//ResponseEntity<String> responseEntity = new ResponseEntity<String>(dateTime, HttpStatus.OK);
		//ResponseEntity<String> responseEntity = new ResponseEntity<String>(dateTime, HttpStatus.CREATED);
		//ResponseEntity<String> responseEntity = new ResponseEntity<String>(dateTime, HttpStatus.BAD_REQUEST);
		
		/*--------- to include HTTP Response headers ------------*/
		HttpHeaders headers = new HttpHeaders();
		headers.add("company", "edureka");
		headers.add("region", "INDIA");
		
		ResponseEntity<String> responseEntity = new ResponseEntity<String>(dateTime, headers, HttpStatus.OK);
		
		return responseEntity;
	}
}
