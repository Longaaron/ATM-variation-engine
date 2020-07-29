package com.atm.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.cli.CommandLine;

import com.atm.common.AtmError;
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
		AtmMachine atmMachine = new AtmMachine();

		// while loop to be inserted here to go through file and call the correct
		// classes at each line
		try {
			File f = new File(fileName);
			Scanner sc = new Scanner(f);
			Scanner atmSessionFile = new Scanner(f);

			String firstLine = atmSessionFile.nextLine();

			String[] firstLineValueArr = firstLine.split(" ");
			// Identifies the first line of the file as the Atm balance
			if (firstLineValueArr.length == 1) {
				int atmBalance = Integer.parseInt(firstLineValueArr[0]); // try bl9ck
				atmMachine.setBalance(atmBalance);
				// Identifies the start of the User session
				while (sc.hasNextLine()) {
					String line = sc.nextLine();
					String[] userSessionLineArr = line.split(" ");

					// Identifies User account details
					if (userSessionLineArr.length == 3) {
						// validation for AccountEnum
						if (userSessionLineArr[1].equals(userSessionLineArr[2])) {
							UserAccount userAccount = new UserAccount();
							userAccount.setAccountNumber(userSessionLineArr[0]);
							userAccount.setAccountPin(userSessionLineArr[1]);

							line = sc.nextLine();
							String[] userBalanceArr = line.split(" ");

							// Identifies user balance and overDraft
							if (userBalanceArr.length == 2) {

								int userBalance = Integer.parseInt(userBalanceArr[0]);
								int userOverdraft = Integer.parseInt(userBalanceArr[1]);

								userAccount.setBalance(userBalance);
								userAccount.setOverDraft(userOverdraft);

								// need to add condition for blank line
								// also stepping into userInteraction with the atm(balance , withdrawal)
								// need to add condition for an empty line
								while (sc.hasNextLine()) {
									String userSessionline = sc.nextLine();
									String[] userInteractionArr = userSessionline.split(" ");
									if (userInteractionArr[0].equals("B")) {
										bal.balance(atmMachine, userAccount);
									} else if (userInteractionArr[0].equals("W")) {
										int withDrawalAmount = Integer.parseInt(userInteractionArr[1]);
										// check if atm has enough money to withdraw cash
										// user cant withdraw more funds then they actually have
										if (atmMachine.getBalance() != 0
												&& atmMachine.getBalance() >= withDrawalAmount) {
											if (withDrawalAmount <= userBalance) {
												userBalance = userAccount.getBalance() - withDrawalAmount;
												atmBalance = atmMachine.getBalance() - withDrawalAmount;
												userAccount.setBalance(userBalance);
												atmMachine.setBalance(atmBalance);

												System.out.println(userBalance);
												// System.out.println(atmMachine.getBalance());
											} else {
												System.out.println(AtmError.FUNDS_ERR.getEnumDes());
											}
										} else {
											System.out.println(AtmError.ATM_ERR.getEnumDes());
										}
									} else if (userSessionline.isEmpty()) {
										break;
									}
								}

							}
						} else {
							System.out.println(AtmError.ACCOUNT_ERR.getEnumDes());
						}
					}
				}
				sc.close();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
