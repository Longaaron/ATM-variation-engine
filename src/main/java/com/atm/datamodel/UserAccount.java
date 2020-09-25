package com.atm.datamodel;

public class UserAccount {
	
	String accountNumber;
	String accountPin;
	int balance;
	int overDraft;
	
	public String getAccountNumber() {
		return accountNumber;
	}
	public String setAccountNumber(String accountNumber) {
		return this.accountNumber = accountNumber;
	}
	public String getAccountPin() {
		return accountPin;
	}
	public String setAccountPin(String correctPin) {
		return this.accountPin = correctPin;
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
	
	public int getCombinedTotal() {
		return balance + overDraft;
	}

}
