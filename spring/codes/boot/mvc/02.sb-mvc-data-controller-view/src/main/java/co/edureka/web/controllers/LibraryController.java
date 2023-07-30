package co.edureka.web.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import co.edureka.web.models.Book;

@Controller
@RequestMapping("/library")
public class LibraryController {
	
	@GetMapping("/book")
	public String getBookDetails(Model model) {
		//logic to get the data from DB 
		Book bk = new Book();
		
		bk.setBookId(10011);
		bk.setBookTitle("Java Complete Reference");
		bk.setBookPrice(750.75f);
		
		model.addAttribute("book", bk);
		
		return "bookDetails";
	}
	
	 @GetMapping("/books")	
	 public String getBooksDetail(Model model) {
		//logic to get the data from DB 
		Book book1 = new Book(100123,"Java Complete Reference", 750.5f);
		Book book2 = new Book(100124,"Spring with Spring Boot", 550.5f);
		Book book3 = new Book(100125,"Microservices Made Simple", 625f);
		
		List<Book> booksList = Arrays.asList(book1, book2, book3);
		
		model.addAttribute("books", booksList);
		
		return "booksDetail";
	 } 	
}
