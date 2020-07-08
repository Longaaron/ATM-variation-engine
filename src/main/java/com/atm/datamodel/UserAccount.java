package com.atm.datamodel;

public class UserAccount {
	
	String accountNumber;
	int accountPin;
	int balance;
	int overDraft;
	
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public int getAccountPin() {
		return accountPin;
	}
	public void setAccountPin(int accountPin) {
		this.accountPin = accountPin;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public int getOverDraft() {
		return overDraft;
	}
	public void setOverDraft(int overDraft) {
		this.overDraft = overDraft;
	}
	
	

}
