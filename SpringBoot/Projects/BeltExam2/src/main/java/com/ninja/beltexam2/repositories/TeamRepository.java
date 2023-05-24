package com.ninja.beltexam2.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ninja.beltexam2.models.Team;

@Repository
public interface TeamRepository extends CrudRepository<Team, Long> {
	
	public List<Team> findAll();
	public Optional<Team> findById(Long id);
}
