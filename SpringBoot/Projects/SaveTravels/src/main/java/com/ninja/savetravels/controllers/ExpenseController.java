package com.ninja.savetravels.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ninja.savetravels.models.Expense;
import com.ninja.savetravels.services.ExpenseService;

import jakarta.validation.Valid;

@Controller
public class ExpenseController {
	@Autowired
	ExpenseService expenseService;
	
	// Main landing page. Redirects to expenses page
	@RequestMapping("/")
	public String index() {
		return "redirect:/expenses";
	}
	
	// Expenses page containing table of expenses and form to add new expenses
	@RequestMapping("/expenses")
	public String expenses(@ModelAttribute("expense") Expense expense, Model model) {
		List<Expense> expenses = expenseService.allExpenses();
		model.addAttribute("expenses", expenses);
		return "expenses.jsp";
	}
	
	// Create an expense
	@PostMapping("/expenses")
	public String create(
			@Valid @ModelAttribute("expense") Expense expense,
			BindingResult result
			) {
		if(result.hasErrors()) {
			return "expenses.jsp";
		}
		expenseService.createExpense(expense);
		return "redirect:/expenses";
	}
	
	// Show immutable page of expense
	@RequestMapping("/expenses/{id}")
	public String show(
			Model model,
			@PathVariable("id") Long id
			) {
		model.addAttribute("expense", expenseService.findExpense(id));
		return "show.jsp";
	}
	
	// Show edit page of expense
	@RequestMapping("/expenses/edit/{id}")
	public String edit(@PathVariable("id") Long id, Model model) {
		Expense expense = expenseService.findExpense(id);
		model.addAttribute("expense", expense);
		return "edit.jsp";
	}
	
	//Update expense
	@RequestMapping(value="/expenses/{id}", method=RequestMethod.PUT)
	public String update(
			@Valid @ModelAttribute("expense") Expense expense,
			BindingResult result,
			Model model
			) {
		if(result.hasErrors()) {
			model.addAttribute("expense", expense);
			return "edit.jsp";
		}
		expenseService.updateExpense(expense);
		return "redirect:/expenses";
	}
	
	// Delete an expense
	@RequestMapping(value="/expenses/{id}", method=RequestMethod.DELETE)
	public String destroy(@PathVariable("id") Long id) {
		expenseService.deleteExpense(id);
		return "redirect:/expenses";
	}
}
