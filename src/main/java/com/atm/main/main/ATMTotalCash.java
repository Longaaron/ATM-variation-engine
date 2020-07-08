package com.atm.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ATMTotalCash {
	
	public static void atmTransaction(String line) throws IOException
	{
		 String line1 = line;
         
         ArrayList<Integer> atmTotal = new ArrayList<Integer>();
         
         String[] atmCashValue = line.split(":");
         String atmCashnumber = atmCashValue[0];
         int number = Integer.parseInt(atmCashValue[0]);
         atmTotal.add(number);  
                 
        //teste
         
        
         for(int atmT: atmTotal){
         	int index = 1;
            System.out.println(atmT);
            index++;  // index iterates but index after transaction doesn't update to Transaction 2:
         }
	}
}
