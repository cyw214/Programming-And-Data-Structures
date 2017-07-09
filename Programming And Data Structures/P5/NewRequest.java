/*
CSE 17
Charles Wallace
cyw214
Program #5 DEADLINE: December 4, 2014
Program: WebRentz Movie Rental System
*/ 

import java.text.SimpleDateFormat;
import java.util.Date;

/** Subclass of Transaction. Represents a new customer request for a movie. */
public class NewRequest extends Transaction {
 
  /** The constructor. */
 public NewRequest(Customer customer, Movie movie, Date date) {
  super(customer, movie, date);
 }

 /** Provides a message in the form “dd-MM-yyyy Requested by customer-name” */
 public String getMovieEventString() 
 {
   SimpleDateFormat ddMMyyyy = new SimpleDateFormat("dd-MMM-yyyy");
   String eventstring = ddMMyyyy.format(this.getDate()) + " Requested by " + this.getCustomer().getName();
   return eventstring;
 }
 
 /** Overrides Object’s equals method. Two NewRequest objects are equal if they have equivalent customers, movies, and dates.*/
 public boolean equals(Object o) 
 {
     if((this.getCustomer()).equals(((NewRequest)o).getCustomer()))
      if((this.getMovie()).equals(((NewRequest)o).getMovie()))
        if((this.getDate()).equals(((NewRequest)o).getDate()))
            return true;
     return false;
 }
 
}
