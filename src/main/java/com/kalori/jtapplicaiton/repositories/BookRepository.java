package com.kalori.jtapplicaiton.repositories;
import org.springframework.data.repository.CrudRepository;
import com.kalori.jtapplicaiton.model.Book;

public interface BookRepository extends CrudRepository<Book, Long> {

}
