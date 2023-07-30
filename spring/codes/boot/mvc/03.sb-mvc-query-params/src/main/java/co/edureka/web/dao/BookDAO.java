package co.edureka.web.dao;

import java.util.ArrayList;
import java.util.List;

import co.edureka.web.models.Book;

public class BookDAO {
	public static List<Book> getAllBooks(){
		List<Book> books = new ArrayList<Book>();
		
		Book book1 = new Book(100123,"Java Complete Reference", 750.5f);
		Book book2 = new Book(100124,"Spring with Spring Boot", 550.5f);
		Book book3 = new Book(100125,"Microservices Made Simple", 625f);
		
		books.add(book1);
		books.add(book2);
		books.add(book3);
		
		return books;
	}
}
