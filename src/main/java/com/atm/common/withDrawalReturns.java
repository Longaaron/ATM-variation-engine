package com.atm.common;

import com.atm.datamodel.UserAccount;
import com.atm.service.atmServiceImpl;
import com.atm.service.atmUserInteractionImpl;

public class withDrawalReturns {
	
	int newBalance;
	int withDrawalAmount;
	UserAccount userAccount = new UserAccount();
	
	public void setWithDrawalAmount(int withDrawalAmount) {
		this.withDrawalAmount = withDrawalAmount;
	}
	
	public int getWithDrawalAmount() {
		return this.withDrawalAmount;
	}
	
	public void setNewBalance(int newBalance) {
		this.newBalance = newBalance;
	}	
	public int getNewBalance() {
		return this.newBalance = userAccount.getBalance() - withDrawalAmount;
	}
	public AtmError potentialErrorOutput1() {
		return AtmError.ACCOUNT_ERR;
	}
	
	public AtmError potentialErrorOutput2() {
		return AtmError.FUNDS_ERR;
	}
	
	public AtmError potentialErrorOutput3() {
		return AtmError.ATM_ERR;
	}
}