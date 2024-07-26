package com.ninja.authentication.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ninja.authentication.models.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {

	public List<Book> findAll();
	
	public Optional<Book> findById(Long id);
	
	public void deleteById(Long id);

}
