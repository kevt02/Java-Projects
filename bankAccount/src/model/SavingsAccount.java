/*
 * Course: TCSS143 - Introduction to Object Oriented Programming
 * File Name: SavingsAccount.java
 * Assignment: 2
 * Due Date: 2022 April 19
 * Instructor: Mr. Schuessler
 */
package model;
/**
  * This program will construct a SavingsAccount that uses certain methods
  * inherited from BankAccount class with unique rules altered. 
  * @author Kevin Truong
  * @version 2022 April 19
  */
 

public class SavingsAccount extends BankAccount {

/**
  * Indicates if the savings account is active dependent on balance
  */

  private boolean myStatusIsActive;
  
/*
 * Constructor that calls super constructor (BankAccount) and instantiates
 * myStatusIsActive
 * @param theNameOfOwner = name given from driver
 * @param theInterestRate = interest rate from driver
 */
  
  public SavingsAccount(final String theNameOfOwner,
                        final double theInterestRate) {
    super(theNameOfOwner, theInterestRate);
    myStatusIsActive = false;
  }
  
/*
 * Helper method during testing if myStatusIsActive was working properly 
 */
   
  public boolean getStatus() {
    return myStatusIsActive;
  }
  
/*
 * This method inherits BankAccount's processDeposit with added condition if
 * the account balance is above 25 after deposit, the account status will
 * return true.
 * @param theAmount = the amount being deposited from driver
 * @return myStatusIsActive = boolean if savings account is active
 */  

  public boolean processDeposit(final double theAmount) {
    super.processDeposit(theAmount);
    if(theAmount > 25.0) {
      myStatusIsActive = true;
    }
    return myStatusIsActive;
  }
  
/*
 * This method inherits BankAccount's processWithdrawal with additional
 * conditions. If myStatusIsActive is false, the withdraw will fail. If
 * number of withdraws reaches 5, every subsequent withdrawals will have
 * $1 fee. If remaining balance after withdrawal is below 25, the account
 * will become inactive
 * @param theAmount = the amount being withdrawn from driver
 * @return myStatusIsActive = boolean if savings account is active
 */  
  
  public boolean processWithdrawal(final double theAmount) {
    if(myStatusIsActive = true) {
      super.processWithdrawal(theAmount);
      if(myMonthlyWithdrawCount >= 5) {
        myMonthlyServiceCharges = 1;
      } else {
        myMonthlyServiceCharges = 0;
      }
      if(getBalance() < 25) {
      myStatusIsActive = false;
      }
    }
    return myStatusIsActive;
  }

/*
 * This method inherits BankAccount's performMonthlyProcess but if the 
 * account balance is below 25 after deductions, the account will become
 * inactive.
 *
 */  
  
  public void performMonthlyProcess() {
    super.performMonthlyProcess();
    if(getBalance() < 25) {
      myStatusIsActive = false;
    }
  }
  
/*
 * toString method that calls BankAccount's toString and concatinates
 * myStatusIsActive info
 * @return = savings account info 
 */
   
  public String toString() {
    return super.toString().substring(0, super.toString().length() - 1) + 
    ", myStatusIsActive: " + myStatusIsActive + "]";
  }
}