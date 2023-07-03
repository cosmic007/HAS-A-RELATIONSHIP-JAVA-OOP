package com.canddella.utility;

import java.util.ArrayList;
import java.util.Scanner;

import com.canddella.entity.Account;
import com.canddella.entity.Customer;
import com.canddella.service.Service;

public class Utility {

	public static void main(String[] args) {

		boolean next = false;
		int accountCount = 1;

		ArrayList<Customer> customerList = new ArrayList<Customer>();
		do {
			int choice = Service.displayMenu();
			switch (choice) {
			case 1:
				boolean isFound = Service.createAccountForExistingCus(accountCount, customerList);
				if (!isFound) {
					Account account = Service.createAccount(accountCount);
					customerList.add(Service.createCustomer(account));
					accountCount++;

				} else {
					accountCount++;
				}
				break;
			case 2:
				String accountNo = Service.selectPreferredAccount(customerList);

				if (accountNo != null) {
					Service.manageTransaction(customerList, accountNo);
				}
				break;
			case 3:
				Service.displayAccounts(customerList);
				break;
			default:
				System.out.println("Invalid choice");
				break;

			}
			
			System.out.println("Do you want to continue: \n1.Yes\n2.No");
			Scanner scanner = new Scanner(System.in);
			int ans=scanner.nextInt();
			if(ans==1)
			{
				next=true;
			}
			else if(ans==2)
			{
				next=false;
				break;
			}
			else
			{
				System.out.println("Invalid Option\nCancelled");
				next=false;
				break;
			}
		} while (next);

	}

}
