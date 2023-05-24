package com.ninja.beltexam2.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;


import com.ninja.beltexam2.models.Team;
import com.ninja.beltexam2.repositories.TeamRepository;

@Service
public class TeamService {
	private final TeamRepository teamRepo;
	
	public TeamService(TeamRepository teamRepo) {
		this.teamRepo = teamRepo;
	}
	
	// Create team
	public Team create(Team team) {
		return teamRepo.save(team);
	}
	
	// Update team
	public Team update(Team team) {
		return teamRepo.save(team);
	}
	
	// Delete team by id with no return value
	public void delete(Long id) {
		teamRepo.deleteById(id);
	}
	
	// Get all teams
	public List<Team> allTeams(){
		return teamRepo.findAll();
	}
	
	// Get team by id
	public Team findTeam(Long teamId) {
		Optional<Team> course = teamRepo.findById(teamId);
		if(course.isPresent()) {
			return course.get();
		}
		return null;
	}
}
