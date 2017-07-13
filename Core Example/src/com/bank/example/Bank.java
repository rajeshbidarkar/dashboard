package com.bank.example;

public class Bank {
	private Account[] accounts;     
	private int numOfAccounts;
	    
	public Bank() {
	    accounts = new Account[100];
	    numOfAccounts = 0;
	    }

	public int openNewAccount(String customerName, double openingBalance) {
		Account b = new Account(customerName, openingBalance);
	    accounts[numOfAccounts] = b;
	    numOfAccounts++;
	    return b.getAccountNum();
	}

	public void withdrawFrom(int accountNum, double amount) throws Exception {
	    for (int i =0; i<numOfAccounts; i++) {
	        if (accountNum == accounts[i].getAccountNum()  ) {
	            accounts[i].withdraw(amount);
	            System.out.println("Amount withdrawn successfully");
	            return;
	        }
	    }
	    System.out.println("Account number not found.");
    }

	public void depositTo(int accountNum, double amount) {
	    for (int i =0; i<numOfAccounts; i++) {
	        if (accountNum == accounts[i].getAccountNum()  ) {
	            accounts[i].deposit(amount);
	            System.out.println("Amount deposited successfully");
	            return;
	        }
	    }
	    System.out.println("Account number not found.");
	}

	public void printAccountInfo(int accountNum) {
	    for (int i =0; i<numOfAccounts; i++) {
	                if (accountNum == accounts[i].getAccountNum()  ) {
	                    System.out.println(accounts[i].getAccountInfo());
	                    return;
	                }
	            }
	    System.out.println("Account number not found.");
	}

	public void printTransactionInfo(int accountNum) {
	    for (int i =0; i<numOfAccounts; i++) {
	                if (accountNum == accounts[i].getAccountNum()  ) {
	                    System.out.println(accounts[i].getAccountInfo());
	                    System.out.println("Last transaction: " + accounts[i].getTransactionInfo(accounts[i].getNumberOfTransactions()-1));
	                    return;
	                }
	            }
	    System.out.println("Account number not found.");
	}

	public void printAccountInfo(int accountNum, int n) {
	    for (int i =0; i<numOfAccounts; i++) {
                 if (accountNum == accounts[i].getAccountNum()  ) {
                         System.out.println(accounts[i].getAccountInfo());
                         System.out.println(accounts[i].getTransactionInfo(n));
                         return;
                  }
         }
	    System.out.println("Account number not found.");
	    }
static class Account{

	   private int accountNum;
	   private String customerName;
	   private double balance;
	   private double[] transactions;
	   private String[] transactionsSummary;
	   private int numOfTransactions;
	   private  static int noOfAccounts=0;
	
	   public String getAccountInfo(){
	       return "Account number: " + accountNum + "\nCustomer Name: " + customerName + "\nBalance:" + balance +"\n";
	   }
	
	   public String getTransactionInfo(int n)
	   {
	        String transaction = transactionsSummary[n];
	        if (transaction == null) {
	            return "No transaction exists with that number.";
	        }
	        else {
	            return transaction;
	        }
	    }
	
	   public Account(String abc, double xyz){
	     customerName = abc;
	     balance = xyz;
	     noOfAccounts ++;
	     accountNum = noOfAccounts;
	     transactions = new double[100];
	     transactionsSummary = new String[100];
	     transactions[0] = balance;
	     transactionsSummary[0] = "A balance of : Rs." + Double.toString(balance) + " was deposited.";
	     numOfTransactions = 1;
	   }
	
		public int getAccountNum(){
		    return accountNum;
		}
		
		public int getNumberOfTransactions() {
		    return numOfTransactions;
		}
		
		public void deposit(double amount){
		
		    if (amount<=0) {
		        System.out.println("Amount to be deposited should be positive");
		    } else {
		        balance = balance + amount;
		        transactions[numOfTransactions] = amount;
		        transactionsSummary[numOfTransactions] = "Rs." + Double.toString(amount) + " was deposited.";
		        numOfTransactions++;
		    }
		}
		public void withdraw(double amount) throws Exception
		{
		    if (amount<=0){
		         System.out.println("Amount to be withdrawn should be positive");
		     }
		    else
		    {
		        if (balance < amount) {
		            throw new Exception("Insufficient balance");
		        } else {
		            balance = balance - amount;
		            transactions[numOfTransactions] = amount;
		            transactionsSummary[numOfTransactions] = "Rs." + Double.toString(amount) + " was withdrawn.";
		            numOfTransactions++;
		        }
		    }
		}
	
}
}