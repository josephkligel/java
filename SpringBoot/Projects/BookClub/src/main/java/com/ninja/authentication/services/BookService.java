package com.ninja.authentication.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ninja.authentication.models.Book;
import com.ninja.authentication.repositories.BookRepository;

@Service
public class BookService {
	private final BookRepository bookRepo;
	
	public BookService(BookRepository bookRepo) {
		this.bookRepo = bookRepo;
	}
	
	// Create
	public Book create(Book b) {
		return bookRepo.save(b);
	}
	
	// Update
	public Book update(Book b) {
		return bookRepo.save(b);
	}
	
	// Get book by id
	public Book findBook(Long id){
		Optional<Book> book = bookRepo.findById(id);
		if(book.isPresent()) {
			return book.get();
		} else {
			return null;
		}
	}
	
	// Get all books
	public List<Book> allBooks(){
		return bookRepo.findAll();
	}
	
	public void delete(Long id) {
		bookRepo.deleteById(id);
	}
}
