package com.codingdojo.mvc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.mvc.models.Book;
import com.codingdojo.mvc.services.BookService;

@Controller
public class BookController {
	@Autowired
	BookService bookService;
	
	@GetMapping("/")
	public String index(Model model) {
		List<Book> books = bookService.allBooks();
		model.addAttribute("books", books);
		return "index.jsp";
	}

	@GetMapping("/books/{bookID}")
	public String item(
			Model model,
			@PathVariable("bookID") Long bookID
			)
	{	
		
		model.addAttribute("book", bookService.findBook(bookID));
		return "show.jsp";
	}
	
	@PostMapping("/books")
	public String create(
			@RequestParam("title") String title,
			@RequestParam("description") String description,
			@RequestParam("language") String language,
			@RequestParam("pages") Integer pages
			) {
		Book book = new Book(title, description, language, pages);
		bookService.createBook(book);		
		return "redirect:/";
	}
	
	@GetMapping("/books/new")
	public String newBook() {
		
		return "new.jsp";
	}
}
