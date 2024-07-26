package com.ninja.dojosandninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ninja.dojosandninjas.models.Dojo;
import com.ninja.dojosandninjas.repositories.DojoRepository;

@Service
public class DojoService {
	private final DojoRepository dojoRepository;
	
	public DojoService(DojoRepository dojoRepository) {
		this.dojoRepository = dojoRepository;
	}
	
	public List<Dojo> allDojos(){
		return dojoRepository.findAll();
	}
	
	public Dojo createDojo(Dojo d) {
		return dojoRepository.save(d);
	}
	
	public Dojo updateDojo(Dojo d) {
		return dojoRepository.save(d);
	}
	
	public Dojo findDojo(Long dojoId) {
		Optional<Dojo> optionalDojo = dojoRepository.findById(dojoId);
		if(optionalDojo.isPresent()) {
			return optionalDojo.get();
		} else {
			return null;
		}
	}
	
	public void deleteDojo(Long dojoId) {
		dojoRepository.deleteById(dojoId);
	}
}
