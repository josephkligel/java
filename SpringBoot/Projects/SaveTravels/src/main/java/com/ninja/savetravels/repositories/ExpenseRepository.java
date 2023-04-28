package com.ninja.savetravels.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ninja.savetravels.models.Expense;

public interface ExpenseRepository extends CrudRepository<Expense, Long> {
	public List<Expense> findAll();
	
	public Expense findById(Integer id);
	
	public void deleteById(Integer id);
	
}
