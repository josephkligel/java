package com.ninja.savetravels.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ninja.savetravels.models.Expense;
import com.ninja.savetravels.repositories.ExpenseRepository;

@Service
public class ExpenseService {
	private final ExpenseRepository expenseRepository;
	
	public ExpenseService(ExpenseRepository expenseRepository) {
		this.expenseRepository = expenseRepository;
	}
	
	 // returns all the expenses
	 public List<Expense> allExpenses() {
	     return expenseRepository.findAll();
	 }
	 // creates a expense
	 public Expense createExpense(Expense e) {
	     return expenseRepository.save(e);
	 }
	 
	 // Update a expense
	 public Expense updateExpense(Expense e) {
		 return expenseRepository.save(e);
	 }
	 
	// retrieves a expense
	 public Expense findExpense(Long id) {
	     Optional<Expense> optionalExpense = expenseRepository.findById(id);
	     if(optionalExpense.isPresent()) {
	         return optionalExpense.get();
	     } else {
	         return null;
	     }
	 }
	 
	 // Delete expense
	 public void deleteExpense(Long id) {
		 expenseRepository.deleteById(id);
	 }
}
