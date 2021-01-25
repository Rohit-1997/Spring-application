package com.kalori.jtapplicaiton.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.kalori.jtapplicaiton.repositories.*;
import com.kalori.jtapplicaiton.model.*;

/**
 * This class Runs on Start up of the spring application
 * This class purpose is create and save some data in the
 * H2 database once the application starts
 * @author Kalori Rohit kumar
 *
 */
@Component
public class BootstrapData implements CommandLineRunner {
	
	private final AuthorRepository authorRepo;
	private final BookRepository bookRepo;
	private final PublisherRepository publisherRepo;
	
	
	public BootstrapData(AuthorRepository authorRepo, BookRepository bookRepo, PublisherRepository publisherRepo) {
		this.authorRepo = authorRepo;
		this.bookRepo = bookRepo;
		this.publisherRepo = publisherRepo;
	}


	/**
	 * Creates data and adds it to the database
	 */
	@Override
	public void run(String... args) throws Exception {
		
		// Creating a Publisher
		Publisher spnPublisher = new Publisher("SPN publishers", "Kansas City");
		publisherRepo.save(spnPublisher);
		
		System.out.println("The publisher count: " + publisherRepo.count());
		
		Author jpAuth = new Author("Jordan", "Peterson");
		Book rulesForLifeBook = new Book("12 Rules For Life", "123123");
		
		// Adding the book and authors
		jpAuth.getBooks().add(rulesForLifeBook);
		rulesForLifeBook.getAuthors().add(jpAuth);
		rulesForLifeBook.setPublisher(spnPublisher);
		
		// Adding the books to the publisher
		spnPublisher.getBooks().add(rulesForLifeBook);
		
		// Saving the objects to the database
		authorRepo.save(jpAuth);
		bookRepo.save(rulesForLifeBook);
		publisherRepo.save(spnPublisher);
		
		Author rodAuth = new Author("rod", "Johnson");
		Book  springBook = new Book("Spring Development", "139139");
		
		rodAuth.getBooks().add(springBook);
		springBook.getAuthors().add(rodAuth);
		springBook.setPublisher(spnPublisher);
		
		
		// Adding the spring book to the publisher
		spnPublisher.getBooks().add(springBook);


		authorRepo.save(rodAuth);
		bookRepo.save(springBook);
		publisherRepo.save(spnPublisher);
		
		System.out.println("Added the data to the database on application startup");
		System.out.println("The count of books added: " + bookRepo.count());
		System.out.println("Number of books with the publisher: " + spnPublisher.getBooks().size());
	}
	
	

}
