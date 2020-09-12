package com.atm.service;

import com.atm.datamodel.AtmMachine;
import com.atm.datamodel.UserAccount;

public interface atmUserInteraction {

	public void processBalance(UserAccount userAccount);
	public void processWithdrawal(UserAccount userAccount, AtmMachine atmMachine, int withDrawalAmount, int userBalance, int atmBalance);
}
