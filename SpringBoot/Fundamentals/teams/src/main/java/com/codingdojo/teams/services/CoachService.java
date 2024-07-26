package com.codingdojo.teams.services;

import org.springframework.stereotype.Service;

import com.codingdojo.teams.models.Coach;
import com.codingdojo.teams.repositories.CoachRepository;

@Service
public class CoachService {
	private final CoachRepository coachRepo;
	
	
	public CoachService(CoachRepository coachRepo) {
		this.coachRepo = coachRepo;
	}
	
	// Create coach
	public Coach create(Coach c) {
		return coachRepo.save(c);
	}
	
	// Update coach
	public Coach update(Coach c) {
		return coachRepo.save(c);
	}
}
