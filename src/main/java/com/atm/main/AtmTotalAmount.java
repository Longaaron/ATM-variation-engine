package com.atm.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import com.atm.datamodel.AtmMachine;

public class AtmTotalAmount {
	
	public static void atmTransaction(String line) throws IOException
	{		
		 AtmMachine atmMachine = new AtmMachine();
		 String line1 = line;
         
         ArrayList<Integer> atmTotal = new ArrayList<Integer>();
         
         String[] atmCashValue = line.split(" ");
         String atmCashnumber = atmCashValue[0];
         int number = Integer.parseInt(atmCashValue[0]);
         atmTotal.add(number);  
          
         int balance = Integer.parseInt(line);
		 atmMachine.setBalance(balance);
		 
		 System.out.println(atmMachine.getBalance());
	}
}
