package com.atm.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.atm.datamodel.AtmMachine;
import com.atm.datamodel.UserAccount;
import com.atm.service.atmServiceImpl;
import com.atm.service.atmUserInteractionImpl;

public class atmServiceTest{
	
	AtmMachine atmMachine = new AtmMachine();
	UserAccount userAccount = new UserAccount();
	atmService atmService = new atmServiceImpl();
	
	@Before
	public void beforeFunction() {
		userAccount.setAccountNumber("17222478");
		userAccount.setAccountPin("1234");
	}

	@Test
	public void testIfAccountNumberIsNotNull() {
		//String accountNumber = null;		
		assertNotNull("account Number is null", userAccount.getAccountNumber());				
	}
	
	@Test
	public void testIfAccountNumberLengthIsCorrect() {
		String accountNumber = userAccount.getAccountNumber();		
		assertEquals(8, accountNumber.length());
	}
	
	@Test
	public void testIfPinLengthIsCorrect() {
		String checkPin = userAccount.getAccountPin();
		assertEquals(4, checkPin.length());
	}
	
	@Test
	public void testIfPinNumberIsNotNull() {
		assertNotNull("pin entered is null", userAccount.getAccountPin());
	}
	
	@Test
	public void testIfPinIsEqual() {		
		assertEquals(userAccount.getAccountPin(), "1234");
	}
	
	@Test
	public void checkIfUserBalanceIsZero() {
		int userBalance = userAccount.getBalance();	
		assertNotNull(userBalance);
	}
	
	@Test
	public void checkIfAtmBalanceIsZero() {
		int atmBalance = atmMachine.getBalance();	
		assertNotNull(atmBalance);
	}
	
	//public void processFile(String fileName);
	
	/*@Test
	public void processFileTestCase1() {
		atmService.processFile(fileName);		
	}
	*/

}
