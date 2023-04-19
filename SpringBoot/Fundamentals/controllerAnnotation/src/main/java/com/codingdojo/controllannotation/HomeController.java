package com.codingdojo.controllannotation;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("dojoName", "Burbank");
		return "index.jsp";
	}
	
	@RequestMapping("/dojos")
	public String dojos(Model model) {
		ArrayList<String> dojos = new ArrayList<String>();
		dojos.add("Burbank");
		dojos.add("Chicago");
		dojos.add("Bellevue");
		model.addAttribute("dojosFromController", dojos);
		return "dojos.jsp";
	}
}
