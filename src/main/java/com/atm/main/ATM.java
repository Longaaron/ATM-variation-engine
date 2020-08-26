package com.atm.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.cli.CommandLine;

import com.atm.common.AtmError;
import com.atm.common.Constants;
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
		AtmBalance bal = new AtmBalance();
		AtmMachine atmMachine = new AtmMachine();

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
								//userAccount.setCombinedTotal(userBalance + userOverdraft);

								boolean userActiveSession = false;
								while (!userActiveSession) {
									String userSessionline;
									String[] userInteractionArr;
									if (sc.hasNextLine()) {
										userSessionline = sc.nextLine();
										userInteractionArr = userSessionline.split(" ");
										if (userSessionline != null && userInteractionArr[0].length() == 0) {
											userActiveSession = !userActiveSession;
										} else {

											// simple if statement to identify if the
											// the user wants to display their balance
											if (Constants.ATM_BALANCE.equals(userInteractionArr[0])) {
												System.out.println("$" + userAccount.getBalance());

												// simple if statement to identify if the
												// the user wants to withdraw money
											} else if (Constants.ATM_WITHDRAWAL.equals(userInteractionArr[0])) {
												int withDrawalAmount = Integer.parseInt(userInteractionArr[1]);
												int combinedBalanceOverdraft = userAccount.getCombinedTotal();
												// check if atm has enough money to withdraw cash
												// user cant withdraw more funds then they actually have
												if (atmMachine.getBalance() != 0
														&& atmMachine.getBalance() >= withDrawalAmount) {

													// if the user wants to take out money and its less then their
													// combined total then continue, else error
													if (withDrawalAmount <= combinedBalanceOverdraft) {

														// if user balance is greater then the amount that the user
														// wants to withdraw then you subtract that amount away
														// else if the amount is greater than the balance remaining, set
														// balance to zero and bring overdraft into play
														if (userAccount.getBalance() >= withDrawalAmount) {
															userBalance = userAccount.getBalance() - withDrawalAmount;
														} else {
															userAccount.setBalance(0);
														}

														// setting the overall remaining balance that user can withdraw
														int remainingUserBalance = userAccount.getCombinedTotal()
																- withDrawalAmount;

														atmBalance = atmMachine.getBalance() - withDrawalAmount;
														combinedBalanceOverdraft = userAccount.getCombinedTotal()
																- withDrawalAmount;

														userAccount.setBalance(userBalance);
														//userAccount.setCombinedTotal(combinedBalanceOverdraft);
														atmMachine.setBalance(atmBalance);
														
														if(userBalance <= 0 && withDrawalAmount <= userAccount.getOverDraft() ) {
															 userAccount.setOverDraft(userAccount.getOverDraft() - withDrawalAmount);
														}

														// if user balance is 0 or goes below zero
														// if there is an overdraft
														// if combined total is not empty
														if (userBalance <= 0 && userAccount.getOverDraft() > 0
																&& userAccount.getCombinedTotal() != 0) {
															System.out.println("Available cash including overdraft: "
																	+ "$" + userAccount.getCombinedTotal());
															//userAccount.setOverDraft(
																	//withDrawalAmount - userAccount.getCombinedTotal());

															// if remaining balance is not empty
														} else if (remainingUserBalance != 0) {
															System.out.println("$" + userAccount.getBalance()
																	+ " remaining in your main account");
														} else {
															System.out.println("$" + userAccount.getCombinedTotal()
																	+ " remaining in your overdraft");
															userAccount.setOverDraft(
																	userAccount.getCombinedTotal() - withDrawalAmount);
														}
													} else { // closed if
														System.out.println(AtmError.FUNDS_ERR.getEnumDes());
													}
												} else { // closed if
													System.out.println(AtmError.ATM_ERR.getEnumDes());
												}
											} else { // closed if
												System.out.println(AtmError.ATM_ERR.getEnumDes());
											}
										}
									} // Causes an infinite loop due to sc.hasNextLine
								} // WHILE loop
							} else {
								System.out.println(AtmError.ACCOUNT_ERR.getEnumDes());
							}
						} else {
							System.out.println(AtmError.PIN_ERROR.getEnumDes());
						}
					} else {
						System.out.println(AtmError.ACCOUNT_ERR.getEnumDes());
					}
				} // WHILE LOOP
				sc.close();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	private static int getCombinedTotal(UserAccount userAccount) {

		int totalUserBalance = userAccount.getBalance() + userAccount.getOverDraft();

		return totalUserBalance;
	}
}
