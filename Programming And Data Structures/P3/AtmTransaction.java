/* 
CSE 17 
Charles Wallace
cyw214
Program #3 DEADLINE: October 27, 2014 
Program: Checking Account 
*/ 

import java.util.Date;

/** a subclass of WithdrawalTransaction stores identifying charactersistics of an atm transaction*/
public class AtmTransaction extends WithdrawalTransaction{
  
  /** The address of ATM where money was withdrawn*/
  private String address;  
  /** Initializes the object*/
  public AtmTransaction(Date transactionDate, double amount, String address)
  {
    super(transactionDate, amount);
    this.address = address;
  }
  /** Returns “ATM - address” */
  public String getDescription()
  {
    String description = "ATM -" + address;
    return description;
  }
}