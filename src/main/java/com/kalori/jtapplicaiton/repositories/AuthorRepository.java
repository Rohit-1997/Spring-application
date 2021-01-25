package com.kalori.jtapplicaiton.repositories;

import org.springframework.data.repository.CrudRepository;
import com.kalori.jtapplicaiton.model.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}
