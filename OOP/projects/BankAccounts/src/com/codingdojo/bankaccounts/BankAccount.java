package com.codingdojo.bankaccounts;

import java.util.Random;

public class BankAccount {
	
	// Static class members
	public static int numOfAccounts = 0;
	public static double total = 0.0;
	
	// Object attributes
	private long accountNumber;
	private double checkingBalance;
	private double savingsBalance;
	
	public BankAccount() {
		BankAccount.numOfAccounts++;
		this.accountNumber = this.createAccountNumber();
	}
	
	// Getters
	public double getCheckingBalance() {
		return this.checkingBalance;
	}
	
	public double getSavingsBalance() {
		return this.savingsBalance;
	}
	
	public double getCheckingAndSavingsBalance() {
		return this.checkingBalance + this.savingsBalance;
	}
	
	public long getAccountNumber() {
		return this.accountNumber;
	}
	
	// Random ten-digit account number
	private long createAccountNumber() {
		// Create random long number
		long rand = new Random().nextLong();
		// Check if long number is negative. If so, multiply random number by -1 to get its absolute value.
		// Return random number
		return rand < 0 ? rand * -1 : rand;
	}
	
	// Deposit method
	public void deposit(String accountType, double amount) {
		// Add amount to total first
		BankAccount.total += amount;
		// If checking account type add to checking account balance
		// Else if savings account type add to savings account balance
		if(accountType.equals("checking")) {
			this.checkingBalance += amount;
		} else if(accountType.equals("savings")) {
			this.savingsBalance += amount;
		}
	}
	
	// Withdraw method
	public void withdraw(String accountType, double amount) {
		// Create local variable called "balance". It holds the amount of the account type balance
		double balance = accountType.equals("checking") ? this.checkingBalance : this.savingsBalance;
		// Check if the amount parameter is higher than the newly created balance number.
		// If so print "Insufficient funds"
		if(amount > balance ) {
			System.out.println("Insufficient funds");
		// Else the balance has enough money
		} else {
			// Amount is subtracted from total
			total -= amount;
			
			// Check what the account type string equals and subtract the amount from the correct account balance
			if(accountType.equals("checking")) {
				this.checkingBalance -= amount;
			} else if(accountType.equals("savings")) {
				this.savingsBalance -= amount;
			}
		}
	}

}
