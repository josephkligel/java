package com.ninja.beltexam.controllers;

import java.security.Principal;

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
import org.springframework.web.bind.annotation.RequestParam;

import com.ninja.beltexam.models.Course;
import com.ninja.beltexam.models.LoginUser;
import com.ninja.beltexam.models.User;
import com.ninja.beltexam.services.CourseService;
import com.ninja.beltexam.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class MainController {
	@Autowired
	public UserService userService;
	@Autowired
	public CourseService courseService;
	
	public MainController(UserService userService, CourseService courseService) {
		this.userService = userService;
		this.courseService = courseService;
	}

	// Login and register page
	@RequestMapping("/")
	public String index(
			@ModelAttribute("user") User user,
			@ModelAttribute("loginUser") LoginUser loginUser
			) {
		return "index.jsp";
	}
	
	@PostMapping("/register")
	public String register(
			@Valid @ModelAttribute("user") User user,
			BindingResult result,
			Model model,
			HttpSession session
			) {
		// Check for errors and pass in newLogin object if error is present and index page has to be returned
		if(result.hasErrors()) {
			model.addAttribute("loginUser", new LoginUser());
			return "index.jsp";
		}
		userService.saveWithUserRole(user);
		return "redirect:/classes";
	}
//	
//	@RequestMapping("/login")
//	public String login(
//			@RequestParam(value="error", required=false) String error,
//			@RequestParam(value="logout", required=false) String logout,
//			Model model
//			) {
//		if(error != null) {
//			model.addAttribute("errorMessage", "Invalid Credentials, Please try again.");
//		}
//		if(logout != null) {
//				model.addAttribute("logoutMessage", "Logout successfull");
//		}
//		return "loginPage.jsp";
//	}
	
	@PostMapping("/login")
	public String loggingIn(
			@Valid @ModelAttribute("loginUser") LoginUser loginUser,
			BindingResult result,
			HttpSession session
			) {
		if(result.hasErrors()) {
			return "index.jsp";
		}
		session.setAttribute("user", loginUser);
		return "redirect:/classes";
	}
	
	// Logout api
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	// Instruction home with list of classes
	@RequestMapping("/classes")
	public String home(Principal principal, Model model) {
		String username = principal.getName();
		model.addAttribute("user", 
				userService.findUserByEmail(username)
				);
		return "classes.jsp";
	}
	
	// New course page
	@RequestMapping("/classes/new")
	public String course(
			@ModelAttribute("course") Course course,
			Model model,
			HttpSession session
			) {
		model.addAttribute("user", session.getAttribute("user"));
		return "new_course.jsp";
	}
	
	// Post new course
	@PostMapping("/classes")
	public String create(
			@Valid @ModelAttribute("course") Course course,
			BindingResult result
			) {
		if(result.hasErrors()) {
			return "new_course.jsp";
		}
		courseService.create(course);
		return "redirect:/classes";
	}
	
	// Show course page
	@RequestMapping("/classes/{courseId}")
	public String show(
			@PathVariable("courseId") Long courseId,
			Model model
			) {
		Course course = courseService.findCourse(courseId);
		model.addAttribute("course", course);
		return "show_course.jsp";
	}
	
	// Course edit page
	@RequestMapping("/classes/{courseId}/edit")
	public String edit(
			@PathVariable("courseId") Long courseId,
			HttpSession session,
			Model model
			) {
		// Get course and set model
		Course course = courseService.findCourse(courseId);
		model.addAttribute("course", course);
		// Set user model
		model.addAttribute("user", session.getAttribute("user"));
		return "edit_course.jsp";
	}
	
	// Update put method
	@PutMapping("/classes/update")
	public String update(
			@Valid @ModelAttribute("course") Course course,
			Model model,
			BindingResult result
			) {
		if(result.hasErrors()) {
			return "edit_course.jsp";
		}
		courseService.update(course);
		return "redirect:/classes";
	}
	
	// Delete course
	@DeleteMapping("/classes/delete/{courseId}")
	public String delete(
			@PathVariable("courseId") Long courseId
			) {
		courseService.delete(courseId);
		return "redirect:/classes";
	}
}
