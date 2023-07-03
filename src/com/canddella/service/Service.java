package com.canddella.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import com.canddella.entity.Account;
import com.canddella.entity.Customer;

public class Service {

	public static int displayMenu() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("*************Welcome to Bank**************");
		System.out.println("1.Create Account\n2.Manage Account \n3.Display Accounts\n4.Exit");
		int choice = scanner.nextInt();
		return choice;

	}

	public static Account createAccount(int accountCount) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Create New Account\n");
		System.out.println("***********Accounts Available***********\n");
		System.out.println("1.Savings Max Account\n2.Current Account\n3.Loan Account");
		System.out.println("Enter your choice:");
		int choice = scanner.nextInt();
		String accountType = null;
		String accountNo = null;
		switch (choice) {
		case 1:
			accountType = "Savings Max Account";
			accountNo = "ACSMA" + accountCount;
			break;
		case 2:
			accountType = "Current Account";
			accountNo = "ACCA" + accountCount;
			break;
		case 3:
			accountType = "Loan Account";
			accountNo = "ACLA" + accountCount;
			break;
		default:
			System.out.println("Enter a valid option:");
			break;
		}
		LocalDate accountCreateDate = LocalDate.now();
		double accountBalance = 1000;

		return new Account(accountNo, accountType, accountCreateDate, accountBalance);

	}

	public static Customer createCustomer(Account account) {
		Scanner scanner= new Scanner(System.in);
		System.out.println("Enter the Customer ID:");
		String customerCode=scanner.nextLine();
		System.out.println("Enter the Customer Name:");
		String customerName=scanner.nextLine();
		System.out.println("Enter Customer Type:");
		String customerType=scanner.nextLine();
		Customer customer = new Customer(customerCode,customerName,customerType,new ArrayList<Account>());
		customer.getAccountList().add(account);
		System.out.println(account.getAccountType()+" created for "+customer.getCustomerName());
		System.out.println("Account is active !!!!!!");
		
		return customer;
		
		
		
	}

	public static boolean createAccountForExistingCus(int accountCount, ArrayList<Customer> customerList) {
		Scanner scanner = new Scanner(System.in);
		
		boolean isFound=true;
		HashMap <String, ArrayList <Account>> customerAccountHashMap= new HashMap<> ();
		for(Customer customer:customerList)
		{
			if(customer!=null)
			{
				customerAccountHashMap.put(customer.getCustomerCode(), customer.getAccountList());
			}
		}
		
		System.out.println("Enter the Customer ID:");
		String customerCode=scanner.nextLine();
		
		if(customerAccountHashMap.get(customerCode)!=null)
		{
			customerAccountHashMap.get(customerCode).add(createAccount(accountCount));
			isFound=true;
			System.out.println("Accout has been successfully added");
		
		}
		else
		{
			System.out.println("Customer ID not found\n");
			isFound=false;
			
		}
		return isFound;
		
		
		
		
		
	}

	public static String selectPreferredAccount(ArrayList<Customer> customerList) {
		Scanner scanner=new Scanner(System.in);
		String accountNo = null;
		HashMap <String, Customer> customerAccountHashMap= new HashMap<> ();
		for(Customer customer:customerList)
		{
			if(customer!=null)
			{
				customerAccountHashMap.put(customer.getCustomerCode(), customer);
			}
		}
		System.out.println("Enter the customerID:");
		String customerID=scanner.nextLine();
		if(customerAccountHashMap.get(customerID)!=null)
		{
			Customer customer = customerAccountHashMap.get(customerID);
			System.out.println(customer.getCustomerName()+" has the following accounts");
			for(Account account:customer.getAccountList())
			{
				if(account!=null)
				{
					System.out.println(account.getAccountType()+" - Account No:"+account.getAccountNo());
				}
			}
			System.out.println("Enter preferred account no:");
			accountNo=scanner.nextLine();
			
			
			
		}
		else
		{
			System.out.println("Customer ID not found");
		}
		return accountNo;
		
		
		
	}

	public static void manageTransaction(ArrayList<Customer> customerList, String accountNo) {
		Scanner scanner = new Scanner(System.in);
		HashMap <String, Account> accountNoAccountHashMap= new HashMap<> ();
		for(Customer customer:customerList)
		{
			if(customer!=null)
			{
				for(Account account:customer.getAccountList())
				{
					if(account!=null)
					{
						accountNoAccountHashMap.put(account.getAccountNo(), account);
					}
					
				}
			}
		}
		System.out.println("1.Deposit  2.Withdraw\nEnter your choice:");
		int choice=scanner.nextInt();
		
		
		switch(choice)
		{
		case 1:
			System.out.println("Enter the amount to be deposited:");
			double amountD=scanner.nextDouble();
			
			Account accountD=accountNoAccountHashMap.get(accountNo);
			accountD.setAccountBalance(accountD.getAccountBalance()+amountD);
			System.out.println("Amount deposited");
			break;
		case 2:
			System.out.println("Enter the amount to be withdrawed:");
			double amountW=scanner.nextDouble();
			
			Account accountW=accountNoAccountHashMap.get(accountNo);
			
			if(accountW.getAccountBalance()>amountW)
			{
				
				if((accountW.getAccountBalance()-amountW)<1000)
				{
					System.out.println("Sorry, you have to maintain a minimum of accountBalance Rs1000");
				}
				else
				{
					accountW.setAccountBalance(accountW.getAccountBalance()-amountW);
					System.out.println("Amount withdrawed");
					
				}
				
			}
			else
			{
				System.out.println("Insufficient Balance");
			}
			break;
		default:
			System.out.println("Invalid Choice");
			break;
		}
		
		
		
		
		
	}

	public static void displayAccounts(ArrayList<Customer> customerList) {
		
		System.out.println("***************************************Customer-Account Details**********************************");
		System.out.println("");
		System.out.printf("%-30s%-30s%-20s%-30s%-20s","CustomerId","CustomerName","CustomerType","AccountType","Balance");
		System.out.println("");
		System.out.println("");
		System.out.println("**************************************************************************************************");
		
		for(Customer customer:customerList)
		{
			if(customer!=null)
			{
				for(Account account:customer.getAccountList())
				{
					if(account!=null)
					{
						System.out.printf("%-30s%-30s%-20s%-30s%-20s", customer.getCustomerCode(),customer.getCustomerName(),
								customer.getCustomerType(),account.getAccountType(),account.getAccountBalance());
						System.out.println("");
						
					}
				}
			}
		}
		
		
		
		
		
		
		
		
		
	}

}
