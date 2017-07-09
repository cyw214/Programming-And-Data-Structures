/* 
CSE 17 
Charles Wallace
cyw214
Program #3 DEADLINE: October 27, 2014 
Program: Checking Account 
*/ 

import java.text.SimpleDateFormat;
import java.util.Date;

/** a subclass of transaction, provides methods and a constructor for an object representing a deposit*/
public class DepositTransaction extends Transaction{

 private String description;
 
 /** Initializes the object.*/
 public DepositTransaction(Date transactionDate, double amount, String description)
 {
  super(transactionDate, amount);
  this.description = description;
 }
  /** Returns description*/
 public String getDescription()
 {
  return description;
 }
  /** Adds the transaction amount from the account */  
  public void execute(BankAccount account)
  {
    account.deposit(getAmount());
   
  }
  
 /** Should return a string of the format: “date description amount” where the date is given 
  10 characters, the description 30 characters, and the amount 10 characters. See “Account Statement Format” below for examples. */
  public String toStatementRow()
  {
    SimpleDateFormat mmddyyyy = new SimpleDateFormat("MM/dd/yyyy");
    String transactiondate = mmddyyyy.format(this.getTransactionDate());
    String date = String.format("%-10s", transactiondate);
    String description = String.format("%-35s", (" " + this.getDescription()));
    String amount = String.format("%8.2f", this.getAmount());
    return date + description + "          " + amount;
 }
}