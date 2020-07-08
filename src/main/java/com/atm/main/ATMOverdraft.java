package com.atm.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ATMOverdraft {
	
	public static void draft(String line) throws IOException
	{
		 String line1 = line;
         
         	 ArrayList<Integer> userAccount = new ArrayList<Integer>();
             
             String[] overDraftDetail = line1.split(" ");
            // String valueOfAccount = overDraftDetail[0];
             int valueOfAccount = Integer.parseInt(overDraftDetail[0]);
             int accountTotalDetail = Integer.parseInt(overDraftDetail[1]);
             userAccount.add(accountTotalDetail);  
             
             if(accountTotalDetail >= 100) {
            	 int userBalanace = valueOfAccount + accountTotalDetail;
            	 System.out.println(userBalanace);
             }
             else if(accountTotalDetail == 0) {
            	 int userBalanace = valueOfAccount;
            	 System.out.println(userBalanace);
             }
		}
  }


