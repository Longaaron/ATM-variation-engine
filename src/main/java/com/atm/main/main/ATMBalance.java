package com.atm.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ATMBalance {
	
	static int bal = 900; // needs to be saved and changed, just in for now
	
	public static void balance(String line) throws IOException
	{
	     String line1 = line;
         String pattern = "B";
             
             if(line1.matches(pattern)) {
            	 System.out.println(bal);
             }
             else {
            	 System.out.println(" "); // just for now
             }
         }
  	}

