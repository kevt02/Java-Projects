/*
 * Course: TCSS143 - Introduction to Object Oriented Programming
 * File Name: NamedAccount.java
 * Assignment: 2
 * Due Date: 2022 April 19
 * Instructor: Mr. Schuessler
 */
 package model;
/**
  * This program is an interface that contains abstract methods that will
  * be implemented and instantiated in BankAccount and its subclass and
  * SafeDepositBoxAccount
  * @author Kevin Truong
  * @version 2022 April 19
  */ 
  
public interface NamedAccount {

/*
 * Abstract method to get name of account
 */ 
 
  String getAccountHolderName();
  
/*
 * Abstract method to change name of account
 * @param theNewName = new name from driver
 */
  void setAccountHolderName(final String theNewName);
}