package com.atm.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import com.atm.common.AtmError;
import com.atm.datamodel.AtmMachine;
import com.atm.datamodel.UserAccount;

public class UserSession {

	public static void accountDetails(String line, int balance, int userBalance, String balButton, String withdrawal)
			throws IOException {
		UserAccount userAccount = new UserAccount();
		AtmMachine atmMachine = new AtmMachine();
		atmMachine.setBalance(balance);
		userAccount.setBalance(userBalance);

		String line1 = line;
		String accountValidation = "[0-9] {8}";
		String[] userDetail = line1.split(" ");
		String atmAccountDetail = userDetail[0];
		String correctPin = userDetail[1];
		String userEnteredPin = userDetail[2];

		if (correctPin.matches(userEnteredPin)) { // loop balance,withdraw
			userAccount.setAccountNumber(atmAccountDetail);
			userAccount.setAccountPin(correctPin);

			if (balButton.matches("B") && userBalance != 0) {
				System.out.println(userBalance);
			}
			
			if (balButton.contains("W ")) {
				ArrayList<Integer> userWithdrawal = new ArrayList<Integer>();
				String[] withdrawalValue = balButton.split("W ");
				String withdrawalnumber = withdrawalValue[0];

				int number = Integer.parseInt(withdrawalValue[1]);
				userWithdrawal.add(number);

				for (int w : userWithdrawal) {
					if (w <= userBalance) {
						int index = 1;
						int total = userBalance - w;
						System.out.println(total);
						index++;
					} else {
						System.out.println(AtmError.FUNDS_ERR.getEnumDes());
					}
				}
			}

			if (withdrawal.contains("W")) {
				ArrayList<Integer> userWithdrawal = new ArrayList<Integer>();
				String[] withdrawalValue = withdrawal.split("W ");
				String withdrawalnumber = withdrawalValue[0];

				int number = Integer.parseInt(withdrawalValue[1]);
				userWithdrawal.add(number);

				for (int w : userWithdrawal) {
					if (w <= userBalance) {
						int index = 1;
						int total = userBalance - w;
						System.out.println(total);
						index++;
					} else {
						System.out.println(AtmError.FUNDS_ERR.getEnumDes());
					}
				}
			}
		} else {
			System.out.println("Pin you have entered is incorrect");
		}

	}

}
