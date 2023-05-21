package com.ninja.authentication.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ninja.authentication.models.Book;
import com.ninja.authentication.models.LoginUser;
import com.ninja.authentication.models.User;
import com.ninja.authentication.services.BookService;
import com.ninja.authentication.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class MainController {
	@Autowired
	public UserService userService;
	@Autowired
	public BookService bookService;

	@RequestMapping("/")
	public String index(Model model) {
		
		model.addAttribute("newUser", new User());
		model.addAttribute("newLogin", new LoginUser());
		return "index.jsp";
	}
	
	@PostMapping("/register")
	public String register(
			@Valid @ModelAttribute("newUser") User newUser,
			BindingResult result,
			Model model,
			HttpSession session
			) {
		// Attempt to register a new user
		userService.register(newUser, result);
		// Check for errors and pass in newLogin object if error is present and index page has to be returned
		if(result.hasErrors()) {
			model.addAttribute("newLogin", new LoginUser());
			return "index.jsp";
		}
		// Else if no errors save user to a session and go to user home
		session.setAttribute("user", newUser);
		return "redirect:/books";
	}
	
	@PostMapping("/login")
	public String login(
			@Valid @ModelAttribute("newLogin") LoginUser newLogin,
			BindingResult result,
			Model model,
			HttpSession session
			) {
		// Calling login method from UserService
		// Assign return object to a new user
		User user = userService.login(newLogin, result);
		// Check for errors
		if(result.hasErrors()) {
			model.addAttribute("newUser", new User());
			return "index.jsp";
		}
		
		// If no errors save user object in session and redirect to home page
		session.setAttribute("user", user);
		return "redirect:/books";
	}
	
	@RequestMapping("/books")
	public String home(HttpSession session, Model model) {
		model.addAttribute("user", session.getAttribute("user"));
		model.addAttribute("books", bookService.allBooks());
		return "books.jsp";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		// Delete entire session
		session.invalidate();
		return "redirect:/";
	}
	
	@RequestMapping("/books/new")
	public String book(
			@ModelAttribute("book") Book book,
			Model model,
			HttpSession session
			) {
		model.addAttribute("user", session.getAttribute("user"));
		return "new_book.jsp";
	}
	
	@PostMapping("/books")
	public String create(
			@Valid @ModelAttribute("book") Book book,
			BindingResult result
			) {
		if(result.hasErrors()) {
			return "new_book.jsp";
		}
		
		
		bookService.create(book);
		return "redirect:/books";
	}
	// Show page for book
	@RequestMapping("/books/{bookId}")
	public String show(
			@PathVariable("bookId") Long bookId, 
			Model model,
			HttpSession session
			) {
		Book book = bookService.findBook(bookId);
		// Add user attribute to model from session
		model.addAttribute("loggedinUser", session.getAttribute("user"));
		model.addAttribute("book", book);
		return "show.jsp";
	}
	 // Edit page for book
	@RequestMapping("/books/edit/{bookId}")
	public String edit(
			@PathVariable("bookId") Long bookId,
			Model model,
			HttpSession session
			) {
		Book book = bookService.findBook(bookId);
		model.addAttribute("book", book);
		model.addAttribute("user", session.getAttribute("user"));
		return "edit_book.jsp";
	}
	// Put request to update book
	@PutMapping("/books/update")
	public String update(
			@Valid @ModelAttribute("book") Book book,
			BindingResult result
			) {
		if(result.hasErrors()) {
			return "edit_book.jsp";
		}
		bookService.update(book);
		return "redirect:/books";
	}
	
	@DeleteMapping("/books/delete/{bookId}")
	public String delete(@PathVariable("bookId") Long bookId) {
		bookService.delete(bookId);
		return "redirect:/books";
	}
}
