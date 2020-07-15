package com.atm.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.cli.CommandLine;

import com.atm.datamodel.AtmMachine;
import com.atm.datamodel.UserAccount;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ATM {

	public static void main(String[] args) throws IOException {

		// CommandLine commandLineArgs = this.parseCommandlineoptions(args);
		String fileName = args[0];
		AtmTotalAmount atmTC = new AtmTotalAmount();
		UserSession details = new UserSession();
		AtmOverdraft overdraft = new AtmOverdraft();
		AtmBalance bal = new AtmBalance();
		// AtmWithdrawal w = new AtmWithdrawal();
		AtmMachine atmMachine = new AtmMachine();
		UserAccount userAccount = new UserAccount();

		String pattern1 = "[0-9]{4}";
		String pattern2 = "[0-9]{8} [0-4]{4} [0-4]{4}";
		String pattern3 = "[0-9]{3} [0-1]{3}";
		String pattern4 = "B";
		String pattern5 = "W [0-9]{3}";

		// while loop to be inserted here to go through file and call the correct
		// classes at each line
		try {
			File f = new File(fileName);
			Scanner sc = new Scanner(f);
			Scanner scFirstLine = new Scanner(f);

			String firstLine = scFirstLine.nextLine();

			if (firstLine.matches(pattern1)) {
				int balance = Integer.parseInt(firstLine);
				atmMachine.setBalance(balance);
				atmTC.atmTransaction(firstLine, balance);

				while (sc.hasNextLine()) {
					String line = sc.nextLine();

					if (line.matches(pattern2)) {
						atmMachine.setBalance(balance);
						String userAccountLine = sc.nextLine(); // works

						String balButton = sc.nextLine();
						String withdrawal = sc.nextLine();

						int userBalance = Integer.parseInt(userAccountLine);
						userAccount.setBalance(userBalance);

						details.accountDetails(line, balance, userBalance, balButton, withdrawal); // possibly 3
																									// arguements
					} else if (line.matches(pattern3)) {
						overdraft.draft(line, balance);
						// }
						// else if(line.matches(pattern4)) {
						// bal.balance(line, balance);
					}
					// else if(line.matches(pattern5)) {
					// w.withDrawal(line, balance);
					// }
				}
			}
			sc.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
