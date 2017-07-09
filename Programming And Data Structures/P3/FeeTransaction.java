/* 
CSE 17 
Charles Wallace
cyw214
Program #3 DEADLINE: October 27, 2014 
Program: Checking Account 
*/ 

import java.util.Date;

/** fee transaction extends Withdrawal Transaction stores justification for fees incurred from withdrawals */
public class FeeTransaction extends WithdrawalTransaction{
  /** stores justification*/
  private String justification;
  /** Initializes the object*/
   public FeeTransaction(Date transactionDate, double amount, String justification)
   {
     super(transactionDate, amount);
     this.justification = justification;
   }
  /** Returns justification*/
  public String getDescription()
  {
    return justification;
  }
}