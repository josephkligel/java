package com.codingdojo.mvc.models.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.mvc.models.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
	List<Book> findAll();
	
	List<Book> findByDescriptionContaining(String search);
	
	List<Book> deleteByTitleStartingWith(String search);
}
