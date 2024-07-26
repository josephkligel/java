package com.codingdojo.teams.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.teams.models.Coach;

@Repository
public interface CoachRepository extends CrudRepository<Coach, Long> {

	public List<Coach> findAll();
	
	public Optional<Coach> findById(Long id);
	
	public Coach save(Coach c);
}
