/* 
CSE 17 
Charles Wallace
cyw214
Program #3 DEADLINE: October 27, 2014 
Program: Checking Account 
*/ 
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;

/** an abstract class representing a bank account*/
public abstract class BankAccount{

  private int accountNum; 
  private String customerName;
  private double balance;
  protected ArrayList<Transaction> transactions;
  protected ArrayList<Double> balanceHistory;
  
  /** Initialize a new bank account using the parameters.*/
  public BankAccount(int accountNum, String customerName, double balance)
  {
     this.accountNum = accountNum;
     this.customerName = customerName;
     this.balance = balance;
     transactions = new ArrayList<>();
     balanceHistory = new ArrayList<>();     
  }
 
  /** Initialize a new bank account , setting the balance to 0.*/
  public BankAccount(int accountNum, String customerName)
  {
    this(accountNum, customerName, 0.0);
  }
  /** Get method for accountNum*/ 
  public int getAccountNum()
  {
    return accountNum;
  }
  /** Get method for customerName*/
  public String getCustomerName()
  {
    return customerName;
  }
  /** Get method for balance*/   
  public double getBalance()
  {
    return balance;
  }
  /** Adds t to the end of transactions and then applies it to the account. Records new balance in balanceHistory*/
  public void addTransaction(Transaction t)
  {
    
    transactions.add(t);
    t.execute(this);
    
    balanceHistory.add(balance);
  }
  /** If the value > 0 then adds it to the account’s balance*/
  public void deposit(double value)
  {
    if(value > 0)
    {
      balance = balance + value;
    }
  }
  /** If the value > 0 then subtracts it from the account’s balance */
  public void withdraw(double value)
  {
    if(value > 0)
    {
      balance = balance - value;
    }
  }
  /** Writes an account statement to the screen for all transactions that occur between startDate and endDate inclusive.*/
  public void printStatement(Date startDate, Date endDate)
  {
    SimpleDateFormat mmddyyyy = new SimpleDateFormat("MM/dd/yyyy");
    String start = mmddyyyy.format(startDate);
    String end = mmddyyyy.format(endDate);
    
    System.out.printf("%-19s%-25s","Account Holder:",this.getCustomerName());
    System.out.printf("%-20s%-25d","\nAccount Number:", this.getAccountNum());
    System.out.printf("%-19s%25s","\nStatement Period:",(start + " to " + end));
    if (transactions.get(0) instanceof WithdrawalTransaction)
    {
      if(transactions.get(0) instanceof CheckTransaction)
      {
        System.out.printf("%-20s%-25.2f","\nStarting Balance:", (balanceHistory.get(0))+(transactions.get(0)).getAmount()+(transactions.get(1)).getAmount());
      }
      else
      {
      System.out.printf("%-20s%-25.2f","\nStarting Balance:", (balanceHistory.get(0))+(transactions.get(0)).getAmount());
      }
    }
    else if(transactions.get(0) instanceof DepositTransaction)
    {
    System.out.printf("%-20s%-25.2f","\nEnding Balance:", balanceHistory.get(0)-(transactions.get(0)).getAmount());
    }
    System.out.printf("%-20s%-25.2f","\nEnding Balance:", balanceHistory.get((balanceHistory.size()-1)));
    
    System.out.print("\n\n");
    String tableform = String.format("%-10s%1s%-31s%1s%-10s%1s%-10s%1s%-12s","Date"," ", "Description"," ","Withdrawal"," ","Deposit"," ","Balance");
    System.out.print(tableform);
    System.out.print("\n---------- ------------------------------- ---------- ---------- -------");
    
    for(int i = 0; i < (balanceHistory.size()); ++i)
    {
      Transaction temptran = transactions.get(i);
      Date trandate = temptran.getTransactionDate();
      if((trandate.after(startDate)||trandate.equals(startDate))&&(trandate.before(endDate)||trandate.equals(endDate)))
      {
       
        String s = String.format("%50s%10.2f",temptran.toStatementRow(),balanceHistory.get(i));
        System.out.print("\n" + s);
      }
    }
    
    
  }
  /** Returns the account’s number and balance*/
  public String toString()
  { 
    return accountNum + " " + balance;
  }
  /** Returns the account type*/
  public abstract String getAccountType();
   
}