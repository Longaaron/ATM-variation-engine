package com.atm.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import com.atm.datamodel.AtmMachine;
import com.atm.datamodel.UserAccount;

public class UserSession {
	
	public static void accountDetails(String line, int balance) throws IOException
	{
         UserAccount userAccount = new UserAccount();
         AtmMachine atmMachine = new AtmMachine();
         
         String line1 = line;
         String accountValidation = "[0-9] {8}";        
         String[] userDetail = line1.split(" ");
         String atmAccountDetail = userDetail[0];
         String correctPin = userDetail[1];
         String userEnteredPin = userDetail[2];

        
        		 
         if(correctPin.matches(userEnteredPin)) { // loop balance,withdraw and change to user session            		       	
        	 userAccount.setAccountNumber(atmAccountDetail);
        	 userAccount.setAccountPin(correctPin);   
        	 
        	 atmMachine.getBalance();
        	 
        	 System.out.println(balance);
    		 
         }else{
             System.out.println("Pin you have entered is incorrect");
         }
          
  }

}
