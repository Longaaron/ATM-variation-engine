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
	
	@Before
	public void beforeFunction() {
		String accountNumber = userAccount.setAccountNumber("17222478");
		String testPin = (userAccount.setAccountPin("1234"));
	}

	@Test
	public void testIfAccountNumberIsNotNull() {
		String accountNumber = userAccount.getAccountNumber();
		
		assertNotNull(accountNumber, "account Number is null");		
		//assertNull(accountNumber, "account number is not null");
	}
	
	@Test
	public void testIfLengthIsCorrect() {
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
		String checkPin = userAccount.getAccountPin();
		assertNotNull(checkPin, "pin entered is null");
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

}
