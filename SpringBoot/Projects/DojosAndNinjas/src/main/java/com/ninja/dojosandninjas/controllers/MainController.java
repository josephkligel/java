package com.ninja.dojosandninjas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ninja.dojosandninjas.models.Dojo;
import com.ninja.dojosandninjas.models.Ninja;
import com.ninja.dojosandninjas.services.DojoService;
import com.ninja.dojosandninjas.services.NinjaService;

import jakarta.validation.Valid;

@Controller
public class MainController {
	@Autowired
	public DojoService dojoService;
	@Autowired 
	public NinjaService ninjaService;
	
	// ------ Dojo Controllers------
	
	@RequestMapping("/dojos/new")
	public String newDojo(@ModelAttribute("dojo") Dojo dojo) {
		return "newDojo.jsp";
	}
	
	@PostMapping("/dojos")
	public String create(
			@Valid @ModelAttribute("dojo") Dojo dojo, 
			BindingResult result) {
		if(result.hasErrors()) {
			return "newDojo.jsp";
		}
		dojoService.createDojo(dojo);
		return String.format("redirect:/dojos/%s", dojo.getId());
	}
	
	@RequestMapping("/dojos/{dojoId}")
	public String dojo(@PathVariable("dojoId") Long dojoId, Model model) {
		Dojo dojo = dojoService.findDojo(dojoId);
		List<Ninja> ninjas = ninjaService.findByDojo(dojoId);
		
		dojo.setNinjas(ninjas);
		model.addAttribute("dojo", dojo);
		return "dojo.jsp";
	}
	
	//	------ Ninja Controllers ------
	
	@RequestMapping("/ninjas/new")
	public String newNinja(@ModelAttribute("ninja") Ninja ninja, Model model) {
		List<Dojo> dojos = dojoService.allDojos();
		model.addAttribute("dojos", dojos);
		return "newNinja.jsp";
	}
	
	@PostMapping("/ninjas")
	public String create(
			@Valid @ModelAttribute("ninja") Ninja ninja,
			BindingResult result,
			Model model
			) {
		if(result.hasErrors()) {
//			return result.getAllErrors().toString();
			model.addAttribute("dojos", dojoService.allDojos());
			return "newNinja.jsp";
		}
		ninjaService.createNinja(ninja);
		return String.format("redirect:/dojos/%s", ninja.getDojo().getId());
	}
}
