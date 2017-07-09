/*
CSE 17
Charles Wallace
cyw214
Program #5 DEADLINE: December 4, 2014
Program: WebRentz Movie Rental System
*/

import java.util.Date;
import java.text.SimpleDateFormat;

/**Subclass of Transaction. Represents a rental of an available movie to a customer.*/
public class Rental extends Transaction {
 
  /** The number of copies of the movie left after the rental was processed. */
  private int copiesRemaining;

  /** The constructor. */
  public Rental(Customer customer, Movie movie, Date date) 
  {
   super(customer, movie, date);
  }

  /** Set method for copiesRemaining. */
  public void setCopiesRemaining(int copiesRemaining) 
  {
    this.copiesRemaining = copiesRemaining;
  }

 /** Provides a message in the form “dd-MMM-yyyy Rented by customer-name (xcopies remaining)”*/
 public String getMovieEventString() 
 {
   SimpleDateFormat ddMMyyyy = new SimpleDateFormat("dd-MMM-yyyy");
   String eventstring = ddMMyyyy.format(this.getDate()) + " Rented by " + this.getCustomer().getName() + " (" + copiesRemaining + " copies remaining" + ")";
   return eventstring;
 }

 /**Overrides Object’s equals method. Two Rental objects are equal if theyhave equivalent customers, movies, and dates.*/
 public boolean equals(Object o) 
 {
     if((this.getCustomer()).equals(((Rental)o).getCustomer()))
      if((this.getMovie()).equals(((Rental)o).getMovie()))
       if((this.getDate()).equals(((Rental)o).getDate()))
            return true;
     
       return false;
 }
}