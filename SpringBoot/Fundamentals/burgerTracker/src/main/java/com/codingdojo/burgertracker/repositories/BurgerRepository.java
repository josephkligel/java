package com.codingdojo.burgertracker.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.burgertracker.models.Burger;

public interface BurgerRepository extends CrudRepository<Burger, Long> {
	
	List<Burger> findAll();
	
	Burger findById(Integer id);

}
