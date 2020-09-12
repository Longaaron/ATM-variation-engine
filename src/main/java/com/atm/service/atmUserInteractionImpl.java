package com.atm.service;

import com.atm.common.AtmError;
import com.atm.datamodel.AtmMachine;
import com.atm.datamodel.UserAccount;

public class atmUserInteractionImpl implements atmUserInteraction {

	public void processBalance(UserAccount userAccount) {
		System.out.println("$" + userAccount.getBalance());
	}

	public void processWithdrawal(UserAccount userAccount, AtmMachine atmMachine, int withDrawalAmount, int userBalance,
			int atmBalance) {
		int combinedBalanceOverdraft = userAccount.getCombinedTotal();
		// check if atm has enough money to withdraw cash
		// user cant withdraw more funds then they actually have
		if (atmMachine.getBalance() != 0 && atmMachine.getBalance() >= withDrawalAmount) {

			// if the user wants to take out money and its less then their
			// combined total then continue, else error
			if (withDrawalAmount <= combinedBalanceOverdraft) {

				// if user balance is greater then the amount that the user
				// wants to withdraw then you subtract that amount away
				// else if the amount is greater than the balance remaining, set
				// balance to zero and bring overdraft into play
				if (userAccount.getBalance() >= withDrawalAmount) {
					userBalance = userAccount.getBalance() - withDrawalAmount;
				} else if (userAccount.getBalance() - withDrawalAmount <= 0) {

					userAccount.setOverDraft(combinedBalanceOverdraft - withDrawalAmount);
					userAccount.setBalance(0);

				}
				atmBalance = atmMachine.getBalance() - withDrawalAmount;

				if (userAccount.getBalance() != 0) {
					userAccount.setBalance(userBalance);
				}

				atmMachine.setBalance(atmBalance);

				// if user balance is 0 or goes below zero
				// if there is an overdraft
				// if combined total is not empty
				if (userAccount.getBalance() <= 0 && userAccount.getOverDraft() > 0 && combinedBalanceOverdraft != 0) {
					System.out.println("Available cash including overdraft: " + "$" + userAccount.getCombinedTotal());
				} else if (userBalance != 0) {
					System.out.println("$" + userAccount.getBalance() + " remaining in your main account");
				} else if (userAccount.getOverDraft() != 0 || userAccount.getOverDraft() == 0) {
					System.out.println("$" + userAccount.getCombinedTotal() + " remaining in your overdraft");
					userAccount.setOverDraft(userAccount.getCombinedTotal() - withDrawalAmount);
				}
			} else { // closed if
				System.out.println(AtmError.FUNDS_ERR.getEnumDes());
			}

		}
	}
}
