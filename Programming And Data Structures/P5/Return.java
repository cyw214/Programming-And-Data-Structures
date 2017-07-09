/*
CSE 17
Charles Wallace
cyw214
Program #5 DEADLINE: December 4, 2014
Program: WebRentz Movie Rental System
*/ 

import java.util.Date;
import java.text.SimpleDateFormat;

/** Subclass of Transaction. Represents a customer returning a copy of a movie.*/
public class Return extends Transaction{ 
  
  /** The constructor.*/
  public Return(Customer customer, Movie movie, Date date)
  {
    super(customer,movie,date);
  }

  /** Provides a message in the form “dd-MMM-yyyy Returned by customer-name”*/
  public String getMovieEventString()
  {
   SimpleDateFormat ddMMyyyy = new SimpleDateFormat("dd-MMM-yyyy");
   String eventstring = ddMMyyyy.format(this.getDate()) + " Returned by " + this.getCustomer().getName();
   return eventstring;
  }

  /** Overrides Object’s equals method. Two Return objects are equal if they have equivalent customers, movies, and dates.*/
  public boolean equals(Object o)
  {
     if((this.getCustomer()).equals(((Return)o).getCustomer()))
      if((this.getMovie()).equals(((Return)o).getMovie()))
       if((this.getDate()).equals(((Return)o).getDate()))
            return true;
      return false;
     
  }

}