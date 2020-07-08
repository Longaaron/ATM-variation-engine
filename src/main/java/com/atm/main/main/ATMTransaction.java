package com.atm.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ATMTransaction {
	
	public static void accountDetails(String line) throws IOException
	{
		 String line1 = line;
         String accountValidation = "[0-9] {8}";
         
         ArrayList<String> userAccount = new ArrayList<String>(); // replace by class
         
         String[] userDetail = line1.split(" ");
         String atmAccountDetail = userDetail[0];
         String correctPin = userDetail[1];
         String userEnteredPin = userDetail[2];
             
         userAccount.add(correctPin);  
         userAccount.add(userEnteredPin);
             
         
         if(correctPin.matches(userEnteredPin)) { // loop balance,withdraw and change to user session            		
        	 System.out.println("Proceeding with Transaction");
         }else{
            		 System.out.println("Pin you have entered is incorrect");
            	 }
          
  }

}
