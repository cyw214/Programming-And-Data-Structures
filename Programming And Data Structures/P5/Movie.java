/*
 CSE 17
 Charles Wallace
 cyw214
 Program #5 DEADLINE: December 4, 2014
 Program: WebRentz Movie Rental System
 */ 

import java.util.ArrayList;

/** A class representing a video title.*/
public class Movie{ 
  
  /** The id number for the movie*/
  private int id; 
  
  /** The title of the movie*/
  private String title; 
  
  /** The number of copies owned by the business.*/
  private int numCopies; 
  
  /** The number of copies currently on hand (i.e., not rented out to customers).*/
  private int numAvailable; 
  
  /** The waiting list for the movie. Requests will be processed in a “first-come, first-serve” fashion.*/
  private MyQueue<Customer> waitList; 
  
  /** A list of all outstanding rental transactions, i.e., those where the movie has not yet been returned.*/
  private MyLinkedList<Rental> currentRentals; 
  
  /** A list of all rental and return transactions for the movie.*/
  private ArrayList<Transaction> rentalHistory; 
  
  /** The constructor. Initializes all fields, including setting numAvailable to the same value as numCopies.*/
  public Movie(int id, String title, int numCopies)
  {
    this.id = id;
    this.title = title;
    this.numCopies = numCopies;
    this.numAvailable = numCopies;
    
    currentRentals = new MyLinkedList<Rental>();
    rentalHistory = new ArrayList<Transaction>();
    waitList = new MyQueue<Customer>();
  }
  
  /** Return the id of the movie.*/
  public int getId()
  {
    return id;
  }
  
  /** Return the title of the movie.*/
  public String getTitle()
  {
    return title;
  }
  
  /** Return the numCopies of the movie.*/
  public int getNumCopies()
  {
    return numCopies;
  }
  
  /** Return the numAvailable of the movie.*/
  public int getNumAvailable()
  {
    return numAvailable;
  }
  
  /** Add customer to the end of the movie’s wait list.*/
  public void addToWaitList(Customer customer)
  {
    waitList.enqueue(customer);
  }
  /** Process a rental transaction. Decrease the number of available copies by one, record this number in the
    transaction, and then add the transaction to both the list of current rentals and the rental history. You may
    assume that the rental is for the movie the method is invoked on.*/
  public void processRental(Rental rentalTrans)
  { 
    numAvailable -= 1;
    rentalTrans.setCopiesRemaining(numAvailable);
    currentRentals.add(rentalTrans);
    rentalHistory.add(rentalTrans); 
  }
  
  /** Process a return transaction. Remove the customer’s rental transaction from the current rentals, increment
    the number of available copies by 1, and add the return transaction to the rental history. You may assume that
    the rental is for the movie the method is invoked on.*/
  public void processReturn(Return returnTrans)
  {
    numAvailable += 1;
    for(int i = 0; i < currentRentals.size(); i++)
    {
      if((currentRentals.get(i)).getCustomer().equals(returnTrans.getCustomer())){
        currentRentals.remove(i);
        rentalHistory.add(returnTrans); 
      }
    }
    
  }
  
  /** Removes the next Customer from the wait list and returns it. If the wait list is empty, returns null.*/
  public Customer getNextCustomerFromWaitList()
  {
    if(waitList.getSize() == 0)
      return null;
    else
      return waitList.dequeue();
  }
  
  /** Prints a detailed status of the movie, including its rental history and current wait list. See below for details.*/
  public void printMovieDetails() {
    String star = "";
    System.out.println("Id: " + id + "   Movie: " + title + " ("
                         + numCopies + " total copies)");
    
    System.out.println("   Rental History");
    System.out.println("   --------------");
    if (rentalHistory.size() != 0) {
      int count1 = 0;
      while(count1 < rentalHistory.size()){
        
        int count2 = 0;
        while(count2 < currentRentals.size()){
          if (currentRentals.get(count2).getCustomer()
                .equals(rentalHistory.get(count1).getCustomer())
                && currentRentals.get(count2).getMovie()
                .equals(rentalHistory.get(count1).getMovie())) {
            star = "*";
          }else{
            star = " ";
          }
          count2++;
        }
        
        if (rentalHistory.get(count1).getMovie().equals(this)) {
          System.out.print("   " + star + " ");
          System.out.println(rentalHistory.get(count1).getMovieEventString());
        }
        count1++;
      }
    } else {
      System.out.println("   n/a");
      
    }
    
    System.out.println("\n   Wait List");
    System.out.println("   ----------");
    if (waitList.getSize() != 0) {
      int count3 = 0;
      while(count3 < waitList.getSize()){   
        int id = count3 + 1;
        System.out.println("");
        System.out.println("   #" + id + ": " + waitList.peekIndex(count3).getName());
        count3++;
      }
      
    } else {
      System.out.println("   n/a");
    }
    
    
    
  }
  /** Overrides Object’s equals method. Two Movie objects are equal if they have the same id number.*/
  public boolean equals(Object o)
  {
    if(this.getId() == ((Movie)o).getId())
      return true;
    else
      return false;
    
  }
  
}