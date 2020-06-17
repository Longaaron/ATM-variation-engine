package com.atm.main;

import java.util.Scanner;

public class ATM {
    static Scanner keyboard = new Scanner(System.in);
    static String accountNumber, pin, result;
    static double oldBalance, newBalance, deposit, withdraw, currentBalance, atmCurrentFunds;
    static int choose;


    
    public static void main(String[] args) {

        /*for (int run = 0; run < 3; run++) {
            System.out.println("Enter your account number");
            accountNumber = keyboard.nextLine();
            System.out.println("Enter your account pin");
            pin = keyboard.nextLine();
    
           // result = checkID(acctNum, pwd);
            if (!result.equals("ERROR")) {
                break;
            } else if (run == 2) {// times
                System.out.println("MAXIMUM TRIES EXCEEDED");
                return;
            }
        }
        */
        menu();
    }
    
    
   // public static String validateAccount(String accountNumber, String pin) {
   // }
    
    public static int menu() {
        System.out.println("Choose one of the following: \n1.Display Balance\n2.Deposit\n3.Withdraw\n4.Log Out");
        choose = keyboard.nextInt();
    
        if (choose == 1) {// 1. Display Balance
            displayBalance();
            menu();
            return 1;
    
        }
        if (choose == 2) {// 2. Deposit
            deposit();
            menu();
            return 2;
    
        }
        if (choose == 3) {// 3. Withdraw
            withdraw();
            menu();
            return 3;
    
        }
        if (choose == 4) {// 4. Log out
            System.out.println("You are logged out.");
            return 4;
    
        }
        if (choose <= 5) {// system error
            System.out.println("System Error");
            menu();
            return 5;
        }
        if (choose >= 1) {// system error
            System.out.println("System Error");
            menu();
            return 6;
        }
        return choose;
    }
    
    public static void deposit()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter deposit amount:");
        double amount = input.nextDouble();
        System.out.println("Your deposit amount: " + amount);
        currentBalance += amount;
        System.out.println("Your new balance is: + currentBalance");
    }
    
    public static double displayBalance() {
        System.out.println("Total balance is: " + currentBalance);
        oldBalance = 0.00;
        return 1;
    }
    
    public static void withdraw()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter withdrawal amount: ");
        double amount = input.nextDouble();

        if(amount <= atmCurrentFunds){
        System.out.println("Your withdrawal amount: " + amount);
        currentBalance -= amount;
        atmCurrentFunds -= amount;
        System.out.println("Your new balance is: " + currentBalance);
        }else{

        System.out.println("Amount requested exceeds ATM current funds, Please try again with a smaller amount");
        }
    }
}
