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
	atmUserInteraction atmUserInteraction = new atmUserInteractionImpl();
	
	/*
	 * Simple tests for processBalance
	 */
	
	@Before
	public void beforeBalanceFunction() {
		userAccount.setBalance(5000);
	}

	

}
