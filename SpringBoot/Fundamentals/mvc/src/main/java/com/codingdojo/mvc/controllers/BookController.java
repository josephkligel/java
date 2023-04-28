package com.codingdojo.mvc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.mvc.models.Book;
import com.codingdojo.mvc.services.BookService;

import jakarta.validation.Valid;

@Controller
public class BookController {
	@Autowired
	BookService bookService;
	
	@GetMapping("/books")
	public String index(Model model) {
		List<Book> books = bookService.allBooks();
		model.addAttribute("books", books);
		return "books.jsp";
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

	@GetMapping("/books/new")
	public String newBook(@ModelAttribute("book") Book book) {
		
		return "new.jsp";
	}
	
	
	@PostMapping("/books")
	public String create(
			@Valid @ModelAttribute("book") Book book,
			BindingResult result
			) {
		if(result.hasErrors()) {
			return "new.jsp";
		}
		bookService.createBook(book);		
		return "redirect:/books";
	}
	
	@GetMapping("/books/edit/{id}")
	public String edit(@PathVariable("id") Long id, Model model) {
		Book book = bookService.findBook(id);
		model.addAttribute("book", book);
		return "edit.jsp";
	}
	
	@RequestMapping(value="/books/{id}", method = RequestMethod.PUT)
	public String update(
			@Valid @ModelAttribute("book") Book book,
			BindingResult result,
			Model model
			
			) {
		
		if(result.hasErrors()) {
			model.addAttribute("book", book);
			return "edit.jsp";
		}
		bookService.updateBook(book);
		return "redirect:/books";
	}
	
	@DeleteMapping("/books/{id}")
	public String destroy(@PathVariable("id") Long id) {
		System.out.println("Deleting book with id: " + id);
		bookService.deleteById(id);
		return "redirect:/books";
	}
	
}
