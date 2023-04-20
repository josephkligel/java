package com.codingdojo.forms;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpSession;

@Controller
public class MainController {
	@RequestMapping("/")
	public String index() {
		
		return "index.jsp";
	}
	
	@RequestMapping(value="/login")
	public String login(
			@RequestParam(value="email") String email,
			@RequestParam(value="password") String password,
			HttpSession session,
			RedirectAttributes redirectAttributes
			) {
		if(password.length() < 5) {
			redirectAttributes.addFlashAttribute("error", "Password must be 5 characters or more");
			return "redirect:/";
		} else {
			session.setAttribute("email", email);
		}
		return "redirect:/home";
	}
	
	@RequestMapping("/home")
	public String home() {
		
		return "welcome.jsp";
	}
}
