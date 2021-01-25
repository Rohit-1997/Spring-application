package com.kalori.jtapplicaiton.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.kalori.jtapplicaiton.repositories.BookRepository;
import java.util.List;
import java.util.ArrayList;
import com.kalori.jtapplicaiton.model.Book;

/**
 * A book controller class that handles the
 * requests realted to books
 * @author Kalori Rohit kumar
 *
 */
@RestController
@RequestMapping("/api/books")
public class BookController {
	
	private final BookRepository bookRepo;
	
	public BookController(BookRepository bookRepo) {
		this.bookRepo = bookRepo;
	}
	
	
	@GetMapping
	public Iterable<String> getBooks() {
		System.out.println("In book controller");
		List<String> bookDetails = new ArrayList<>();
		for (Book b: bookRepo.findAll()) {
			bookDetails.add(b.getBookDetails());
		}
		return bookDetails;
	}

}
