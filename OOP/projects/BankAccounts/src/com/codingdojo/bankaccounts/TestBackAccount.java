package com.codingdojo.bankaccounts;

public class TestBackAccount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BankAccount testBankAccount = new BankAccount();
		BankAccount testBankAccount2 = new BankAccount();
		
		System.out.printf("Checking account balance: $%.2f\n", testBankAccount.getCheckingBalance());
		System.out.printf("Savings account balance: $%.2f\n", testBankAccount.getSavingsBalance());
		
		testBankAccount.deposit("checking", 100.0);
		testBankAccount.deposit("Checking", 50.0);
		System.out.printf("Checking account balance: $%.2f\n", testBankAccount.getCheckingBalance());
		System.out.printf("Savings account balance: $%.2f\n", testBankAccount.getSavingsBalance());
		
		testBankAccount.withdraw("checking", 25.50);
		testBankAccount.withdraw("savings", 12.75);
		System.out.printf("Checking account balance: $%.2f\n", testBankAccount.getCheckingBalance());
		System.out.printf("Savings account balance: $%.2f\n", testBankAccount.getSavingsBalance());
		
		System.out.printf("Total from checking and savings: $%.2f\n", testBankAccount.getCheckingAndSavingsBalance());
		
		System.out.printf("Total number of accounts created: %d\n", BankAccount.numOfAccounts);
		
		testBankAccount2.deposit("checking", 400.0);
		System.out.printf("Total balance of all accounts: $%.2f\n", BankAccount.total);
		
		System.out.printf("First bank account number: %d\n", testBankAccount.getAccountNumber());
		System.out.printf("Second bank account number: %d\n", testBankAccount2.getAccountNumber());
	}

}
