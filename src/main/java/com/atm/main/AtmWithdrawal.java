/*package com.atm.main;  

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import com.atm.common.AtmError;

public class AtmWithdrawal {

	public static void withDrawal(String line, int balance) throws IOException {
		
		int userMoney = 90;// TEMP

		String line1 = line;

		ArrayList<Integer> userWithdrawal = new ArrayList<Integer>();
		String[] withdrawalValue = line1.split("W ");
		String withdrawalnumber = withdrawalValue[0];

		int number = Integer.parseInt(withdrawalValue[1]);
		userWithdrawal.add(number);

		for (int w : userWithdrawal) {
			if (w <= userMoney) {
				int index = 1;
				int total = userMoney - w;
				System.out.println(total);
				index++;
			} else {
				System.out.println(AtmError.FUNDS_ERR.getEnumDes());
			}
		}
	}
}
*/
