package com.atm.service;

import com.atm.common.withDrawalReturns;
import com.atm.datamodel.AtmMachine;
import com.atm.datamodel.UserAccount;

public interface atmUserInteraction {
	
	/*
	 * ATM interface used to help process the balance and withDrawal. Acting as a contract between two classes.
	 */

	public UserAccount processBalance(UserAccount userAccount);
	public withDrawalReturns processWithdrawal(UserAccount userAccount, AtmMachine atmMachine, int withDrawalAmount, int userBalance, int atmBalance);
}
