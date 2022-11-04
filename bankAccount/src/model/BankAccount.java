package model;
/*
 * Course: TCSS143 - Introduction to Object Oriented Programming
 * File Name: BankAccount.java
 * Assignment: 2
 * Due Date: 2022 April 19
 * Instructor: Mr. Schuessler
 */

/**
  * This program will construct a BankAccount that has interest and processing
  * fees. The program will be able to deposit and withdraw money and be able
  * to change the name from implementing NamedAccount.
  * @author Kevin Truong
  * @version 2022 April 19
  */

public class BankAccount implements NamedAccount {

/**
  * contains name of customer
  */

  private String myCustomerName;

/**
  * contains account balance
  */
  
  private double myAccountBalance;
 
/**
  * contains interest rate
  */
  
  private double myInterestRate;

/**
  * contains the withdraw count
  */
  
  protected int myMonthlyWithdrawCount;

/**
  * contains monthly service charges
  */

  protected double myMonthlyServiceCharges;

/*
 * Constructor that instantiates all fields needed for this bank account
 * program with given name and interest rate from driver program
 * @param theNameOfOwner = name given from driver
 * @param theInterestRate = interest rate from driver
 */
  
  public BankAccount(final String theNameOfOwner,
                     final double theInterestRate) {
    
    myCustomerName = theNameOfOwner;
    myInterestRate = theInterestRate;
    myAccountBalance = 0;
    myMonthlyWithdrawCount = 0;
    myMonthlyServiceCharges = 0;
  }
  
/*
 * Getter method to return private account balance to subclasses
 * @return myAccountBalance = the account balance
 */
  
  public double getBalance() {
    return myAccountBalance;
  }

/*
 * This method decides if deposit is possible if number attempted is positive.
 * If negative, nothing will happen.
 * @param theAmount = the number being attempted to deposit
 * @return depositPossibe = boolean if the deposit is possible
 */
  
  
  public boolean processDeposit(final double theAmount) {
    boolean depositPossible = true;
    if(theAmount <= 0) {
      depositPossible = false;
    } else {
      myAccountBalance += theAmount;
    }
    return depositPossible;
  }

/*
 * This method decides if a withdrawal is possible. Withdrawal amount must be
 * posistive and cannot exceed account balance, fails if true. If possible,
 * the incoming double param will be subtracted from the account balance.
 * @param theAmount = the number being attemped to withdraw
 * @return withdrawPossible = boolean if withdraw is possible
 */
 
  public boolean processWithdrawal(final double theAmount) {
    boolean withdrawPossible = true;
    if(theAmount < 0 || theAmount > myAccountBalance) {
      withdrawPossible = false;
    } else {
      myAccountBalance -= theAmount;
      myMonthlyWithdrawCount++;
    }
    return withdrawPossible;
  }
  
/*
 * This method calculates the interest of an account using APR
 * @return result = the resulting interest rate dependent on the account
 * balance
 */
   
  public double calculateInterest() {
    double result = (myAccountBalance * myInterestRate) / 12.0;
    return result;
  }
 
/*
 * This method deducts monthly service charges if any from account balance. 
 * Monthly service charges cannot cause account to go negative. After 
 * deductions, calculateInterst() is called and withdraw count and charges
 * are reset to 0 for new month.
 * 
 */
 
  public void performMonthlyProcess() {
    if(myMonthlyServiceCharges > myAccountBalance) {
      myAccountBalance = 0;
    } else {
      myAccountBalance -= myMonthlyServiceCharges;
    }
    myAccountBalance += calculateInterest();
    myMonthlyWithdrawCount = 0;
    myMonthlyServiceCharges = 0;
  }
  
/*
 * Method to get the customer name from account implementing abstract ver. 
 * from NamedAccount.
 * @return myCustomerName = the name of the account
 */
  
  public String getAccountHolderName() {
    return myCustomerName;
  }
  
/*
 * Method to change customer name on an account implementing abstract ver.
 * from NamedAccount.
 * 
 */
  
  public void setAccountHolderName(final String theNewName) {
    myCustomerName = theNewName;
  }
  
/*
 * toString method to display account information.
 * @return = concatinated string with information and variables. 
 */
  
  public String toString() {
    return getClass().getSimpleName() + "[owner: " + myCustomerName + 
           ", balance: " + myAccountBalance + ", interest rate: " + 
           myInterestRate + ",\n number of withdrawals this month: " + 
           myMonthlyWithdrawCount +  ", service charges for this month: " + 
           myMonthlyServiceCharges + "]";
  }
}
  