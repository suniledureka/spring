package co.edureka.web.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import co.edureka.web.dao.BookDAO;
import co.edureka.web.models.Book;

@Controller
@RequestMapping("/library")
public class LibraryController {
	
	@GetMapping("/book")
	//public String getBookDetails(@RequestParam("isbn") Integer isbn, Model model) {
	public String getBookDetails(@RequestParam(value = "isbn", required = false, defaultValue = "0") Integer isbn, Model model) {
		List<Book> books = BookDAO.getAllBooks();
		
		Optional<Book> optBook = books.stream().filter(book -> book.getBookId().equals(isbn)).findAny();
		
		if(optBook.isPresent()) {
			model.addAttribute("book", optBook.get());
		}else {
			model.addAttribute("error_msg", "No matching book for ISBN: " + isbn);
		}
		
		return "bookDetails";
	}
}
