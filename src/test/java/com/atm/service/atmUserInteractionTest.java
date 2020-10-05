package com.atm.service;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import com.atm.datamodel.AtmMachine;
import com.atm.datamodel.UserAccount;
import com.atm.common.withDrawalReturns;
import com.atm.service.atmServiceImpl;
import com.atm.service.atmUserInteractionImpl;

public class atmUserInteractionTest {
	
	AtmMachine atmMachine = new AtmMachine();
	UserAccount userAccount = new UserAccount();
	atmService atmService = new atmServiceImpl();
	withDrawalReturns withDrawalReturns = new withDrawalReturns();
	
	/*
	 * Simple tests for processBalance
	 */
	
	@Before
	public void beforeBalanceFunction() {
		//userAccount.setBalance(5000);
	}

	@Test
	public void testProcessBalance1() {
		assertEquals(userAccount.getBalance(), userAccount.returnBalance());
	}
	
	@Before
	public void beforeBalanceFunction1() {
		//userAccount.setBalance(9000);;
	}
	
	@Test
	public void testProcessBalance2() {
		assertEquals(userAccount.getBalance(), userAccount.returnBalance());
	}
	
	/*
	 * Simple Tests for processWithdrawal
	 */
	
	
	@Before
	public void beforeWithDrawalFunction() {
		userAccount.setBalance(5000);
		withDrawalReturns.setWithDrawalAmount(-2500);
		withDrawalReturns.setNewBalance(userAccount.getBalance() - withDrawalReturns.getWithDrawalAmount());
		userAccount.setBalance(withDrawalReturns.getNewBalance());
	}
	
	@Test
	public void testWithDrawalFunction() {
		//assertEquals(2500, withDrawalReturns.getNewBalance());
	}
	
	@Test
	public void testWithDrawalFunction1() {
		//assertEquals(2500, userAccount.getBalance());
	}
	
	@Before
	public void beforeWithDrawalFunction1() {
		userAccount.setBalance(100);
		withDrawalReturns.setWithDrawalAmount(-50);
		withDrawalReturns.setNewBalance(userAccount.getBalance() - withDrawalReturns.getWithDrawalAmount());
		userAccount.setBalance(withDrawalReturns.getNewBalance());
	}
	
	@Test
	public void testWithDrawalFunction2() {
		assertEquals(50, userAccount.getBalance());
	}
	
	
	
	
	
	
	

}
