package co.edureka.boot.rest.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestDataRestController {
	@RequestMapping("/data")
	public ResponseEntity<?> processRequestHearsAndBody(@RequestHeader("Host") String host, 
														@RequestHeader(name = "company", required = false, defaultValue = "NA") String company, 
														@RequestBody(required = false) String data){
		String text = "Host : " + host + "\n";
		text += "Company : " + company + "\n";
		if(data != null)
			text += "Processed Data : " + data.toUpperCase();
		
		ResponseEntity<String> response = new ResponseEntity<String>(text, HttpStatus.OK);
		return response;
	}
}
