package com.ninja.beltexam2.controllers;

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

import com.ninja.beltexam2.models.Team;
import com.ninja.beltexam2.models.User;
import com.ninja.beltexam2.services.TeamService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class TeamController {
	
	@Autowired
	private TeamService teamService;
	
	// Method to check for user session. If not present, user is sent back to original page
	public String managePageAccess(HttpSession session, String jspFile) {
		User user = (User) session.getAttribute("user");
		if(user != null)
			return jspFile;
		else
			return "redirect:/";
		
	}
	
	@RequestMapping("/home")
	public String home(HttpSession session, Model model) {
		model.addAttribute("user", session.getAttribute("user"));
		model.addAttribute("teams", teamService.allTeams());
		return managePageAccess(session, "home.jsp");
	}
	
	@RequestMapping("/teams/new")
	public String newTeam(
			@ModelAttribute("team") Team team,
			HttpSession session,
			Model model
			) {
		model.addAttribute("user", session.getAttribute("user"));
		return "new_team.jsp";
	}
	
	@PostMapping("/teams")
	public String createTeam(
			@Valid @ModelAttribute("team") Team team,
			BindingResult result
			) {
		if(result.hasErrors()) {
			return "new_team.jsp";
		}
		teamService.create(team);
		return "redirect:/home";
	}
	
	@RequestMapping("/teams/{teamId}")
	public String team(
			@PathVariable("teamId") Long teamId,
			Model model,
			HttpSession session
			) {
		model.addAttribute("user", session.getAttribute("user"));
		model.addAttribute("team", teamService.findTeam(teamId));
		return "show.jsp";
	}
	
	@RequestMapping("/teams/{teamId}/edit")
	public String editTeam(
			@PathVariable("teamId") Long teamId,
			Model model
			) {
		model.addAttribute("team", teamService.findTeam(teamId));
		return "edit_team.jsp";
	}
	
	@PutMapping("/teams/update")
	public String updateTeam(
			@Valid @ModelAttribute("team") Team team,
			BindingResult result
			) {
		if(result.hasErrors()) {
			return "edit_team.jsp";
		}
		teamService.update(team);
		return "redirect:/home";
	}
	
	// Delete team
		@DeleteMapping("/teams/{teamId}/delete")
		public String delete(
				@PathVariable("teamId") Long teamId
				) {
			teamService.delete(teamId);
			return "redirect:/home";
		}

}
