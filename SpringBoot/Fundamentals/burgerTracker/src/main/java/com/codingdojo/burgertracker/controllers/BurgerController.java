package com.codingdojo.burgertracker.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.burgertracker.models.Burger;
import com.codingdojo.burgertracker.services.BurgerService;

import jakarta.validation.Valid;

@Controller
public class BurgerController {
	
	@Autowired
	BurgerService burgerService;
	
	@GetMapping("/burgers")
	public String index(@ModelAttribute("burger") Burger burger, Model model) {
		model.addAttribute("burgers", burgerService.allBurgers());
		return "burgers.jsp";
	}
	
	@PostMapping("/burgers")
	public String create(@Valid @ModelAttribute("burger") Burger burger, BindingResult result) {
		if(result.hasErrors()) {
			return "burgers.jsp";
		}
		burgerService.createBurger(burger);
		return "redirect:/burgers";
	}
	
	@GetMapping("/burgers/edit/{id}")
	public String edit(@PathVariable("id") Long id, Model model) {
		Burger burger = burgerService.findBurger(id);
		model.addAttribute("burger", burger);
		return "edit.jsp";
	}
	
	@RequestMapping(value="/burgers/{id}", method=RequestMethod.PUT)
	public String update(
			@Valid @ModelAttribute("burger") Burger burger,
			BindingResult result,
			Model model
			) {
		if(result.hasErrors()) {
			model.addAttribute("burger", burger);
			return "edit.jsp";
		}
		burgerService.updateBurger(burger);
		return "redirect:/burgers";
	}
}
