// Calvin Kwan
// CS141, section 01
// Project 1 - Bank Charges
// 10/2/2010

import java.util.Scanner;
import java.text.DecimalFormat;

public class BankChargesTest
{
	public static void main(String[]args)
	{ 
		double balance;
		int numcheck;
		
		DecimalFormat fm = new DecimalFormat("0.00");
		Scanner kb = new Scanner(System.in);
		
		System.out.print("What is the account balance? ");
		balance = kb.nextDouble();

		System.out.print("How many checks were written? ");
		numcheck = kb.nextInt();
		
		BankCharges bc = new BankCharges(balance, numcheck);
		System.out.printf("Bank Fees: $%.2f", bc.getBalance() +  
											bc.getChecks());										
	}
}