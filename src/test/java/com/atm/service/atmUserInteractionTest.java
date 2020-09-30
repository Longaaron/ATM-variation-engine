package com.atm.service;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;


import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import com.atm.datamodel.AtmMachine;
import com.atm.datamodel.UserAccount;
import com.atm.service.atmServiceImpl;
import com.atm.service.atmUserInteractionImpl;

public class atmUserInteractionTest {
	
	AtmMachine atmMachine = new AtmMachine();
	UserAccount userAccount = new UserAccount();
	atmService atmService = new atmServiceImpl();
	HashMap<String, String> userInteractions = new HashMap<String, String>();

	@Rule
	public TemporaryFolder folder = new TemporaryFolder();

	@Test
	public void myTest() throws IOException {
		// this folder gets cleaned up automatically by JUnit
		File file = folder.newFile("test1.txt");

		// populate the file
		
		atmMachine.setBalance(7000);
		
		userAccount.setAccountNumber("17222478");
		userAccount.setAccountPin("3425");
		userAccount.setBalance(500);
		userAccount.setOverDraft(100);
		
		userInteractions.put("B", "500");
		userInteractions.put("W", "100");
		userInteractions.put("B", "10");
		userInteractions.put("FUNDS_ERR", "FUNDS_ERR");
		userInteractions.put("B", "0");
		
		
		// run your test
	}

}
