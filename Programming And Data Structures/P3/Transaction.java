/* 
CSE 17 
Charles Wallace
cyw214
Program #3 DEADLINE: October 27, 2014 
Program: Checking Account 
*/ 

import java.util.Date;

/** represents an An activity that changes the balance of a bank account.  */
public abstract class Transaction{

  /** Date of the transaction*/
  private Date transactionDate;
  /** Amount of the transaction in dollars and cents.*/
  private double amount;

  /** Initializes the object*/
  protected Transaction(Date transactionDate, double amount)
  {
    this.transactionDate = transactionDate;
    this.amount = amount;
  }
  /** Returns a description for the transaction. See subclasses for values.*/
  public abstract String getDescription();
  /** Returns the transaction date*/
  public Date getTransactionDate()
  {
    return transactionDate;
  } 
  /** Returns the amount of the transaction.*/
  public double getAmount()
  {
    return amount;
  }
  /** Returns a string containing the transaction information in row form. This will be used by 
  printStatement() in the bank accounts.*/
  public abstract String toStatementRow();
  /** Applies the transaction against account. */
  public abstract void execute(BankAccount account); 
  
}