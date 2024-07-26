package com.ninja.dojosandninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ninja.dojosandninjas.models.Ninja;
import com.ninja.dojosandninjas.repositories.NinjaRepository;

@Service
public class NinjaService {
	private final NinjaRepository ninjaRepository;
	
	public NinjaService(NinjaRepository ninjaRepository) {
		this.ninjaRepository = ninjaRepository;
	}
	
	public List<Ninja> allNinjas(){
		return ninjaRepository.findAll();
	}
	
	public Ninja createNinja(Ninja n) {
		return ninjaRepository.save(n);
	}
	
	public Ninja updateNinja(Ninja n) {
		return ninjaRepository.save(n);
	}
	
	public Ninja findNinja(Long ninjaId) {
		Optional<Ninja> optionalNinja = ninjaRepository.findById(ninjaId);
		if(optionalNinja.isPresent()) {
			return optionalNinja.get();
		} else {
			return null;
		}
	}
	
	public List<Ninja> findByDojo(Long dojoId){
		return ninjaRepository.findByDojoId(dojoId);
	}
	
	public void deleteNinja(Long ninjaId) {
		ninjaRepository.deleteById(ninjaId);
	}
}
