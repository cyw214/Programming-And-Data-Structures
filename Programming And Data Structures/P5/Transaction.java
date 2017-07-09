/*
CSE 17
Charles Wallace
cyw214
Program #5 DEADLINE: December 4, 2014
Program: WebRentz Movie Rental System
*/

import java.util.Date;

/** Transaction An abstract class representing a transaction (either new movie request, rental, or return).*/
public abstract class Transaction{

  /** The affected customer.*/
  protected Customer customer; 

  /** The affected movie.*/
  protected Movie movie;

  /** The date (java.util.Date) of the transaction.*/
  protected Date date; 

  /** The constructor. Initializes the fields.*/
  public Transaction(Customer customer, Movie movie, Date date)
  {
    this.customer = customer;
    this.movie = movie;
    this.date = date;
  }

  /** Get method for customer.*/
  public Customer getCustomer()
  {
    return customer;
  }
  /** Get method for movie.*/
  public Movie getMovie()
  {
    return movie;
  }
  /** Get method for date.*/
  public Date getDate()
  {
    return date;
  }
  /** An abstract method that returns a summary of the transaction suitable for display when grouped by movie.*/
  public abstract String getMovieEventString(); 

}