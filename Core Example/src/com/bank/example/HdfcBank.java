package com.bank.example;

public class HdfcBank {

	public static void main(String[] args) throws Exception {
		
		Bank bank = new Bank();
		bank.openNewAccount("Rajesh", 100);
		bank.printAccountInfo(1);
		bank.withdrawFrom(1, 50);
	}

}


/* CSV, 
 * TSV, 
 * excel, 
 * fixed width, 
 * Excel CSV
 *
 * */
 