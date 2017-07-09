/* 
CSE 17 
Charles Wallace
cyw214
Program #3 DEADLINE: October 27, 2014 
Program: Checking Account 
*/ 

import java.util.Date;

/** Checking account is a subclass of Banking account, it represents the state of a checking account*/
public class CheckingAccount extends BankAccount{

  /** Fee to withdraw from an account if funds are insufficient to cover a check. Initially 30.0.*/
  private static double insufficientFundsFee = 30.0;
  /** Initialize a new checking account using the parameters.*/
  public CheckingAccount(int accountNum, String customerName, double balance)
  {
    super(accountNum, customerName, balance);
  }
  /** Returns “Checking” */
  public String getAccountType()
  {
    return "Checking";
  }
  /** Get method for insufficientFundsFee*/
  public static double getInsufficentFundsFee()
  {
    return insufficientFundsFee;
  }
  /** Set method for insufficientFundsFee*/
  public void setInsufficientFundsFee(double fee)
  {
    insufficientFundsFee = fee;
  }
}