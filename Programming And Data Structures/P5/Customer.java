/*
CSE 17
Charles Wallace
cyw214
Program #5 DEADLINE: December 4, 2014
Program: WebRentz Movie Rental System
*/ 

/** A simple class representing a customer.*/
public class Customer{ 

  /** The customer’s full name.*/
  private String name; 

  /** The customer’s account number.*/
  private int id;

  /** The constructor. Sets id and name.*/
  public Customer(int id, String name)
  {
    this.name = name;
    this.id = id;
  }

  /** Returns the id.*/
  public int getId()
  {
    return id;
  }

  /** Returns the name.*/
  public String getName()
  {
    return name;
  }

  /**Overrides Object’s equals method. Two Customer objects are equal if they have the same id number.*/
  public boolean equals(Object o)
  {
    if(this.getId() == ((Customer)o).getId())
      return true;
    else
      return false;
  }
 
}