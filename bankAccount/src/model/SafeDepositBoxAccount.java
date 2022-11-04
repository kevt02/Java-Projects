/*
 * Course: TCSS143 - Introduction to Object Oriented Programming
 * File Name: SafeDepositBoxAccount.java
 * Assignment: 2
 * Due Date: 2022 April 19
 * Instructor: Mr. Schuessler
 */
package model;
/**
  * This program will hold a safe deposit account that will only know name
  * of who owns account as a private field. 
  * @author Kevin Truong
  * @version 2022 April 19
  */
 

public class SafeDepositBoxAccount implements NamedAccount {

/**
  * the name on deposit account 
  */
  private String myDepositName;
/*
 * Constructor that instantiates myDepositName
 * @param theNameOfOwner = the name on the account
 */  
  public SafeDepositBoxAccount(final String theNameOfOwner) {
    myDepositName = theNameOfOwner;
  }
  
/*
 * Getter method to return name on account instantiated from abstract ver. in
 * NamedAccount
 * @return myDepositName = the account name
 */  
  
  public String getAccountHolderName() {
    return myDepositName;
  }
/*
 * Method to change name of account from abstract ver. in NamedAccount
 * @param theNewName = the new name to be changed
 */    
  
  public void setAccountHolderName(final String theNewName) {
    myDepositName = theNewName;
  }
  
/*
 * toString method that displays name of account
 * @return = string that shows name of deposit account
 */  
  
  public String toString() {
    return "SafeDepositBoxAccount[owner: " + myDepositName + "]";
  } 
}