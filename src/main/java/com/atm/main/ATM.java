package com.atm.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.cli.CommandLine;

import com.atm.common.AtmError;
import com.atm.common.Constants;
import com.atm.datamodel.AtmMachine;
import com.atm.datamodel.UserAccount;
import com.atm.service.atmServiceImpl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ATM {

	public static void main(String[] args) throws IOException {

		// CommandLine commandLineArgs = this.parseCommandlineoptions(args);
		String fileName = args[0];
		atmServiceImpl atmServiceImpl = new atmServiceImpl();
		atmServiceImpl.processFile(fileName);
	}
}
