package com.atm.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class AtmBalance {
	
	public static void balance(String line, int balance) throws IOException
	{
	     String line1 = line;
         String pattern = "B";
             
             if(line1.matches(pattern)) {
            	 System.out.println(balance);
             }
             else {
            	 System.out.println(" "); // just for now
             }
         }
  	}

