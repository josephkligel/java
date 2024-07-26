package com.codingdojo.teams.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.teams.models.Coach;
import com.codingdojo.teams.services.CoachService;

@Controller
public class MainController {
	@Autowired
	public CoachService coachService;
	
	@RequestMapping("/coach")
	public String coach(@ModelAttribute("coach") Coach coach, BindingResult result) {
		
		return "new_coach.jsp";
	}
}
