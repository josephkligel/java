package com.ninja.omikujiform;

import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class MainController {
	
	@RequestMapping("/okumiji")
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping("/formData")
	public String form(
			@RequestBody MultiValueMap<String, String> formData,
			HttpSession session
			) 
	{
		session.setAttribute("formData", formData);
		System.out.println(formData);
		return "redirect:/okumiji/show";
	}
	
	@RequestMapping("/okumiji/show")
	public String show() {
		
		return "fortune.jsp";
	}
}
