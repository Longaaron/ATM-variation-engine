package com.atm.service;

import com.atm.datamodel.AtmMachine;
import com.atm.datamodel.UserAccount;

public interface atmUserInteraction {
	
	/*
	 * ATM interface used to help process the balance and withDrawal. Acting as a contract between two classes.
	 */

	public void processBalance(UserAccount userAccount);
	public void processWithdrawal(UserAccount userAccount, AtmMachine atmMachine, int withDrawalAmount, int userBalance, int atmBalance);
}
