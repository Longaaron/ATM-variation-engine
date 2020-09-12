package com.atm.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import com.atm.common.AtmError;
import com.atm.common.Constants;
import com.atm.datamodel.AtmMachine;
import com.atm.datamodel.UserAccount;
import com.atm.main.AtmBalance;

public class atmServiceImpl implements atmService {

	public void processFile(String fileName) {
		// TODO Auto-generated method stub
		AtmBalance bal = new AtmBalance();
		AtmMachine atmMachine = new AtmMachine();
		atmUserInteractionImpl atmUserInteraction = new atmUserInteractionImpl();

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
								// userAccount.setCombinedTotal(userBalance + userOverdraft);

								boolean userActiveSession = false;
								while (!userActiveSession) {
									String userSessionline;
									String[] userInteractionArr;
									if (sc.hasNextLine()) {
										userSessionline = sc.nextLine();
										userInteractionArr = userSessionline.split(" ");
										if (userSessionline == null || userInteractionArr.length == 0
												|| userSessionline.isEmpty()) {
											userActiveSession = !userActiveSession;
										} else {

											// simple if statement to identify if the
											// the user wants to display their balance
											if (Constants.ATM_BALANCE.equals(userInteractionArr[0])) {
												atmUserInteraction.processBalance(userAccount);

												// simple if statement to identify if the
												// the user wants to withdraw money
											} else if (Constants.ATM_WITHDRAWAL.equals(userInteractionArr[0])) {
												int withDrawalAmount = Integer.parseInt(userInteractionArr[1]);
												atmUserInteraction.processWithdrawal(userAccount, atmMachine, withDrawalAmount, userBalance, atmBalance);
												
											} else { // closed if
												System.out.println(AtmError.ATM_ERR.getEnumDes());
											}
										}
									} else {
										userActiveSession = true;// Causes an infinite loop due to sc.hasNextLine
									}
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

}
