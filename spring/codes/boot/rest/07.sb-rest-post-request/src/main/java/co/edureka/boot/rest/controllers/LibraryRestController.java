package co.edureka.boot.rest.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edureka.boot.rest.models.Book;

@RestController
@RequestMapping("/library")
public class LibraryRestController {
	@PostMapping(path = "/book/save",
				consumes = {"application/xml", "application/json"})
	public ResponseEntity<?> saveBook(@RequestBody Book newBook){
		//logic to save book to data store
		System.out.println(newBook);
		
		return new ResponseEntity<String>("Book Added with BookID - " + newBook.getBookId(), HttpStatus.CREATED);
	}
}
