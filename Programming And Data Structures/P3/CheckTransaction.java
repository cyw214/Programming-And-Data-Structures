/* 
CSE 17 
Charles Wallace
cyw214
Program #3 DEADLINE: October 27, 2014 
Program: Checking Account 
*/ 

import java.util.Date;

/** Extends the Withdrawal Transaction class contains methods and data fields for a check transaction, implements comparable*/
public class CheckTransaction extends WithdrawalTransaction implements Comparable{
  /** The name of the entity the check is made out to*/
  private String payee;  
  /** The check number*/
  private int checkNo;
  /** Initializes the object*/
  public CheckTransaction(Date transactionDate, double amount, String payee, int checkNo)
  {
    super(transactionDate, amount);
    this.payee = payee;
    this.checkNo = checkNo;
  }
  /**  Returns “Check checkNo - payee” */
  public String getDescription()
  {
    return "Check " + checkNo + " - " + payee;
  }
  /**  Returns the payee*/
  public String getPayee()
  {
    return payee;
  }
  /** Returns the checkNo*/
  public int getCheckNo()
  {
    return checkNo;
  }
  /** Returns < 0 if this checkNo is < that of o. Returns 0 if they are equal. Otherwise, returns > 0.*/
  public int compareTo(Object o)
  {
    if (checkNo < ((CheckTransaction) o).getCheckNo()) 
    {
      return -1;
    } 
    else if (checkNo == ((CheckTransaction) o).getCheckNo()) 
    {
      return 0;
    } 
    else 
    {
      return 1;
    }
  }
  /**  Execute a withdrawal for the check amount from the account. If the resulting balance of the 
  account is less than 0, generates a  FeeTransaction with the current date, justification “Overdraft fee”, and amount 
  specified by the insufficientFundsFee variable, and applies the transaction to the account*/
  public void execute(BankAccount account)
  { 
    account.withdraw(getAmount());
    Transaction trans1 = new FeeTransaction(this.getTransactionDate(),((CheckingAccount)account).getInsufficentFundsFee(),"Overdraft fee");
    
    if((account.getBalance()-this.getAmount()) < 0)
    { 
      account.addTransaction(trans1);
    }
  }
}