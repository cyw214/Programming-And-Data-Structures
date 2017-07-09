/* 
CSE 17 
Charles Wallace
cyw214
Program #3 DEADLINE: October 27, 2014 
Program: Checking Account 
*/

import java.text.SimpleDateFormat;
import java.util.Date;

/** A subclass of Transaction */
public class WithdrawalTransaction extends Transaction{

  /** Initializes the object. Note, amounts are expected to be positive numbers*/
  public WithdrawalTransaction(Date transaction, double amount)
  {
    super(transaction, amount);
  }
  /** Returns “Withdrawal”*/
   public String getDescription()
   {
     return "Withdrawal";
   } 
  /** Subtracts the transaction amount from the account */
  public void execute(BankAccount account)
  {
    account.withdraw(getAmount());
  }
   
  /** Should return a string of the format: “dateform description amount” where the dateform is given 10 characters
  * the description 30 characters, and the amount 10 characters. See “Account  Statement Format” below for examples. */
  public String toStatementRow()
  {
    SimpleDateFormat mmddyyyy = new SimpleDateFormat("MM/dd/yyyy");
    String transactiondate = mmddyyyy.format(this.getTransactionDate());
    String date = String.format("%-10s", transactiondate);
    String description = String.format("%-35s", (" " + this.getDescription()));
    String amount = String.format("%8.2f", this.getAmount());
    return date + description + amount + "          ";
  } 
}