package com.ninja.dojosandninjas.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.ninja.dojosandninjas.models.Ninja;

public interface NinjaRepository extends CrudRepository<Ninja, Long> {

	public List<Ninja> findAll();
	
	public Optional<Ninja> findById(Long ninjaId);
	
	public void deleteById(Long ninjaId);
	
	public List<Ninja> findByDojoId(Long dojoId);
	
}
