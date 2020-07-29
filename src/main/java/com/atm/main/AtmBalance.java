package com.atm.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import com.atm.datamodel.AtmMachine;
import com.atm.datamodel.UserAccount;

public class AtmBalance {
	
	public static void balance(AtmMachine atmMachine, UserAccount userAccount) throws IOException
	{
            	 System.out.println(userAccount.getBalance());
   	}
}

