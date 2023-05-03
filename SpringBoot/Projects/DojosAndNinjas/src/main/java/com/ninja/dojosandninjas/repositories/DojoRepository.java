package com.ninja.dojosandninjas.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.ninja.dojosandninjas.models.Dojo;

public interface DojoRepository extends CrudRepository<Dojo, Long> {

	public List<Dojo> findAll();
	
	public Optional<Dojo> findById(Long ninjaId);
	
	public void deleteById(Integer ninjaId);
}
